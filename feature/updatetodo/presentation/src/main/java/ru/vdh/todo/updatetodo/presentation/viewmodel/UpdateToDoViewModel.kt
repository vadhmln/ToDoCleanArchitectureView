package ru.vdh.todo.updatetodo.presentation.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.vdh.todo.core.presentation.viewmodel.BaseViewModel
import ru.vdh.todo.core.presentation.viewmodel.usecase.UseCaseExecutorProvider
import ru.vdh.todo.updatetodo.domain.usecase.GetNewFeatureUseCase
import ru.vdh.todo.updatetodo.presentation.mapper.UpdateToDoDomainToPresentationMapper
import ru.vdh.todo.updatetodo.presentation.mapper.NewFeaturePresentationToDomainMapper
import ru.vdh.todo.updatetodo.presentation.model.NewFeaturePresentationNotification
import ru.vdh.todo.updatetodo.presentation.model.NewFeatureViewState
import javax.inject.Inject

@HiltViewModel
class UpdateToDoViewModel @Inject constructor(
    private val getNewFeatureUseCase: GetNewFeatureUseCase,
    private val newFeaturePresentationToDomainMapper: NewFeaturePresentationToDomainMapper,
    private val updateToDoDomainToPresentationMapper: UpdateToDoDomainToPresentationMapper,
    useCaseExecutorProvider: UseCaseExecutorProvider,
    application: Application
) : BaseViewModel<NewFeatureViewState, NewFeaturePresentationNotification>(
    useCaseExecutorProvider,
    application
) {

    override fun initialState() = NewFeatureViewState()

    private val resultMutableLiveData = MutableLiveData<String>()
    val resultLiveData: LiveData<String> = resultMutableLiveData

    init {
        Log.e("AAA", "UserDetailsViewModel created!!!")
    }

    //вызывается когда связанная с ней активити/fragment уничтожается
    override fun onCleared() {
        Log.e("AAA", "UserDetailsViewModel cleared!!!")
        super.onCleared()
    }

    fun parsePriority(priority: String): Int {
        return when (priority) {
            "High priority" -> 0
            "Medium priority" -> 1
            "Low priority" -> 2
            else -> {
                2
            }
        }
    }

}