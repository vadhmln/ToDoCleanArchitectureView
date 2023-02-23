package ru.vdh.todo.todolist.presentation.model

data class ToDoListViewState(
    val saveResult: Boolean = false,
    val firstName: String = "",
    val lastName: String = ""
)