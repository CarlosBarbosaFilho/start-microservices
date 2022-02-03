package br.com.cbgomes.service;

import br.com.cbgomes.RabbitMQMessageProducer;
import br.com.cbgomes.clients.fraud.CallingFraudService;
import br.com.cbgomes.clients.fraud.response.FraudHistoryResponse;
import br.com.cbgomes.clients.notification.NotificationService;
import br.com.cbgomes.clients.notification.response.NotificationRequestMessage;
import br.com.cbgomes.controller.request.RequestCustomer;
import br.com.cbgomes.entity.Customer;
import br.com.cbgomes.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CallingFraudService callingFraudService;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    public CustomerService(CustomerRepository customerRepository, CallingFraudService callingFraudService,
                           NotificationService callingNotificationService
                            , RabbitMQMessageProducer rabbitMQMessageProducer) {
        this.customerRepository = customerRepository;
        this.callingFraudService = callingFraudService;
        this.rabbitMQMessageProducer = rabbitMQMessageProducer;
    }

    public void createCustomer(RequestCustomer requestCustomer) {

        log.info("calling the method to create on customer {}", requestCustomer);
        var customerSaved = this.customerRepository.save(factoryCustomer(requestCustomer));

        log.info("calling fraud service");
        FraudHistoryResponse responseFraudService = this.callingFraudService.isFraud(customerSaved.getId());

        log.info("calling notification service");
        var notificationRequest = NotificationRequestMessage
                .builder()
                        .idCustomer(customerSaved.getId())
                        .customer_email(customerSaved.getEmail())
                        .sender(customerSaved.getName())
                .message("Carlos send message to queue")
                .build();

        this.rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );

        if (responseFraudService.getIsFraud()){
            throw new IllegalStateException("This is a fraudster");
        }
    }

    private Customer factoryCustomer(RequestCustomer requestCustomer) {
        return Customer.builder()
                        .name(requestCustomer.getName())
                        .email(requestCustomer.getEmail())
                        .build();
    }
}
