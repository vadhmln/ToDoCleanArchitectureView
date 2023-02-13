package ru.vdh.todo.todolist.ui.binder

import ru.vdh.todo.core.ui.mapper.ViewStateBinder
import ru.vdh.todo.todolist.presentation.model.NewFeatureViewState
import ru.vdh.todo.todolist.ui.view.NewFeatureViewsProvider

class NewFeatureViewStateBinder :
    ViewStateBinder<NewFeatureViewState, NewFeatureViewsProvider> {
    override fun NewFeatureViewsProvider
            .bindState(viewState: NewFeatureViewState) = Unit
}