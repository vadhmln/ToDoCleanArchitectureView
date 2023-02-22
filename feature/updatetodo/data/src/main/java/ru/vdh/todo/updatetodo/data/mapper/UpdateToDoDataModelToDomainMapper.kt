package ru.vdh.todo.updatetodo.data.mapper

import ru.vdh.todo.updatetodo.data.model.UpdateToDoDataModel
import ru.vdh.todo.updatetodo.domain.model.UpdateToDoDomainModel

class UpdateToDoDataModelToDomainMapper {
    fun toDomain(updateToDoDataModel: UpdateToDoDataModel) =
        UpdateToDoDomainModel(
            id = updateToDoDataModel.id,
            title = updateToDoDataModel.title,
            priority = updateToDoDataModel.priority,
            description = updateToDoDataModel.description
        )
}