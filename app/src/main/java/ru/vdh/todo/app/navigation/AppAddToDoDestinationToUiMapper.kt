package ru.vdh.todo.app.navigation

import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import ru.vdh.todo.NavGraphDirections
import ru.vdh.todo.R
import ru.vdh.todo.addtodo.presentation.destination.AddToDoPresentationDestination.ToDoList
import ru.vdh.todo.addtodo.ui.mapper.AddToDoDestinationToUiMapper
import ru.vdh.todo.core.presentation.model.PresentationDestination
import ru.vdh.todo.core.ui.navigation.model.UiDestination
import ru.vdh.todo.navigation.mapper.GlobalDestinationToUiMapper


class AppAddToDoDestinationToUiMapper(
    private val activity: FragmentActivity,
    private val globalDestinationToUiMapper: GlobalDestinationToUiMapper
) : AddToDoDestinationToUiMapper {
    override fun toUi(
        input: PresentationDestination
    ): UiDestination = when (input) {
        is ToDoList -> AppToDoList(activity, input.toDoId)
        else -> globalDestinationToUiMapper.toUi(input)
    }

    private data class AppToDoList(
        private val activity: FragmentActivity,
        override val toDoId: Int
    ) : AddToDoDestinationToUiMapper.ToDoListUiDestination(toDoId) {
        override fun navigate() {

            val currentFragment =
                activity.supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main)

            currentFragment?.findNavController()
                ?.navigate(NavGraphDirections.actionGlobalToNavTodoList())
        }
    }
}
