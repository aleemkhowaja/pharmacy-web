package com.pharm.controller.doctor;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pharm.model.Doctor;
import com.pharm.service.interfaces.doctor.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DoctorController implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private DoctorService doctorService;

    public List<Doctor> getAllDoctors(){
        return doctorService.findAll();
    }

}
