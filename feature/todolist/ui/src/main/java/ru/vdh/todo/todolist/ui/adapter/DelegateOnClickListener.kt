package ru.vdh.todo.todolist.ui.adapter

import javax.inject.Inject

class DelegateOnClickListener @Inject constructor() : ToDoListAdapter.OnClickListener {
    var onToDoItemClickListener: ToDoListAdapter.OnClickListener =
        ToDoListAdapter.OnClickListener.DoNothing

    override fun onToDoItemClick(toDoId: Int) {
        onToDoItemClickListener.onToDoItemClick(toDoId)
    }
}