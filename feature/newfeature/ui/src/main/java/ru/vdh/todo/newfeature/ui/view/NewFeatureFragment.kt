package ru.vdh.todo.newfeature.ui.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.vdh.myapp.newfeature.ui.R
import ru.vdh.todo.core.ui.mapper.ViewStateBinder
import ru.vdh.todo.core.ui.view.BaseFragment
import ru.vdh.todo.core.ui.view.ViewsProvider
import ru.vdh.todo.newfeature.presentation.model.NewFeaturePresentationNotification
import ru.vdh.todo.newfeature.presentation.model.NewFeatureViewState
import ru.vdh.todo.newfeature.presentation.model.NewFeaturePresentationModel
import ru.vdh.todo.newfeature.presentation.viewmodel.NewFeatureViewModel
import ru.vdh.todo.newfeature.ui.mapper.NewFeatureDestinationToUiMapper
import ru.vdh.todo.newfeature.ui.mapper.NewUserNotificationPresentationToUiMapper
import javax.inject.Inject

private const val NO_LAYOUT_RESOURCE = 0

@AndroidEntryPoint
class NewFeatureFragment : BaseFragment<NewFeatureViewState, NewFeaturePresentationNotification>(),
    NewFeatureViewsProvider {

    override val viewModel: NewFeatureViewModel by viewModels()

    override val layoutResourceId = R.layout.new_feature_fragment

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

    override lateinit var userNameField: TextView
    override lateinit var dataEditView: EditText
    override lateinit var getUserNameButton: View
    override lateinit var saveUserNameButton: View
    override lateinit var secondFragmentButton: View


    override fun View.bindViews() {
        userNameField = findViewById(R.id.userDetailsTextView)
        dataEditView = findViewById(R.id.dataEditText)
        getUserNameButton = findViewById<Button>(R.id.get_user_details_button)
        saveUserNameButton = findViewById<Button>(R.id.save_data_button)
        secondFragmentButton = findViewById<Button>(R.id.fragment_second)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        Log.e("AAA", "UserDetailsFragment created!!!")

        //подписка на изменение данных
        viewModel.resultLiveData.observe(viewLifecycleOwner) {
            userNameField.text = it
        }

        val view = if (layoutResourceId != NO_LAYOUT_RESOURCE) {
            inflater.inflate(layoutResourceId, container, false).apply {
                bindViews()
            }
        } else {
            null
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getUserNameButton.setOnClickListener {
            viewModel.load()
        }

        saveUserNameButton.setOnClickListener {
            val text = dataEditView.text.toString()
            viewModel.save(NewFeaturePresentationModel(firstName = text))
        }

        secondFragmentButton.setOnClickListener {
            findNavController().navigate(NewFeatureFragmentDirections.actionNewFeatureFragmentToSecondFragment())
        }
    }

    companion object {
        private const val ARGUMENT_RESTAURANT_ID = "UserName"

        fun newInstance(userName: String) = NewFeatureFragment().apply {
            arguments = bundleOf(ARGUMENT_RESTAURANT_ID to userName)
        }
    }

}