package com.pharm.dto.dispatchpartydetails;

import java.util.Date;

/**
 * 
 * Copyright 2020, Geeks Solutions
 * Geeks Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * RequestDispatchPartyDetailsDTO.java used to send request parameters
 */
public class RequestDispatchPartyDetailsDTO
{
    private Integer dispatchPartyDetailsId;
    
    private String quality;
    
    private Integer tons;
    
    private Integer rate;
    
    private Integer amount;
    
    private Integer rebate;
    
    private Integer dispatchparty;
    
    private Date dateOf;
    
    private Integer paidAmount;
    
    private Integer remainingAmount;

    /**
     * for report 
     */
    private String fromDate;
    
    private String toDate;
    
    public Integer getDispatchPartyDetailsId()
    {
        return dispatchPartyDetailsId;
    }

    public void setDispatchPartyDetailsId(Integer dispatchPartyDetailsId)
    {
        this.dispatchPartyDetailsId = dispatchPartyDetailsId;
    }

    public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public Integer getTons()
    {
        return tons;
    }

    public void setTons(Integer tons)
    {
        this.tons = tons;
    }

    public Integer getRate()
    {
        return rate;
    }

    public void setRate(Integer rate)
    {
        this.rate = rate;
    }

    public Integer getAmount()
    {
        return amount;
    }

    public void setAmount(Integer amount)
    {
        this.amount = amount;
    }

    public Integer getRebate()
    {
        return rebate;
    }

    public void setRebate(Integer rebate)
    {
        this.rebate = rebate;
    }

    public Integer getDispatchparty()
    {
        return dispatchparty;
    }

    public void setDispatchparty(Integer dispatchparty)
    {
        this.dispatchparty = dispatchparty;
    }

    public Date getDateOf()
    {
        return dateOf;
    }

    public void setDateOf(Date dateOf)
    {
        this.dateOf = dateOf;
    }

	public Integer getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(Integer paidAmount) {
		this.paidAmount = paidAmount;
	}

	public Integer getRemainingAmount() {
		return remainingAmount;
	}

	public void setRemainingAmount(Integer remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

	public String getFromDate()
	{
	    return fromDate;
	}

	public void setFromDate(String fromDate)
	{
	    this.fromDate = fromDate;
	}

	public String getToDate()
	{
	    return toDate;
	}

	public void setToDate(String toDate)
	{
	    this.toDate = toDate;
	}
	
	
}