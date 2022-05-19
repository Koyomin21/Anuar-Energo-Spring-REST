package itse1909r.borangaziyev.repository;

import itse1909r.borangaziyev.model.ElectricityBill;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class ElectricityBillRepositoryTest {
    @Mock
    NamedParameterJdbcTemplate jdbcTemplate;
    @InjectMocks
    ElectricityBillRepository electricityBillRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllElectricityBills() {
        when(electricityBillRepository.getAllElectricityBills()).thenReturn(Arrays.<ElectricityBill>asList(new ElectricityBill()));
        List<ElectricityBill> result = electricityBillRepository.getAllElectricityBills();
        Assertions.assertNotNull(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme