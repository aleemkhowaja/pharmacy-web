package com.pharm.service.impl.suppliersuggestion;

import com.pharm.model.SupplierSuggestion;
import com.pharm.repository.suppliersuggestion.SupplierSuggestionRepository;
import com.pharm.service.interfaces.suppliersuggestion.SupplierSuggestionService;
import com.pharm.util.CommonConstant;
import com.pharm.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Service
public class SupplierSuggestionServiceImpl implements SupplierSuggestionService {
    @Autowired
    private SupplierSuggestionRepository supplierSuggestionRepository;

    @Override
    @Transactional
    public List<SupplierSuggestion> getAllSupplierSuggestions(int pageNumber, int pageSize, String sortOrder, String sortBy, SupplierSuggestion filter) {
        String validationErrors = PageUtil.validatePaginationParams(pageNumber, pageSize, sortOrder, sortBy);
        if((isNotBlank(validationErrors))) {
            throw new IllegalArgumentException(validationErrors);
        }

        Page<SupplierSuggestion> supplierSuggestions = supplierSuggestionRepository.filter(filter.getLastName(), filter.getEmail(), filter.getPhone(),
                filter.getCity(), filter.getAddress(),PageUtil.returnPageable(pageNumber, pageSize, sortOrder, sortBy));
        if(supplierSuggestions.hasContent())
        {
            final Long size = supplierSuggestionRepository.count(filter.getLastName(), filter.getEmail(), filter.getPhone(),
                    filter.getCity(), filter.getAddress());
            System.out.println("size::"+size);
            supplierSuggestions.getContent().get(0).setCount(size);
        }
        return supplierSuggestions.getContent();
    }

    @Override
    @Transactional
    public SupplierSuggestion getSupplierSuggestionById(Long id) {
        Optional<SupplierSuggestion> opt = supplierSuggestionRepository.findById(id);
        if(opt.isPresent()){
            return opt.get();
        }
        return null;
    }

    @Override
    @Transactional
    public SupplierSuggestion createSupplierSuggestion(SupplierSuggestion supplierSuggestion) {
        supplierSuggestion.setStatus(CommonConstant.ACTIVE);
        return supplierSuggestionRepository.save(supplierSuggestion);
    }

    @Override
    @Transactional
    public SupplierSuggestion updateSupplierSuggestion(SupplierSuggestion supplierSuggestion){
        if (supplierSuggestion.getId()!= null) {
        SupplierSuggestion persisted = getSupplierSuggestionById(supplierSuggestion.getId());
        if (persisted == null) {
            return null;
        }
        supplierSuggestion.setStatus(CommonConstant.ACTIVE);
        SupplierSuggestion updated = supplierSuggestionRepository.save(supplierSuggestion);
        return updated;
    }
        return null;
    }

    @Override
    @Transactional
    public SupplierSuggestion deleteSupplierSuggestion(SupplierSuggestion supplierSuggestion) {
        if(supplierSuggestion!=null && supplierSuggestion.getId()!=null){
            SupplierSuggestion deleted = getSupplierSuggestionById(supplierSuggestion.getId());
            if (deleted!=null){
                deleted.setStatus(CommonConstant.DELETE);
                return supplierSuggestionRepository.save(deleted);
            }

        }
        return null;
    }
}
