package com.pharm.dto.dispatchpartydetails;

import java.io.Serializable;

import com.pharm.dto.common.CommonDTO;

/**
 * 
 * Copyright 2020, Geeks Solutions
 * Geeks Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * ResponseDispatchPartyDTO.java used to send response
 */
public class ResponseDispatchPartyDetailsDTO extends CommonDTO implements Serializable 				 
{
    private Integer dispatchPartyDetailsId;
    
    private String quality;
    
    private Integer tons;
    
    private Integer rate;
    
    private Integer amount;
    
    private Integer rebate;
    
    private String dateOf;
    
    private Integer dispatchparty;
    
    private String dispatchPartyDesc;
    
    private Integer paidAmount = 0;
    
    private Integer remainingAmount = 0;
    
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

    public String getDateOf()
    {
        return dateOf;
    }

    public void setDateOf(String dateOf)
    {
        this.dateOf = dateOf;
    }

	public Integer getDispatchparty() {
		return dispatchparty;
	}

	public void setDispatchparty(Integer dispatchparty) {
		this.dispatchparty = dispatchparty;
	}

	public String getDispatchPartyDesc() {
		return dispatchPartyDesc;
	}

	public void setDispatchPartyDesc(String dispatchPartyDesc) {
		this.dispatchPartyDesc = dispatchPartyDesc;
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
    
}