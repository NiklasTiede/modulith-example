package com.example.mymodulithapp.product;

import com.example.mymodulithapp.notification.NotificationDTO;
import com.example.mymodulithapp.notification.NotificationService;
import com.example.mymodulithapp.product.internal.Product;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProductService {

    private final ApplicationEventPublisher events;
    private final NotificationService notificationService;

    public ProductService(ApplicationEventPublisher events, NotificationService notificationService) {
        this.events = events;
        this.notificationService = notificationService;
    }

    public void create(Product product) {
        var newProduct = new NotificationDTO(new Date(), "SMS", product.name());
        notificationService.createNotification(newProduct);
        events.publishEvent(new NotificationDTO(new Date(), "SMS", product.name()));
    }
}
