package ru.vdh.todo.todolist.presentation.destination

import ru.vdh.todo.core.presentation.model.PresentationDestination
import ru.vdh.todo.todolist.presentation.model.ToDoListPresentationModel

sealed interface ToDoListPresentationDestination: PresentationDestination {

    data class AddToDo(
        val toDoId: Int
    ) : ToDoListPresentationDestination

    data class UpdateToDo(
        val toDoId: Int
//        val currentItem: ToDoListPresentationModel
    ) : ToDoListPresentationDestination
}