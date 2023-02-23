package ru.vdh.todo.updatetodo.ui.mapper

import ru.vdh.todo.core.ui.mapper.NotificationPresentationToUiMapper
import ru.vdh.todo.core.ui.model.NotificationUiModel
import ru.vdh.todo.updatetodo.presentation.model.UpdateToDoPresentationNotification

class UpdateToDoNotificationPresentationToUiMapper :
    NotificationPresentationToUiMapper<UpdateToDoPresentationNotification> {
    override fun toUi(
        presentationNotification: UpdateToDoPresentationNotification
    ): NotificationUiModel {
        throw IllegalStateException("Notifications not supported.")
    }
}
