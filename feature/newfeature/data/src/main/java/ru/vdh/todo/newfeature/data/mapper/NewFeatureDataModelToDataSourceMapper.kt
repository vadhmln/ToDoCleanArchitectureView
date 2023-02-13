package ru.vdh.todo.newfeature.data.mapper

import ru.vdh.todo.newfeature.data.model.NewFeatureDataModel
import ru.vdh.todo.newfeature.domain.model.NewFeatureDomainModel

class NewFeatureDataModelToDataSourceMapper {
    fun toDataSource(userName: NewFeatureDomainModel) =
        NewFeatureDataModel(firstName = userName.firstName, lastName = "")
}