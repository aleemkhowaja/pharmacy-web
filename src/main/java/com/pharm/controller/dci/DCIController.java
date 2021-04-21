package com.pharm.controller.dci;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pharm.model.DCI;
import com.pharm.service.interfaces.dci.DCIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DCIController implements GraphQLQueryResolver {

    @Autowired
    private DCIService dciService;

    public List<DCI> getAllDCI(){
        return dciService.findAll();
    }
}
