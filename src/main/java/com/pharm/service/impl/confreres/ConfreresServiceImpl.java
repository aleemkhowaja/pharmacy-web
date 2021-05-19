package com.pharm.service.impl.confreres;

import com.pharm.model.Confreres;
import com.pharm.repository.confreres.ConfreresRepository;
import com.pharm.service.interfaces.confreres.ConfreresService;
import com.pharm.util.CommonConstant;
import com.pharm.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Service
public class ConfreresServiceImpl implements ConfreresService {

    @Autowired
    private ConfreresRepository confreresRepository;

    @Override
    public List<Confreres> findAll(int pageNumber, int pageSize, String sortOrder, String sortBy, Confreres filter) {

        String validationErrors = PageUtil.validatePaginationParams(pageNumber, pageSize, sortOrder, sortBy);
        if((isNotBlank(validationErrors))) {
            throw new IllegalArgumentException(validationErrors);
        }

        Page<Confreres> confreres = confreresRepository.filter(filter.getLastName(),filter.getCin(), filter.getCnss(), filter.getEmail(),
                filter.getPhone(), filter.getAddress(),PageUtil.returnPageable(pageNumber, pageSize, sortOrder, sortBy));
        if(confreres.hasContent())
        {
            final Long size = confreresRepository.count(filter.getLastName(),filter.getCin(), filter.getCnss(), filter.getEmail(),
                    filter.getPhone(), filter.getAddress());
            System.out.println("size::"+size);
            confreres.getContent().get(0).setCount(size);
        }
        return confreres.getContent();

    }

    @Override
    public Confreres findById(Long id) {
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
            Confreres persisted = findById(confreres.getId());
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
            Confreres deleted = findById(confreres.getId());
            if (deleted!=null){
                deleted.setStatus(CommonConstant.DELETE);
                return confreresRepository.save(deleted);
            }

        }
        return null;
    }
}
