package com.samcm.controller.dispatcherpartyledger;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.samcm.dto.dispatchparty.ResponseDispatchPartyDTO;
import com.samcm.dto.dispatchpartyledger.RequestDispatchPartyLedgerDTO;
import com.samcm.enums.Bank;
import com.samcm.enums.SourceOfAmount;
import com.samcm.service.interfaces.dispatchparty.DispatchPartyService;
import com.samcm.service.interfaces.dispatchpartydetails.DispatchPartyDetailsService;

@Controller
public class DispatchPartyLedgerPageController 
{

	@Autowired
	private DispatchPartyDetailsService dispatchPartyDetailsService;
	
	@Autowired
	private DispatchPartyService dispatchPartyService; 
	

	@GetMapping(value = "/dispatchpartyledger.htm")
	public String returnDispatchPartyDetailsPage( Model model,
			HttpServletRequest request) 
	{
		RequestDispatchPartyLedgerDTO requestDispatchPartyLedgerDTO = new RequestDispatchPartyLedgerDTO();
		request.setAttribute("ForComboYN", "Y");
		
		/**
		 * return dispatch party details
		 * and set into model attribute
		 */
		List<ResponseDispatchPartyDTO> responseDispatchPartyDTOs = dispatchPartyService.findAll();
		model.addAttribute("dispatchPartyList", responseDispatchPartyDTOs);
		
		/**
		 * get source of amount enum
		 * and set into model attribute
		 */
		SourceOfAmount sourceOfAmount[] = SourceOfAmount.values();
		model.addAttribute("sourceOfAmount", sourceOfAmount);
		
		/**
		 * get bank enum
		 * and set into model attribute
		 */
		Bank bank[] = Bank.values();
		model.addAttribute("bank", bank);
		
		model.addAttribute("dispatchpartyledger", requestDispatchPartyLedgerDTO);
		
		return "dispatchpartyledger/DispatchPartyLedgerList";
	}
	
}
