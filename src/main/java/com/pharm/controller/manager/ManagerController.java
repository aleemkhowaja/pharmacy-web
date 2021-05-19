package com.pharm.controller.manager;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pharm.model.Manager;
import com.pharm.service.interfaces.manager.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManagerController implements GraphQLMutationResolver, GraphQLQueryResolver {

    @Autowired
    private ManagerService managerService;

    public List<Manager> getAllManagers(){
        return managerService.findAll();
    }
    public Manager getManagerById(Long id){
        return managerService.findById(id);
    }
    public Manager createManager(Manager manager){
        return managerService.create(manager);
    }
    public Manager updateManager(Manager manager){
        return managerService.update(manager);
    }
    public Manager deleteManager(Long id){
        Manager manager = new Manager();
        manager.setId(id);
        return managerService.delete(manager);
    }

}
