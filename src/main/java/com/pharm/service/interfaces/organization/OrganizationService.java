package com.pharm.service.interfaces.organization;


import com.pharm.model.Organization;

import java.util.List;

public interface OrganizationService {
    List<Organization> findAll();
    Organization findById(Long id);
    Organization create(Organization organization);
    Organization update(Organization organization);
    Organization delete(Organization organization);
}
