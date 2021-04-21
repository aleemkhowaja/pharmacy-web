package com.pharm.controller.country;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pharm.model.Country;
import com.pharm.service.interfaces.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryController implements GraphQLQueryResolver {

    @Autowired
    private CountryService countryService;

    public List<Country> getAllCountries(){
        return countryService.findAll();
    }
}
