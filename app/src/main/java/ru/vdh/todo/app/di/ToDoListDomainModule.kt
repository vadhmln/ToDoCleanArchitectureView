package ru.vdh.todo.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.vdh.todo.core.domain.coroutine.CoroutineContextProvider
import ru.vdh.todo.todolist.domain.repository.ToDoListRepository
import ru.vdh.todo.todolist.domain.usecase.DeleteAllToDoUseCase
import ru.vdh.todo.todolist.domain.usecase.GetToDoListUseCase
import ru.vdh.todo.todolist.domain.usecase.SearchByHighPriorityUseCase
import ru.vdh.todo.todolist.domain.usecase.SearchByLowPriorityUseCase
import ru.vdh.todo.todolist.domain.usecase.SearchInDatabaseUseCase

@Module
@InstallIn(ViewModelComponent::class)
class ToDoListDomainModule {

    @Provides
    fun provideGetToDoListUseCase(
        toDoListRepository: ToDoListRepository,
        coroutineContextProvider: CoroutineContextProvider
    ): GetToDoListUseCase =
        GetToDoListUseCase(
            toDoListRepository = toDoListRepository,
            coroutineContextProvider = coroutineContextProvider
        )

    @Provides
    fun provideDeleteAllToDoUseCase(
        toDoListRepository: ToDoListRepository,
        coroutineContextProvider: CoroutineContextProvider
    ): DeleteAllToDoUseCase =
        DeleteAllToDoUseCase(
            toDoListRepository = toDoListRepository,
            coroutineContextProvider = coroutineContextProvider
        )

    @Provides
    fun provideSearchInDatabaseUseCase(
        toDoListRepository: ToDoListRepository,
        coroutineContextProvider: CoroutineContextProvider
    ): SearchInDatabaseUseCase =
        SearchInDatabaseUseCase(
            toDoListRepository = toDoListRepository,
            coroutineContextProvider = coroutineContextProvider
        )

    @Provides
    fun provideSearchByHighPriorityUseCase(
        toDoListRepository: ToDoListRepository,
        coroutineContextProvider: CoroutineContextProvider
    ): SearchByHighPriorityUseCase =
        SearchByHighPriorityUseCase(
            toDoListRepository = toDoListRepository,
            coroutineContextProvider = coroutineContextProvider
        )

    @Provides
    fun provideSearchByLowPriorityUseCase(
        toDoListRepository: ToDoListRepository,
        coroutineContextProvider: CoroutineContextProvider
    ): SearchByLowPriorityUseCase =
        SearchByLowPriorityUseCase(
            toDoListRepository = toDoListRepository,
            coroutineContextProvider = coroutineContextProvider
        )
}