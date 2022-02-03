package br.com.cbgomes.controller.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseCustomer {

    private Integer id;
    private String name;
    private String email;
}
