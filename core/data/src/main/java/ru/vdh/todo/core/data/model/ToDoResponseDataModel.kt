package ru.vdh.todo.core.data.model

data class ToDoResponseDataModel(
    var id: Int,
    var title: String,
    var priority: String,
    var description: String
)