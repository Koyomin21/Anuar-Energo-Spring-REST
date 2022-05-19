package itse1909r.borangaziyev.service;

import itse1909r.borangaziyev.model.Provider;
import itse1909r.borangaziyev.model.Rate;
import itse1909r.borangaziyev.repository.ProviderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class ProviderServiceTest {
    @Mock
    ProviderRepository providerRepository;
    @InjectMocks
    ProviderService providerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testUpdateRate() {
        Rate rate = new Rate();
        rate.setProviderId(1);
        rate.setRateId(1);

        Rate rate2 = new Rate();
        rate2.setProviderId(0);
        rate2.setRateId(1);

        when(providerRepository.updateRate(any())).thenReturn(true);

        boolean result = providerService.updateRate(rate);


        Assertions.assertEquals(true, result);
        Assertions.assertThrows(RuntimeException.class, ()->{
            providerService.updateRate(rate2);
        });
    }

    @Test
    void testGetPagedProviders() {
        when(providerRepository.getPagedProviders(anyInt(), anyInt(), anyString())).thenReturn(Arrays.<Provider>asList(new Provider()));

        List<Provider> result = providerService.getPagedProviders(0, 0, "sortByColumn");
        Assertions.assertEquals(Arrays.<Provider>asList(new Provider()), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme