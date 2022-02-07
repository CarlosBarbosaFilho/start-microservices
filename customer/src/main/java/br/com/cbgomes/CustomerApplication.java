package br.com.cbgomes;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication(scanBasePackages = "br.com.cbgomes")
@EnableFeignClients(basePackages = "br.com.cbgomes.*")
@EnableEurekaClient
@PropertySources({
        @PropertySource("classpath:clients-${spring.profiles.active}.properties")
})
public class CustomerApplication {

    public static void main(String[] args) {
        run(CustomerApplication.class, args);
    }
}
