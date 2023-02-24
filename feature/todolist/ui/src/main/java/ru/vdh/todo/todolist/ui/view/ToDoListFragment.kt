package ru.vdh.todo.todolist.ui.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ru.vdh.todo.NavGraphDirections
import ru.vdh.todo.core.ui.mapper.ViewStateBinder
import ru.vdh.todo.core.ui.view.BaseFragment
import ru.vdh.todo.core.ui.view.ViewsProvider
import ru.vdh.todo.todolist.presentation.model.ToDoListPresentationNotification
import ru.vdh.todo.todolist.presentation.model.ToDoListViewState
import ru.vdh.todo.todolist.presentation.viewmodel.ToDoListViewModel
import ru.vdh.todo.todolist.ui.R
import ru.vdh.todo.todolist.ui.adapter.ToDoListAdapter
import ru.vdh.todo.todolist.ui.databinding.FragmentListTodoBinding
import ru.vdh.todo.todolist.ui.mapper.ToDoListDestinationToUiMapper
import ru.vdh.todo.todolist.ui.mapper.ToDoListNotificationPresentationToUiMapper
import javax.inject.Inject

@AndroidEntryPoint
class ToDoListFragment : BaseFragment<ToDoListViewState, ToDoListPresentationNotification>(),
    ToDoListViewsProvider {

    private var _binding: FragmentListTodoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override val viewModel: ToDoListViewModel by viewModels()

    override val layoutResourceId = R.layout.fragment_list_todo

    private val adapter: ToDoListAdapter by lazy { ToDoListAdapter() }

    @Inject
    override lateinit var destinationMapper:
            ToDoListDestinationToUiMapper

    @Inject
    override lateinit var notificationMapper:
            ToDoListNotificationPresentationToUiMapper

    @Inject
    @JvmSuppressWildcards
    override lateinit var viewStateBinder:
            ViewStateBinder<ToDoListViewState, ViewsProvider>


    override fun View.bindViews() {
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        Log.e("AAA", "ToDoListFragment created!!!")

        _binding = FragmentListTodoBinding.inflate(inflater, container, false)

        setupRecyclerview()

        // Observe LiveData
        viewModel.getAllPresentationData.observe(viewLifecycleOwner) { data ->
            viewModel.checkIfDatabaseEmpty(data)
            adapter.setData(data)
            binding.recyclerView.scheduleLayoutAnimation()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addToDoButton.setOnClickListener {
            findNavController().navigate(NavGraphDirections.actionGlobalToNavAddTodo())
        }


        // The usage of an interface lets you inject your own implementation
        val menuHost: MenuHost = requireActivity()

        // Add menu items without using the Fragment Menu APIs
        // Note how we can tie the MenuProvider to the viewLifecycleOwner
        // and an optional Lifecycle.State (here, RESUMED) to indicate when
        // the menu should be visible
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                // Add menu items here
                menuInflater.inflate(R.menu.todo_list_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                // Handle the menu selection
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun setupRecyclerview() {
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        // Swipe to Delete
//        swipeToDelete(recyclerView)
    }

//    private fun swipeToDelete(recyclerView: RecyclerView) {
//        val swipeToDeleteCallback = object : SwipeToDelete() {
//            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//                val deletedItem = adapter.dataList[viewHolder.adapterPosition]
//                // Delete Item
//                viewModel.deleteItem(deletedItem)
//                adapter.notifyItemRemoved(viewHolder.adapterPosition)
//                // Restore Deleted Item
//                restoreDeletedData(viewHolder.itemView, deletedItem)
//            }
//        }
//        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
//        itemTouchHelper.attachToRecyclerView(recyclerView)
//    }
//
//    private fun restoreDeletedData(view: View, deletedItem: ToDoData) {
//        val snackBar = Snackbar.make(
//            view, "Deleted '${deletedItem.title}'",
//            Snackbar.LENGTH_LONG
//        )
//        snackBar.setAction("Undo") {
//            mToDoViewModel.insertData(deletedItem)
//        }
//        snackBar.show()
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}