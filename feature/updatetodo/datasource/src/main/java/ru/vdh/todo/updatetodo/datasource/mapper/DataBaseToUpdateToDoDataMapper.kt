package ru.vdh.todo.updatetodo.datasource.mapper

import ru.vdh.todo.database_local.model.ToDoLocalDataBaseModel
import ru.vdh.todo.database_local.util.Converter
import ru.vdh.todo.updatetodo.data.model.UpdateToDoDataModel

class DataBaseToUpdateToDoDataMapper {

    fun toData(
        input: ToDoLocalDataBaseModel,
        converter: Converter
    ) = UpdateToDoDataModel(
        input.id,
        input.title,
        converter.fromPriority(input.priority),
        input.description
    )
}
