package ru.vdh.todo.updatetodo.ui.binder

import ru.vdh.todo.core.ui.mapper.ViewStateBinder
import ru.vdh.todo.updatetodo.presentation.model.UpdateToDoViewState
import ru.vdh.todo.updatetodo.ui.view.UpdateToDoViewsProvider

class UpdateToDoViewStateBinder :
    ViewStateBinder<UpdateToDoViewState, UpdateToDoViewsProvider> {
    override fun UpdateToDoViewsProvider
            .bindState(viewState: UpdateToDoViewState) = Unit
}