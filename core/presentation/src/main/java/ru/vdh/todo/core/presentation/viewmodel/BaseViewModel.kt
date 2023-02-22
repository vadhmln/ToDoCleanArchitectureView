package ru.vdh.todo.core.presentation.viewmodel

import android.app.Application
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ru.vdh.todo.core.presentation.model.PresentationDestination
import ru.vdh.todo.core.presentation.viewmodel.livedata.SingleLiveEvent
import ru.vdh.todo.core.presentation.viewmodel.usecase.UseCaseExecutorProvider
import ru.vdh.todo.core.domain.exception.DomainException
import ru.vdh.todo.core.domain.usecase.UseCase
import ru.vdh.todo.core.presentation.R

abstract class BaseViewModel<VIEW_STATE : Any, NOTIFICATION : Any>(
    useCaseExecutorProvider: UseCaseExecutorProvider,
    application: Application
) : ViewModel() {
    private val _viewState = MutableLiveData<VIEW_STATE>()
        .apply { value = initialState() }
    val viewState = _viewState.asLiveData()
    private val _notification = SingleLiveEvent<NOTIFICATION>()
    val notification = _notification.asLiveData()
    private val _destination = SingleLiveEvent<PresentationDestination>()
    val destination = _destination.asLiveData()

    protected abstract fun initialState(): VIEW_STATE

    private val currentViewState: VIEW_STATE
        get() = viewState.value ?: initialState()

    private val useCaseExecutor by lazy {
        useCaseExecutorProvider(viewModelScope)
    }

    protected fun <OUTPUT> execute(
        useCase: UseCase<Unit, OUTPUT>,
        onSuccess: (OUTPUT) -> Unit = {},
        onException: (DomainException) -> Unit = {}
    ) {
        execute(useCase, Unit, onSuccess, onException)
    }

    protected fun <INPUT, OUTPUT> execute(
        useCase: UseCase<INPUT, OUTPUT>,
        value: INPUT,
        onSuccess: (OUTPUT) -> Unit = {},
        onException: (DomainException) -> Unit = {}
    ) {
        useCaseExecutor.execute(useCase, value, onSuccess, onException)
    }

    protected fun updateViewState(newViewState: VIEW_STATE) {
        _viewState.value = newViewState
    }

    protected fun updateViewState(
        updatedState: VIEW_STATE.() -> VIEW_STATE
    ) = updateViewState(currentViewState.updatedState())

    protected fun notify(notification: NOTIFICATION) {
        _notification.value = notification
    }

    protected fun navigateTo(destination: PresentationDestination) {
        _destination.value = destination
    }

    protected fun navigateBack() {
        _destination.value = PresentationDestination.Back
    }

    private fun <T> LiveData<T>.asLiveData() = this

    /** Add/Update Fragment */

    val listener: AdapterView.OnItemSelectedListener = object :
        AdapterView.OnItemSelectedListener{
        override fun onNothingSelected(p0: AdapterView<*>?) {}
        override fun onItemSelected(
            parent: AdapterView<*>?,
            view: View?,
            position: Int,
            id: Long
        ) {
            when(position){
                0 -> { (parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(application, R.color.red)) }
                1 -> { (parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(application, R.color.yellow)) }
                2 -> { (parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(application, R.color.green)) }
            }
        }
    }

    fun verifyDataFromUser(title: String, description: String): Boolean {
        return !(title.isEmpty() || description.isEmpty())
    }
}
