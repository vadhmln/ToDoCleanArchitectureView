package ru.vdh.todo.updatetodo.data.mapper

import ru.vdh.todo.updatetodo.data.model.NewFeatureDataModel
import ru.vdh.todo.updatetodo.domain.model.NewFeatureDomainModel

class NewFeatureDataModelToDomainMapper {
    fun toDomain(newFeatureDataModel: NewFeatureDataModel) =
        NewFeatureDomainModel(firstName = newFeatureDataModel.firstName, lastName = newFeatureDataModel.lastName)
}