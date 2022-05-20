package integrationTests;


import com.fasterxml.jackson.databind.ObjectMapper;
import itse1909r.borangaziyev.AnuarEnergoApplication;
import itse1909r.borangaziyev.model.ElectricityBill;
import itse1909r.borangaziyev.service.ElectricityBillService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@AutoConfigureMockMvc
@SpringBootTest(classes = AnuarEnergoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ElectricalBillControllerIntegrationTest {

    @LocalServerPort
    private int port;

    private String urlTemplate = "http://localhost:"+port;

    @MockBean
    private ElectricityBillService electricityBillService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper om;

    @Test
    void testOptions() throws Exception {

        mockMvc.perform(get(urlTemplate + "/bills/options"))
                .andExpect(status().is3xxRedirection());


    }


    @Test
    void testGetBillsByUserId() throws Exception {
        List<ElectricityBill> billList = Arrays.asList(new ElectricityBill());

        when(electricityBillService.getBillsOfUser(1)).thenReturn(billList);

        mockMvc.perform(get(urlTemplate + "/bills/checkBills/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("hasBills", "true"));

    }


}
