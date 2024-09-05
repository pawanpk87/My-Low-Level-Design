package org.buildcode.service;

import org.buildcode.enums.NotificationType;

public class PushNotificationService implements NotificationService {

    @Override
    public Boolean sendNotification(String content) {
        // send push notification
        return true;
    }

    @Override
    public NotificationType getType() {
        return NotificationType.PUSH_NOTIFICATION;
    }
}