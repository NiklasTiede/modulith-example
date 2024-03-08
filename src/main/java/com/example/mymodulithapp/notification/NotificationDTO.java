package com.example.mymodulithapp.notification;

import java.util.Date;

public record NotificationDTO(
        Date date,
         String format,
         String productName
) {
}
