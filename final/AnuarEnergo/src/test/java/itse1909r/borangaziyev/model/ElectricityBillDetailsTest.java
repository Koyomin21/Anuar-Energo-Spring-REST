package itse1909r.borangaziyev.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ElectricityBillDetailsTest {
    ElectricityBillDetails electricityBillDetails = new ElectricityBillDetails();

    @Test
    void testIsHavePayment() {
        boolean result = electricityBillDetails.isHavePayment();
        Assertions.assertEquals(false, result);
    }

    @Test
    void testSetDetailsId() {
        electricityBillDetails.setDetailsId(0);
    }

    @Test
    void testSetElectroBillId() {
        electricityBillDetails.setElectroBillId(0);
    }

    @Test
    void testSetProviderId() {
        electricityBillDetails.setProviderId(0);
    }

    @Test
    void testSetPaymentId() {
        electricityBillDetails.setPaymentId(0);
    }

    @Test
    void testSetDebtId() {
        electricityBillDetails.setDebtId(0);
    }

    @Test
    void testEquals() {
        boolean result = electricityBillDetails.equals("o");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testCanEqual() {
        boolean result = electricityBillDetails.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        int result = electricityBillDetails.hashCode();
        Assertions.assertNotNull(result);
    }

    @Test
    void testToString() {
        String result = electricityBillDetails.toString();
        Assertions.assertEquals("ElectricityBillDetails(detailsId=0, electroBillId=0, providerId=0, paymentId=0, debtId=0)", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme