package ru.vdh.todo.todolist.data.model

data class ToDoListDataModel(
    var date: Long?,
    val id: Int,
    val title: String,
    val priority: String,
    val description: String
)