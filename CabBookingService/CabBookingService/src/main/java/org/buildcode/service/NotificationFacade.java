package org.buildcode.service;

import org.buildcode.enums.NotificationType;

import java.util.ArrayList;
import java.util.List;

public class NotificationFacade {
    private final List<NotificationService> notificationServices;

    public NotificationFacade() {
        this.notificationServices = new ArrayList<>();
    }

    public Boolean sendNotification(String content, NotificationType notificationType) {
        NotificationService notificationService = NotificationService.getService(notificationType, notificationServices);
        notificationService.sendNotification(content);
        return true;
    }
}