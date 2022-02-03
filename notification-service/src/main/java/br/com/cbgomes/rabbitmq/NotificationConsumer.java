package br.com.cbgomes.rabbitmq;

import br.com.cbgomes.clients.notification.response.NotificationRequestMessage;
import br.com.cbgomes.entity.EntityNotification;
import br.com.cbgomes.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queue.notification}")
    public void consumer(NotificationRequestMessage notificationRequestMessage) {
        log.info("Consumed {} from queue", notificationRequestMessage);
        notificationService
                .registerNotificationToCustomer(createNotificationEntity(notificationRequestMessage));
    }

    private EntityNotification createNotificationEntity(NotificationRequestMessage notificationRequestMessage) {
        return EntityNotification.builder()
                .idCustomer(notificationRequestMessage.getIdCustomer())
                .customer_email(notificationRequestMessage.getCustomer_email())
                .sender(notificationRequestMessage.getSender())
                .message(notificationRequestMessage.getMessage())
                .sentAt(LocalDateTime.now())
                .build();
    }
}
