package com.samcm.controller.employeesalary;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.samcm.dto.employee.RequestEmployeeDTO;
import com.samcm.dto.employeesalary.RequestEmployeeSalaryDTO;

@Controller
public class EmployeeSalaryPageController
{

    @GetMapping(value = "/employeesalary.htm")
    public String returnEmployeePage(Model model,  HttpServletRequest request)
    {
    	model.addAttribute("employeeSalary", new RequestEmployeeSalaryDTO());
    	return "employeesalary/EmployeeSalary";
    }
}
