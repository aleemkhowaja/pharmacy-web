package com.pharm.controller.country;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pharm.model.Country;
import com.pharm.service.interfaces.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryController implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private CountryService countryService;

    public List<Country> getAllCountries(){
        return countryService.findAll();
    }
    public Country getCountryById(Long id){
        return countryService.findById(id);
    }
    public Country createCountry(Country country){
        return countryService.create(country);
    }
    public Country updateCountry(Country country){
        return countryService.update(country);
    }
    public Country deleteCountry(Long id){
        Country country = new Country();
        country.setId(id);
        return countryService.delete(country);
    }
}
