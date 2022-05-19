package itse1909r.borangaziyev.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RateTest {
    Rate rate = new Rate();

    @Test
    void testSetRateId() {
        rate.setRateId(0);
    }

    @Test
    void testSetPricePerUnit() {
        rate.setPricePerUnit(0);
    }

    @Test
    void testSetProviderId() {
        rate.setProviderId(0);
    }

    @Test
    void testSetDescription() {
        rate.setDescription("description");
    }

    @Test
    void testSetRateTypeName() {
        rate.setRateTypeName("rateTypeName");
    }

    @Test
    void testEquals() {
        boolean result = rate.equals("o");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testCanEqual() {
        boolean result = rate.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        int result = rate.hashCode();
        Assertions.assertNotNull( result);
    }

    @Test
    void testToString() {
        String result = rate.toString();
        Assertions.assertEquals("Rate(rateId=0, pricePerUnit=0, providerId=0, description=null, rateTypeName=null)", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme