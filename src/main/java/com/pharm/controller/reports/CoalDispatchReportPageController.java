package com.pharm.controller.reports;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pharm.dto.dispatchpartydetails.RequestDispatchPartyDetailsDTO;

@Controller
public class CoalDispatchReportPageController
{

    @GetMapping(value = "/coaldispatchreport.htm")
    public String returnEmployeePage(Model model,  HttpServletRequest request)
    {
    	model.addAttribute("coaldispatchedreport", new RequestDispatchPartyDetailsDTO());
    	return "reportspages/CoalDispatchReport";
    }
}
