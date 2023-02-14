package ru.vdh.todo.app.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.vdh.todo.todolist.data.datasource.NewFeatureDataSource
import ru.vdh.todo.todolist.data.mapper.NewFeatureDataModelToDataSourceMapper
import ru.vdh.todo.todolist.data.mapper.NewFeatureDataModelToDomainMapper
import ru.vdh.todo.todolist.data.repository.NewFeatureRepositoryImpl
import ru.vdh.todo.todolist.datasource.SharedPrefNewFeatureDataSource
import ru.vdh.todo.todolist.domain.repository.NewFeatureRepository
import ru.vdh.todo.todolist.presentation.mapper.NewFeatureDomainToPresentationMapper
import ru.vdh.todo.todolist.presentation.mapper.NewFeaturePresentationToDomainMapper
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ToDoListDataModule {

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