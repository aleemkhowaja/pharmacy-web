package com.pharm.repository.pharmaceuticalForm;

import com.pharm.model.PharmaceuticalForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmaceuticalFormRepository extends JpaRepository<PharmaceuticalForm, Long> {
}
