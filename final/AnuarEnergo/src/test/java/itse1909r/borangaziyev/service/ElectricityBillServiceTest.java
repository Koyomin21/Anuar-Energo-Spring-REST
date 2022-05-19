package itse1909r.borangaziyev.service;

import itse1909r.borangaziyev.model.ElectricityBill;
import itse1909r.borangaziyev.repository.ElectricityBillRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class ElectricityBillServiceTest {
    @Mock
    ElectricityBillRepository billRepository;
    @InjectMocks
    ElectricityBillService electricityBillService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllBills() {
        when(billRepository.getAllElectricityBills()).thenReturn(Arrays.<ElectricityBill>asList(new ElectricityBill()));
        List<ElectricityBill> result = electricityBillService.getAllBills();
        Assertions.assertEquals(Arrays.<ElectricityBill>asList(new ElectricityBill()), result);

        when(billRepository.getAllElectricityBills()).thenReturn(null);
        List<ElectricityBill> result2 = electricityBillService.getAllBills();
        Assertions.assertEquals(result2, new ArrayList<ElectricityBill>());




    }

    @Test
    void testGetBillsOfUser() {
        when(billRepository.getAllElectricityBills()).thenReturn(Arrays.<ElectricityBill>asList(new ElectricityBill()));
        List<ElectricityBill> result = electricityBillService.getBillsOfUser(0);
        Assertions.assertEquals(Arrays.<ElectricityBill>asList(new ElectricityBill()), result);

        when(billRepository.getAllElectricityBills()).thenReturn(Arrays.<ElectricityBill>asList());
        List<ElectricityBill> result2 = electricityBillService.getBillsOfUser(1);
        Assertions.assertEquals(Arrays.<ElectricityBill>asList(), result2);

    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme