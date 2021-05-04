package com.pharm.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.pharm.model.Customer;
import com.pharm.model.Organization;
import com.pharm.service.interfaces.organization.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;

public class OrganizationResolver implements GraphQLResolver<Organization> {
    @Autowired
    private OrganizationService organizationService;

        public Organization getOrganization(Customer customer){
        return organizationService.findById(customer.getOrganization().getId().intValue());
    }

}
