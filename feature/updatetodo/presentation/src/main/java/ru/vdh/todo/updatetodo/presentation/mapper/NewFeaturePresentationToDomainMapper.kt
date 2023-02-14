package ru.vdh.todo.updatetodo.presentation.mapper

import ru.vdh.todo.updatetodo.domain.model.NewFeatureDomainModel
import ru.vdh.todo.updatetodo.presentation.model.NewFeaturePresentationModel

class NewFeaturePresentationToDomainMapper {
    fun toDomain(newUser: NewFeaturePresentationModel) =
        NewFeatureDomainModel(
            firstName = newUser.firstName,
            lastName = newUser.lastName
        )
}
