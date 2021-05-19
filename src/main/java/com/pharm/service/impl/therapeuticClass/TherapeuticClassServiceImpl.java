package com.pharm.service.impl.therapeuticClass;

import com.pharm.model.TherapeuticClass;
import com.pharm.repository.therapeuticClass.TherapeuticClassRepository;
import com.pharm.service.interfaces.therapeuticClass.TherapeuticClassService;
import com.pharm.util.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TherapeuticClassServiceImpl implements TherapeuticClassService {
    @Autowired
    TherapeuticClassRepository therapeuticClassRepository;

    @Override
    public List<TherapeuticClass> findAll() {
        return therapeuticClassRepository.findAll();
    }

    @Override
    public TherapeuticClass findById(Long id) {
        Optional<TherapeuticClass> optionalTherapeuticClass = therapeuticClassRepository.findById(id);
        if(optionalTherapeuticClass.isPresent()){
            return optionalTherapeuticClass.get();
        }
        return null;
    }

    @Override
    public TherapeuticClass create(TherapeuticClass therapeuticClass) {
        therapeuticClass.setStatus(CommonConstant.ACTIVE);
        return therapeuticClassRepository.save(therapeuticClass);
    }

    @Override
    public TherapeuticClass update(TherapeuticClass therapeuticClass) {
        if (therapeuticClass.getId()!=null){
            TherapeuticClass persisted = findById(therapeuticClass.getId());
            if(persisted==null){
                return null;
            }
            therapeuticClass.setStatus(CommonConstant.ACTIVE);
            return therapeuticClassRepository.save(therapeuticClass);
        }
        return therapeuticClass;
    }

    @Override
    public TherapeuticClass delete(TherapeuticClass therapeuticClass) {
        if (therapeuticClass.getId()!=null && therapeuticClass!=null){
            TherapeuticClass deleted = findById(therapeuticClass.getId());
            if (deleted!=null){
                deleted.setStatus(CommonConstant.DELETE);
                return therapeuticClassRepository.save(deleted);
            }

        }
        return null;
    }
}
