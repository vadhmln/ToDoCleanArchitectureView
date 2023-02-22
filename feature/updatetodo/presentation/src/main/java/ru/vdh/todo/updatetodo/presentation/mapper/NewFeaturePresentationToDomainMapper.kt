package ru.vdh.todo.updatetodo.presentation.mapper

import ru.vdh.todo.updatetodo.domain.model.UpdateToDoDomainModel
import ru.vdh.todo.updatetodo.presentation.model.UpdateToDoPresentationModel

class NewFeaturePresentationToDomainMapper {
    fun toDomain(updateToDoPresentationModel: UpdateToDoPresentationModel) =
        UpdateToDoDomainModel(
            id = updateToDoPresentationModel.id,
            title = updateToDoPresentationModel.title,
            priority = updateToDoPresentationModel.priority,
            description = updateToDoPresentationModel.description
        )
}
