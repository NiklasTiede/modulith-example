package com.example.mymodulithapp.notification.internal;

import java.util.Date;

public record Notification(
        Date date,
        NotificationType format,
        String productName
) {
}
