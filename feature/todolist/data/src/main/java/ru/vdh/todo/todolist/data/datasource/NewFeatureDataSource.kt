package ru.vdh.todo.todolist.data.datasource

import ru.vdh.todo.todolist.data.model.NewFeatureDataModel

interface NewFeatureDataSource {
    fun save(newFeatureDataModel: NewFeatureDataModel): Boolean

    fun get(): NewFeatureDataModel
}