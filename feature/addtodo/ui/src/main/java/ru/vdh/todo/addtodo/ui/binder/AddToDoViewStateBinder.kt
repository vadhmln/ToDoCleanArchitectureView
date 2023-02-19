package ru.vdh.todo.addtodo.ui.binder

import ru.vdh.todo.addtodo.presentation.model.AddToDoViewState
import ru.vdh.todo.core.ui.mapper.ViewStateBinder
import ru.vdh.todo.addtodo.ui.view.AddToDoViewsProvider

class AddToDoViewStateBinder :
    ViewStateBinder<AddToDoViewState, AddToDoViewsProvider> {
    override fun AddToDoViewsProvider
            .bindState(viewState: AddToDoViewState) = Unit
}