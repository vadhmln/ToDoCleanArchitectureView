package ru.vdh.todo.updatetodo.presentation.model

data class UpdateToDoPresentationModel(
    var date: Long?,
    val id: Int,
    val title: String,
    val priority: String,
    val description: String
)