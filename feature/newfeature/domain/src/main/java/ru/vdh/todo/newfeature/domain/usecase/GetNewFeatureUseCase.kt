package ru.vdh.todo.newfeature.domain.usecase

import ru.vdh.todo.core.domain.coroutine.CoroutineContextProvider
import ru.vdh.todo.core.domain.usecase.BackgroundExecutingUseCase
import ru.vdh.todo.newfeature.domain.model.NewFeatureDomainModel
import ru.vdh.todo.newfeature.domain.repository.NewFeatureRepository

class GetNewFeatureUseCase(
    private val newFeatureRepository: NewFeatureRepository,
    private val coroutineContextProvider: CoroutineContextProvider
) : BackgroundExecutingUseCase<NewFeatureDomainModel, NewFeatureDomainModel>(coroutineContextProvider) {

    fun execute(): NewFeatureDomainModel {
        return newFeatureRepository.get()
    }

    override fun executeInBackground(request: NewFeatureDomainModel) = newFeatureRepository.get()
}