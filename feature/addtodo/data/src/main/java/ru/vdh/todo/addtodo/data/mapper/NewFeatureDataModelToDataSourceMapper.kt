package ru.vdh.todo.addtodo.data.mapper

import ru.vdh.todo.addtodo.data.model.NewFeatureDataModel
import ru.vdh.todo.addtodo.domain.model.NewFeatureDomainModel

class NewFeatureDataModelToDataSourceMapper {
    fun toDataSource(userName: NewFeatureDomainModel) =
        NewFeatureDataModel(firstName = userName.firstName, lastName = "")
}