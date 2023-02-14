package ru.vdh.todo.todolist.ui.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.vdh.todo.NavGraphDirections
import ru.vdh.todo.core.ui.mapper.ViewStateBinder
import ru.vdh.todo.core.ui.view.BaseFragment
import ru.vdh.todo.core.ui.view.ViewsProvider
import ru.vdh.todo.todolist.presentation.model.NewFeaturePresentationNotification
import ru.vdh.todo.todolist.presentation.model.NewFeatureViewState
import ru.vdh.todo.todolist.presentation.viewmodel.NewFeatureViewModel
import ru.vdh.todo.todolist.ui.R
import ru.vdh.todo.todolist.ui.databinding.FragmentListTodoBinding
import ru.vdh.todo.todolist.ui.mapper.NewFeatureDestinationToUiMapper
import ru.vdh.todo.todolist.ui.mapper.NewUserNotificationPresentationToUiMapper
import javax.inject.Inject

@AndroidEntryPoint
class ToDoListFragment : BaseFragment<NewFeatureViewState, NewFeaturePresentationNotification>(),
    NewFeatureViewsProvider {

    private var _binding: FragmentListTodoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override val viewModel: NewFeatureViewModel by viewModels()

    override val layoutResourceId = R.layout.fragment_list_todo

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

        _binding = FragmentListTodoBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addToDoButton.setOnClickListener {
            findNavController().navigate(NavGraphDirections.actionGlobalToNavAddTodo())
        }

        binding.listLayout.setOnClickListener {
//            findNavController().navigate(NavGraphDirections.actionGlobalToNavAddTodo())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}