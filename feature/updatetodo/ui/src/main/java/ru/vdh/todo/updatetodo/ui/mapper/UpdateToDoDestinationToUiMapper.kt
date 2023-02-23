package ru.vdh.todo.updatetodo.ui.mapper

import ru.vdh.todo.core.ui.navigation.mapper.DestinationPresentationToUiMapper
import ru.vdh.todo.core.ui.navigation.model.UiDestination

interface UpdateToDoDestinationToUiMapper : DestinationPresentationToUiMapper {
    abstract class NewFeatureSuccessUiDestination(
        open val dishId: String
    ) : UiDestination
}
