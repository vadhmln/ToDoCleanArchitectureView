package ru.vdh.todo.updatetodo.presentation.mapper

import ru.vdh.todo.updatetodo.domain.model.UpdateToDoDomainModel
import ru.vdh.todo.updatetodo.presentation.model.UpdateToDoPresentationModel

class UpdateToDoDomainToPresentationMapper {
    fun toPresentation(updateToDoDomainModel: UpdateToDoDomainModel) =
        UpdateToDoPresentationModel(
            id = updateToDoDomainModel.id,
            title = updateToDoDomainModel.title,
            priority = updateToDoDomainModel.priority,
            description = updateToDoDomainModel.description
        )
}