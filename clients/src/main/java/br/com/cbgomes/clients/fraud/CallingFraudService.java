package br.com.cbgomes.clients.fraud;

import br.com.cbgomes.clients.fraud.response.FraudHistoryResponse;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient (
       // value = "call-fraud-service", url = "http://fraud:8081/api/v1/frauds"
        name = "fraud",
        url = "${clients.fraud.url}"
)
public interface CallingFraudService {

    @LoadBalanced
    @GetMapping (value = "/is-fraud/{customerId}", consumes = "application/json")
    FraudHistoryResponse isFraud(@PathVariable ("customerId") Long customerId);

}