package com.samcm.dto.dispatchparty;

import java.io.Serializable;

import com.samcm.dto.common.CommonDTO;

/**
 * 
 * Copyright 2020, Geeks Solutions
 * Geeks Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * ResponseDispatchPartyDTO.java used to send response
 */
public class ResponseDispatchPartyDTO extends CommonDTO implements Serializable
{
    private Integer dispatchPartyId;
    
    private String dispatchParty;
    
    private String dispatchPartyOwner;

    public Integer getDispatchPartyId()
    {
        return dispatchPartyId;
    }

    public void setDispatchPartyId(Integer dispatchPartyId)
    {
        this.dispatchPartyId = dispatchPartyId;
    }

    public String getDispatchParty()
    {
        return dispatchParty;
    }

    public void setDispatchParty(String dispatchParty)
    {
        this.dispatchParty = dispatchParty;
    }

    public String getDispatchPartyOwner()
    {
        return dispatchPartyOwner;
    }

    public void setDispatchPartyOwner(String dispatchPartyOwner)
    {
        this.dispatchPartyOwner = dispatchPartyOwner;
    }
}