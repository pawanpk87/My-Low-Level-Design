package org.buildcode.service;

import org.buildcode.enums.NotificationType;

import java.util.ArrayList;
import java.util.List;

public class NotificationServiceFacade {
    private final List<NotificationService> notificationServices;

    public NotificationServiceFacade() {
        notificationServices = new ArrayList<>();
    }

    public void sendNotification(String content) {
        NotificationService notificationService = NotificationService.getService(notificationServices, NotificationType.EMAIL);
        notificationService.sendNotification(content);
    }
}