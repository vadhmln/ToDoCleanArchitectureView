package ru.vdh.todo.addtodo.ui.mapper

import ru.vdh.todo.core.ui.navigation.mapper.DestinationPresentationToUiMapper
import ru.vdh.todo.core.ui.navigation.model.UiDestination

interface AddToDoDestinationToUiMapper : DestinationPresentationToUiMapper {
    abstract class ToDoListUiDestination(
        open val toDoId: Int
    ) : UiDestination

}
