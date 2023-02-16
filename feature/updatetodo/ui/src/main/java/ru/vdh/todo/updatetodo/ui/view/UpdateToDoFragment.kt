package ru.vdh.todo.updatetodo.ui.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import dagger.hilt.android.AndroidEntryPoint

import ru.vdh.todo.core.ui.mapper.ViewStateBinder
import ru.vdh.todo.core.ui.view.BaseFragment
import ru.vdh.todo.core.ui.view.ViewsProvider
import ru.vdh.todo.updatetodo.presentation.model.NewFeaturePresentationNotification
import ru.vdh.todo.updatetodo.presentation.model.NewFeatureViewState
import ru.vdh.todo.updatetodo.presentation.viewmodel.NewFeatureViewModel
import ru.vdh.todo.updatetodo.ui.R
import ru.vdh.todo.updatetodo.ui.databinding.FragmentUpdateTodoBinding
import ru.vdh.todo.updatetodo.ui.mapper.NewFeatureDestinationToUiMapper
import ru.vdh.todo.updatetodo.ui.mapper.NewUserNotificationPresentationToUiMapper
import javax.inject.Inject

@AndroidEntryPoint
class UpdateToDoFragment : BaseFragment<NewFeatureViewState, NewFeaturePresentationNotification>(),
    NewFeatureViewsProvider {

    private var _binding: FragmentUpdateTodoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override val viewModel: NewFeatureViewModel by viewModels()

    override val layoutResourceId = R.layout.fragment_update_todo

    @Inject
    override lateinit var destinationMapper:
            NewFeatureDestinationToUiMapper

    @Inject
    override lateinit var notificationMapper:
            NewUserNotificationPresentationToUiMapper

    @Inject
    @JvmSuppressWildcards
    override lateinit var viewStateBinder:
            ViewStateBinder<NewFeatureViewState, ViewsProvider>


    override fun View.bindViews() {
    }

    private val menuProvider = object : MenuProvider {
        override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
            menuInflater.inflate(R.menu.update_todo_menu, menu)
        }

        override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
            return when (menuItem.itemId) {
                R.id.menu_save -> {
                    // AddToDoUseCase
                    true
                }
                R.id.menu_delete -> {
                    // AddToDoUseCase
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

        _binding = FragmentUpdateTodoBinding.inflate(inflater, container, false)

        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

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