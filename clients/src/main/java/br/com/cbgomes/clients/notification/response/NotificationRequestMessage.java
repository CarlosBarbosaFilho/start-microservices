package br.com.cbgomes.clients.notification.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequestMessage {

    @JsonProperty("sender")
    private String sender;

    @JsonProperty("customer_email")
    private String customer_email;

    @JsonProperty("idCustomer")
    private Long idCustomer;

    @JsonProperty("message")
    private String message;
}
