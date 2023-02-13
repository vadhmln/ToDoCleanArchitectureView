package ru.vdh.todo.todolist.data.mapper

import ru.vdh.todo.todolist.data.model.NewFeatureDataModel
import ru.vdh.todo.todolist.domain.model.NewFeatureDomainModel

class NewFeatureDataModelToDomainMapper {
    fun toDomain(newFeatureDataModel: NewFeatureDataModel) =
        NewFeatureDomainModel(firstName = newFeatureDataModel.firstName, lastName = newFeatureDataModel.lastName)
}