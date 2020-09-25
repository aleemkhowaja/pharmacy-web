	 package com.samcm.repository.dispatchpartydetails;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.samcm.model.DispatchParty;
import com.samcm.model.DispatchPartyDetails;

/**
 * 
 * Copyright 2020, Geeks Solutions
 * Geeks Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * DispatchPartyDetailsRepository.java used to
 */
@Repository
public interface DispatchPartyDetailsRepository extends JpaRepository<DispatchPartyDetails, Integer>, CrudRepository<DispatchPartyDetails, Integer>
{
	@Query(value = "select distinct dispd from DispatchPartyDetails dispd "
		+ " left outer join dispd.dispatchParty disp"
		+ " where "
		+ " (:dispatchPartyId is null or disp.dispatchPartyId=(:dispatchPartyId) )"
		 )
	Page<DispatchPartyDetails> filter(@Param("dispatchPartyId") Integer dispatchPartyId,
			Pageable pageable);
	
	@Query("select distinct dispd from DispatchPartyDetails dispd "
			+ " join dispd.dispatchParty disp "
			+ "where"
			+ "(:dispatchPartyDetailsId is null or dispd.dispatchPartyDetailsId=(:dispatchPartyDetailsId) )")
	DispatchPartyDetails findbyDispatchPartyDetailsId(@Param("dispatchPartyDetailsId") Integer dispatchPartyDetailsId);
	
	@Query("select distinct disp from DispatchParty disp "
			+ " where"
			+ " (:dispatchPartyId is null or disp.dispatchPartyId=(:dispatchPartyId) )")
	DispatchParty findDetailsByDispatchId(@Param("dispatchPartyId") Integer dispatchPartyId);
	
	@Query("select distinct dispd from DispatchPartyDetails dispd "
			+ " join dispd.dispatchParty disp ")
	List<DispatchPartyDetails> findDispatchPartyDetailsWithParentProp();
	
	
}
