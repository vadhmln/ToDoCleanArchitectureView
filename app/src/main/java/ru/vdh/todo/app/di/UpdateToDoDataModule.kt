package ru.vdh.todo.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.vdh.todo.updatetodo.data.datasource.UpdateToDoDataSource
import ru.vdh.todo.updatetodo.data.mapper.UpdateToDoDataToDomainMapper
import ru.vdh.todo.updatetodo.data.mapper.UpdateToDoDomainToDataMapper
import ru.vdh.todo.updatetodo.data.repository.UpdateToDoRepositoryImpl
import ru.vdh.todo.updatetodo.domain.repository.UpdateToDoRepository
import ru.vdh.todo.updatetodo.presentation.mapper.UpdateToDoDomainToPresentationMapper
import ru.vdh.todo.updatetodo.presentation.mapper.UpdateToDoPresentationToDomainMapper
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UpdateToDoDataModule {

    @Provides
    fun providesUpdateToDoDataToDomainMapper() = UpdateToDoDataToDomainMapper()

    @Provides
    fun providesUpdateToDoDomainToDataMapper() = UpdateToDoDomainToDataMapper()

    @Provides
    fun providesUpdateToDoPresentationToDomainMapper() = UpdateToDoPresentationToDomainMapper()

    @Provides
    fun providesUpdateToDoDomainToPresentationMapper() = UpdateToDoDomainToPresentationMapper()

    @Provides
    @Singleton
    fun provideUpdateToDoRepository(
        updateToDoDataSource: UpdateToDoDataSource,
        updateToDoDomainToDataMapper: UpdateToDoDomainToDataMapper,
    ): UpdateToDoRepository = UpdateToDoRepositoryImpl(
        updateToDoDataSource,
        updateToDoDomainToDataMapper
    )
}