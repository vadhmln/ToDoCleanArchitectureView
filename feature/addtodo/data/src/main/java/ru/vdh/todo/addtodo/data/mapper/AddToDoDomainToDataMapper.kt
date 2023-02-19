package ru.vdh.todo.addtodo.data.mapper

import ru.vdh.todo.addtodo.data.model.AddToDoDataModel
import ru.vdh.todo.addtodo.domain.model.AddToDoDomainModel

class AddToDoDomainToDataMapper {

    fun toData(addToDoDomainModel: AddToDoDomainModel) =
        AddToDoDataModel(
            id = addToDoDomainModel.id,
            title = addToDoDomainModel.title,
            priority = addToDoDomainModel.priority,
            description = addToDoDomainModel.description
        )
}