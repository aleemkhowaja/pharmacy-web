package com.samcm.repository.genledger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.samcm.model.GenLedger;
import com.samcm.model.SubGenLedger;

/**
 * 
 * Copyright 2020, Geeks Solutions
 * Geeks Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * GenLedgerRepository.java to perform crud operation in dispatch table
 */
@Repository
public interface GenLedgerRepository extends JpaRepository<GenLedger, Integer>, CrudRepository<GenLedger, Integer>
{
    
    @Query("select distinct gc from GenLedger gc "
		+ " where"
		+ " gc.glCode=(:glCode)")
    GenLedger findGLByglCode(@Param("glCode") Integer glCode);
    
    
    @Query("select distinct sgc from SubGenLedger sgc "
		+ " where"
		+ " sgc.glCode=(:glCode)")
    SubGenLedger findSubGLByglCode(@Param("glCode") Integer glCode);
    
    
}
