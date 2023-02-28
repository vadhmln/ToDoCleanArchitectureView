package ru.vdh.todo.updatetodo.presentation.destination

import ru.vdh.todo.core.presentation.model.PresentationDestination

sealed interface UpdateToDoPresentationDestination: PresentationDestination {

    data class ToDoList(
        val toDoId: Int
    ) : UpdateToDoPresentationDestination
}