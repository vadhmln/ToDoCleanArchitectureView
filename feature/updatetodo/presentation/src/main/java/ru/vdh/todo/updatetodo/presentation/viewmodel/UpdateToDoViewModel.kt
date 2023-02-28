package ru.vdh.todo.updatetodo.presentation.viewmodel

import android.app.Application
import android.util.Log
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.vdh.todo.core.presentation.viewmodel.BaseViewModel
import ru.vdh.todo.core.presentation.viewmodel.usecase.UseCaseExecutorProvider
import ru.vdh.todo.updatetodo.domain.usecase.DeleteToDoUseCase
import ru.vdh.todo.updatetodo.domain.usecase.UpdateToDoUseCase
import ru.vdh.todo.updatetodo.presentation.mapper.UpdateToDoPresentationToDomainMapper
import ru.vdh.todo.updatetodo.presentation.model.UpdateToDoPresentationModel
import ru.vdh.todo.updatetodo.presentation.model.UpdateToDoPresentationNotification
import ru.vdh.todo.updatetodo.presentation.model.UpdateToDoViewState
import javax.inject.Inject

@HiltViewModel
class UpdateToDoViewModel @Inject constructor(
    private val updateToDoUseCase: UpdateToDoUseCase,
    private val deleteToDoUseCase: DeleteToDoUseCase,
    private val updateToDoPresentationToDomainMapper: UpdateToDoPresentationToDomainMapper,
    useCaseExecutorProvider: UseCaseExecutorProvider,
    application: Application
) : BaseViewModel<UpdateToDoViewState, UpdateToDoPresentationNotification>(
    useCaseExecutorProvider,
    application
) {

    override fun initialState() = UpdateToDoViewState()

    init {
        Log.e("AAA", "UserDetailsViewModel created!!!")
    }

    fun updateToDo(updateToDoPresentationModel: UpdateToDoPresentationModel) {
//        updateViewState(UpdateToDoViewState::loading)
        val domainToDo = updateToDoPresentationToDomainMapper.toDomain(updateToDoPresentationModel)
        execute(updateToDoUseCase, domainToDo)
    }

    fun deleteItem(updateToDoPresentationModel: UpdateToDoPresentationModel) {
        val domainToDo = updateToDoPresentationToDomainMapper.toDomain(updateToDoPresentationModel)
        execute(deleteToDoUseCase, domainToDo)
    }

    fun parsePriorityToInt(priority: String): Int {
        return when (priority) {
            "High priority" -> 0
            "Medium priority" -> 1
            "Low priority" -> 2
            else -> {
                2
            }
        }
    }

    //вызывается когда связанная с ней активити/fragment уничтожается
    override fun onCleared() {
        Log.e("AAA", "UpdateToDoViewModel cleared!!!")
        super.onCleared()
    }
}