package ru.vdh.todo.todolist.datasource.mapper

import ru.vdh.todo.database_local.model.PriorityLocalDataBaseModel
import ru.vdh.todo.database_local.model.ToDoLocalDataBaseModel
import ru.vdh.todo.todolist.data.model.ToDoListDataModel

class DataBaseToToDoListDataMapper {

    fun toData(input: ToDoLocalDataBaseModel) =
        ToDoListDataModel(
            input.id,
            input.title,
            parsePriority(input.priority),
            input.description
        )

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
