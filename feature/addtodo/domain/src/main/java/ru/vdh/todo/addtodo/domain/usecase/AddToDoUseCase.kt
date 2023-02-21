package ru.vdh.todo.addtodo.domain.usecase

import ru.vdh.todo.core.domain.coroutine.CoroutineContextProvider
import ru.vdh.todo.core.domain.usecase.BackgroundExecutingUseCase
import ru.vdh.todo.addtodo.domain.model.AddToDoDomainModel
import ru.vdh.todo.addtodo.domain.repository.AddToDoRepository

class AddToDoUseCase(
    private val addToDoRepository: AddToDoRepository,
    coroutineContextProvider: CoroutineContextProvider
) : BackgroundExecutingUseCase<AddToDoDomainModel, Unit>(coroutineContextProvider) {

    override fun executeInBackground(request: AddToDoDomainModel) {
        addToDoRepository.addToDo(addToDoDomainModel = request)
    }
}



