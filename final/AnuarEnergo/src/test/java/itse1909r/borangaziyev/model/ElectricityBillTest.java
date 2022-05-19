package itse1909r.borangaziyev.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

class ElectricityBillTest {
    //Field startPeriod of type LocalDate - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    //Field endPeriod of type LocalDate - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    ElectricityBill electricityBill = new ElectricityBill();

    @Test
    void testSetElectroBillId() {
        electricityBill.setElectroBillId(0);
    }

    @Test
    void testSetUserId() {
        electricityBill.setUserId(0);
    }

    @Test
    void testSetUnitsUsed() {
        electricityBill.setUnitsUsed(0);
    }

    @Test
    void testSetStartPeriod() {
        electricityBill.setStartPeriod(LocalDate.of(2022, Month.MAY, 18));
    }

    @Test
    void testSetEndPeriod() {
        electricityBill.setEndPeriod(LocalDate.of(2022, Month.MAY, 18));
    }

    @Test
    void testSetTotalSum() {
        electricityBill.setTotalSum(0);
    }

    @Test
    void testEquals() {
        boolean result = electricityBill.equals("o");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testCanEqual() {
        boolean result = electricityBill.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testHashCode() {
        int result = electricityBill.hashCode();
        Assertions.assertNotNull(result);
    }

    @Test
    void testToString() {
        String result = electricityBill.toString();
        Assertions.assertEquals("ElectricityBill(electroBillId=0, userId=0, unitsUsed=0, startPeriod=null, endPeriod=null, totalSum=0)", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme