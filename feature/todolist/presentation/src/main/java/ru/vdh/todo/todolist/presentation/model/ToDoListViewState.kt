package ru.vdh.todo.todolist.presentation.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

data class ToDoListViewState(
    val isLoading: Boolean = false,
    val toDoList: LiveData<List<ToDoListPresentationModel>> = MutableLiveData()
) {
    fun loading(): ToDoListViewState = copy(isLoading = true)

    fun withToDoList(toDoListData: LiveData<List<ToDoListPresentationModel>>) = copy(
        isLoading = false,
        toDoList = toDoListData
    )
}
