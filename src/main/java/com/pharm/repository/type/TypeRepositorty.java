package com.pharm.repository.type;

import com.pharm.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeRepositorty extends JpaRepository<Type, Integer> {
    @Override
    List<Type> findAll();
}
