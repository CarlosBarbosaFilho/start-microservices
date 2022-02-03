package br.com.cbgomes.controller;

import br.com.cbgomes.controller.request.RequestCustomer;
import br.com.cbgomes.controller.response.ResponseCustomer;
import br.com.cbgomes.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/customers")
@AllArgsConstructor
public class CustomerResources {

    private final CustomerService customerService;

    @PostMapping
    public void createCustomer(@RequestBody RequestCustomer requestCustomer){
        log.info(" Create a new register of customer {}", requestCustomer);
        this.customerService.createCustomer(requestCustomer);
    }
}
