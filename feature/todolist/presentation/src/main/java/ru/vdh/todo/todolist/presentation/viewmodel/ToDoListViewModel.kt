package ru.vdh.todo.todolist.presentation.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.vdh.todo.core.presentation.viewmodel.BaseViewModel
import ru.vdh.todo.core.presentation.viewmodel.usecase.UseCaseExecutorProvider
import ru.vdh.todo.todolist.domain.model.ToDoListDomainModel
import ru.vdh.todo.todolist.domain.usecase.DeleteToDoUseCase
import ru.vdh.todo.todolist.domain.usecase.GetToDoListUseCase
import ru.vdh.todo.todolist.presentation.destination.ToDoListPresentationDestination.UpdateToDo
import ru.vdh.todo.todolist.presentation.destination.ToDoListPresentationDestination.AddToDo
import ru.vdh.todo.todolist.presentation.mapper.ToDoListDomainToPresentationMapper
import ru.vdh.todo.todolist.presentation.mapper.ToDoListPresentationToDomainMapper
import ru.vdh.todo.todolist.presentation.model.ToDoListPresentationModel
import ru.vdh.todo.todolist.presentation.model.ToDoListPresentationNotification
import ru.vdh.todo.todolist.presentation.model.ToDoListViewState
import javax.inject.Inject

private typealias DoNothing = Unit

@HiltViewModel
class ToDoListViewModel @Inject constructor(
    private val getToDoListUseCase: GetToDoListUseCase,
    private val deleteToDoUseCase: DeleteToDoUseCase,
    private val toDoListDomainToPresentationMapper: ToDoListDomainToPresentationMapper,
    private val toDoListPresentationToDomainMapper: ToDoListPresentationToDomainMapper,
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

    fun onAddToDoAction(toDoId: Int) {
        navigateTo(AddToDo(toDoId))
    }

    fun onUpdateToDoAction(toDoId: Int) {
        navigateTo(UpdateToDo(toDoId))
    }

    fun deleteItem(toDoListPresentationModel: ToDoListPresentationModel) {
        val domainToDo = toDoListPresentationToDomainMapper.toDomain(toDoListPresentationModel)
        execute(deleteToDoUseCase, domainToDo)
    }

    private fun presentToDoList(toDoListDomainData: LiveData<List<ToDoListDomainModel>>) {
        val toDoListPresentationData = toDoListDomainData.map {
            it.map(toDoListDomainToPresentationMapper::toPresentation)
        }
        updateViewState {
            withToDoList(toDoListPresentationData)
        }
    }

    //вызывается когда связанная с ней активити/fragment уничтожается
    override fun onCleared() {
        Log.e("AAA", "ToDoListViewModel cleared!!!")
        super.onCleared()
    }
}
