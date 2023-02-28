package ru.vdh.todo.addtodo.presentation.destination

import ru.vdh.todo.core.presentation.model.PresentationDestination

sealed interface AddToDoPresentationDestination: PresentationDestination {

    data class ToDoList(
        val toDoId: Int
    ) : AddToDoPresentationDestination
}