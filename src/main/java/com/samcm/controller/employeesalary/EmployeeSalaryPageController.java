package com.samcm.controller.employeesalary;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.samcm.dto.dispatchpartydetails.RequestDispatchPartyDetailsDTO;
import com.samcm.dto.employeesalary.RequestEmployeeSalaryDTO;

@Controller
public class EmployeeSalaryPageController
{

    @GetMapping(value = "/employeesalary.htm")
    public String returnEmployeePage(Model model,  HttpServletRequest request)
    {
 	model.addAttribute("employeeSalary", new RequestEmployeeSalaryDTO());
    	RequestDispatchPartyDetailsDTO requestDispatchPartyDetailsDTO = new RequestDispatchPartyDetailsDTO();
	//srequestDispatchPartyDetailsDTO.setDispatchpartyId(dispatchPartyId);
//	request.setAttribute("ForComboYN", "Y");
//	List<ResponseDispatchPartyDTO> dispatchPartyDTOs = dispatchPartyService.findAll();
//	
//	model.addAttribute("dispatchPartyList", dispatchPartyDTOs);
	model.addAttribute("dispatchpartydetails", requestDispatchPartyDetailsDTO);
    	return "employeesalary/EmployeeSalary1";
    }
}
