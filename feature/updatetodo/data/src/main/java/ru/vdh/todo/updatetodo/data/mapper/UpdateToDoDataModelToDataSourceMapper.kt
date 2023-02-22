package ru.vdh.todo.updatetodo.data.mapper

import ru.vdh.todo.updatetodo.data.model.UpdateToDoDataModel
import ru.vdh.todo.updatetodo.domain.model.UpdateToDoDomainModel

class UpdateToDoDataModelToDataSourceMapper {
    fun toDataSource(updateToDoDomainModel: UpdateToDoDomainModel) =
        UpdateToDoDataModel(
            id = updateToDoDomainModel.id,
            title = updateToDoDomainModel.title,
            priority = updateToDoDomainModel.priority,
            description = updateToDoDomainModel.description
        )
}