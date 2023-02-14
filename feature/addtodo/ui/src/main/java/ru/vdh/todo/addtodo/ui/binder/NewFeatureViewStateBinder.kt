package ru.vdh.todo.addtodo.ui.binder

import ru.vdh.todo.addtodo.presentation.model.NewFeatureViewState
import ru.vdh.todo.core.ui.mapper.ViewStateBinder
import ru.vdh.todo.addtodo.ui.view.NewFeatureViewsProvider

class NewFeatureViewStateBinder :
    ViewStateBinder<NewFeatureViewState, NewFeatureViewsProvider> {
    override fun NewFeatureViewsProvider
            .bindState(viewState: NewFeatureViewState) = Unit
}