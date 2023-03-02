package ru.vdh.todo.todolist.ui.view

import androidx.recyclerview.widget.RecyclerView
import ru.vdh.todo.core.ui.view.ViewsProvider

interface ToDoListViewsProvider : ViewsProvider {
    val recyclerView: RecyclerView
}
