package com.example.mymodulithapp.notification;

import com.example.mymodulithapp.notification.internal.Notification;
import com.example.mymodulithapp.notification.internal.NotificationType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private static final Logger LOG = LoggerFactory.getLogger(NotificationService.class);

    public void createNotification(NotificationDTO notificationDTO) {
        Notification notification = toEntity(notificationDTO);
        LOG.info("Received notification by module dependency for product {} in date {} by {}.", notification.productName()
                , notification.date(), notification.format());
    }

    @Async
    @ApplicationModuleListener
    public void notificationEvent(NotificationDTO event) {
        Notification notification = toEntity(event);
        LOG.info("Received notification by event for product {} in date {} by {}.", notification.productName()
                , notification.date(), notification.format());
    }

    private Notification toEntity(NotificationDTO notificationDTO) {
        Notification notification = null;
        if (notificationDTO.format().equals("SMS")) {
            notification = new Notification(notificationDTO.date(), NotificationType.SMS, notificationDTO.productName());
        }
        if (notificationDTO.format().equals("EMAIL")) {
            notification = new Notification(notificationDTO.date(), NotificationType.EMAIL, notificationDTO.productName());
        }
        return notification;
    }

}
