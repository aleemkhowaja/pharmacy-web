package com.pharm.service.impl.doctor;

import com.pharm.model.Doctor;
import com.pharm.repository.doctor.DoctorRepository;
import com.pharm.service.interfaces.doctor.DoctorService;
import com.pharm.util.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Doctor> findAll()
    {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor findById(final Long id)
    {
        Optional<Doctor> optional = doctorRepository.findById(id);
        if(optional.isPresent())
        {
            return optional.get();
        }
        return null;
    }

    @Override
    public Doctor create(final Doctor doctor)
    {
        doctor.setStatus(CommonConstant.ACTIVE);
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor update(final Doctor doctor)

    {
        if (doctor.getId() != null)
        {
            Doctor persisted = findById(doctor.getId());
            if (persisted==null)
            {
                return null;
            }
            doctor.setStatus(CommonConstant.ACTIVE);
            return doctorRepository.save(doctor);
        }
        return null;
    }

    @Override
    public Doctor delete(final Doctor doctor)
    {
        if (doctor.getId()!=null && doctor!=null)
        {
            Doctor delete = findById(doctor.getId());
            if (delete!=null)
            {
                delete.setStatus(CommonConstant.DELETE);
                return doctorRepository.save(delete);
            }
        }
        return null;
    }
}
