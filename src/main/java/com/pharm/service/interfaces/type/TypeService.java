package com.pharm.service.interfaces.type;


import com.pharm.model.Type;

import java.util.List;

public interface TypeService {
    List<Type> findAll();
    Type findById(Integer id);
    Type create(Type type);
    Type update(Type type);
    Type delete(Type type);
}
