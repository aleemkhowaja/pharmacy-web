package com.pharm.service.interfaces.country;


import com.pharm.model.Country;

import java.util.List;

public interface CountryService {
    List<Country> findAll();
    Country findById(Long id);
    Country create(Country country);
    Country update(Country country);
    Country delete(Country country);
}
