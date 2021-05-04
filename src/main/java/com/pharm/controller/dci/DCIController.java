package com.pharm.controller.dci;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pharm.model.DCI;
import com.pharm.service.interfaces.dci.DCIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DCIController implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private DCIService dciService;

    public List<DCI> getAllDCI(){
        return dciService.findAll();
    }
    public DCI getDCIById(Integer id){
        return dciService.findById(id);
    }
    public DCI createDCI(DCI dci){
        return dciService.create(dci);
    }
    public DCI updateDCI(DCI dci){
        return dciService.update(dci);
    }
    public DCI deleteDCI(Long id){
        DCI dci = new DCI();
        dci.setId(id);
        return dciService.delete(dci);
    }
}
