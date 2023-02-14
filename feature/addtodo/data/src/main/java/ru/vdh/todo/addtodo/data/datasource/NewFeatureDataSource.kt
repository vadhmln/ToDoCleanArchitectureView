package ru.vdh.todo.addtodo.data.datasource

import ru.vdh.todo.addtodo.data.model.NewFeatureDataModel

interface NewFeatureDataSource {
    fun save(newFeatureDataModel: NewFeatureDataModel): Boolean

    fun get(): NewFeatureDataModel
}