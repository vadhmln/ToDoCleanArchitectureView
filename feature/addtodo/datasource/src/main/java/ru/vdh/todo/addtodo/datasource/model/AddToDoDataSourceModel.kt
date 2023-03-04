package ru.vdh.todo.addtodo.datasource.model

data class AddToDoDataSourceModel(
    var date: Long?,
    val id: Int,
    val title: String,
    val priority: String,
    val description: String
)