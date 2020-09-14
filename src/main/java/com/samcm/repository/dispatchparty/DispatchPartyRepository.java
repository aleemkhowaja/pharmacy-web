package com.samcm.repository.dispatchparty;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.samcm.model.DispatchParty;

/**
 * 
 * Copyright 2020, Geeks Solutions
 * Geeks Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * DispatchPartyRepository.java to perform crud operation in dispatch table
 */
@Repository
public interface DispatchPartyRepository extends JpaRepository<DispatchParty, Integer>, CrudRepository<DispatchParty, Integer>
{
	@Query(value = "select distinct disp from DispatchParty disp "
		+ " where "
		+ " (:dispatchParty is null or :dispatchParty= '' or  UPPER(disp.dispatchParty) like '%'|| UPPER(:dispatchParty)||'%') and "
		+ " (:dispatchPartyOwner is null or :dispatchPartyOwner= '' or  UPPER(disp.dispatchPartyOwner) like '%'||UPPER(:dispatchPartyOwner)||'%') "
		 )
	Page<DispatchParty> filter(@Param("dispatchParty") String dispatchParty, 
			@Param("dispatchPartyOwner") String dispatchPartyOwner,
			Pageable pageable);
}
