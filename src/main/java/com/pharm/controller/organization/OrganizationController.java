package com.pharm.controller.organization;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pharm.model.Organization;
import com.pharm.service.interfaces.organization.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrganizationController implements GraphQLQueryResolver, GraphQLMutationResolver {
    @Autowired
    private OrganizationService organizationService;

    public List<Organization> getAllOrganizations(){
        return organizationService.findAll();
    }
    public  Organization getOrganizationById(Integer id){return organizationService.findById(id); }
    public Organization createOrganization(Organization organization){
        return organizationService.create(organization);
    }
    public Organization updateOrganization(Organization organization){
        return  organizationService.update(organization);
    }
    public Organization deleteOrganization(Long id){
        Organization organization = new Organization();
        organization.setId(id);
        return organizationService.delete(organization);
    }
}
