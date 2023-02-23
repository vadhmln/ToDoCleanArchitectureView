package ru.vdh.todo.todolist.ui.mapper

import ru.vdh.todo.core.ui.navigation.mapper.DestinationPresentationToUiMapper
import ru.vdh.todo.core.ui.navigation.model.UiDestination

interface ToDoListDestinationToUiMapper : DestinationPresentationToUiMapper {
    abstract class NewFeatureSuccessUiDestination(
        open val dishId: String
    ) : UiDestination
}
