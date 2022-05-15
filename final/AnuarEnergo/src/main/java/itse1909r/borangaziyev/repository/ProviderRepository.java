package itse1909r.borangaziyev.repository;


import itse1909r.borangaziyev.model.Payment;
import itse1909r.borangaziyev.model.Provider;
import itse1909r.borangaziyev.model.Rate;
import itse1909r.borangaziyev.model.mapper.PaymentMapper;
import itse1909r.borangaziyev.model.mapper.ProviderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProviderRepository {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public ProviderRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public boolean updateRate(Rate rate) {
        String sql =    "UPDATE Rate " +
                        "SET pricePerUnit = :price," +
                        "rateDescription = :descr, " +
                        "rateTypeName = :typeName, " +
                        "providerId = :provider " +
                        "WHERE rateId = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("price", rate.getPricePerUnit());
        params.addValue("descr", rate.getDescription());
        params.addValue("typeName", rate.getRateTypeName());
        params.addValue("provider", rate.getProviderId());
        params.addValue("id", rate.getRateId());

        return jdbcTemplate.update(sql, params) > 0;
    }
    public List<Provider> getPagedProviders(int offset, int limit, String sortByColumn) {
        String sql = "SELECT * FROM Provider ORDER BY :sortColumn LIMIT :limit OFFSET :page";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("sortColumn", sortByColumn);
        params.addValue("limit", limit);
        params.addValue("page", offset);

        System.out.println(offset);
        System.out.println(limit);
        System.out.println(sortByColumn);

        return jdbcTemplate.query(
                sql,
                params,
                new ProviderMapper()
        );

    }

}
