package com.pharm.controller.confreres;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pharm.model.Confreres;
import com.pharm.service.interfaces.confreres.ConfreresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConfreresController implements GraphQLQueryResolver, GraphQLMutationResolver {
    @Autowired
    private ConfreresService confreresService;

    public List<Confreres> getAllConfreres(){
        return confreresService.findAll();
    }
    public Confreres getConfreresById(Integer id){
        return confreresService.findById(id);
    }
    public Confreres createConfreres(Confreres confreres){
        return confreresService.create(confreres);
    }
    public Confreres updateConfreres(Confreres confreres){
        return confreresService.update(confreres);
    }
    public Confreres deleteConfreres(Long id){
        Confreres confreres = new Confreres();
        confreres.setId(id);
        return confreresService.delete(confreres);
    }
}
