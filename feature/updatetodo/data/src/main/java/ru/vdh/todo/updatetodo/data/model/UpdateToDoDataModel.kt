package ru.vdh.todo.updatetodo.data.model

data class UpdateToDoDataModel(
    var date: Long?,
    val id: Int,
    val title: String,
    val priority: String,
    val description: String
)