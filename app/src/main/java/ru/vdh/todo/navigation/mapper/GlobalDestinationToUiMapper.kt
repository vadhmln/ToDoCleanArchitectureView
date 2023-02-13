package ru.vdh.todo.navigation.mapper

import androidx.navigation.NavController
import ru.vdh.todo.navigation.model.UnhandledDestinationException
import dagger.Lazy
import ru.vdh.todo.core.presentation.model.PresentationDestination
import ru.vdh.todo.core.ui.navigation.mapper.DestinationPresentationToUiMapper
import ru.vdh.todo.core.ui.navigation.model.UiDestination

class GlobalDestinationToUiMapper(
    private val lazyNavController: Lazy<NavController>
) : DestinationPresentationToUiMapper {
    override fun toUi(
        input: PresentationDestination
    ): UiDestination = when (input) {
        PresentationDestination.Back -> BackUiDestination(lazyNavController)
        else -> throw UnhandledDestinationException(input)
    }

    private class BackUiDestination(
        private val lazyNavController: Lazy<NavController>
    ) : UiDestination {
        override fun navigate() {
            lazyNavController.get().popBackStack()
        }
    }
}
