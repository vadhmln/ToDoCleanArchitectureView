package ru.vdh.todo.addtodo.datasource.mapper

import ru.vdh.todo.addtodo.data.model.AddToDoDataModel
import ru.vdh.todo.database_local.model.ToDoLocalDataBaseModel
import ru.vdh.todo.database_local.util.Converter

class DataToDataBaseMapper(private val converter: Converter) {

    fun toDataBase(input: AddToDoDataModel): ToDoLocalDataBaseModel {
        return ToDoLocalDataBaseModel(
            input.id,
            input.title,
            converter.toPriority(input.priority),
            input.description
        )
    }
}
