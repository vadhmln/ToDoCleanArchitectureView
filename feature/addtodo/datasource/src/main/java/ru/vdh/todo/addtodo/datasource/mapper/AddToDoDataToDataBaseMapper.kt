package ru.vdh.todo.addtodo.datasource.mapper

import ru.vdh.todo.addtodo.data.model.AddToDoDataModel
import ru.vdh.todo.database_local.model.PriorityLocalDataBaseModel
import ru.vdh.todo.database_local.model.ToDoLocalDataBaseModel

class AddToDoDataToDataBaseMapper() {

    fun toDataBase(input: AddToDoDataModel): ToDoLocalDataBaseModel {
        return ToDoLocalDataBaseModel(
            input.date,
            input.id,
            input.title,
            parsePriority(input.priority),
            input.description
        )
    }

    private fun parsePriority(priority: String): PriorityLocalDataBaseModel {
        return when(priority){
            "High priority" -> { PriorityLocalDataBaseModel.HIGH }
            "Medium priority" -> { PriorityLocalDataBaseModel.MEDIUM }
            "Low priority" -> { PriorityLocalDataBaseModel.LOW }
            else -> PriorityLocalDataBaseModel.LOW
        }
    }
}
