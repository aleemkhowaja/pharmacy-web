package com.pharm.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.pharm.model.Confreres;
import com.pharm.model.Contact;
import com.pharm.model.Customer;
import com.pharm.model.Manager;
import com.pharm.service.interfaces.manager.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;

public class ManagerResolver implements GraphQLResolver<Manager> {
    @Autowired
    private ManagerService managerService;

    public Manager getManager(Contact contact){
        return managerService.findById(contact.getManager().getId());
    }
    public Manager getManager(Customer customer){ return managerService.findById(customer.getManager().getId()); }
    public Manager getManager(Confreres confreres){ return managerService.findById(confreres.getManager().getId()); }
}
