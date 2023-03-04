package ru.vdh.todo.updatetodo.presentation.mapper

import ru.vdh.todo.updatetodo.domain.model.UpdateToDoDomainModel
import ru.vdh.todo.updatetodo.presentation.model.UpdateToDoPresentationModel

class UpdateToDoPresentationToDomainMapper {
    fun toDomain(input: UpdateToDoPresentationModel) =
        UpdateToDoDomainModel(
            date = input.date,
            id = input.id,
            title = input.title,
            priority = input.priority,
            description = input.description
        )
}
