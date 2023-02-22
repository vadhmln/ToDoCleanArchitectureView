package ru.vdh.todo.todolist.domain.model

data class ToDoListDomainModel(
    val id: Int,
    val title: String,
    val priority: String,
    val description: String
)