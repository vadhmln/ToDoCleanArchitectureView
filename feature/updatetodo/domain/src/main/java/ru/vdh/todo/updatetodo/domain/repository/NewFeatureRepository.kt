package ru.vdh.todo.updatetodo.domain.repository

import ru.vdh.todo.updatetodo.domain.model.NewFeatureDomainModel

interface NewFeatureRepository {

    fun save(newFeature: NewFeatureDomainModel): Boolean

    fun get(): NewFeatureDomainModel
}