package ru.vdh.todo.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.vdh.todo.core.domain.coroutine.CoroutineContextProvider
import ru.vdh.todo.updatetodo.domain.repository.UpdateToDoRepository
import ru.vdh.todo.updatetodo.domain.usecase.UpdateToDoUseCase

@Module
@InstallIn(ViewModelComponent::class)
class UpdateToDoDomainModule {

    @Provides
    fun provideGetNewFeatureUseCase(
        updateToDoRepository: UpdateToDoRepository,
        coroutineContextProvider: CoroutineContextProvider
    ): UpdateToDoUseCase =
        UpdateToDoUseCase(
            updateToDoRepository = updateToDoRepository,
            coroutineContextProvider = coroutineContextProvider
        )
}