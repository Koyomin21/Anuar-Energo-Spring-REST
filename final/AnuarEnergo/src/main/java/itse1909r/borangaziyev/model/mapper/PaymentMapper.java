package itse1909r.borangaziyev.model.mapper;

import itse1909r.borangaziyev.model.Payment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentMapper implements RowMapper<Payment> {

    @Override
    public Payment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Payment payment = new Payment();
        payment.setPaymentId(rs.getInt("paymentId"));
        payment.setPaymentDate(rs.getDate("paymentDate").toLocalDate());
        payment.setAccountNumber(rs.getString("accountNumber"));
        payment.setUserId(rs.getInt("userId"));

        return payment;
    }
}
