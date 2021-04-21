package com.pharm.dto.employee;

import java.io.Serializable;

import com.pharm.dto.common.CommonDTO;
import com.pharm.dto.employeesalary.ResponseEmployeeSalaryDTO;

/**
 * 
 * Copyright 2020, Geeks Solutions
 * Geeks Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * ResponseEmployeeDTO.java used to
 */
public class ResponseEmployeeDTO extends CommonDTO implements Serializable
{
    private Integer employeeId;

    private String employeeName;

    private String fatherName;

    private String contactNo;

    private String email;

    private String address;

    private String designation;

    private String salaryType;

    private Integer salary;

    private Integer overtimeAmount;

    private Integer publicHolidayAmount;

    private ResponseEmployeeSalaryDTO responseEmployeeSalaryDTO = new ResponseEmployeeSalaryDTO();

    public Integer getEmployeeId()
    {
	return employeeId;
    }

    public void setEmployeeId(Integer employeeId)
    {
	this.employeeId = employeeId;
    }

    public String getEmployeeName()
    {
	return employeeName;
    }

    public void setEmployeeName(String employeeName)
    {
	this.employeeName = employeeName;
    }

    public String getFatherName()
    {
	return fatherName;
    }

    public void setFatherName(String fatherName)
    {
	this.fatherName = fatherName;
    }

    public String getContactNo()
    {
	return contactNo;
    }

    public void setContactNo(String contactNo)
    {
	this.contactNo = contactNo;
    }

    public String getEmail()
    {
	return email;
    }

    public void setEmail(String email)
    {
	this.email = email;
    }

    public String getAddress()
    {
	return address;
    }

    public void setAddress(String address)
    {
	this.address = address;
    }

    public String getDesignation()
    {
	return designation;
    }

    public void setDesignation(String designation)
    {
	this.designation = designation;
    }

    public Integer getSalary()
    {
	return salary;
    }

    public void setSalary(Integer salary)
    {
	this.salary = salary;
    }

    public Integer getOvertimeAmount()
    {
	return overtimeAmount;
    }

    public void setOvertimeAmount(Integer overtimeAmount)
    {
	this.overtimeAmount = overtimeAmount;
    }

    public Integer getPublicHolidayAmount()
    {
	return publicHolidayAmount;
    }

    public void setPublicHolidayAmount(Integer publicHolidayAmount)
    {
	this.publicHolidayAmount = publicHolidayAmount;
    }

    public String getSalaryType()
    {
	return salaryType;
    }

    public void setSalaryType(String salaryType)
    {
	this.salaryType = salaryType;
    }

    public ResponseEmployeeSalaryDTO getResponseEmployeeSalaryDTO()
    {
        return responseEmployeeSalaryDTO;
    }

    public void setResponseEmployeeSalaryDTO(ResponseEmployeeSalaryDTO responseEmployeeSalaryDTO)
    {
        this.responseEmployeeSalaryDTO = responseEmployeeSalaryDTO;
    }
    
}