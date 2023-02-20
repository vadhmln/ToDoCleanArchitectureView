package ru.vdh.todo.addtodo.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import ru.vdh.todo.addtodo.domain.model.AddToDoDomainModel
import ru.vdh.todo.addtodo.domain.usecase.GetToDoListUseCase
import ru.vdh.todo.addtodo.domain.usecase.AddToDoUseCase
import ru.vdh.todo.core.presentation.viewmodel.BaseViewModel
import ru.vdh.todo.core.presentation.viewmodel.usecase.UseCaseExecutorProvider
import ru.vdh.todo.addtodo.presentation.mapper.AddToDoDomainToPresentationMapper
import ru.vdh.todo.addtodo.presentation.mapper.AddToDoPresentationToDomainMapper
import ru.vdh.todo.addtodo.presentation.model.AddToDoPresentationNotification
import ru.vdh.todo.addtodo.presentation.model.AddToDoViewState
import ru.vdh.todo.addtodo.presentation.model.AddToDoPresentationModel
import javax.inject.Inject

@HiltViewModel
class AddToDoViewModel @Inject constructor(
    private val getToDoListUseCase: GetToDoListUseCase,
    private val addToDoUseCase: AddToDoUseCase,
    useCaseExecutorProvider: UseCaseExecutorProvider,
    private val addToDoPresentationToDomainMapper: AddToDoPresentationToDomainMapper,
    private val addToDoDomainToPresentationMapper: AddToDoDomainToPresentationMapper
) : BaseViewModel<AddToDoViewState, AddToDoPresentationNotification>(useCaseExecutorProvider) {

    override fun initialState() = AddToDoViewState()

    private val resultMutableLiveData = MutableLiveData<String>()
    val resultLiveData: LiveData<String> = resultMutableLiveData

    init {
        Log.e("AAA", "AddToDoViewModel created!!!")
    }

    //вызывается когда связанная с ней активити/fragment уничтожается
    override fun onCleared() {
        Log.e("AAA", "AddToDoViewModel cleared!!!")
        super.onCleared()
    }

    fun onAddToDoAction(addToDoPresentationModel: AddToDoPresentationModel) {
        updateViewState(AddToDoViewState::loading)
        val domainToDo =
            addToDoPresentationToDomainMapper.toDomain(addToDoPresentationModel)
        execute(addToDoUseCase, domainToDo)
    }

    fun getAllToDoList(request: Flow<List<AddToDoDomainModel>>) {
//        val toDoDetails = addToDoDomainToPresentationMapper
//            .toPresentation(addToDoDomainModel)
//        updateViewState { toDoDetailsReady(toDoDetails) }
        execute(getToDoListUseCase, request)
    }

//    private fun presentDishDetails(addToDoDomainModel: AddToDoDomainModel) {
//        val dishDetails = addToDoDomainToPresentationMapper
//            .toPresentation(addToDoDomainModel)
//        updateViewState { toDoDetailsReady(dishDetails) }
//    }

}