package ru.vdh.todo.updatetodo.domain.model

data class UpdateToDoDomainModel(
    var date: Long?,
    val id: Int,
    val title: String,
    val priority: String,
    val description: String
)