package com.samcm.repository.dispatchpartyledger;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.samcm.model.DispatchParty;
import com.samcm.model.DispatchPartyLedger;

/**
 * 
 * Copyright 2020, Geeks Solutions
 * Geeks Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * DispatchPartyLedgerRepository.java to perform crud operation in dispatch table
 */
@Repository
public interface DispatchPartyLedgerRepository extends JpaRepository<DispatchPartyLedger, Integer>, CrudRepository<DispatchPartyLedger, Integer>
{
	/*
	 * @Query(value = "select distinct displ from DispatchPartyLedger displ " +
	 * " where " +
	 * " (:dispatchParty is null or :dispatchParty= '' or  UPPER(disp.dispatchParty) like '%'|| UPPER(:dispatchParty)||'%') and "
	 * +
	 * " (:dispatchPartyOwner is null or :dispatchPartyOwner= '' or  UPPER(disp.dispatchPartyOwner) like '%'||UPPER(:dispatchPartyOwner)||'%') "
	 * ) Page<DispatchParty> filter(@Param("dispatchParty") String dispatchParty,
	 * 
	 * @Param("dispatchPartyOwner") String dispatchPartyOwner, Pageable pageable);
	 */
}
