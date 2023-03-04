package ru.vdh.todo.updatetodo.datasource.model

data class UpdateToDoDataSourceModel(
    var date: Long?,
    val id: Int,
    val title: String,
    val priority: String,
    val description: String
)