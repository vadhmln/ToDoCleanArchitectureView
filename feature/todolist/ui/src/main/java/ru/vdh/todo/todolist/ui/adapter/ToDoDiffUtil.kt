package ru.vdh.todo.todolist.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import ru.vdh.todo.todolist.presentation.model.ToDoListPresentationModel

class ToDoDiffUtil(
    private val oldList: List<ToDoListPresentationModel>,
    private val newList: List<ToDoListPresentationModel>
): DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
                && oldList[oldItemPosition].title == newList[newItemPosition].title
                && oldList[oldItemPosition].description == newList[newItemPosition].description
                && oldList[oldItemPosition].priority == newList[newItemPosition].priority
    }
}