package itse1909r.borangaziyev.repository;

import itse1909r.borangaziyev.model.Provider;
import itse1909r.borangaziyev.model.Rate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class ProviderRepositoryTest {
    @Mock
    NamedParameterJdbcTemplate jdbcTemplate;
    @InjectMocks
    ProviderRepository providerRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testUpdateRate() {
        boolean result = providerRepository.updateRate(new Rate());
        Assertions.assertEquals(false, result);
    }

    @Test
    void testGetPagedProviders() {
        List<Provider> result = providerRepository.getPagedProviders(0, 0, "sortByColumn");
        Assertions.assertEquals(Arrays.<Provider>asList(), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme