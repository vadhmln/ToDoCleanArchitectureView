package ru.vdh.todo.updatetodo.domain.usecase

import ru.vdh.todo.core.domain.coroutine.CoroutineContextProvider
import ru.vdh.todo.core.domain.usecase.BackgroundExecutingUseCase
import ru.vdh.todo.updatetodo.domain.model.UpdateToDoDomainModel
import ru.vdh.todo.updatetodo.domain.repository.UpdateToDoRepository

class UpdateToDoUseCase(
    private val updateToDoRepository: UpdateToDoRepository,
    private val coroutineContextProvider: CoroutineContextProvider
) : BackgroundExecutingUseCase<UpdateToDoDomainModel, UpdateToDoDomainModel>(coroutineContextProvider) {
    override fun executeInBackground(request: UpdateToDoDomainModel): UpdateToDoDomainModel {
        TODO("Not yet implemented")
    }


}