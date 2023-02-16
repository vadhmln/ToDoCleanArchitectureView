package ru.vdh.todo.app.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.vdh.todo.updatetodo.data.datasource.NewFeatureDataSource
import ru.vdh.todo.updatetodo.data.mapper.NewFeatureDataModelToDataSourceMapper
import ru.vdh.todo.updatetodo.data.mapper.NewFeatureDataModelToDomainMapper
import ru.vdh.todo.updatetodo.data.repository.NewFeatureRepositoryImpl
import ru.vdh.todo.updatetodo.datasource.SharedPrefNewFeatureDataSource
import ru.vdh.todo.updatetodo.domain.repository.NewFeatureRepository
import ru.vdh.todo.updatetodo.presentation.mapper.NewFeatureDomainToPresentationMapper
import ru.vdh.todo.updatetodo.presentation.mapper.NewFeaturePresentationToDomainMapper

import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UpdateToDoDataModule {

    @Provides
    fun providesNewFeatureDataModelToDomainMapper() = NewFeatureDataModelToDomainMapper()

    @Provides
    fun providesNewFeatureDataModelToDataSourceMapper() = NewFeatureDataModelToDataSourceMapper()

    @Provides
    fun providesNewFeaturePresentationToDomainMapper() = NewFeaturePresentationToDomainMapper()

    @Provides
    fun providesNewFeatureDomainToPresentationMapper() = NewFeatureDomainToPresentationMapper()

    @Provides
    @Singleton
    fun provideNewFeatureDataSource(@ApplicationContext context: Context): NewFeatureDataSource {
        return SharedPrefNewFeatureDataSource(context = context)
    }

    @Provides
    @Singleton
    fun provideNewFeatureRepository(
        newFeatureDataSource: NewFeatureDataSource,
        newFeatureDataModelToDomainMapper: NewFeatureDataModelToDomainMapper,
        newFeatureDataModelToDataSourceMapper: NewFeatureDataModelToDataSourceMapper
    ): NewFeatureRepository = NewFeatureRepositoryImpl(
        newFeatureDataSource = newFeatureDataSource,
        newFeatureDataModelToDomainMapper,
        newFeatureDataModelToDataSourceMapper
    )
}