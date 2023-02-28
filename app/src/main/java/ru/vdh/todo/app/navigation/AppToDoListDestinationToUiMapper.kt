package ru.vdh.todo.app.navigation

import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import ru.vdh.todo.NavGraphDirections
import ru.vdh.todo.R
import ru.vdh.todo.core.presentation.model.PresentationDestination
import ru.vdh.todo.core.ui.navigation.model.UiDestination
import ru.vdh.todo.navigation.mapper.GlobalDestinationToUiMapper
import ru.vdh.todo.todolist.presentation.destination.ToDoListPresentationDestination.AddToDo
import ru.vdh.todo.todolist.presentation.destination.ToDoListPresentationDestination.UpdateToDo
import ru.vdh.todo.todolist.presentation.model.ToDoListPresentationModel
import ru.vdh.todo.todolist.ui.mapper.ToDoListDestinationToUiMapper
import ru.vdh.todo.todolist.ui.mapper.ToDoListDestinationToUiMapper.AddToDoUiDestination
import ru.vdh.todo.todolist.ui.mapper.ToDoListDestinationToUiMapper.UpdateToDoUiDestination

class AppToDoListDestinationToUiMapper(
    private val activity: FragmentActivity,
    private val globalDestinationToUiMapper: GlobalDestinationToUiMapper,
) : ToDoListDestinationToUiMapper {

    override fun toUi(
        input: PresentationDestination
    ): UiDestination = when (input) {
        is AddToDo -> AppAddToDo(activity, input.toDoId)
        is UpdateToDo -> AppUpdateToDo(activity, input.currentItem,)
        else -> globalDestinationToUiMapper.toUi(input)
    }

    private data class AppAddToDo(
        private val activity: FragmentActivity,
        override val toDoId: Int
    ) : AddToDoUiDestination(toDoId) {
        override fun navigate() {

            val currentFragment =
                activity.supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main)

            currentFragment?.findNavController()
                ?.navigate(NavGraphDirections.actionGlobalToNavAddTodo())
            Log.d("AAA", "Add button clicked!!!")
        }
    }

    private data class AppUpdateToDo(
        private val activity: FragmentActivity,
//        override val toDoId: Int,
        override val currentItem: ToDoListPresentationModel
    ) : UpdateToDoUiDestination(currentItem) {
        override fun navigate() {
            val currentFragment =
                activity.supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main)

            currentFragment?.findNavController()
                ?.navigate(NavGraphDirections.actionGlobalToNavUpdateTodo(currentItem))
            Log.d("AAA", "An Item was clicked $currentItem!!!")
        }
    }
}


