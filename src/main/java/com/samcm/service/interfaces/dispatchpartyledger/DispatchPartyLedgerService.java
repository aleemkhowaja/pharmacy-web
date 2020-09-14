package com.samcm.service.interfaces.dispatchpartyledger;

import javax.servlet.http.HttpServletRequest;

import com.samcm.dto.dispatchpartyledger.RequestDispatchPartyLedgerDTO;
import com.samcm.dto.dispatchpartyledger.ResponseDispatchPartyLedgerDTO;
import com.samcm.model.DispatchPartyLedger;
import com.samcm.service.interfaces.BaseService;
import com.samcm.util.JQGridDTO;

public interface DispatchPartyLedgerService extends BaseService<JQGridDTO, RequestDispatchPartyLedgerDTO, ResponseDispatchPartyLedgerDTO, DispatchPartyLedger, HttpServletRequest>
{

}
