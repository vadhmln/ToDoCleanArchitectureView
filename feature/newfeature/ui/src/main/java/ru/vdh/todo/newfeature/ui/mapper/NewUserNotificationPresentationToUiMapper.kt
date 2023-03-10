package ru.vdh.todo.newfeature.ui.mapper

import ru.vdh.todo.core.ui.mapper.NotificationPresentationToUiMapper
import ru.vdh.todo.core.ui.model.NotificationUiModel
import ru.vdh.todo.newfeature.presentation.model.NewFeaturePresentationNotification

class NewUserNotificationPresentationToUiMapper :
    NotificationPresentationToUiMapper<NewFeaturePresentationNotification> {
    override fun toUi(
        presentationNotification: NewFeaturePresentationNotification
    ): NotificationUiModel {
        throw IllegalStateException("Notifications not supported.")
    }
}
