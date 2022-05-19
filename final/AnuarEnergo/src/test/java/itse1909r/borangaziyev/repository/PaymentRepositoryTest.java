package itse1909r.borangaziyev.repository;

import itse1909r.borangaziyev.model.Payment;
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

class PaymentRepositoryTest {
    @Mock
    NamedParameterJdbcTemplate jdbcTemplate;
    @InjectMocks
    PaymentRepository paymentRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllPayments() {
        List<Payment> result = paymentRepository.getAllPayments();
        Assertions.assertEquals(Arrays.<Payment>asList(new Payment()), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme