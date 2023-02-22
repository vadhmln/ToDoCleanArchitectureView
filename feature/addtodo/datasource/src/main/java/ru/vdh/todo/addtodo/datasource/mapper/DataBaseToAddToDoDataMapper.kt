package ru.vdh.todo.addtodo.datasource.mapper

import ru.vdh.todo.addtodo.data.model.AddToDoDataModel
import ru.vdh.todo.database_local.model.ToDoLocalDataBaseModel
import ru.vdh.todo.database_local.util.Converter

class DataBaseToAddToDoDataMapper {

    fun toData(
        input: ToDoLocalDataBaseModel,
        converter: Converter
    ) = AddToDoDataModel(
        input.id,
        input.title,
        converter.fromPriority(input.priority),
        input.description
    )
}
