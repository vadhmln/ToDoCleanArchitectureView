package ru.vdh.todo.addtodo.ui.mapper

import ru.vdh.todo.addtodo.presentation.model.AddToDoPresentationNotification
import ru.vdh.todo.core.ui.mapper.NotificationPresentationToUiMapper
import ru.vdh.todo.core.ui.model.NotificationUiModel

class AddToDoNotificationPresentationToUiMapper :
    NotificationPresentationToUiMapper<AddToDoPresentationNotification> {
    override fun toUi(
        presentationNotification: AddToDoPresentationNotification
    ): NotificationUiModel {
        throw IllegalStateException("Notifications not supported.")
    }
}
