package itse1909r.borangaziyev.service;


import itse1909r.borangaziyev.aop.ExecutionTimeLogger;
import itse1909r.borangaziyev.model.ElectricityBill;
import itse1909r.borangaziyev.model.Provider;
import itse1909r.borangaziyev.repository.ElectricityBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ElectricityBillService {

    private ElectricityBillRepository billRepository;

    @Autowired
    public ElectricityBillService(ElectricityBillRepository billRepository) {
        this.billRepository = billRepository;
    }


    @Async
    @Scheduled(initialDelay = 1000, fixedDelay = 10000)
    @ExecutionTimeLogger
    public List<ElectricityBill> getAllBills() {
        List<ElectricityBill> bills = billRepository.getAllElectricityBills();

        // sorting bills by startPeriod
        if(bills != null || !bills.isEmpty()) {
            List<ElectricityBill> sortedList = bills.stream()
                    .sorted(Comparator.comparing(ElectricityBill::getStartPeriod))
                    .collect(Collectors.toList());

            return sortedList;
        }

        return new ArrayList<>();
    }

    public List<ElectricityBill> getBillsOfUser(int userId) {
        List<ElectricityBill> bills = billRepository.getAllElectricityBills();

        if(bills != null || !bills.isEmpty()) {

            return bills.stream()
                    .filter(bill -> bill.getUserId() == userId)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
