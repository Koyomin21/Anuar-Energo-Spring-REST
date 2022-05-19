package itse1909r.borangaziyev.service;

import itse1909r.borangaziyev.model.Payment;
import itse1909r.borangaziyev.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.mockito.Mockito.*;

class PaymentServiceTest {
    @Mock
    PaymentRepository paymentRepository;
    @InjectMocks
    PaymentService paymentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCheckForNewPayments() {
        when(paymentRepository.getAllPayments()).thenReturn(Arrays.<Payment>asList(new Payment()));
        paymentService.checkForNewPayments();
        when(paymentRepository.getAllPayments()).thenReturn(Arrays.<Payment>asList());
        paymentService.checkForNewPayments();

    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme