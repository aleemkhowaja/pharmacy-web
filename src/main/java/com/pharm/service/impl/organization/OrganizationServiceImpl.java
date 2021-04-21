package com.pharm.service.impl.organization;

import com.pharm.model.Organization;
import com.pharm.repository.organization.OrganizationRepository;
import com.pharm.service.interfaces.organization.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public List<Organization> findAll() {
        return organizationRepository.findAll();
    }
}
