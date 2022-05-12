package itse1909r.borangaziyev.model;

import javax.validation.constraints.AssertTrue;

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
