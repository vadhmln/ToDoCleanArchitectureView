package ru.vdh.todo.addtodo.domain.model

data class AddToDoDomainModel(
    var date: Long?,
    val id: Int,
    val title: String,
    val priority: String,
    val description: String
)