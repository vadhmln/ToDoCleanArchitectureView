package ru.vdh.todo.updatetodo.data.datasource

import ru.vdh.todo.updatetodo.data.model.NewFeatureDataModel

interface NewFeatureDataSource {
    fun save(newFeatureDataModel: NewFeatureDataModel): Boolean

    fun get(): NewFeatureDataModel
}