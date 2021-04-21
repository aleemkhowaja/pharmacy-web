package com.pharm.service.interfaces.dci;

import com.pharm.model.DCI;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DCIService {
    List<DCI> findAll();
}
