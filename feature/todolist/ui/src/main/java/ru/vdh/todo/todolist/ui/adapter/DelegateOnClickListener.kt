package ru.vdh.todo.todolist.ui.adapter

import ru.vdh.todo.todolist.presentation.model.ToDoListPresentationModel
import javax.inject.Inject

class DelegateOnClickListener @Inject constructor() : ToDoListAdapter.OnClickListener {
    var onToDoItemClickListener: ToDoListAdapter.OnClickListener =
        ToDoListAdapter.OnClickListener.DoNothing

    override fun onToDoItemClick(currentItem: ToDoListPresentationModel) {
        onToDoItemClickListener.onToDoItemClick(currentItem)
    }
}