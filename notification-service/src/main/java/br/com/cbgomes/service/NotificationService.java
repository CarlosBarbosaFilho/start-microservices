package br.com.cbgomes.service;

import br.com.cbgomes.entity.EntityNotification;
import br.com.cbgomes.repository.NotificationRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void registerNotificationToCustomer(EntityNotification notification){
        this.notificationRepository.save(notification);
    }
}
