package itse1909r.borangaziyev.model.mapper;

import itse1909r.borangaziyev.model.ElectricityBill;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ElectricityBillMapperTest {
    ElectricityBillMapper electricityBillMapper = new ElectricityBillMapper();

    @Test
    void testMapRow() throws SQLException {
        ResultSet rs = mock(ResultSet.class);
        Date date = new Date(2021, 12,12);

        when(rs.getInt(anyString())).thenReturn(1);

        when(rs.getDate(anyString())).thenReturn(date);

        ElectricityBill result = electricityBillMapper.mapRow(rs, 0);
        Assertions.assertNotNull(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme