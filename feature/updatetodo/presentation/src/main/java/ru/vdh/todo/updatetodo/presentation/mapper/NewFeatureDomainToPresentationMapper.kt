package ru.vdh.todo.updatetodo.presentation.mapper

import ru.vdh.todo.updatetodo.domain.model.NewFeatureDomainModel
import ru.vdh.todo.updatetodo.presentation.model.NewFeaturePresentationModel

class NewFeatureDomainToPresentationMapper {
    fun toPresentation(user: NewFeatureDomainModel) =
        NewFeaturePresentationModel(
            firstName = user.firstName,
            lastName = user.lastName
        )
}