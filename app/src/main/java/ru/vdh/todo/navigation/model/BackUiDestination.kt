package ru.vdh.todo.navigation.model

import androidx.navigation.NavController
import dagger.Lazy
import ru.vdh.todo.core.ui.navigation.model.UiDestination

class BackUiDestination(
    private val lazyNavController: Lazy<NavController>
) : UiDestination {
    override fun navigate() {
        lazyNavController.get().popBackStack()
    }
}
