package ru.vdh.todo.addtodo.domain.repository

import ru.vdh.todo.addtodo.domain.model.NewFeatureDomainModel

interface NewFeatureRepository {

    fun save(newFeature: NewFeatureDomainModel): Boolean

    fun get(): NewFeatureDomainModel
}