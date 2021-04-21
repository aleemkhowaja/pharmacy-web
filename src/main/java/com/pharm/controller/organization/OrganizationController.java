package com.pharm.controller.organization;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pharm.model.Organization;
import com.pharm.service.interfaces.organization.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrganizationController implements GraphQLQueryResolver {
    @Autowired
    private OrganizationService organizationService;

    public List<Organization> getAllOrganizations(){
        return organizationService.findAll();
    }
}
