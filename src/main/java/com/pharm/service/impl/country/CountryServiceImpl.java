package com.pharm.service.impl.country;

import com.pharm.model.Country;
import com.pharm.repository.country.CountryRepository;
import com.pharm.service.interfaces.country.CountryService;
import com.pharm.util.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;
    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        Optional<Country> optional = countryRepository.findById(id.intValue());
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    public Country create(Country country) {
        country.setStatus(CommonConstant.ACTIVE);
        return countryRepository.save(country);
    }

    @Override
    public Country update(Country country) {
        if (country.getId()!=null){
            Country persisted = findById(country.getId());
            if (persisted==null){
                return null;
            }
            country.setStatus(CommonConstant.ACTIVE);
            return countryRepository.save(country);
        }
        return null;
    }

    @Override
    public Country delete(Country country) {
        if (country.getId()!=null && country!=null){
            Country delete = findById(country.getId());
            if (delete!=null){
                delete.setStatus(CommonConstant.DELETE);
                return countryRepository.save(delete);
            }
        }
        return null;
    }
}
