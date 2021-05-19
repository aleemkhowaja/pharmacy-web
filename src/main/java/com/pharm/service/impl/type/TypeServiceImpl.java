package com.pharm.service.impl.type;

import com.pharm.model.Type;
import com.pharm.repository.type.TypeRepositorty;
import com.pharm.service.interfaces.type.TypeService;
import com.pharm.util.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeRepositorty typeRepository;
    @Override
    public List<Type> findAll() {
        return typeRepository.findAll();
    }

    @Override
    public Type findById(Long id) {
        Optional<Type> optionalTypes = typeRepository.findById(id);
        if (optionalTypes.isPresent()){
            return optionalTypes.get();
        }
        return null;
    }

    @Override
    public Type create(Type type) {
        type.setStatus(CommonConstant.ACTIVE);
        return typeRepository.save(type);
    }

    @Override
    public Type update(Type type) {
        if(type.getId()!=null){
            Type persisted = findById(type.getId());
            if (persisted==null){
                return null;
            }
            type.setStatus(CommonConstant.ACTIVE);
            return typeRepository.save(type);
        }
        return null;
    }

    @Override
    public Type delete(Type type) {
        if(type !=null && type.getId()!=null){
            Type deleted = findById(type.getId());
            if (deleted!=null){
                deleted.setStatus(CommonConstant.DELETE);
                return typeRepository.save(deleted);
            }

        }
        return null;
    }
}
