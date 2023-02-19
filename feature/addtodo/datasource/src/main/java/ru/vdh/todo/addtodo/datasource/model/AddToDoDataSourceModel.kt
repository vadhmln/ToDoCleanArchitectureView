package ru.vdh.todo.addtodo.datasource.model

data class AddToDoDataSourceModel(
    var id: Int,
    var title: String,
    var priority: String,
    var description: String
)