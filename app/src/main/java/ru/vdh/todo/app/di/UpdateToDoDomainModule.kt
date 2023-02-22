package ru.vdh.todo.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.vdh.todo.core.domain.coroutine.CoroutineContextProvider
import ru.vdh.todo.updatetodo.domain.repository.NewFeatureRepository
import ru.vdh.todo.updatetodo.domain.usecase.GetNewFeatureUseCase

@Module
@InstallIn(ViewModelComponent::class)
class UpdateToDoDomainModule {

    @Provides
    fun provideGetNewFeatureUseCase(
        newFeatureRepository: NewFeatureRepository,
        coroutineContextProvider: CoroutineContextProvider
    ): GetNewFeatureUseCase =
        GetNewFeatureUseCase(
            newFeatureRepository = newFeatureRepository,
            coroutineContextProvider = coroutineContextProvider
        )
}