package com.pharm.controller.pharmaceuticalForm;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pharm.model.PharmaceuticalForm;
import com.pharm.service.interfaces.pharmaceuticalForm.PharmaceuticalFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PharmaceuticalFormController implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private PharmaceuticalFormService pharmaceuticalFormService;

    public List<PharmaceuticalForm> getAllPharmaceuticalForms(){
        return pharmaceuticalFormService.findAll();
    }
    public PharmaceuticalForm getPharmaceuticalFormById(Long id){
        return pharmaceuticalFormService.findById(id);
    }
    public PharmaceuticalForm createPharmaceuticalForm(PharmaceuticalForm pharmaceuticalForm){
        return pharmaceuticalFormService.create(pharmaceuticalForm);
    }
    public PharmaceuticalForm updatePharmaceuticalForm(PharmaceuticalForm pharmaceuticalForm){ return pharmaceuticalFormService.update(pharmaceuticalForm); }
    public PharmaceuticalForm deletePharmaceuticalForm(Long id){
        PharmaceuticalForm pharmaceuticalForm= new PharmaceuticalForm();
        pharmaceuticalForm.setId(id);
        return pharmaceuticalFormService.delete(pharmaceuticalForm);
    }
}
