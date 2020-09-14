package com.samcm.service.interfaces;

import java.util.HashMap;
import java.util.List;

/**
 * 
 * Copyright 2020, Geeks Solutions
 * Geeks Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * BaseService.java used to
 * @param <T> = Request DTO
 * @param <V> = Response DTO
 * @param <M> = Model class
 */
public interface BaseService<G,T,V,M,N>
{
    /**
     * create Record
     * @param createDto (Request DTO)
     * @return response DTO
     */
    V create(T createDto);
    
    /**
     * 
     * @param modelId
     * @return
     */
    V findById(Integer modelId);
    
    /**
     * get requestDTO and send responseDTO
     * @param requestDTO
     * @return responseDTO
     */
    V detail(T requestDTO);
    
    /**
     * retrieve all records
     * @param httpRequest
     * @return
     */
    G findAll(N httpRequest);
    
    /**
     * retrieve all records for Combobox
     * @param httpRequest
     * @return
     */
    List<V> findAll();
    
    
    /**
     * delete record by id
     * @param modelId
     * @return number of rows
     */
    Integer delete(Integer modelId);
    
    /**
     * retrieve record if exist
     * @param modelId
     * @return model class
     */
    M getIfExist(Integer modelId);
    
    /**
     * 
     * @param prop
     * @return responseDTO
     */
    List<V> findByParentProperties(HashMap<String, Object> prop);
}
