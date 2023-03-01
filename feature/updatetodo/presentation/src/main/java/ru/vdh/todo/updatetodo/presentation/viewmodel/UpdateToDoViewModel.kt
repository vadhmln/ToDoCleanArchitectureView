package ru.vdh.todo.updatetodo.presentation.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import ru.vdh.todo.core.presentation.viewmodel.BaseViewModel
import ru.vdh.todo.core.presentation.viewmodel.usecase.UseCaseExecutorProvider
import ru.vdh.todo.updatetodo.domain.usecase.DeleteToDoUseCase
import ru.vdh.todo.updatetodo.domain.usecase.GetToDoItemByIdUseCase
import ru.vdh.todo.updatetodo.domain.usecase.UpdateToDoUseCase
import ru.vdh.todo.updatetodo.presentation.destination.UpdateToDoPresentationDestination.ToDoList
import ru.vdh.todo.updatetodo.presentation.mapper.UpdateToDoDomainToPresentationMapper
import ru.vdh.todo.updatetodo.presentation.mapper.UpdateToDoPresentationToDomainMapper
import ru.vdh.todo.updatetodo.presentation.model.UpdateToDoPresentationModel
import ru.vdh.todo.updatetodo.presentation.model.UpdateToDoPresentationNotification
import ru.vdh.todo.updatetodo.presentation.model.UpdateToDoViewState
import javax.inject.Inject

@HiltViewModel
class UpdateToDoViewModel @Inject constructor(
    private val updateToDoUseCase: UpdateToDoUseCase,
    private val deleteToDoUseCase: DeleteToDoUseCase,
    private val getToDoItemByIdUseCase: GetToDoItemByIdUseCase,
    private val updateToDoPresentationToDomainMapper: UpdateToDoPresentationToDomainMapper,
    private val updateToDoDomainToPresentationMapper: UpdateToDoDomainToPresentationMapper,
    useCaseExecutorProvider: UseCaseExecutorProvider,
    application: Application
) : BaseViewModel<UpdateToDoViewState, UpdateToDoPresentationNotification>(
    useCaseExecutorProvider,
    application
) {

    override fun initialState() = UpdateToDoViewState.EXISTING_TODO

    init {
        Log.e("AAA", "UserDetailsViewModel created!!!")
    }

    fun updateToDo(updateToDoPresentationModel: UpdateToDoPresentationModel) {
//        updateViewState(UpdateToDoViewState::loading)
        val domainToDo = updateToDoPresentationToDomainMapper.toDomain(updateToDoPresentationModel)
        execute(updateToDoUseCase, domainToDo)
    }

    fun onUpdateToDo(toDoId: Int) {
        navigateTo(ToDoList(toDoId))
    }

    fun deleteItem(updateToDoPresentationModel: UpdateToDoPresentationModel) {
        val domainToDo = updateToDoPresentationToDomainMapper.toDomain(updateToDoPresentationModel)
        execute(deleteToDoUseCase, domainToDo)
    }

    fun getItemById(toDoId: Int): LiveData<UpdateToDoPresentationModel> {
        return getToDoItemByIdUseCase.executeInBackground(toDoId)
            .map(updateToDoDomainToPresentationMapper::toPresentation).asLiveData()
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