package ru.vdh.todo.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.vdh.todo.updatetodo.data.datasource.UpdateToDoDataSource
import ru.vdh.todo.updatetodo.data.mapper.UpdateToDoDataModelToDataSourceMapper
import ru.vdh.todo.updatetodo.data.mapper.UpdateToDoDataModelToDomainMapper
import ru.vdh.todo.updatetodo.data.repository.NewFeatureRepositoryImpl
import ru.vdh.todo.updatetodo.domain.repository.NewFeatureRepository
import ru.vdh.todo.updatetodo.presentation.mapper.NewFeaturePresentationToDomainMapper
import ru.vdh.todo.updatetodo.presentation.mapper.UpdateToDoDomainToPresentationMapper
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UpdateToDoDataModule {

    @Provides
    fun providesNewFeatureDataModelToDomainMapper() = UpdateToDoDataModelToDomainMapper()

    @Provides
    fun providesNewFeatureDataModelToDataSourceMapper() = UpdateToDoDataModelToDataSourceMapper()

    @Provides
    fun providesNewFeaturePresentationToDomainMapper() = NewFeaturePresentationToDomainMapper()

    @Provides
    fun providesNewFeatureDomainToPresentationMapper() = UpdateToDoDomainToPresentationMapper()

    @Provides
    @Singleton
    fun provideNewFeatureRepository(
        updateToDoDataSource: UpdateToDoDataSource,
        updateToDoDataModelToDomainMapper: UpdateToDoDataModelToDomainMapper,
        updateToDoDataModelToDataSourceMapper: UpdateToDoDataModelToDataSourceMapper
    ): NewFeatureRepository = NewFeatureRepositoryImpl(
        updateToDoDataSource = updateToDoDataSource,
        updateToDoDataModelToDomainMapper,
        updateToDoDataModelToDataSourceMapper
    )
}