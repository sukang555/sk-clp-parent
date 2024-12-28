package payment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaymentHistoryDTO {
    private String newPaymentHistory;
    private String accountManagementId;
    private String oldPaymentHistory;
}
