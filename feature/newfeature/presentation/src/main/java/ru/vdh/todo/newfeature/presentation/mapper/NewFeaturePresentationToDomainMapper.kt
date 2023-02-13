package ru.vdh.todo.newfeature.presentation.mapper

import ru.vdh.todo.newfeature.domain.model.NewFeatureDomainModel
import ru.vdh.todo.newfeature.presentation.model.NewFeaturePresentationModel

class NewFeaturePresentationToDomainMapper {
    fun toDomain(newUser: NewFeaturePresentationModel) =
        NewFeatureDomainModel(
            firstName = newUser.firstName,
            lastName = newUser.lastName
        )
}
