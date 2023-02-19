package ru.vdh.todo.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import ru.vdh.todo.core.ui.mapper.ViewStateBinder
import ru.vdh.todo.core.ui.view.ViewsProvider
import ru.vdh.todo.addtodo.presentation.model.AddToDoViewState
import ru.vdh.todo.addtodo.ui.binder.AddToDoViewStateBinder
import ru.vdh.todo.addtodo.ui.mapper.AddToDoNotificationPresentationToUiMapper

@Module
@InstallIn(FragmentComponent::class)
class AddToDoUiModule {

    @Provides
    @Suppress("UNCHECKED_CAST")
    fun providesAddToDoViewStateBinder() = AddToDoViewStateBinder()
            as ViewStateBinder<AddToDoViewState, ViewsProvider>

    @Provides
    fun providesAddToDoNotificationPresentationToUiMapper() =
        AddToDoNotificationPresentationToUiMapper()
}