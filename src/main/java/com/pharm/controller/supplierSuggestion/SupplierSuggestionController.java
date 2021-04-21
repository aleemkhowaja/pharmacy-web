package com.pharm.controller.supplierSuggestion;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pharm.model.SupplierSuggestion;
import com.pharm.service.interfaces.suppliersuggestion.SupplierSuggestionService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SupplierSuggestionController implements GraphQLQueryResolver, GraphQLMutationResolver {
    @Autowired
    private SupplierSuggestionService supplierSuggestionService;

    public List<SupplierSuggestion> getAllSupplierSuggestions(){
        return supplierSuggestionService.getAllSupplierSuggestions();
    }

    public SupplierSuggestion getSupplierSuggestionById(Long id){
        return supplierSuggestionService.getSupplierSuggestionById(id);
    }

    public SupplierSuggestion createSupplierSuggestion(SupplierSuggestion supplierSuggestion){
        supplierSuggestion.setStatus("1");
        return supplierSuggestionService.createSupplierSuggestion(supplierSuggestion);
    }
    public SupplierSuggestion updateSupplierSuggestion(Long id, SupplierSuggestion supplierSuggestion){
        supplierSuggestion.setId(id);
        return supplierSuggestionService.updateSupplierSuggestion(supplierSuggestion);
    }
    public SupplierSuggestion deleteSupplierSuggestion(Long id){
        SupplierSuggestion supplierSuggestion = new SupplierSuggestion();
        supplierSuggestion.setId(id);
        return supplierSuggestionService.deleteSupplierSuggestion(supplierSuggestion);
    }
}
