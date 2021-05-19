package com.pharm.service.impl.organization;

import com.pharm.model.Organization;
import com.pharm.repository.organization.OrganizationRepository;
import com.pharm.service.interfaces.organization.OrganizationService;
import com.pharm.util.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public List<Organization> findAll() {
        return organizationRepository.findAll();
    }

    @Override
    public Organization findById(Long id) {
        Optional<Organization> optional = organizationRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    public Organization create(Organization organization) {
        organization.setStatus(CommonConstant.ACTIVE);
        return organizationRepository.save(organization);
    }

    @Override
    public Organization update(Organization organization) {
        if(organization.getId()!=null){
            Organization persisted = findById(organization.getId());
            if (persisted==null){
                return null;
            }
            organization.setStatus(CommonConstant.ACTIVE);
            return organizationRepository.save(organization);
        }
        return null;
    }

    @Override
    public Organization delete(Organization organization) {
        if (organization!=null && organization.getId()!=null){
            Organization deleted = findById(organization.getId());
            if (deleted!=null){
                deleted.setStatus(CommonConstant.DELETE);
                return organizationRepository.save(deleted);
            }

        }
        return null;
    }
}
