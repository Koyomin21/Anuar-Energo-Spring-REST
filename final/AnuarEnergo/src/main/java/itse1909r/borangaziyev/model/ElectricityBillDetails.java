package itse1909r.borangaziyev.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.AssertTrue;

@Component
@Data
public class ElectricityBillDetails {
    private int detailsId;
    private int electroBillId;
    private int providerId;
    private int paymentId;
    private int debtId;


    @AssertTrue(message = "Services should be paid")
    public boolean isHavePayment() {
        return paymentId != 0;
    }
}
