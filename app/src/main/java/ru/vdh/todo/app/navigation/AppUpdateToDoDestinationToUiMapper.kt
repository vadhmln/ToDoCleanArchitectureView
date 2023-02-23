package ru.vdh.todo.app.navigation

import ru.vdh.todo.core.presentation.model.PresentationDestination
import ru.vdh.todo.core.ui.navigation.model.UiDestination
import ru.vdh.todo.navigation.mapper.GlobalDestinationToUiMapper
import ru.vdh.todo.updatetodo.ui.mapper.UpdateToDoDestinationToUiMapper

class AppUpdateToDoDestinationToUiMapper(
    private val globalDestinationToUiMapper: GlobalDestinationToUiMapper
) : UpdateToDoDestinationToUiMapper {
    override fun toUi(
        input: PresentationDestination
    ): UiDestination = when (input) {
        else -> globalDestinationToUiMapper.toUi(input)
    }

//    object GoNowhere : DishDetailsUiDestination {
//        override fun navigate() = Unit
//    }
}
