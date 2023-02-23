package ru.vdh.todo.todolist.presentation.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import ru.vdh.todo.core.presentation.viewmodel.BaseViewModel
import ru.vdh.todo.core.presentation.viewmodel.usecase.UseCaseExecutorProvider
import ru.vdh.todo.todolist.domain.model.ToDoListDomainModel
import ru.vdh.todo.todolist.domain.usecase.GetToDoListUseCase
import ru.vdh.todo.todolist.presentation.mapper.ToDoListDomainToPresentationMapper
import ru.vdh.todo.todolist.presentation.model.ToDoListPresentationNotification
import ru.vdh.todo.todolist.presentation.model.ToDoListViewState
import ru.vdh.todo.todolist.presentation.model.ToDoListPresentationModel
import javax.inject.Inject

@HiltViewModel
class ToDoListViewModel @Inject constructor(
    private val getToDoListUseCase: GetToDoListUseCase,
    private val toDoListDomainToPresentationMapper: ToDoListDomainToPresentationMapper,
    useCaseExecutorProvider: UseCaseExecutorProvider,
    application: Application,
) : BaseViewModel<ToDoListViewState, ToDoListPresentationNotification>(
    useCaseExecutorProvider,
    application
) {

    private val getAllDomainData: LiveData<List<ToDoListDomainModel>> = getAllToDoList()
    val getAllPresentationData =
        getAllDomainData.map { it ->
            it.map {
                toDoListDomainToPresentationMapper.toPresentation(it)
            }
        }

    private val emptyDatabase: MutableLiveData<Boolean> = MutableLiveData(false)

    override fun initialState() = ToDoListViewState()

    private val resultMutableLiveData = MutableLiveData<String>()
    val resultLiveData: LiveData<String> = resultMutableLiveData

    init {
        Log.e("AAA", "UserDetailsViewModel created!!!")
    }

    private fun getAllToDoList(
//        request: Flow<List<ToDoListDomainModel>>
    ): LiveData<List<ToDoListDomainModel>> {
        val request: Flow<List<ToDoListDomainModel>> = emptyFlow()

//        updateViewState { toDoDetailsReady(toDoDetails) }
        return getToDoListUseCase.executeInBackground(request).asLiveData()
//        execute(getToDoListUseCase, request)
    }

    fun checkIfDatabaseEmpty(toDoData: List<ToDoListPresentationModel>) {
        emptyDatabase.value = toDoData.isEmpty()
    }

    //вызывается когда связанная с ней активити/fragment уничтожается
    override fun onCleared() {
        Log.e("AAA", "UserDetailsViewModel cleared!!!")
        super.onCleared()
    }
}