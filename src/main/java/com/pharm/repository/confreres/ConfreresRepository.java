package com.pharm.repository.confreres;

import com.pharm.model.Confreres;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConfreresRepository extends JpaRepository<Confreres, Integer> {
    List<Confreres> findAll();
}
