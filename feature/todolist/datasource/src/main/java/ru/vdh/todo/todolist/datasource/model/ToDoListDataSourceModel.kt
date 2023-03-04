package ru.vdh.todo.todolist.datasource.model

data class ToDoListDataSourceModel(
    val id: Int,
    val title: String,
    val priority: String,
    val description: String
)