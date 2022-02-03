package br.com.cbgomes.controller;

import br.com.cbgomes.clients.fraud.response.FraudHistoryResponse;
import br.com.cbgomes.service.FraudService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/frauds")
@AllArgsConstructor
@Slf4j
public class FraudController {

    private final FraudService service;

    @GetMapping("/is-fraud/{customerId}")
    public FraudHistoryResponse isFraud(@PathVariable("customerId") Long customerId) {
        log.info("checking fraud service to customer with id {}", customerId);
        var isFraud = this.service.isFraudCustomer(customerId);

        return new FraudHistoryResponse(isFraud);
    }
}
