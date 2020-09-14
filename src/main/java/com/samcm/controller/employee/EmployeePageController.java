package com.samcm.controller.employee;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.samcm.dto.employee.RequestEmployeeDTO;

@Controller
public class EmployeePageController
{

    @GetMapping(value = "/employee.htm")
    public String returnEmployeePage(Model model,  HttpServletRequest request)
    {
		model.addAttribute("employee", new RequestEmployeeDTO());
		return "employee/EmployeeList";
    }
}
