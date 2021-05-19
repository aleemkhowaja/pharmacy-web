package com.pharm.service.interfaces.dci;

import com.pharm.model.DCI;

import java.util.List;

public interface DCIService {
    List<DCI> findAll();
    DCI findById(Long id);
    DCI create(DCI dci);
    DCI update(DCI dci);
    DCI delete(DCI dci);
}
