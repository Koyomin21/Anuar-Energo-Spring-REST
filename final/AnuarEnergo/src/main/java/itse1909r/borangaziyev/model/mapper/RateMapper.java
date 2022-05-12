package itse1909r.borangaziyev.model.mapper;

import itse1909r.borangaziyev.model.Rate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RateMapper implements RowMapper<Rate> {

    @Override
    public Rate mapRow(ResultSet rs, int rowNum) throws SQLException {
        Rate rate = new Rate();

        rate.setRateId(rs.getInt("rateId"));
        rate.setPricePerUnit(rs.getInt("pricePerUnit"));
        rate.setProviderId(rs.getInt("providerId"));
        rate.setRateTypeName(rs.getString("rateTypeName"));
        rate.setDescription(rs.getString("description"));

        return rate;
    }
}
