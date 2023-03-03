package ru.vdh.todo.todolist.ui.view

import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.vdh.todo.core.ui.view.ViewsProvider

interface ToDoListViewsProvider : ViewsProvider {
    val recyclerView: RecyclerView

    val noDataImageView: ImageView

    val noDataTextView: TextView
}
