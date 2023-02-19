package ru.vdh.todo.addtodo.data.model

data class AddToDoDataModel(
    val id: Int,
    val title: String,
    val priority: String,
    val description: String
)