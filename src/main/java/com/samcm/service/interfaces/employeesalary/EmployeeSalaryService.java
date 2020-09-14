package com.samcm.service.interfaces.employeesalary;

import javax.servlet.http.HttpServletRequest;

import com.samcm.dto.employee.ResponseEmployeeDTO;
import com.samcm.dto.employeesalary.RequestEmployeeSalaryDTO;
import com.samcm.model.Employee;
import com.samcm.service.interfaces.BaseService;
import com.samcm.util.JQGridDTO;

/**
 * 
 * Copyright 2020, Geeks Solutions
 * Geeks Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 * 
 * EmployeeSalaryService.java used to take request from controller and send to repository
 * and send response back to controller
 */
public interface EmployeeSalaryService extends BaseService<JQGridDTO, RequestEmployeeSalaryDTO, ResponseEmployeeDTO, Employee, HttpServletRequest>
{
	
}