package ru.vdh.todo.updatetodo.data.model

data class UpdateToDoDataModel(
    val id: Int,
    val title: String,
    val priority: String,
    val description: String
)