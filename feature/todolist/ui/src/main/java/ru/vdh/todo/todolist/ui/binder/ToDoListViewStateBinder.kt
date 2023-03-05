package ru.vdh.todo.todolist.ui.binder

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.vdh.todo.core.ui.mapper.ViewStateBinder
import ru.vdh.todo.todolist.presentation.UseCaseProvider
import ru.vdh.todo.todolist.presentation.model.ToDoListPresentationModel
import ru.vdh.todo.todolist.presentation.model.ToDoListViewState
import ru.vdh.todo.todolist.ui.adapter.SwipeToDelete
import ru.vdh.todo.todolist.ui.adapter.ToDoListAdapter
import ru.vdh.todo.todolist.ui.view.ToDoListFragment
import ru.vdh.todo.todolist.ui.view.ToDoListViewsProvider
import javax.inject.Inject

class ToDoListViewStateBinder @Inject constructor(
    private val onToDoItemClickListener: OnClickListener,
    private val fragment: ToDoListFragment,
    private val useCaseProvider: UseCaseProvider
) : ViewStateBinder<ToDoListViewState, ToDoListViewsProvider> {

    private val emptyDatabase: MutableLiveData<Boolean> = MutableLiveData(false)

    private val _onDishClickListener: ToDoListAdapter.OnClickListener =
        DelegateOnClickListener()

    override fun ToDoListViewsProvider.bindState(viewState: ToDoListViewState) {

        fragment.adapter.apply { onToDoItemClickListener = _onDishClickListener }

        if (recyclerView.adapter == null) {
            recyclerView.adapter = fragment.adapter
            recyclerView.layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        }
        viewState.toDoList.observe(fragment.viewLifecycleOwner) { data ->
            checkIfDatabaseEmpty(data)
            fragment.adapter.setData(data)
            Log.d("AAA", "Data was set!!!")
            recyclerView.scheduleLayoutAnimation()
        }

        emptyDatabase.observe(fragment.viewLifecycleOwner) {
            if (it) {
                noDataImageView.visibility = View.VISIBLE
                noDataTextView.visibility = View.VISIBLE
            } else {
                noDataImageView.visibility = View.INVISIBLE
                noDataTextView.visibility = View.INVISIBLE
            }
        }
        swipeToDelete(recyclerView)
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

    private fun swipeToDelete(recyclerView: RecyclerView) {
        val swipeToDeleteCallback = object : SwipeToDelete() {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val deletedItem =
                    fragment.adapter.dataList[viewHolder.adapterPosition]
                // Delete Item
                CoroutineScope(Dispatchers.IO).launch {
                    useCaseProvider.deleteItem(deletedItem)
                }
                Log.d("AAA", "Current swiped item!!!")
                fragment.adapter.notifyItemRemoved(viewHolder.adapterPosition)
                // Restore Deleted Item
                restoreDeletedData(viewHolder.itemView, deletedItem)
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    private fun restoreDeletedData(view: View, deletedItem: ToDoListPresentationModel) {
        val snackBar = Snackbar.make(
            view, "Deleted '${deletedItem.title}'",
            Snackbar.LENGTH_LONG
        )
        snackBar.setAction("Undo") {
            CoroutineScope(Dispatchers.IO).launch {
                useCaseProvider.restoreDeletedToDo(deletedItem)
            }
        }
        snackBar.show()
    }
}