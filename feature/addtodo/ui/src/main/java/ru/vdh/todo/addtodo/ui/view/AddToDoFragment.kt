package ru.vdh.todo.addtodo.ui.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import dagger.hilt.android.AndroidEntryPoint
import ru.vdh.todo.addtodo.presentation.model.AddToDoPresentationModel
import ru.vdh.todo.addtodo.presentation.model.AddToDoPresentationNotification
import ru.vdh.todo.addtodo.presentation.model.AddToDoViewState
import ru.vdh.todo.addtodo.presentation.viewmodel.AddToDoViewModel
import ru.vdh.todo.addtodo.ui.R
import ru.vdh.todo.addtodo.ui.databinding.FragmentAddTodoBinding
import ru.vdh.todo.core.ui.mapper.ViewStateBinder
import ru.vdh.todo.core.ui.view.BaseFragment
import ru.vdh.todo.core.ui.view.ViewsProvider
import ru.vdh.todo.addtodo.ui.mapper.NewFeatureDestinationToUiMapper
import ru.vdh.todo.addtodo.ui.mapper.AddToDoNotificationPresentationToUiMapper
import javax.inject.Inject

@AndroidEntryPoint
class AddToDoFragment : BaseFragment<AddToDoViewState, AddToDoPresentationNotification>(),
    AddToDoViewsProvider {

    private var _binding: FragmentAddTodoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override val viewModel: AddToDoViewModel by viewModels()

    override val layoutResourceId = R.layout.fragment_add_todo

    @Inject
    override lateinit var destinationMapper:
            NewFeatureDestinationToUiMapper

    @Inject
    override lateinit var notificationMapper:
            AddToDoNotificationPresentationToUiMapper

    @Inject
    @JvmSuppressWildcards
    override lateinit var viewStateBinder:
            ViewStateBinder<AddToDoViewState, ViewsProvider>


    override fun View.bindViews() {
    }

    private val menuProvider = object : MenuProvider {
        override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
            menuInflater.inflate(R.menu.add_todo_menu, menu)
        }

        override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
            return when (menuItem.itemId) {
                R.id.menu_add -> {
                    viewModel.onAddToDoAction(AddToDoPresentationModel(
                        id = 0,
                        title = binding.titleEditText.toString(),
                        priority = binding.prioritiesSpinner.toString(),
                        description = binding.descriptionEditText.toString()
                    ))
                    Toast.makeText(requireContext(), "Add button clicked!", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        Log.e("AAA", "ToDoListFragment created!!!")

        //подписка на изменение данных
        viewModel.resultLiveData.observe(viewLifecycleOwner) {
        }

        _binding = FragmentAddTodoBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(menuProvider, viewLifecycleOwner, Lifecycle.State.RESUMED)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}