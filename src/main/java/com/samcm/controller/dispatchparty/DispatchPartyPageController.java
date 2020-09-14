package com.samcm.controller.dispatchparty;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.samcm.dto.dispatchparty.RequestDispatchPartyDTO;
import com.samcm.dto.dispatchparty.ResponseDispatchPartyDTO;
import com.samcm.dto.dispatchpartydetails.RequestDispatchPartyDetailsDTO;
import com.samcm.service.interfaces.dispatchparty.DispatchPartyService;

@Controller
public class DispatchPartyPageController 
{

	@Autowired
	private DispatchPartyService dispatchPartyService;
	
	
	@GetMapping(value = "/dispatchparty.htm")
	public String returnDispatchPartyPage(Model model, HttpServletRequest request) 
	{
		model.addAttribute("dispatchparty", new RequestDispatchPartyDTO());
		return "dispatchparty/DispatchPartyList";
	}

	@GetMapping(value = "/dispatchpartydetails.htm")
	public String returnDispatchPartyDetailsPage( Model model,
			HttpServletRequest request) 
	{
		RequestDispatchPartyDetailsDTO requestDispatchPartyDetailsDTO = new RequestDispatchPartyDetailsDTO();
		//srequestDispatchPartyDetailsDTO.setDispatchpartyId(dispatchPartyId);
		request.setAttribute("ForComboYN", "Y");
		List<ResponseDispatchPartyDTO> dispatchPartyDTOs = dispatchPartyService.findAll();
		
		model.addAttribute("dispatchPartyList", dispatchPartyDTOs);
		model.addAttribute("dispatchpartydetails", requestDispatchPartyDetailsDTO);
		return "dispatchpartydetails/DispatchPartyDetailList";
	}
	
//	
}