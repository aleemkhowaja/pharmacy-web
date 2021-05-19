package com.pharm.controller.therapeuticClass;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pharm.model.TherapeuticClass;
import com.pharm.service.interfaces.therapeuticClass.TherapeuticClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TherapeuticClassController implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private TherapeuticClassService therapeuticClassService;

    public List<TherapeuticClass> getAllTherapeuticClasses(){
        return therapeuticClassService.findAll();
    }
    public TherapeuticClass getTherapeuticClassById(Long id){
        return therapeuticClassService.findById(id);
    }
    public TherapeuticClass createTherapeuticClass(TherapeuticClass therapeuticClass){
        return therapeuticClassService.create(therapeuticClass);
    }
    public TherapeuticClass updateTherapeuticClass(TherapeuticClass therapeuticClass){ return therapeuticClassService.update(therapeuticClass); }
    public TherapeuticClass deleteTherapeuticClass(Long id){
        TherapeuticClass therapeuticClass= new TherapeuticClass();
        therapeuticClass.setId(id);
        return therapeuticClassService.delete(therapeuticClass);
    }
}
