package itse1909r.borangaziyev.service;

import itse1909r.borangaziyev.model.Payment;
import itse1909r.borangaziyev.model.Provider;
import itse1909r.borangaziyev.model.Rate;
import itse1909r.borangaziyev.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProviderService {

    private ProviderRepository providerRepository;

    @Autowired
    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public boolean updateRate(Rate rate) {
        if(rate.getRateId() == 0) {
            throw new RuntimeException("Not a valid rate");
        }

        if(rate.getProviderId() == 0) {
            throw new RuntimeException("The provider is 0, cannot be updated");
        }

        return providerRepository.updateRate(rate);
    }

    public List<Provider> getPagedProviders(int page, int limit, String sortByColumn) {
        limit = limit > 0 ? limit : 1;
        page = page == 0 ? page = 1 : page;
        page = (limit * page) - limit;

        List<Provider> paymentList = providerRepository.getPagedProviders(page, limit, sortByColumn);
        if(paymentList == null) return new ArrayList<>();

        return paymentList;
    }


}
