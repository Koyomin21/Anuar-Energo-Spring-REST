package itse1909r.borangaziyev.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

class PaymentTest {
    //Field paymentDate of type LocalDate - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    Payment payment = new Payment();

    @Test
    void testSetPaymentId() {
        payment.setPaymentId(0);
    }

    @Test
    void testSetUserId() {
        payment.setUserId(0);
    }

    @Test
    void testSetAccountNumber() {
        payment.setAccountNumber("accountNumber");
    }

    @Test
    void testSetPaymentDate() {
        payment.setPaymentDate(LocalDate.of(2022, Month.MAY, 18));
    }

    @Test
    void testEquals() {
        boolean result = payment.equals("o");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testCanEqual() {
        boolean result = payment.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        int result = payment.hashCode();
        Assertions.assertNotNull(result);
    }

    @Test
    void testToString() {
        String result = payment.toString();
        Assertions.assertEquals("Payment(paymentId=0, userId=0, accountNumber=null, paymentDate=null)", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme