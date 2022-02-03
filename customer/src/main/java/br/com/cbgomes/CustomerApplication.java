package br.com.cbgomes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.annotation.PostConstruct;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication(scanBasePackages = "br.com.cbgomes")
@EnableFeignClients(basePackages = "br.com.cbgomes.*")
@EnableEurekaClient
public class CustomerApplication {

    public static void main(String[] args) {
        run(CustomerApplication.class, args);
    }
}
