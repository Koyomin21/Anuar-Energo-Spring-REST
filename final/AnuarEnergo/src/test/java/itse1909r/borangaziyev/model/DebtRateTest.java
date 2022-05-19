package itse1909r.borangaziyev.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DebtRateTest {
    DebtRate debtRate = new DebtRate();

    @Test
    void testSetDebtId() {
        debtRate.setDebtId(0);
    }

    @Test
    void testSetRateName() {
        debtRate.setRateName("rateName");
    }

    @Test
    void testSetAddedPricePerUnit() {
        debtRate.setAddedPricePerUnit(0);
    }

    @Test
    void testEquals() {
        boolean result = debtRate.equals("o");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testCanEqual() {
        boolean result = debtRate.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        int result = debtRate.hashCode();
        Assertions.assertNotNull(result);
    }

    @Test
    void testToString() {
        String result = debtRate.toString();
        Assertions.assertEquals("DebtRate(debtId=0, rateName=null, addedPricePerUnit=0)", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme