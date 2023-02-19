package ru.vdh.todo.database_local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class ToDoLocalDataBaseModel(

    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var priority: PriorityLocalDataBaseModel,
    var description: String
)