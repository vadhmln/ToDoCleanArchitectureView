package ru.vdh.todo.newfeature.domain.repository

import ru.vdh.todo.newfeature.domain.model.NewFeatureDomainModel

interface NewFeatureRepository {

    fun save(newFeature: NewFeatureDomainModel): Boolean

    fun get(): NewFeatureDomainModel
}