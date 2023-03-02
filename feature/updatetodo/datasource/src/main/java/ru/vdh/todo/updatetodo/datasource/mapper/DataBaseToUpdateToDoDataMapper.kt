package ru.vdh.todo.updatetodo.datasource.mapper

import ru.vdh.todo.database_local.model.PriorityLocalDataBaseModel
import ru.vdh.todo.database_local.model.ToDoLocalDataBaseModel
import ru.vdh.todo.updatetodo.data.model.UpdateToDoDataModel

class DataBaseToUpdateToDoDataMapper {

    fun toData(input: ToDoLocalDataBaseModel?) =
        input?.let {
            UpdateToDoDataModel(
                it.id,
                input.title,
                parsePriority(input.priority),
                input.description
            )
        }

    private fun parsePriority(priority: PriorityLocalDataBaseModel): String {
        return when (priority) {
            PriorityLocalDataBaseModel.HIGH -> {
                "High priority"
            }

            PriorityLocalDataBaseModel.MEDIUM -> {
                "Medium priority"
            }

            PriorityLocalDataBaseModel.LOW -> {
                "Low priority"
            }

            else -> "Low priority"
        }
    }
}
