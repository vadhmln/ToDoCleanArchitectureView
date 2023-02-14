package ru.vdh.todo.addtodo.data.repository

import ru.vdh.todo.addtodo.data.datasource.NewFeatureDataSource
import ru.vdh.todo.addtodo.data.mapper.NewFeatureDataModelToDataSourceMapper
import ru.vdh.todo.addtodo.data.mapper.NewFeatureDataModelToDomainMapper
import ru.vdh.todo.addtodo.domain.model.NewFeatureDomainModel
import ru.vdh.todo.addtodo.domain.repository.NewFeatureRepository

class NewFeatureRepositoryImpl(
    private val newFeatureDataSource: NewFeatureDataSource,
    private val newFeatureDataModelToDomainMapper: NewFeatureDataModelToDomainMapper,
    private val newFeatureDataModelToDataSourceMapper: NewFeatureDataModelToDataSourceMapper
) : NewFeatureRepository {

    override fun save(newFeature: NewFeatureDomainModel): Boolean {
        val user = newFeatureDataModelToDataSourceMapper.toDataSource(newFeature)
        return newFeatureDataSource.save(user)
    }

    override fun get(): NewFeatureDomainModel {
        val user = newFeatureDataSource.get()
        return newFeatureDataModelToDomainMapper.toDomain(user)
    }
}


