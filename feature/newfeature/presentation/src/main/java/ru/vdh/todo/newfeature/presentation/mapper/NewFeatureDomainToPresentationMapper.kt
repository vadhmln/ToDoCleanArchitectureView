package ru.vdh.todo.newfeature.presentation.mapper

import ru.vdh.todo.newfeature.domain.model.NewFeatureDomainModel
import ru.vdh.todo.newfeature.presentation.model.NewFeaturePresentationModel

class NewFeatureDomainToPresentationMapper {
    fun toPresentation(user: NewFeatureDomainModel) =
        NewFeaturePresentationModel(
            firstName = user.firstName,
            lastName = user.lastName
        )
}