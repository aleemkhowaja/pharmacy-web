package com.pharm.service.impl.pharmaceuticalForm;

import com.pharm.model.PharmaceuticalForm;
import com.pharm.repository.pharmaceuticalForm.PharmaceuticalFormRepository;
import com.pharm.service.interfaces.pharmaceuticalForm.PharmaceuticalFormService;
import com.pharm.util.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PharmaceuticalFormServiceImpl implements PharmaceuticalFormService {
    @Autowired
    PharmaceuticalFormRepository pharmaceuticalFormRepository;

    @Override
    public List<PharmaceuticalForm> findAll() {
        return pharmaceuticalFormRepository.findAll();
    }

    @Override
    public PharmaceuticalForm findById(Long id) {
        Optional<PharmaceuticalForm> optionalPharmaceuticalForm = pharmaceuticalFormRepository.findById(id);
        if(optionalPharmaceuticalForm.isPresent()){
            return optionalPharmaceuticalForm.get();
        }
        return null;
    }

    @Override
    public PharmaceuticalForm create(PharmaceuticalForm pharmaceuticalForm) {
        pharmaceuticalForm.setStatus(CommonConstant.ACTIVE);
        return pharmaceuticalFormRepository.save(pharmaceuticalForm);
    }

    @Override
    public PharmaceuticalForm update(PharmaceuticalForm pharmaceuticalForm) {
        if (pharmaceuticalForm.getId()!=null){
            PharmaceuticalForm persisted = findById(pharmaceuticalForm.getId());
            if(persisted==null){
                return null;
            }
            pharmaceuticalForm.setStatus(CommonConstant.ACTIVE);
            return pharmaceuticalFormRepository.save(pharmaceuticalForm);
        }
        return pharmaceuticalForm;
    }

    @Override
    public PharmaceuticalForm delete(PharmaceuticalForm pharmaceuticalForm) {
        if (pharmaceuticalForm.getId()!=null && pharmaceuticalForm!=null){
            PharmaceuticalForm deleted = findById(pharmaceuticalForm.getId());
            if (deleted!=null){
                deleted.setStatus(CommonConstant.DELETE);
                return pharmaceuticalFormRepository.save(deleted);
            }

        }
        return null;
    }
}
