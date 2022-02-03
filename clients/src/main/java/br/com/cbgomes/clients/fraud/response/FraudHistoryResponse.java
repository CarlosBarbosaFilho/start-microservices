package br.com.cbgomes.clients.fraud.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FraudHistoryResponse {

//    private Long id;
//    private String description;
//    private Long customerId;
    private Boolean isFraud;
    //private LocalDateTime createAt;
}
