package com.samcm.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Where;

/**
 * 
 * Copyright 2020, Geeks Solutions
 * Geeks Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * Employee.java is Model class used to persist Employee Object in employee table
 */

@Entity
@Table(name = "employee")
@Where(clause = "status='A'")
public class Employee extends Common
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "contact_no")
    private String contactNo;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "designation")
    private String designation;
    
    @Column(name = "salary_type") 
    private String salaryType;
    
    @Column(name = "salary") 
    private Integer salary;
    
    @Column(name = "overtime_amount") 
    private Integer overtimeAmount;
    
    @Column(name = "public_holiday_amount") 
    private Integer publicHolidayAmount;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private List<EmployeeSalary> employeeSalaries = new ArrayList<EmployeeSalary>();


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

	public String getSalaryType() 
	{
		return salaryType;
	}

	public void setSalaryType(String salaryType) 
	{
		this.salaryType = salaryType;
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

	public List<EmployeeSalary> getEmployeeSalaries()
	{
	    return employeeSalaries;
	}

	public void setEmployeeSalaries(List<EmployeeSalary> employeeSalaries)
	{
	    this.employeeSalaries = employeeSalaries;
	}
}