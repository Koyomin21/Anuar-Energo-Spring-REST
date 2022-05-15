package itse1909r.borangaziyev.service;


import itse1909r.borangaziyev.model.Payment;
import itse1909r.borangaziyev.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PaymentService {

    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Scheduled(fixedRateString = "${fixedRate.in.milliseconds}")
    public void checkForNewPayments() {
        List<Payment> paymentList = paymentRepository.getAllPayments();
        if(paymentList != null && paymentList.isEmpty()) {
            System.out.println("No payments have been made!");
        } else {
            System.out.println("Payments: " + paymentList);
        }
    }



}
