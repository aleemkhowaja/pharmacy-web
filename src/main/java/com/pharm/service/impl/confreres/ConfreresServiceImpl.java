package com.pharm.service.impl.confreres;

import com.pharm.model.Confreres;
import com.pharm.repository.confreres.ConfreresRepository;
import com.pharm.service.interfaces.confreres.ConfreresService;
import com.pharm.util.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConfreresServiceImpl implements ConfreresService {

    @Autowired
    private ConfreresRepository confreresRepository;

    @Override
    public List<Confreres> findAll() {
        return confreresRepository.findAll();
    }

    @Override
    public Confreres findById(Integer id) {
        Optional<Confreres> optionalConfreres = confreresRepository.findById(id);
        if (optionalConfreres.isPresent()){
            return optionalConfreres.get();
        }
        return null;
    }

    @Override
    public Confreres create(Confreres confreres) {
        confreres.setStatus(CommonConstant.ACTIVE);
        return confreresRepository.save(confreres);
    }

    @Override
    public Confreres update(Confreres confreres) {
        if (confreres.getId()!=null){
            Confreres persisted = findById(confreres.getId().intValue());
            if (persisted==null){
                return null;
            }
            confreres.setStatus(CommonConstant.ACTIVE);
            return confreresRepository.save(confreres);
        }
        return null;
    }

    @Override
    public Confreres delete(Confreres confreres) {
        if (confreres.getId()!=null && confreres!=null){
            Confreres deleted = findById(confreres.getId().intValue());
            if (deleted!=null){
                deleted.setStatus(CommonConstant.DELETE);
                return confreresRepository.save(deleted);
            }

        }
        return null;
    }
}
