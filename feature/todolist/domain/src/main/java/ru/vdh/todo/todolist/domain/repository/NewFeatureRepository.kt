package ru.vdh.todo.todolist.domain.repository

import ru.vdh.todo.todolist.domain.model.NewFeatureDomainModel

interface NewFeatureRepository {

    fun save(newFeature: NewFeatureDomainModel): Boolean

    fun get(): NewFeatureDomainModel
}