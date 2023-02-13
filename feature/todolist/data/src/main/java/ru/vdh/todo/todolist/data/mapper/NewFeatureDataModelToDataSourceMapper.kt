package ru.vdh.todo.todolist.data.mapper

import ru.vdh.todo.todolist.data.model.NewFeatureDataModel
import ru.vdh.todo.todolist.domain.model.NewFeatureDomainModel

class NewFeatureDataModelToDataSourceMapper {
    fun toDataSource(userName: NewFeatureDomainModel) =
        NewFeatureDataModel(firstName = userName.firstName, lastName = "")
}