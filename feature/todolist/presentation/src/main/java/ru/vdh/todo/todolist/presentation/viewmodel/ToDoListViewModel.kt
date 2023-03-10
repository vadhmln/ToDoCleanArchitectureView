package ru.vdh.todo.todolist.presentation.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import ru.vdh.todo.core.presentation.viewmodel.BaseViewModel
import ru.vdh.todo.core.presentation.viewmodel.usecase.UseCaseExecutorProvider
import ru.vdh.todo.todolist.domain.model.ToDoListDomainModel
import ru.vdh.todo.todolist.domain.usecase.DeleteAllToDoUseCase
import ru.vdh.todo.todolist.domain.usecase.GetToDoListUseCase
import ru.vdh.todo.todolist.domain.usecase.SearchByHighPriorityUseCase
import ru.vdh.todo.todolist.domain.usecase.SearchByLowPriorityUseCase
import ru.vdh.todo.todolist.domain.usecase.SearchInDatabaseUseCase
import ru.vdh.todo.todolist.presentation.destination.ToDoListPresentationDestination.AddToDo
import ru.vdh.todo.todolist.presentation.destination.ToDoListPresentationDestination.UpdateToDo
import ru.vdh.todo.todolist.presentation.mapper.ToDoListDomainToPresentationMapper
import ru.vdh.todo.todolist.presentation.model.ToDoListPresentationModel
import ru.vdh.todo.todolist.presentation.model.ToDoListPresentationNotification
import ru.vdh.todo.todolist.presentation.model.ToDoListViewState
import javax.inject.Inject

private typealias DoNothing = Unit

@HiltViewModel
class ToDoListViewModel @Inject constructor(
    private val getToDoListUseCase: GetToDoListUseCase,
    private val deleteAllToDoUseCase: DeleteAllToDoUseCase,
    private val searchInDatabaseUseCase: SearchInDatabaseUseCase,
    private val searchByHighPriorityUseCase: SearchByHighPriorityUseCase,
    private val searchByLowPriorityUseCase: SearchByLowPriorityUseCase,
    private val toDoListDomainToPresentationMapper: ToDoListDomainToPresentationMapper,
    useCaseExecutorProvider: UseCaseExecutorProvider,
    application: Application,
) : BaseViewModel<ToDoListViewState, ToDoListPresentationNotification>(
    useCaseExecutorProvider,
    application
) {

    override fun initialState() = ToDoListViewState()

    init {
        Log.e("AAA", "ToDoListViewModel created!!!")
    }

    fun onEntered(toDoId: Int) {
        updateViewState(ToDoListViewState::loading)
        execute(
            getToDoListUseCase,
            toDoId,
            onSuccess = { toDoListData -> presentToDoList(toDoListData.asLiveData()) },
            onException = { DoNothing }
        )
    }

    private fun presentToDoList(toDoListDomainData: LiveData<List<ToDoListDomainModel>>) {
        val toDoListPresentationData = toDoListDomainData.map {
            it.map(toDoListDomainToPresentationMapper::toPresentation)
        }
        updateViewState {
            withToDoList(toDoListPresentationData)
        }
    }

    fun onAddToDoAction(toDoId: Int) {
        navigateTo(AddToDo(toDoId))
    }

    fun onUpdateToDoAction(toDoId: Int) {
        navigateTo(UpdateToDo(toDoId))
    }

    fun deleteAllToDoItems() {
        execute(deleteAllToDoUseCase)
    }

    fun searchDatabase(searchQuery: String): LiveData<List<ToDoListPresentationModel>> {
        val list = searchInDatabaseUseCase.executeInBackground(searchQuery).map {
            it.map(toDoListDomainToPresentationMapper::toPresentation)
        }
        return list.asLiveData()
    }

    fun sortByHighPriority(request: Int): LiveData<List<ToDoListPresentationModel>> {
        val list = searchByHighPriorityUseCase.executeInBackground(request).map {
            it.map(toDoListDomainToPresentationMapper::toPresentation)
        }
        return list.asLiveData()
    }

    fun sortByLowPriority(request: Int): LiveData<List<ToDoListPresentationModel>> {
        val list = searchByLowPriorityUseCase.executeInBackground(request).map {
            it.map(toDoListDomainToPresentationMapper::toPresentation)
        }
        return list.asLiveData()
    }

    //???????????????????? ?????????? ?????????????????? ?? ?????? ????????????????/fragment ????????????????????????
    override fun onCleared() {
        Log.e("AAA", "ToDoListViewModel cleared!!!")
        super.onCleared()
    }
}
