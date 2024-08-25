package org.buildcode.service;

import org.buildcode.enums.NotificationType;

public class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(String content) {

    }

    @Override
    public NotificationType getNotificationType() {
        return NotificationType.EMAIL;
    }
}
