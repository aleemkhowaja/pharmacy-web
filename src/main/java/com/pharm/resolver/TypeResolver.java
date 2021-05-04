package com.pharm.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.pharm.model.Customer;
import com.pharm.model.Type;
import com.pharm.service.interfaces.type.TypeService;
import org.springframework.beans.factory.annotation.Autowired;

public class TypeResolver implements GraphQLResolver<Type>{
    @Autowired
    private TypeService typeService;

        public Type getType(Customer customer){
        return typeService.findById(customer.getType().getId().intValue());
    }
}
