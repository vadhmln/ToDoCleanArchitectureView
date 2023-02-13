package ru.vdh.todo.newfeature.ui.binder

import ru.vdh.todo.core.ui.mapper.ViewStateBinder
import ru.vdh.todo.newfeature.presentation.model.NewFeatureViewState
import ru.vdh.todo.newfeature.ui.view.NewFeatureViewsProvider

class UserDetailsViewStateBinder :
    ViewStateBinder<NewFeatureViewState, NewFeatureViewsProvider> {
    override fun NewFeatureViewsProvider
            .bindState(viewState: NewFeatureViewState) = Unit
}