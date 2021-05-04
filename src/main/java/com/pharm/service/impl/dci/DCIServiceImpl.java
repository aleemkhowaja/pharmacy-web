package com.pharm.service.impl.dci;

import com.pharm.model.DCI;
import com.pharm.repository.dci.DCIRepository;
import com.pharm.service.interfaces.dci.DCIService;
import com.pharm.util.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DCIServiceImpl implements DCIService {

    @Autowired
    private DCIRepository dciRepository;

    @Override
    public List<DCI> findAll() {
        return dciRepository.findAll();
    }

    @Override
    public DCI findById(Integer id) {
        Optional<DCI> optional = dciRepository.findById(id);
        if(optional.isPresent())
            return optional.get();
        return null;
    }

    @Override
    public DCI create(DCI dci) {
        dci.setStatus(CommonConstant.ACTIVE);
        return dciRepository.save(dci);
    }

    @Override
    public DCI update(DCI dci) {
        if(dci.getId()!=null){
            DCI persisted = findById(dci.getId().intValue());
            if(persisted==null){
                return null;
            }
            dci.setStatus(CommonConstant.ACTIVE);
            DCI updated = dciRepository.save(dci);
            return updated;
        }
        return null;

    }

    @Override
    public DCI delete(DCI dci) {
        if(dci!=null && dci.getId()!=null){
            DCI deleted = findById(dci.getId().intValue());
            if (deleted != null){
                deleted.setStatus(CommonConstant.DELETE);
                return dciRepository.save(deleted);
            }

        }
        return null;
    }
}
