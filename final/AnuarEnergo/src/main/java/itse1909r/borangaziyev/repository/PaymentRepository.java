package itse1909r.borangaziyev.repository;


import itse1909r.borangaziyev.model.ElectricityBill;
import itse1909r.borangaziyev.model.Payment;
import itse1909r.borangaziyev.model.mapper.ElectricityBillMapper;
import itse1909r.borangaziyev.model.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentRepository {
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public PaymentRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Payment> getAllPayments() {
        return jdbcTemplate.query(
                "SELECT * FROM Payment;",
                new PaymentMapper()
        );
    }

}
