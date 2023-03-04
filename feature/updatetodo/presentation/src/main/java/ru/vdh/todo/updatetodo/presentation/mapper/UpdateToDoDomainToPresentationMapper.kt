package ru.vdh.todo.updatetodo.presentation.mapper

import ru.vdh.todo.updatetodo.domain.model.UpdateToDoDomainModel
import ru.vdh.todo.updatetodo.presentation.model.UpdateToDoPresentationModel

class UpdateToDoDomainToPresentationMapper {
    fun toPresentation(input: UpdateToDoDomainModel?) =
        input?.let {
            UpdateToDoPresentationModel(
                date = input.date,
                id = it.id,
                title = input.title,
                priority = input.priority,
                description = input.description
            )
        }
}