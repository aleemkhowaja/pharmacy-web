package com.pharm.service.interfaces.therapeuticClass;

import com.pharm.model.TherapeuticClass;

import java.util.List;

public interface TherapeuticClassService {
    List<TherapeuticClass> findAll();
    TherapeuticClass findById(Long id);
    TherapeuticClass create(TherapeuticClass therapeuticClass);
    TherapeuticClass update(TherapeuticClass therapeuticClass);
    TherapeuticClass delete(TherapeuticClass therapeuticClass);
}
