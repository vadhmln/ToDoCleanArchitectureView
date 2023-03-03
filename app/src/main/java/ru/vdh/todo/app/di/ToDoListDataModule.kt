package ru.vdh.todo.app.di

import android.content.Context
import android.view.View
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.vdh.todo.core.domain.coroutine.CoroutineContextProvider
import ru.vdh.todo.todolist.data.datasource.ToDoListDataSource
import ru.vdh.todo.todolist.data.mapper.ToDoListDataToDomainMapper
import ru.vdh.todo.todolist.data.mapper.ToDoListDomainToDataMapper
import ru.vdh.todo.todolist.data.repository.ToDoListRepositoryImpl
import ru.vdh.todo.todolist.domain.repository.ToDoListRepository
import ru.vdh.todo.todolist.domain.usecase.DeleteToDoUseCase
import ru.vdh.todo.todolist.domain.usecase.RestoreDeletedToDoUseCase
import ru.vdh.todo.todolist.presentation.UseCaseProvider
import ru.vdh.todo.todolist.presentation.mapper.ToDoListDomainToPresentationMapper
import ru.vdh.todo.todolist.presentation.mapper.ToDoListPresentationToDomainMapper
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ToDoListDataModule {

    @Provides
    fun providesToDoListDataToDomainMapper() = ToDoListDataToDomainMapper()

    @Provides
    fun providesToDoListDomainToDataMapper() = ToDoListDomainToDataMapper()

    @Provides
    fun providesToDoListPresentationToDomainMapper() = ToDoListPresentationToDomainMapper()

    @Provides
    fun providesToDoListDomainToPresentationMapper() = ToDoListDomainToPresentationMapper()

    @Provides
    fun providesView(@ApplicationContext context: Context) = View(context)

    @Provides
    @Singleton
    fun provideToDoListRepository(
        toDoListDataSource: ToDoListDataSource,
        toDoListDataToDomainMapper: ToDoListDataToDomainMapper,
        toDoListDomainToDataMapper: ToDoListDomainToDataMapper
    ): ToDoListRepository = ToDoListRepositoryImpl(
        toDoListDataSource = toDoListDataSource,
        toDoListDataToDomainMapper,
        toDoListDomainToDataMapper
    )

    @Provides
    fun provideDeleteToDoUseCase(
        toDoListRepository: ToDoListRepository,
        coroutineContextProvider: CoroutineContextProvider
    ): DeleteToDoUseCase =
        DeleteToDoUseCase(
            toDoListRepository = toDoListRepository,
            coroutineContextProvider = coroutineContextProvider
        )

    @Provides
    fun provideRestoreDeletedToDoUseCase(
        toDoListRepository: ToDoListRepository,
        coroutineContextProvider: CoroutineContextProvider
    ): RestoreDeletedToDoUseCase =
        RestoreDeletedToDoUseCase(
            toDoListRepository = toDoListRepository,
            coroutineContextProvider = coroutineContextProvider
        )

    @Provides
    fun providesUseCaseProvider(
        deleteToDoUseCase: DeleteToDoUseCase,
        restoreDeletedToDoUseCase: RestoreDeletedToDoUseCase,
        toDoListPresentationToDomainMapper: ToDoListPresentationToDomainMapper,
    ) =
        UseCaseProvider(
            deleteToDoUseCase,
            restoreDeletedToDoUseCase,
            toDoListPresentationToDomainMapper
        )

}