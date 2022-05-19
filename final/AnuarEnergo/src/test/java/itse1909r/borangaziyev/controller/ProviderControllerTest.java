package itse1909r.borangaziyev.controller;

import itse1909r.borangaziyev.model.Provider;
import itse1909r.borangaziyev.model.Rate;
import itse1909r.borangaziyev.service.PaymentService;
import itse1909r.borangaziyev.service.ProviderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class ProviderControllerTest {
    @Mock
    ProviderService providerService;
    @Mock
    PaymentService paymentService;
    @InjectMocks
    ProviderController providerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testUpdateRate() {
        when(providerService.updateRate(any())).thenReturn(true);

        String result = providerController.updateRate(new Rate());
        Assertions.assertEquals("Successfully updated", result);
    }

    @Test
    void testGetPagedProviders() {
        when(providerService.getPagedProviders(anyInt(), anyInt(), anyString())).thenReturn(Arrays.<Provider>asList(new Provider()));

        List<Provider> result = providerController.getPagedProviders(0, 0, "sortByColumn");
        Assertions.assertEquals(Arrays.<Provider>asList(new Provider()), result);
    }

//    @Test
//    void testDownloadFile() {
//        ResponseEntity result = providerController.downloadFile("fileName");
//        Assertions.assertEquals(null, result);
//    }

    @Test
    void testUploadFile() {
        MultipartFile file = mock(MultipartFile.class);
        ResponseEntity result = providerController.uploadFile("fileName", file);
        Assertions.assertNull(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme