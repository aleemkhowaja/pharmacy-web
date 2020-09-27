package com.samcm.dto.balancesheet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * Copyright 2020, Geeks Solutions
 * Geeks Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * ResponseBalanceSheetDTO.java used to
 */
public class ResponseTransactionsDTO
{
    private Date date;
    private Integer amount;
    private String description;
    private Integer totalCreditAmount;
    private Integer totalDebitAmount;
    private Integer closingBalance;
    
    private List<ResponseTransactionsDTO> responseTransactionsDTOs = new ArrayList<ResponseTransactionsDTO>();
    

    public Date getDate()
    {
	return date;
    }

    public void setDate(Date date)
    {
	this.date = date;
    }

    public Integer getAmount()
    {
	return amount;
    }

    public void setAmount(Integer amount)
    {
	this.amount = amount;
    }

    public String getDescription()
    {
	return description;
    }

    public void setDescription(String description)
    {
	this.description = description;
    }

    public Integer getTotalCreditAmount()
    {
	return totalCreditAmount;
    }

    public void setTotalCreditAmount(Integer totalCreditAmount)
    {
	this.totalCreditAmount = totalCreditAmount;
    }

    public Integer getTotalDebitAmount()
    {
	return totalDebitAmount;
    }

    public void setTotalDebitAmount(Integer totalDebitAmount)
    {
	this.totalDebitAmount = totalDebitAmount;
    }

    public Integer getClosingBalance()
    {
	return closingBalance;
    }

    public void setClosingBalance(Integer closingBalance)
    {
	this.closingBalance = closingBalance;
    }

    public List<ResponseTransactionsDTO> getResponseTransactionsDTOs()
    {
        return responseTransactionsDTOs;
    }

    public void setResponseTransactionsDTOs(List<ResponseTransactionsDTO> responseTransactionsDTOs)
    {
        this.responseTransactionsDTOs = responseTransactionsDTOs;
    }
    
}