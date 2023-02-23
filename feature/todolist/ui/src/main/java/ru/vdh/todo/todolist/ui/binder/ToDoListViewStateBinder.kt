package ru.vdh.todo.todolist.ui.binder

import ru.vdh.todo.core.ui.mapper.ViewStateBinder
import ru.vdh.todo.todolist.presentation.model.ToDoListViewState
import ru.vdh.todo.todolist.ui.view.ToDoListViewsProvider

class ToDoListViewStateBinder :
    ViewStateBinder<ToDoListViewState, ToDoListViewsProvider> {
    override fun ToDoListViewsProvider
            .bindState(viewState: ToDoListViewState) = Unit
}