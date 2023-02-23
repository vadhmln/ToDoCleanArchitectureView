package ru.vdh.todo.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import ru.vdh.todo.core.ui.mapper.ViewStateBinder
import ru.vdh.todo.core.ui.view.ViewsProvider
import ru.vdh.todo.updatetodo.presentation.model.UpdateToDoViewState
import ru.vdh.todo.updatetodo.ui.binder.UpdateToDoViewStateBinder
import ru.vdh.todo.updatetodo.ui.mapper.UpdateToDoNotificationPresentationToUiMapper


@Module
@InstallIn(FragmentComponent::class)
class UpdateToDoUiModule {

    @Provides
    @Suppress("UNCHECKED_CAST")
    fun providesUpdateToDoViewStateBinder() = UpdateToDoViewStateBinder()
            as ViewStateBinder<UpdateToDoViewState, ViewsProvider>

    @Provides
    fun providesUpdateToDoNotificationPresentationToUiMapper() =
        UpdateToDoNotificationPresentationToUiMapper()
}