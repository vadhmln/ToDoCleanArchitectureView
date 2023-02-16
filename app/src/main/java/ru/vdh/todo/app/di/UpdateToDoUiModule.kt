package ru.vdh.todo.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import ru.vdh.todo.core.ui.mapper.ViewStateBinder
import ru.vdh.todo.core.ui.view.ViewsProvider
import ru.vdh.todo.updatetodo.presentation.model.NewFeatureViewState
import ru.vdh.todo.updatetodo.ui.binder.NewFeatureViewStateBinder
import ru.vdh.todo.updatetodo.ui.mapper.NewUserNotificationPresentationToUiMapper


@Module
@InstallIn(FragmentComponent::class)
class UpdateToDoUiModule {

    @Provides
    @Suppress("UNCHECKED_CAST")
    fun providesUserDetailsViewStateBinder() = NewFeatureViewStateBinder()
            as ViewStateBinder<NewFeatureViewState, ViewsProvider>

    @Provides
    fun providesNewUserNotificationPresentationToUiMapper() =
        NewUserNotificationPresentationToUiMapper()
}