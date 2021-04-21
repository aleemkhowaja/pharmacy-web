package com.pharm.dto.dispatchparty;

import java.util.ArrayList;
import java.util.List;

import com.pharm.dto.dispatchpartydetails.RequestDispatchPartyDetailsDTO;

/**
 * 
 * Copyright 2020, Geeks Solutions
 * Geeks Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * RequestDispatchpartyDTO.java used to send request parameters
 */
public class RequestDispatchPartyDTO
{
    private Integer dispatchPartyId;
    
    private String dispatchParty;
    
    private String dispatchPartyOwner;
    
  //  private RequestDispatchPartyDetailsDTO requestDispatchPartyDetailsDTO = new RequestDispatchPartyDetailsDTO();
    
    private List<RequestDispatchPartyDetailsDTO> requestDispatchPartyDetailsList = new ArrayList<RequestDispatchPartyDetailsDTO>();
    
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

    /*
     * public RequestDispatchPartyDetailsDTO getRequestDispatchPartyDetailsDTO()
     * { return requestDispatchPartyDetailsDTO; } public void
     * setRequestDispatchPartyDetailsDTO(RequestDispatchPartyDetailsDTO
     * requestDispatchPartyDetailsDTO) { this.requestDispatchPartyDetailsDTO =
     * requestDispatchPartyDetailsDTO; }
     */
    public List<RequestDispatchPartyDetailsDTO> getRequestDispatchPartyDetailsList()
    {
        return requestDispatchPartyDetailsList;
    }
    public void setRequestDispatchPartyDetailsList(List<RequestDispatchPartyDetailsDTO> requestDispatchPartyDetailsList)
    {
        this.requestDispatchPartyDetailsList = requestDispatchPartyDetailsList;
    }
}