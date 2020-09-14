package com.samcm.service.interfaces.dispatchpartydetails;

import javax.servlet.http.HttpServletRequest;

import com.samcm.dto.dispatchpartydetails.RequestDispatchPartyDetailsDTO;
import com.samcm.dto.dispatchpartydetails.ResponseDispatchPartyDetailsDTO;
import com.samcm.model.DispatchPartyDetails;
import com.samcm.service.interfaces.BaseService;
import com.samcm.util.JQGridDTO;

public interface DispatchPartyDetailsService extends BaseService<JQGridDTO, RequestDispatchPartyDetailsDTO, ResponseDispatchPartyDetailsDTO, DispatchPartyDetails, HttpServletRequest>
{

}
