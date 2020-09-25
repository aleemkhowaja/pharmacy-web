package com.samcm.repository.transactions;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.samcm.model.DispatchPartyDetails;
import com.samcm.model.Transactions;

/**
 * 
 * Copyright 2020, Geeks Solutions
 * Geeks Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * TransactionsRepository.java used to
 */
@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Integer>, CrudRepository<Transactions, Integer>
{
	
    @Query("select tr from Transactions trans "
    	+ " :fromDate >= trans.date and :toDate <= trans.date")
    List<Transactions> findTransactionsDetail(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
}
