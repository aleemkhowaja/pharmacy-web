package com.samcm.service.interfaces.dispatchparty;

import javax.servlet.http.HttpServletRequest;

import com.samcm.dto.dispatchparty.RequestDispatchPartyDTO;
import com.samcm.dto.dispatchparty.ResponseDispatchPartyDTO;
import com.samcm.model.DispatchParty;
import com.samcm.service.interfaces.BaseService;
import com.samcm.util.JQGridDTO;

public interface DispatchPartyService extends BaseService<JQGridDTO, RequestDispatchPartyDTO, ResponseDispatchPartyDTO, DispatchParty, HttpServletRequest>
{

}
