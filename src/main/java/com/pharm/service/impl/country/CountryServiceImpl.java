package com.pharm.service.impl.country;

import com.pharm.model.Country;
import com.pharm.repository.country.CountryRepository;
import com.pharm.service.interfaces.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;
    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }
}
