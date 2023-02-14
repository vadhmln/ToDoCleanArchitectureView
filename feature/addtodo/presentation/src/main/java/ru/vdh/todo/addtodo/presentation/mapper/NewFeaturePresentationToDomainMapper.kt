package ru.vdh.todo.addtodo.presentation.mapper

import ru.vdh.todo.addtodo.domain.model.NewFeatureDomainModel
import ru.vdh.todo.addtodo.presentation.model.NewFeaturePresentationModel

class NewFeaturePresentationToDomainMapper {
    fun toDomain(newUser: NewFeaturePresentationModel) =
        NewFeatureDomainModel(
            firstName = newUser.firstName,
            lastName = newUser.lastName
        )
}
