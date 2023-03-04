package ru.vdh.todo.database_local.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "todo_table")
@Parcelize
data class ToDoLocalDataBaseModel(
    var date: Long?,
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var priority: PriorityLocalDataBaseModel,
    var description: String
) : Parcelable