package ru.vdh.todo.todolist.datasource.mapper

import ru.vdh.todo.database_local.model.PriorityLocalDataBaseModel
import ru.vdh.todo.database_local.model.ToDoLocalDataBaseModel
import ru.vdh.todo.todolist.data.model.ToDoListDataModel

class ToDoListDataToDataBaseMapper() {

    fun toDataBase(input: ToDoListDataModel): ToDoLocalDataBaseModel {
        return ToDoLocalDataBaseModel(
            input.date,
            input.id,
            input.title,
            parsePriority(input.priority),
            input.description
        )
    }

    private fun parsePriority(priority: String): PriorityLocalDataBaseModel {
        return when (priority) {
            "High priority" -> {
                PriorityLocalDataBaseModel.HIGH
            }

            "Medium priority" -> {
                PriorityLocalDataBaseModel.MEDIUM
            }

            "Low priority" -> {
                PriorityLocalDataBaseModel.LOW
            }

            else -> PriorityLocalDataBaseModel.LOW
        }
    }
}
