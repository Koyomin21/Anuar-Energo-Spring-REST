package itse1909r.borangaziyev.configuration;

import itse1909r.borangaziyev.model.Building;
import itse1909r.borangaziyev.model.ElectricityBill;
import itse1909r.borangaziyev.model.Provider;
import itse1909r.borangaziyev.model.User;
import itse1909r.borangaziyev.service.ElectricityBillService;
import itse1909r.borangaziyev.service.JmsService;
import itse1909r.borangaziyev.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.env.Environment;

import java.util.Arrays;

import static org.mockito.Mockito.*;

class BeanConfigurationTest {
    @Mock
    Environment environment;
    @Mock
    UserService userService;
    @Mock
    ElectricityBillService billService;
    @Mock
    JmsService jmsService;
    @InjectMocks
    BeanConfiguration beanConfiguration;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testUser() {
        User result = beanConfiguration.user();
        Assertions.assertEquals(new User(), result);
    }

    @Test
    void testProvider() {
        Provider result = beanConfiguration.provider();
        Assertions.assertEquals(new Provider(), result);
    }

    @Test
    void testBuilding() {
        Building result = beanConfiguration.building();
        Assertions.assertEquals(new Building(), result);
    }

    @Test
    void testRunParallel() {
        when(billService.getAllBills()).thenReturn(Arrays.<ElectricityBill>asList(new ElectricityBill()));

        beanConfiguration.runParallel();
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme