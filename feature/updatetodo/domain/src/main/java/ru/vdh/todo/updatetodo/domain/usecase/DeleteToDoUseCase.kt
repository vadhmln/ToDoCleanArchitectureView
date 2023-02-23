package ru.vdh.todo.updatetodo.domain.usecase

import ru.vdh.todo.core.domain.coroutine.CoroutineContextProvider
import ru.vdh.todo.core.domain.usecase.BackgroundExecutingUseCase
import ru.vdh.todo.updatetodo.domain.model.UpdateToDoDomainModel
import ru.vdh.todo.updatetodo.domain.repository.UpdateToDoRepository

class DeleteToDoUseCase(
    private val updateToDoRepository: UpdateToDoRepository,
    coroutineContextProvider: CoroutineContextProvider
) : BackgroundExecutingUseCase<UpdateToDoDomainModel, Unit>(coroutineContextProvider) {

    override fun executeInBackground(request: UpdateToDoDomainModel) {
        updateToDoRepository.deleteToDo(request)
    }
}