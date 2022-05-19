package itse1909r.borangaziyev.controller;

import itse1909r.borangaziyev.jms.JmsMessage;
import itse1909r.borangaziyev.model.ElectricityBill;
import itse1909r.borangaziyev.service.ElectricityBillService;
import itse1909r.borangaziyev.service.JmsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class ElectricalBillControllerTest {
    @Mock
    ElectricityBillService billService;
    @Mock
    JmsService jmsService;
    @InjectMocks
    ElectricalBillController electricalBillController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testOptions() {
        HttpServletResponse resp = mock(HttpServletResponse.class);
        ResponseEntity result = electricalBillController.options(resp);
        Assertions.assertNotNull(result);
    }

    @Test
    void testGetBillsByUserId() {
        when(billService.getBillsOfUser(1)).thenReturn(Arrays.<ElectricityBill>asList(new ElectricityBill()));
        when(billService.getBillsOfUser(0)).thenThrow(new RuntimeException());

        ResponseEntity<List<ElectricityBill>> result = electricalBillController.getBillsByUserId(1);
        Assertions.assertEquals("<204 NO_CONTENT No Content,[hasBills:\"true\"]>", result.toString());
        Assertions.assertThrows(RuntimeException.class, ()-> {
            electricalBillController.getBillsByUserId(0);

        });
    }

    @Test
    void testSendComplaint() {


        doThrow(new RuntimeException()).when(jmsService).sendMessage("complaints", new JmsMessage("2", "message"));

        String result = electricalBillController.sendComplaint(new JmsMessage("from", "message"));
        String res = electricalBillController.sendComplaint(new JmsMessage("2", "message"));

        Assertions.assertEquals("Your complaint was successfully sent!", result);
        Assertions.assertEquals("Could not send the complaint", res);

    }

    @Test
    void testSendSuggestion() {
        doThrow(new RuntimeException()).when(jmsService).sendMessage("suggestions", new JmsMessage("3", "message"));
        String result = electricalBillController.sendSuggestion(new JmsMessage("from", "message"));
        String result2 = electricalBillController.sendSuggestion(new JmsMessage("3", "message"));

        Assertions.assertEquals("Your suggestion was successfully sent! Thank you!", result);
        Assertions.assertEquals("Could not send the suggestion", result2);
    }

    @Test
    void testSendMailbox() {
        doThrow(new RuntimeException()).when(jmsService).sendMessage("mailbox", new JmsMessage("4", "message"));

        String result = electricalBillController.sendMailbox(new JmsMessage("from", "message"));
        String result2 = electricalBillController.sendMailbox(new JmsMessage("4", "message"));

        Assertions.assertEquals("Your mail was successfully sent to admins! Thank you!", result);
        Assertions.assertEquals("Could not send the email", result2);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme