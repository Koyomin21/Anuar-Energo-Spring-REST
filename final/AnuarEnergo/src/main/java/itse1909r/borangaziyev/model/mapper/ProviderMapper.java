package itse1909r.borangaziyev.model.mapper;

import itse1909r.borangaziyev.model.Provider;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProviderMapper implements RowMapper<Provider> {

    @Override
    public Provider mapRow(ResultSet rs, int rowNum) throws SQLException {
        Provider provider = new Provider();
        provider.setProviderId(rs.getInt("providerId"));
        provider.setName(rs.getString("name"));
        provider.setContactNumber(rs.getString("contactNumber"));
        provider.setDescription(rs.getString("description"));


        return provider;
    }
}
