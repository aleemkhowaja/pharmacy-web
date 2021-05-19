package com.pharm.service.interfaces.pharmaceuticalForm;

import com.pharm.model.PharmaceuticalForm;

import java.util.List;

public interface PharmaceuticalFormService {
    List<PharmaceuticalForm> findAll();
    PharmaceuticalForm findById(Long id);
    PharmaceuticalForm create(PharmaceuticalForm pharmaceuticalForm);
    PharmaceuticalForm update(PharmaceuticalForm pharmaceuticalForm);
    PharmaceuticalForm delete(PharmaceuticalForm pharmaceuticalForm);
}
