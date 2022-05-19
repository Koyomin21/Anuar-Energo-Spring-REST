package itse1909r.borangaziyev.service;

import itse1909r.borangaziyev.jms.JmsMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jms.core.JmsTemplate;

import static org.mockito.Mockito.*;

class JmsServiceTest {
    @Mock
    JmsTemplate jmsTemplate;
    @InjectMocks
    JmsService jmsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testListenFromCustomer() {
        jmsService.listenFromCustomer(new JmsMessage("from", "message"));
    }

    @Test
    void testListenForSuggestions() {
        jmsService.listenForSuggestions(new JmsMessage("from", "message"));
    }

    @Test
    void testListenToComplaints() {
        jmsService.listenToComplaints(new JmsMessage("from", "message"));
    }

    @Test
    void testSendMessage() {
        jmsService.sendMessage("destination", new JmsMessage("from", "message"));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme