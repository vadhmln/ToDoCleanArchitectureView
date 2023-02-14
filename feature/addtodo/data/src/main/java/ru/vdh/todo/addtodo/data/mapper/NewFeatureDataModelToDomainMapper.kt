package ru.vdh.todo.addtodo.data.mapper

import ru.vdh.todo.addtodo.data.model.NewFeatureDataModel
import ru.vdh.todo.addtodo.domain.model.NewFeatureDomainModel

class NewFeatureDataModelToDomainMapper {
    fun toDomain(newFeatureDataModel: NewFeatureDataModel) =
        NewFeatureDomainModel(firstName = newFeatureDataModel.firstName, lastName = newFeatureDataModel.lastName)
}