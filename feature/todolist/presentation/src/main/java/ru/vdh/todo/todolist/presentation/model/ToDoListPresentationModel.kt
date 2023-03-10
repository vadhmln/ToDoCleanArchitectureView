package ru.vdh.todo.todolist.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ToDoListPresentationModel(
    var date: Long?,
    val id: Int,
    val title: String,
    val priority: String,
    val description: String
) : Parcelable