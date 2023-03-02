package ru.vdh.todo.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.vdh.todo.core.domain.coroutine.CoroutineContextProvider
import ru.vdh.todo.todolist.domain.repository.ToDoListRepository
import ru.vdh.todo.todolist.domain.usecase.DeleteToDoUseCase
import ru.vdh.todo.todolist.domain.usecase.GetToDoListUseCase

@Module
@InstallIn(ViewModelComponent::class)
class ToDoListDomainModule {

    @Provides
    fun provideGetNewFeatureUseCase(
        toDoListRepository: ToDoListRepository,
        coroutineContextProvider: CoroutineContextProvider
    ): GetToDoListUseCase =
        GetToDoListUseCase(
            toDoListRepository = toDoListRepository,
            coroutineContextProvider = coroutineContextProvider
        )

    @Provides
    fun provideDeleteToDoUseCase(
        toDoListRepository: ToDoListRepository,
        coroutineContextProvider: CoroutineContextProvider
    ): DeleteToDoUseCase =
        DeleteToDoUseCase(
            updateToDoRepository = toDoListRepository,
            coroutineContextProvider = coroutineContextProvider
        )
}