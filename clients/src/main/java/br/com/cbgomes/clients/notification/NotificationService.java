package br.com.cbgomes.clients.notification;

import br.com.cbgomes.clients.notification.response.NotificationRequestMessage;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "notification", url = "http://notification-service:8084/api/v1/notifications")
public interface NotificationService {

    @LoadBalanced
    @PostMapping (value = "/notified", consumes = "application/json")
    void notified(@RequestBody NotificationRequestMessage notificationRequestMessage);
}
