package com.samcm.service.interfaces.transactions;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.samcm.dto.balancesheet.RequestTransactionsDTO;
import com.samcm.dto.balancesheet.ResponseTransactionsDTO;
import com.samcm.model.Transactions;
import com.samcm.service.interfaces.BaseService;
import com.samcm.util.JQGridDTO;

/**
 * 
 * Copyright 2020, Geeks Solutions
 * Geeks Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * TransactionsService.java used to
 */
public interface TransactionsService extends BaseService<JQGridDTO, RequestTransactionsDTO, ResponseTransactionsDTO, Transactions, HttpServletRequest>
{
    /**
     * find Transaction details
     * @param fromDate
     * @param toDate
     * @return
     */
    public List<ResponseTransactionsDTO> findTransactionsDetail(Date fromDate, Date toDate); 
	
}