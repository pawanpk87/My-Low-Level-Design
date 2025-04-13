package org.buildcode.service;

import org.buildcode.enums.NotificationType;

import java.util.List;

public interface NotificationService {

    Boolean sendNotification(String content);

    NotificationType getType();

    public static NotificationService getService(NotificationType notificationType, List<NotificationService> notificationServices) {
        return notificationServices.stream()
                .filter(notificationService -> notificationService.getType().equals(notificationService))
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("No Notification Service found for type: " + notificationType));
    }
}