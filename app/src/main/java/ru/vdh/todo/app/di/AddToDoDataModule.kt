package ru.vdh.todo.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.vdh.todo.addtodo.data.datasource.AddToDoDataSource
import ru.vdh.todo.addtodo.data.mapper.AddToDoDataToDomainMapper
import ru.vdh.todo.addtodo.data.mapper.AddToDoDomainToDataMapper
import ru.vdh.todo.addtodo.data.repository.AddToDoRepositoryImpl
import ru.vdh.todo.addtodo.domain.repository.AddToDoRepository
import ru.vdh.todo.addtodo.presentation.mapper.AddToDoDomainToPresentationMapper
import ru.vdh.todo.addtodo.presentation.mapper.AddToDoPresentationToDomainMapper
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AddToDoDataModule {

    @Provides
    fun providesAddToDoDataToDomainMapper() = AddToDoDataToDomainMapper()

    @Provides
    fun providesAddToDoDomainToDataMapper() = AddToDoDomainToDataMapper()

    @Provides
    fun providesAddToDoPresentationToDomainMapper() = AddToDoPresentationToDomainMapper()

    @Provides
    fun providesAddToDoDomainToPresentationMapper() = AddToDoDomainToPresentationMapper()

    @Provides
    @Singleton
    fun provideAddToDoRepository(
        addToDoDataSource: AddToDoDataSource,
        addToDoDomainToDataMapper: AddToDoDomainToDataMapper,
    ): AddToDoRepository = AddToDoRepositoryImpl(
        addToDoDataSource = addToDoDataSource,
        addToDoDomainToDataMapper
    )
}