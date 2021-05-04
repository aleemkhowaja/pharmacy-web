package com.pharm.service.interfaces.confreres;


import com.pharm.model.Confreres;

import java.util.List;

public interface ConfreresService {
    List<Confreres> findAll();
    Confreres findById(Integer id);
    Confreres create(Confreres confreres);
    Confreres update(Confreres confreres);
    Confreres delete(Confreres confreres);
}
