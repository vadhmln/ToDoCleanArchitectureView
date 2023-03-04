package ru.vdh.todo.todolist.domain.model

data class ToDoListDomainModel(
    var date: Long?,
    val id: Int,
    val title: String,
    val priority: String,
    val description: String
)