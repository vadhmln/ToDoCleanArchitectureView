package ru.vdh.todo.updatetodo.data.mapper

import ru.vdh.todo.updatetodo.data.model.UpdateToDoDataModel
import ru.vdh.todo.updatetodo.domain.model.UpdateToDoDomainModel

class UpdateToDoDataToDomainMapper {

    fun toDomain(addToDoDataModel: UpdateToDoDataModel) =
        UpdateToDoDomainModel(
            id = addToDoDataModel.id,
            title = addToDoDataModel.title,
            priority = addToDoDataModel.priority,
            description = addToDoDataModel.description
        )
}