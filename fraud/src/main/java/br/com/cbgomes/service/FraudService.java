package br.com.cbgomes.service;

import br.com.cbgomes.entity.EntityFraudHistory;
import br.com.cbgomes.repository.FraudRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudService {

    private final FraudRepository fraudRepository;

    public boolean isFraudCustomer(Long customerId) {
        var fraud = fraudRepository.save(EntityFraudHistory.builder()
                        .customerId(customerId)
                        .createAt(LocalDateTime.now())
                        .isFraud(false)
                        .description("No fraud")
                .build());

        return fraud.isFraud();
    }
}
