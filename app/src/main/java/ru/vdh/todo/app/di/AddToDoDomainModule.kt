package ru.vdh.todo.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.vdh.todo.core.domain.coroutine.CoroutineContextProvider
import ru.vdh.todo.addtodo.domain.repository.AddToDoRepository
import ru.vdh.todo.addtodo.domain.usecase.GetToDoListUseCase
import ru.vdh.todo.addtodo.domain.usecase.AddToDoUseCase


@Module
@InstallIn(ViewModelComponent::class)
class AddToDoDomainModule {

    @Provides
    fun provideGetToDoListUseCase(
        addToDoRepository: AddToDoRepository,
        coroutineContextProvider: CoroutineContextProvider
    ): GetToDoListUseCase =
        GetToDoListUseCase(
            addToDoRepository = addToDoRepository,
            coroutineContextProvider = coroutineContextProvider
        )


    @Provides
    fun provideAddToDoUseCase(
        addToDoRepository: AddToDoRepository,
        coroutineContextProvider: CoroutineContextProvider
    ): AddToDoUseCase =
        AddToDoUseCase(
            addToDoRepository = addToDoRepository,
            coroutineContextProvider = coroutineContextProvider
        )

}