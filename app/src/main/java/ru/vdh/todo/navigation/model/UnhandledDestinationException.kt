package ru.vdh.todo.navigation.model

import ru.vdh.todo.core.presentation.model.PresentationDestination

class UnhandledDestinationException(
    destination: PresentationDestination
) : IllegalArgumentException(
    "Navigation to ${destination::class.simpleName} was not handled."
)
