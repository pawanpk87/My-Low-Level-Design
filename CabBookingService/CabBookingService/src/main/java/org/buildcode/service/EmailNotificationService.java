package org.buildcode.service;

import org.buildcode.enums.NotificationType;

public class EmailNotificationService implements NotificationService {

    @Override
    public Boolean sendNotification(String content) {
        // send email notification
        return true;
    }

    @Override
    public NotificationType getType() {
        return NotificationType.EMAIL_NOTIFICATION;
    }
}