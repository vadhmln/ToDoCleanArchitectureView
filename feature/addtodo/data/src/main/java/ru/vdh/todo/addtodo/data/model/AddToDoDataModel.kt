package ru.vdh.todo.addtodo.data.model

data class AddToDoDataModel(
    var date: Long?,
    val id: Int,
    val title: String,
    val priority: String,
    val description: String
)