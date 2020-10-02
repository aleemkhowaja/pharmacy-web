package com.samcm.dto.balancesheet;

import java.util.Date;

/**
 * 
 * Copyright 2020, Geeks Solutions
 * Geeks Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * RequestBalanceSheetDTO.java used to send request parameters
 */
public class RequestTransactionsDTO
{
    private Date  fromDate;
    private Date toDate;
    
    private Integer totalCreditAmount;
    private Integer totalDebitAmount;
    private Integer closingBalance;
    
    public Date getFromDate()
    {
        return fromDate;
    }
    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }
    public Date getToDate()
    {
        return toDate;
    }
    public void setToDate(Date toDate)
    {
        this.toDate = toDate;
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
    
    
    
    
}