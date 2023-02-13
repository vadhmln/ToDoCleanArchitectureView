package ru.vdh.todo.todolist.presentation.mapper

import ru.vdh.todo.todolist.domain.model.NewFeatureDomainModel
import ru.vdh.todo.todolist.presentation.model.NewFeaturePresentationModel

class NewFeatureDomainToPresentationMapper {
    fun toPresentation(user: NewFeatureDomainModel) =
        NewFeaturePresentationModel(
            firstName = user.firstName,
            lastName = user.lastName
        )
}