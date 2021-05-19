package com.pharm.service.interfaces.confreres;


import com.pharm.model.Confreres;

import java.util.List;

public interface ConfreresService {
    List<Confreres> findAll(int pageNumber, int pageSize, String sortOrder, String sortBy, Confreres filter);
    Confreres findById(Long id);
    Confreres create(Confreres confreres);
    Confreres update(Confreres confreres);
    Confreres delete(Confreres confreres);
}
