package ru.vdh.todo.updatetodo.ui.view

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationManagerCompat
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import ru.vdh.todo.core.ui.mapper.ViewStateBinder
import ru.vdh.todo.core.ui.view.BaseFragment
import ru.vdh.todo.core.ui.view.ViewsProvider
import ru.vdh.todo.updatetodo.presentation.model.UpdateToDoPresentationNotification
import ru.vdh.todo.updatetodo.presentation.model.UpdateToDoViewState
import ru.vdh.todo.updatetodo.presentation.model.UpdateToDoPresentationModel
import ru.vdh.todo.updatetodo.presentation.viewmodel.UpdateToDoViewModel
import ru.vdh.todo.updatetodo.ui.R
import ru.vdh.todo.updatetodo.ui.databinding.FragmentUpdateTodoBinding
import ru.vdh.todo.updatetodo.ui.mapper.UpdateToDoDestinationToUiMapper
import ru.vdh.todo.updatetodo.ui.mapper.UpdateToDoNotificationPresentationToUiMapper
import javax.inject.Inject

@AndroidEntryPoint
class UpdateToDoFragment : BaseFragment<UpdateToDoViewState, UpdateToDoPresentationNotification>(),
    UpdateToDoViewsProvider {

    private val args by navArgs<UpdateToDoFragmentArgs>()

    private lateinit var currentToDoItem: UpdateToDoPresentationModel

    private var _binding: FragmentUpdateTodoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override val viewModel: UpdateToDoViewModel by viewModels()

    override val layoutResourceId = R.layout.fragment_update_todo

    @Inject
    override lateinit var destinationMapper:
            UpdateToDoDestinationToUiMapper

    @Inject
    override lateinit var notificationMapper:
            UpdateToDoNotificationPresentationToUiMapper

    @Inject
    @JvmSuppressWildcards
    override lateinit var viewStateBinder:
            ViewStateBinder<UpdateToDoViewState, ViewsProvider>


    override fun View.bindViews() {
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        Log.e("AAA", "ToDoListFragment created!!!")

        _binding = FragmentUpdateTodoBinding.inflate(inflater, container, false)

        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

//        binding.currentTitleEditText.text = args.currentItem.title.toEditable()
//        binding.currentDescriptionEditText.text = args.currentItem.description.toEditable()
//        binding.currentPrioritiesSpinner.setSelection(viewModel.parsePriorityToInt(args.currentItem.priority))

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.update_todo_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.menu_save -> updateItem()
                    R.id.menu_delete -> confirmItemRemoval()
                    android.R.id.home -> requireActivity().onBackPressed()
                }
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        val editingState =
            if (args.toDoId > 0) UpdateToDoViewState.EXISTING_TODO
            else UpdateToDoViewState.NEW_TODO

        // If we arrived here with an itemId of >= 0, then we are editing an existing item
        if (editingState == UpdateToDoViewState.EXISTING_TODO) {
            // Request to edit an existing item, whose id was passed in as an argument.
            // Retrieve that item and populate the UI with its details
            viewModel.getItemById(args.toDoId).observe(viewLifecycleOwner) { toDoItem ->
                toDoItem?.let {
                    binding.currentTitleEditText.text = toDoItem.title.toEditable()
                    binding.currentDescriptionEditText.text = toDoItem.description.toEditable()
                    binding.currentPrioritiesSpinner.setSelection(
                        viewModel.parsePriorityToInt(
                            toDoItem.priority
                        )
                    )
                    currentToDoItem = toDoItem
                }
            }
        }
    }

    private fun updateItem() {
        val title = binding.currentTitleEditText.text.toString()
        val description = binding.currentDescriptionEditText.text.toString()
        val priority = binding.currentPrioritiesSpinner.selectedItem.toString()

        val validation = viewModel.verifyDataFromUser(title, description)
        if (validation) {
            // Update Current Item
            val updatedItem = UpdateToDoPresentationModel(
                currentToDoItem.id,
                title,
                priority,
                description
            )
            viewModel.updateToDo(updatedItem)
            Toast.makeText(requireContext(), "Successfully updated!", Toast.LENGTH_SHORT).show()
            // Navigate back
            viewModel.onUpdateOrDeleteToDo(currentToDoItem.id)
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_SHORT)
                .show()
        }
    }

    // Show AlertDialog to Confirm Item Removal
    private fun confirmItemRemoval() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            viewModel.deleteItem(toUpdateToDoPresentation())
            Toast.makeText(
                requireContext(),
                "Successfully Removed: ${currentToDoItem.title}",
                Toast.LENGTH_SHORT
            ).show()
            // Navigate back
            viewModel.onUpdateOrDeleteToDo(currentToDoItem.id)
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete '${currentToDoItem.title}'?")
        builder.setMessage("Are you sure you want to remove '${currentToDoItem.title}'?")
        builder.create().show()
    }

    private fun toUpdateToDoPresentation(): UpdateToDoPresentationModel {
        return UpdateToDoPresentationModel(
            id = currentToDoItem.id,
            title = currentToDoItem.title,
            priority = currentToDoItem.priority,
            description = currentToDoItem.description
        )
    }

    private fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}