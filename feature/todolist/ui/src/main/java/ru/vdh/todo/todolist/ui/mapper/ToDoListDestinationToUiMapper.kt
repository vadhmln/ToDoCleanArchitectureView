package ru.vdh.todo.todolist.ui.mapper

import ru.vdh.todo.core.ui.navigation.mapper.DestinationPresentationToUiMapper
import ru.vdh.todo.core.ui.navigation.model.UiDestination
import ru.vdh.todo.todolist.presentation.model.ToDoListPresentationModel

interface ToDoListDestinationToUiMapper : DestinationPresentationToUiMapper {

    abstract class AddToDoUiDestination(
        open val toDoId: Int
    ) : UiDestination

    abstract class UpdateToDoUiDestination(
//        open val toDoId: Int,
        open val currentItem: ToDoListPresentationModel
    ) : UiDestination
}
