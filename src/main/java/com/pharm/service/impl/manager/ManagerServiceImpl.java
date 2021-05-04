package com.pharm.service.impl.manager;

import com.pharm.model.Manager;
import com.pharm.repository.manager.ManagerRepository;
import com.pharm.service.interfaces.manager.ManagerService;
import com.pharm.util.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    ManagerRepository managerRepository;

    @Override
    public List<Manager> findAll() {
        return managerRepository.findAll();
    }

    @Override
    public Manager findById(Integer id) {
        Optional<Manager> optionalManager = managerRepository.findById(id);
        if(optionalManager.isPresent()){
            return optionalManager.get();
        }
        return null;
    }

    @Override
    public Manager create(Manager manager) {
        manager.setStatus(CommonConstant.ACTIVE);
        return managerRepository.save(manager);
    }

    @Override
    public Manager update(Manager manager) {
        if (manager.getId()!=null){
            Manager persisted = findById(manager.getId().intValue());
            if(persisted==null) {
                return null;
            }
            manager.setStatus(CommonConstant.ACTIVE);
            return managerRepository.save(manager);
        }
        return null;

    }

    @Override
    public Manager delete(Manager manager) {
        if (manager != null && manager.getId() != null) {
            Manager deleted = findById(manager.getId().intValue());
            if (deleted != null) {
                deleted.setStatus(CommonConstant.DELETE);
                return managerRepository.save(deleted);
            }

        }
        return null;
    }
}
