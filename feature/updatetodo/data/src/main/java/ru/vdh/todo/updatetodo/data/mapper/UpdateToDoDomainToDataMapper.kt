package ru.vdh.todo.updatetodo.data.mapper

import ru.vdh.todo.updatetodo.data.model.UpdateToDoDataModel
import ru.vdh.todo.updatetodo.domain.model.UpdateToDoDomainModel

class UpdateToDoDomainToDataMapper {

    fun toData(addToDoDomainModel: UpdateToDoDomainModel) =
        UpdateToDoDataModel(
            id = addToDoDomainModel.id,
            title = addToDoDomainModel.title,
            priority = addToDoDomainModel.priority,
            description = addToDoDomainModel.description
        )
}