package org.buildcode.service;

import org.buildcode.enums.NotificationType;

import java.util.List;

public interface NotificationService {
    void sendNotification(String content);

    NotificationType getNotificationType();

    static NotificationService getService(List<NotificationService> notificationServices, NotificationType notificationType) {
        return notificationServices.stream()
                .filter(notificationService -> notificationService.getNotificationType().equals(notificationType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No Notification service found for type: " + notificationType));
    }
}