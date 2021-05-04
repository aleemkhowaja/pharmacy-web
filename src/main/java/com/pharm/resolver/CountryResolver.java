package com.pharm.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.pharm.model.*;
import com.pharm.service.interfaces.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountryResolver implements GraphQLResolver<Country> {
    @Autowired
    private CountryService countryService;


    public Country getCountry(Customer customer){
        return countryService.findById(customer.getCountry().getId());
    }
    public Country getCountry(Supplier supplier){
        return countryService.findById(supplier.getCountry().getId());
    }
    public Country getCountry(SupplierSuggestion supplierSuggestion){
        return countryService.findById(supplierSuggestion.getCountry().getId());
    }
    public Country getCountry(Confreres confreres){
        return countryService.findById(confreres.getCountry().getId());
    }

}
