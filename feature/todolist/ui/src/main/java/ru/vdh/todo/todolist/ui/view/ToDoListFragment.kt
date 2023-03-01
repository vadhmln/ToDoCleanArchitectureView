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
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import ru.vdh.todo.core.ui.mapper.ViewStateBinder
import ru.vdh.todo.core.ui.view.BaseFragment
import ru.vdh.todo.core.ui.view.ViewsProvider
import ru.vdh.todo.todolist.presentation.model.ToDoListPresentationModel
import ru.vdh.todo.todolist.presentation.model.ToDoListPresentationNotification
import ru.vdh.todo.todolist.presentation.model.ToDoListViewState
import ru.vdh.todo.todolist.presentation.viewmodel.ToDoListViewModel
import ru.vdh.todo.todolist.ui.R
import ru.vdh.todo.todolist.ui.binder.ToDoListViewStateBinder
import ru.vdh.todo.todolist.ui.databinding.FragmentListTodoBinding
import ru.vdh.todo.todolist.ui.mapper.ToDoListDestinationToUiMapper
import ru.vdh.todo.todolist.ui.mapper.ToDoListNotificationPresentationToUiMapper
import javax.inject.Inject

@AndroidEntryPoint
class ToDoListFragment :
    BaseFragment<ToDoListViewState, ToDoListPresentationNotification>(),
    ToDoListViewsProvider,
    ToDoListViewStateBinder.OnClickListener {

    private var _binding: FragmentListTodoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override val viewModel: ToDoListViewModel by viewModels()

    override val layoutResourceId = R.layout.fragment_list_todo

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

    override lateinit var toDoListView: RecyclerView

    private val toDoId by lazy {
        requireNotNull(
            requireArguments().getInt("")
        ) { "A TO DO ID must be provided." }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            viewModel.onEntered(1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        Log.e("AAA", "ToDoListFragment created!!!")

        _binding = FragmentListTodoBinding.inflate(inflater, container, false)

        toDoListView = binding.recyclerView
        binding.recyclerView.scheduleLayoutAnimation()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addToDoButton.setOnClickListener {
            viewModel.onAddToDoAction(layoutResourceId)
        }

        // The usage of an interface lets you inject your own implementation
        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.todo_list_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                // Handle the menu selection
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    override fun onItemClick(toDoId: Int) {
        viewModel.onUpdateToDoAction(toDoId)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}