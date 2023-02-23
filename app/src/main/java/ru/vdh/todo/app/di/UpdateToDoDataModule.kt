package ru.vdh.todo.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.vdh.todo.updatetodo.data.datasource.UpdateToDoDataSource
import ru.vdh.todo.updatetodo.data.mapper.UpdateToDoDataModelToDataSourceMapper
import ru.vdh.todo.updatetodo.data.mapper.UpdateToDoDataModelToDomainMapper
import ru.vdh.todo.updatetodo.data.repository.UpdateToDoRepositoryImpl
import ru.vdh.todo.updatetodo.domain.repository.UpdateToDoRepository
import ru.vdh.todo.updatetodo.presentation.mapper.UpdateToDoPresentationToDomainMapper
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
    fun providesNewFeaturePresentationToDomainMapper() = UpdateToDoPresentationToDomainMapper()

    @Provides
    fun providesNewFeatureDomainToPresentationMapper() = UpdateToDoDomainToPresentationMapper()

    @Provides
    @Singleton
    fun provideNewFeatureRepository(
        updateToDoDataSource: UpdateToDoDataSource,
        updateToDoDataModelToDomainMapper: UpdateToDoDataModelToDomainMapper,
        updateToDoDataModelToDataSourceMapper: UpdateToDoDataModelToDataSourceMapper
    ): UpdateToDoRepository = UpdateToDoRepositoryImpl(
        updateToDoDataSource = updateToDoDataSource,
        updateToDoDataModelToDomainMapper,
        updateToDoDataModelToDataSourceMapper
    )
}