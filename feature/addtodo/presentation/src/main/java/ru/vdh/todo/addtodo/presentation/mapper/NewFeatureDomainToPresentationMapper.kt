package ru.vdh.todo.addtodo.presentation.mapper

import ru.vdh.todo.addtodo.domain.model.NewFeatureDomainModel
import ru.vdh.todo.addtodo.presentation.model.NewFeaturePresentationModel

class NewFeatureDomainToPresentationMapper {
    fun toPresentation(user: NewFeatureDomainModel) =
        NewFeaturePresentationModel(
            firstName = user.firstName,
            lastName = user.lastName
        )
}