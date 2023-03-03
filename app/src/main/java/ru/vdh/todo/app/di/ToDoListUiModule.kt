package ru.vdh.todo.app.di

import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import ru.vdh.todo.core.ui.mapper.ViewStateBinder
import ru.vdh.todo.core.ui.view.ViewsProvider
import ru.vdh.todo.todolist.presentation.UseCaseProvider
import ru.vdh.todo.todolist.presentation.model.ToDoListViewState
import ru.vdh.todo.todolist.ui.binder.ToDoListViewStateBinder
import ru.vdh.todo.todolist.ui.mapper.ToDoListNotificationPresentationToUiMapper
import ru.vdh.todo.todolist.ui.view.ToDoListFragment

@Module
@InstallIn(FragmentComponent::class)
class ToDoListUiModule {

    @Provides
    @Suppress("UNCHECKED_CAST")
    fun providesToDoListViewStateBinder(
        fragment: Fragment,
        useCaseProvider: UseCaseProvider
    ) =
        ToDoListViewStateBinder(fragment as ToDoListFragment, fragment as ToDoListFragment, useCaseProvider)
                as ViewStateBinder<ToDoListViewState, ViewsProvider>

    @Provides
    fun providesToDoListNotificationPresentationToUiMapper() =
        ToDoListNotificationPresentationToUiMapper()
}