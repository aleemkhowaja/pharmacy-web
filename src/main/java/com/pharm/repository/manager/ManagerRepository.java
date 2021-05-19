package com.pharm.repository.manager;

import com.pharm.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManagerRepository extends JpaRepository<Manager,Long> {
    List<Manager> findAll();
}
