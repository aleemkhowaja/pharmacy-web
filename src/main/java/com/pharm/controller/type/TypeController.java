package com.pharm.controller.type;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pharm.model.Type;
import com.pharm.service.interfaces.type.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TypeController implements GraphQLMutationResolver, GraphQLQueryResolver {
    @Autowired
    private TypeService typeService;

    public List<Type> getAllTypes(){
        return typeService.findAll();
    }
    public Type getTypeById(Long id){
        return typeService.findById(id);
    }
    public Type createType(Type type){
        return typeService.create(type);
    }
    public Type updateType(Type type){
        return typeService.update(type);
    }
    public Type deleteType(Long id){
        Type type = new Type();
        type.setId(id);
        return typeService.delete(type);
    }
}
