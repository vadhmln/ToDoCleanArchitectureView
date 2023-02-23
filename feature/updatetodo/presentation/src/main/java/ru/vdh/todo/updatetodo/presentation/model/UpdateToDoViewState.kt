package ru.vdh.todo.updatetodo.presentation.model

data class UpdateToDoViewState(
    val saveResult: Boolean = false,
    val firstName: String = "",
    val lastName: String = ""
)