package ru.vdh.todo.updatetodo.data.mapper

import ru.vdh.todo.updatetodo.data.model.NewFeatureDataModel
import ru.vdh.todo.updatetodo.domain.model.NewFeatureDomainModel

class NewFeatureDataModelToDataSourceMapper {
    fun toDataSource(userName: NewFeatureDomainModel) =
        NewFeatureDataModel(firstName = userName.firstName, lastName = "")
}