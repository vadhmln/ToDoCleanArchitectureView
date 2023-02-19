package ru.vdh.todo.addtodo.presentation.model

data class AddToDoPresentationModel(
    val id: Int,
    val title: String,
    val priority: String,
    val description: String
)