package com.pharm.service.impl.suppliersuggestion;

import com.pharm.model.SupplierSuggestion;
import com.pharm.repository.suppliersuggestion.SupplierSuggestionRepository;
import com.pharm.service.interfaces.suppliersuggestion.SupplierSuggestionService;
import com.samcm.util.CommonConstant;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierSuggestionServiceImpl implements SupplierSuggestionService {
    @Autowired
    private SupplierSuggestionRepository supplierSuggestionRepository;

    @Override
    @Transactional
    public List<SupplierSuggestion> getAllSupplierSuggestions() {
        return supplierSuggestionRepository.findAll();
    }

    @Override
    @Transactional
    public SupplierSuggestion getSupplierSuggestionById(Long id) {
        Optional<SupplierSuggestion> opt = supplierSuggestionRepository.findById(id.intValue());
        if(opt.isPresent()){
            return opt.get();
        }
        return null;
    }

    @Override
    @Transactional
    public SupplierSuggestion createSupplierSuggestion(SupplierSuggestion supplierSuggestion) {
        supplierSuggestion.setStatus("A");
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
        SupplierSuggestion updated = supplierSuggestionRepository.save(supplierSuggestion);
        return updated;
    }
        return null;
    }

    @Override
    @Transactional
    public SupplierSuggestion deleteSupplierSuggestion(SupplierSuggestion supplierSuggestion) {
        if(supplierSuggestion!=null && supplierSuggestion.getId()!=null){
            supplierSuggestion.setStatus(CommonConstant.DELETE);
        }

        return supplierSuggestionRepository.save(supplierSuggestion);
    }
}
