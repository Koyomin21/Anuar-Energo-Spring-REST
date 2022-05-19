package itse1909r.borangaziyev.model.mapper;

import itse1909r.borangaziyev.model.Payment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.support.rowset.ResultSetWrappingSqlRowSet;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PaymentMapperTest {
    PaymentMapper paymentMapper = new PaymentMapper();

    @Test
    void testMapRow() throws SQLException {
        ResultSet rs = mock(ResultSet.class);
        when(rs.getInt(anyString())).thenReturn(1);
        when(rs.getString(anyString())).thenReturn("1231241241");
        when(rs.getDate(anyString())).thenReturn(new Date(1212, 12,12));


        Payment result = paymentMapper.mapRow(rs, 0);
        Assertions.assertNotNull(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme