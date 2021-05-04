package com.pharm.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.pharm.model.DCI;
import com.pharm.model.Product;
import com.pharm.model.ProductSuggestion;
import com.pharm.repository.dci.DCIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DCIResolver implements GraphQLResolver<DCI> {
    @Autowired
    private DCIRepository dciRepository;

    public DCI getDCI(Product product){
        return dciRepository.findById(product.getDci().getId().intValue()).orElseThrow(null);
    }
    public DCI getDCI(ProductSuggestion productSuggestion){ return dciRepository.findById(productSuggestion.getDci().getId().intValue()).orElseThrow(null);
    }
}
