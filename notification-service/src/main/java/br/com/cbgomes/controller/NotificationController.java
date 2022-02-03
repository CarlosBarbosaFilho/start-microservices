package br.com.cbgomes.controller;

import br.com.cbgomes.entity.EntityNotification;
import br.com.cbgomes.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

   private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }


    @PostMapping ("/notified")
    public void callingServiceNotification(@RequestBody EntityNotification entityNotification) {
        this.notificationService.registerNotificationToCustomer(entityNotification);
    }
}
