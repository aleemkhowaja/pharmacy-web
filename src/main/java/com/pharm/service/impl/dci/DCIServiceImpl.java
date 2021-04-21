package com.pharm.service.impl.dci;

import com.pharm.model.DCI;
import com.pharm.repository.dci.DCIRepository;
import com.pharm.service.interfaces.dci.DCIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DCIServiceImpl implements DCIService {

    @Autowired
    private DCIRepository dciRepository;

    @Override
    public List<DCI> findAll() {
        return dciRepository.findAll();
    }
}
