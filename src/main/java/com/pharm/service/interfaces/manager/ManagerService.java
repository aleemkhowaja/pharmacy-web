package com.pharm.service.interfaces.manager;


import com.pharm.model.Manager;

import java.util.List;

public interface ManagerService {
    List<Manager> findAll();
    Manager findById(Integer id);
    Manager create(Manager manager);
    Manager update(Manager manager);
    Manager delete(Manager manager);
}
