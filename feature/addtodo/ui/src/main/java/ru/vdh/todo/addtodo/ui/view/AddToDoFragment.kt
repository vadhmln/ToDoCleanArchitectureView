package ru.vdh.todo.addtodo.ui.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.vdh.todo.NavGraphDirections

import ru.vdh.todo.addtodo.presentation.model.NewFeaturePresentationNotification
import ru.vdh.todo.addtodo.presentation.model.NewFeatureViewState
import ru.vdh.todo.addtodo.presentation.viewmodel.NewFeatureViewModel
import ru.vdh.todo.addtodo.ui.R
import ru.vdh.todo.addtodo.ui.databinding.FragmentAddTodoBinding
import ru.vdh.todo.core.ui.mapper.ViewStateBinder
import ru.vdh.todo.core.ui.view.BaseFragment
import ru.vdh.todo.core.ui.view.ViewsProvider
import ru.vdh.todo.addtodo.ui.mapper.NewFeatureDestinationToUiMapper
import ru.vdh.todo.addtodo.ui.mapper.NewUserNotificationPresentationToUiMapper
import javax.inject.Inject

@AndroidEntryPoint
class AddToDoFragment : BaseFragment<NewFeatureViewState, NewFeaturePresentationNotification>(),
    NewFeatureViewsProvider {

    private var _binding: FragmentAddTodoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override val viewModel: NewFeatureViewModel by viewModels()

    override val layoutResourceId = R.layout.fragment_add_todo

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

        _binding = FragmentAddTodoBinding.inflate(inflater, container, false)

        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.toToDoButton.setOnClickListener {
//            findNavController().navigate(NavGraphDirections.actionGlobalToNavTodoList())
//        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}