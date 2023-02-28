package ru.vdh.todo.app.navigation

import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import ru.vdh.todo.NavGraphDirections
import ru.vdh.todo.R
import ru.vdh.todo.addtodo.ui.mapper.AddToDoDestinationToUiMapper
import ru.vdh.todo.core.presentation.model.PresentationDestination
import ru.vdh.todo.core.ui.navigation.model.UiDestination
import ru.vdh.todo.navigation.mapper.GlobalDestinationToUiMapper
import ru.vdh.todo.updatetodo.presentation.destination.UpdateToDoPresentationDestination
import ru.vdh.todo.updatetodo.ui.mapper.UpdateToDoDestinationToUiMapper

class AppUpdateToDoDestinationToUiMapper(
    private val activity: FragmentActivity,
    private val globalDestinationToUiMapper: GlobalDestinationToUiMapper
) : UpdateToDoDestinationToUiMapper {
    override fun toUi(
        input: PresentationDestination
    ): UiDestination = when (input) {
        is UpdateToDoPresentationDestination.ToDoList -> AppToDoList(activity, input.toDoId)
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
