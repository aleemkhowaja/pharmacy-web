package com.pharm.service.interfaces.doctor;

import com.pharm.model.Doctor;

import java.util.List;

public interface DoctorService
{
    List<Doctor> findAll();

    Doctor findById(final Long id);

    Doctor create(final Doctor doctor);

    Doctor update(final Doctor  doctor);

    Doctor delete(final Doctor doctor);
}
