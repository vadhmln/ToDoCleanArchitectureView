package ru.vdh.todo.newfeature.data.mapper

import ru.vdh.todo.newfeature.data.model.NewFeatureDataModel
import ru.vdh.todo.newfeature.domain.model.NewFeatureDomainModel

class NewFeatureDataModelToDomainMapper {
    fun toDomain(newFeatureDataModel: NewFeatureDataModel) =
        NewFeatureDomainModel(firstName = newFeatureDataModel.firstName, lastName = newFeatureDataModel.lastName)
}