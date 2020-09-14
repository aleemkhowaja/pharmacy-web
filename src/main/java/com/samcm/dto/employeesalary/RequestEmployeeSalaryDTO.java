package com.samcm.dto.employeesalary;

import java.util.Date;
import java.util.List;
/**
 * 
 * Copyright 2020, Geeks Solutions
 * Geeks Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * RequestEmployeeSalaryDTO.java used to send request parameters
 */
public class RequestEmployeeSalaryDTO
{
    private Integer employeeId;
    private Integer employeeSalaryId;
    private Date fromDate;
    private Date toDate;
    private Integer days;
    private Integer totalDaysAmount;
    private Integer otDays;
    private Integer totalOtAmount;
    private Integer publicHolidays;
    private Integer totalPublicHolidaysAmount;
    private Integer grossAmount;
    private Integer advanceSalary;
    private Integer utilities;
    private Integer netAmount;
    private String salaryType;

    private List<RequestEmployeeSalaryDTO> requestEmployeeSalaryDTOs;

    /**
     * @return the employeeId
     */
    public Integer getEmployeeId()
    {
	return employeeId;
    }

    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(Integer employeeId)
    {
	this.employeeId = employeeId;
    }

    /**
     * @return the salaryType
     */
    public String getSalaryType()
    {
	return salaryType;
    }

    /**
     * @param salaryType the salaryType to set
     */
    public void setSalaryType(String salaryType)
    {
	this.salaryType = salaryType;
    }

    /**
     * @return the employeeSalaryId
     */
    public Integer getEmployeeSalaryId()
    {
	return employeeSalaryId;
    }

    /**
     * @param employeeSalaryId the employeeSalaryId to set
     */
    public void setEmployeeSalaryId(Integer employeeSalaryId)
    {
	this.employeeSalaryId = employeeSalaryId;
    }

    /**
     * @return the fromDate
     */
    public Date getFromDate()
    {
	return fromDate;
    }

    /**
     * @param fromDate the fromDate to set
     */
    public void setFromDate(Date fromDate)
    {
	this.fromDate = fromDate;
    }

    /**
     * @return the toDate
     */
    public Date getToDate()
    {
	return toDate;
    }

    /**
     * @param toDate the toDate to set
     */
    public void setToDate(Date toDate)
    {
	this.toDate = toDate;
    }

    /**
     * @return the days
     */
    public Integer getDays()
    {
	return days;
    }

    /**
     * @param days the days to set
     */
    public void setDays(Integer days)
    {
	this.days = days;
    }

    /**
     * @return the totalDaysAmount
     */
    public Integer getTotalDaysAmount()
    {
	return totalDaysAmount;
    }

    /**
     * @param totalDaysAmount the totalDaysAmount to set
     */
    public void setTotalDaysAmount(Integer totalDaysAmount)
    {
	this.totalDaysAmount = totalDaysAmount;
    }

    /**
     * @return the otDays
     */
    public Integer getOtDays()
    {
	return otDays;
    }

    /**
     * @param otDays the otDays to set
     */
    public void setOtDays(Integer otDays)
    {
	this.otDays = otDays;
    }

    /**
     * @return the totalOtAmount
     */
    public Integer getTotalOtAmount()
    {
	return totalOtAmount;
    }

    /**
     * @param totalOtAmount the totalOtAmount to set
     */
    public void setTotalOtAmount(Integer totalOtAmount)
    {
	this.totalOtAmount = totalOtAmount;
    }

    /**
     * @return the publicHolidays
     */
    public Integer getPublicHolidays()
    {
	return publicHolidays;
    }

    /**
     * @param publicHolidays the publicHolidays to set
     */
    public void setPublicHolidays(Integer publicHolidays)
    {
	this.publicHolidays = publicHolidays;
    }

    /**
     * @return the totalPublicHolidaysAmount
     */
    public Integer getTotalPublicHolidaysAmount()
    {
	return totalPublicHolidaysAmount;
    }

    /**
     * @param totalPublicHolidaysAmount the totalPublicHolidaysAmount to set
     */
    public void setTotalPublicHolidaysAmount(Integer totalPublicHolidaysAmount)
    {
	this.totalPublicHolidaysAmount = totalPublicHolidaysAmount;
    }

    /**
     * @return the grossAmount
     */
    public Integer getGrossAmount()
    {
	return grossAmount;
    }

    /**
     * @param grossAmount the grossAmount to set
     */
    public void setGrossAmount(Integer grossAmount)
    {
	this.grossAmount = grossAmount;
    }

    /**
     * @return the advanceSalary
     */
    public Integer getAdvanceSalary()
    {
	return advanceSalary;
    }

    /**
     * @param advanceSalary the advanceSalary to set
     */
    public void setAdvanceSalary(Integer advanceSalary)
    {
	this.advanceSalary = advanceSalary;
    }

    /**
     * @return the utilities
     */
    public Integer getUtilities()
    {
	return utilities;
    }

    /**
     * @param utilities the utilities to set
     */
    public void setUtilities(Integer utilities)
    {
	this.utilities = utilities;
    }

    /**
     * @return the netAmount
     */
    public Integer getNetAmount()
    {
	return netAmount;
    }

    /**
     * @param netAmount the netAmount to set
     */
    public void setNetAmount(Integer netAmount)
    {
	this.netAmount = netAmount;
    }

    /**
     * @return the requestEmployeeSalaryDTOs
     */
    public List<RequestEmployeeSalaryDTO> getRequestEmployeeSalaryDTOs()
    {
	return requestEmployeeSalaryDTOs;
    }

    /**
     * @param requestEmployeeSalaryDTOs the requestEmployeeSalaryDTOs to set
     */
    public void setRequestEmployeeSalaryDTOs(List<RequestEmployeeSalaryDTO> requestEmployeeSalaryDTOs)
    {
	this.requestEmployeeSalaryDTOs = requestEmployeeSalaryDTOs;
    }

}