package ru.vdh.todo.database_local.util

import androidx.room.TypeConverter
import ru.vdh.todo.database_local.model.PriorityLocalDataBaseModel

class Converter {

    @TypeConverter
    fun fromPriority(priorityLocalDataBaseModel: PriorityLocalDataBaseModel): String {
        return priorityLocalDataBaseModel.name
    }

    @TypeConverter
    fun toPriority(priority: String): PriorityLocalDataBaseModel {
        return PriorityLocalDataBaseModel.valueOf(priority)
    }
}