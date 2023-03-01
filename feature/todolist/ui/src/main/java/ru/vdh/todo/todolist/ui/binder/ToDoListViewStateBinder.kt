package ru.vdh.todo.todolist.ui.binder

import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import ru.vdh.todo.core.ui.mapper.ViewStateBinder
import ru.vdh.todo.todolist.presentation.model.ToDoListPresentationModel
import ru.vdh.todo.todolist.presentation.model.ToDoListViewState
import ru.vdh.todo.todolist.ui.adapter.ToDoListAdapter
import ru.vdh.todo.todolist.ui.view.ToDoListViewsProvider

class ToDoListViewStateBinder(
    private val onToDoItemClickListener: OnClickListener,
    private val fragment: Fragment,
) : ViewStateBinder<ToDoListViewState, ToDoListViewsProvider> {

    private val toDoListAdapter by lazy {
        ToDoListAdapter().apply {
            onToDoItemClickListener = _onDishClickListener
        }
    }

    private val emptyDatabase: MutableLiveData<Boolean> = MutableLiveData(false)

    private val _onDishClickListener: ToDoListAdapter.OnClickListener =
        DelegateOnClickListener()

    override fun ToDoListViewsProvider.bindState(viewState: ToDoListViewState) {
        if (toDoListView.adapter == null) {
            toDoListView.adapter = toDoListAdapter
            toDoListView.layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        }
        viewState.toDoList.observe(fragment.viewLifecycleOwner) { data ->
            checkIfDatabaseEmpty(data)
            toDoListAdapter.setData(data)
        }
    }

    private fun checkIfDatabaseEmpty(toDoData: List<ToDoListPresentationModel>) {
        emptyDatabase.value = toDoData.isEmpty()
    }

    private inner class DelegateOnClickListener : ToDoListAdapter.OnClickListener {
        override fun onToDoItemClick(toDoId: Int) {
            onToDoItemClickListener.onItemClick(toDoId)
        }
    }

    interface OnClickListener {
        fun onItemClick(toDoId: Int)
    }
}