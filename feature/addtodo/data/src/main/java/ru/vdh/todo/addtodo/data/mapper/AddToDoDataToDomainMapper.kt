package ru.vdh.todo.addtodo.data.mapper

import ru.vdh.todo.addtodo.data.model.AddToDoDataModel
import ru.vdh.todo.addtodo.domain.model.AddToDoDomainModel

class AddToDoDataToDomainMapper {

    fun toDomain(addToDoDataModel: AddToDoDataModel) =
        AddToDoDomainModel(
            id = addToDoDataModel.id,
            title = addToDoDataModel.title,
            priority = addToDoDataModel.priority,
            description = addToDoDataModel.description
        )
}