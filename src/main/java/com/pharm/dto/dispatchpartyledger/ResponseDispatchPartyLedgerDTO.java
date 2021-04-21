package com.pharm.dto.dispatchpartyledger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.pharm.dto.common.CommonDTO;
import com.pharm.dto.dispatchpartydetails.ResponseDispatchPartyDetailsDTO;

/**
 * 
 * Copyright 2020, Geeks Solutions
 * Geeks Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * ResponseDispatchPartyDTO.java used to send response
 */
public class ResponseDispatchPartyLedgerDTO extends CommonDTO implements Serializable 				 
{
    private Integer dispatchPartyDetailsId;
    
    private Integer quality;
    
    private Integer tons;
    
    private Integer rate;
    
    private Integer amount;
    
    private Integer rebate;
    
    private Date dateOf;
    
    private Integer dispatchparty;
    
    private List<ResponseDispatchPartyDetailsDTO> responseDispatchPartyDetailsDTOs = new ArrayList<ResponseDispatchPartyDetailsDTO>();
    
    private Integer paidAmount;
    
    private Integer remainingAmount;
    
    public Integer getDispatchPartyDetailsId()
    {
        return dispatchPartyDetailsId;
    }

    public void setDispatchPartyDetailsId(Integer dispatchPartyDetailsId)
    {
        this.dispatchPartyDetailsId = dispatchPartyDetailsId;
    }

    public Integer getQuality() {
		return quality;
	}

	public void setQuality(Integer quality) {
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

    public Date getDateOf()
    {
        return dateOf;
    }

    public void setDateOf(Date dateOf)
    {
        this.dateOf = dateOf;
    }

	public Integer getDispatchparty() {
		return dispatchparty;
	}

	public void setDispatchparty(Integer dispatchparty) {
		this.dispatchparty = dispatchparty;
	}

	public List<ResponseDispatchPartyDetailsDTO> getResponseDispatchPartyDetailsDTOs() {
		return responseDispatchPartyDetailsDTOs;
	}

	public void setResponseDispatchPartyDetailsDTOs(
			List<ResponseDispatchPartyDetailsDTO> responseDispatchPartyDetailsDTOs) {
		this.responseDispatchPartyDetailsDTOs = responseDispatchPartyDetailsDTOs;
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