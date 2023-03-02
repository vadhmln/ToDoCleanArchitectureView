package ru.vdh.todo.updatetodo.datasource.mapper

import ru.vdh.todo.database_local.model.PriorityLocalDataBaseModel
import ru.vdh.todo.database_local.model.ToDoLocalDataBaseModel
import ru.vdh.todo.updatetodo.data.model.UpdateToDoDataModel

class UpdateToDoDataToDataBaseMapper() {

    fun toDataBase(input: UpdateToDoDataModel) =
        ToDoLocalDataBaseModel(
            input.id,
            input.title,
            parsePriority(input.priority),
            input.description
        )

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
