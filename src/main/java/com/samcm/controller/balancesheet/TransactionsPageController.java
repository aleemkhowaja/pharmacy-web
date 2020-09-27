package com.samcm.controller.balancesheet;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.samcm.dto.balancesheet.RequestTransactionsDTO;
import com.samcm.service.interfaces.dispatchparty.DispatchPartyService;
import com.samcm.service.interfaces.dispatchpartydetails.DispatchPartyDetailsService;

@Controller
public class TransactionsPageController 
{

	@GetMapping(value = "/balancesheet.htm")
	public String returnBalanceSheetPage( Model model,
			HttpServletRequest request) 
	{
	    	RequestTransactionsDTO transactionsDTO = new RequestTransactionsDTO();
		model.addAttribute("balanceSheet", transactionsDTO);
		
		return "balancesheet/BalanceSheetList";
	}
	
}
