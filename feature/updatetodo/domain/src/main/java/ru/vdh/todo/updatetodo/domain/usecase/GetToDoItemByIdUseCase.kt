package ru.vdh.todo.updatetodo.domain.usecase

import kotlinx.coroutines.flow.Flow
import ru.vdh.todo.core.domain.coroutine.CoroutineContextProvider
import ru.vdh.todo.core.domain.usecase.BackgroundExecutingUseCase
import ru.vdh.todo.updatetodo.domain.model.UpdateToDoDomainModel
import ru.vdh.todo.updatetodo.domain.repository.UpdateToDoRepository

class GetToDoItemByIdUseCase(
    private val updateToDoRepository: UpdateToDoRepository,
    private val coroutineContextProvider: CoroutineContextProvider
) : BackgroundExecutingUseCase<Int, Flow<UpdateToDoDomainModel>>(
    coroutineContextProvider
) {

    override fun executeInBackground(request: Int) =
        updateToDoRepository.getItemById(request)
}