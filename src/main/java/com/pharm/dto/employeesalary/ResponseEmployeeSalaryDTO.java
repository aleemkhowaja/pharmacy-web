package com.pharm.dto.employeesalary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.pharm.dto.common.CommonDTO;
import com.pharm.dto.employee.ResponseEmployeeDTO;

/**
 * 
 * Copyright 2020, Geeks Solutions
 * Geeks Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * ResponseEmployeeDTO.java used to send response
 */
public class ResponseEmployeeSalaryDTO extends CommonDTO implements Serializable
{
    private List<ResponseEmployeeDTO> responseEmployeesDTOs = new ArrayList<ResponseEmployeeDTO>();
    
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
    

    public List<ResponseEmployeeDTO> getResponseEmployeesDTOs() {
	return responseEmployeesDTOs;
    }

    public void setResponseEmployeesDTOs(List<ResponseEmployeeDTO> responseEmployeesDTOs) {
	this.responseEmployeesDTOs = responseEmployeesDTOs;
    }

    public Integer getEmployeeSalaryId()
    {
        return employeeSalaryId;
    }

    public void setEmployeeSalaryId(Integer employeeSalaryId)
    {
        this.employeeSalaryId = employeeSalaryId;
    }

    public Date getFromDate()
    {
        return fromDate;
    }

    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    public Date getToDate()
    {
        return toDate;
    }

    public void setToDate(Date toDate)
    {
        this.toDate = toDate;
    }

    public Integer getDays()
    {
        return days;
    }

    public void setDays(Integer days)
    {
        this.days = days;
    }

    public Integer getTotalDaysAmount()
    {
        return totalDaysAmount;
    }

    public void setTotalDaysAmount(Integer totalDaysAmount)
    {
        this.totalDaysAmount = totalDaysAmount;
    }

    public Integer getOtDays()
    {
        return otDays;
    }

    public void setOtDays(Integer otDays)
    {
        this.otDays = otDays;
    }

    public Integer getTotalOtAmount()
    {
        return totalOtAmount;
    }

    public void setTotalOtAmount(Integer totalOtAmount)
    {
        this.totalOtAmount = totalOtAmount;
    }

    public Integer getPublicHolidays()
    {
        return publicHolidays;
    }

    public void setPublicHolidays(Integer publicHolidays)
    {
        this.publicHolidays = publicHolidays;
    }

    public Integer getTotalPublicHolidaysAmount()
    {
        return totalPublicHolidaysAmount;
    }

    public void setTotalPublicHolidaysAmount(Integer totalPublicHolidaysAmount)
    {
        this.totalPublicHolidaysAmount = totalPublicHolidaysAmount;
    }

    public Integer getGrossAmount()
    {
        return grossAmount;
    }

    public void setGrossAmount(Integer grossAmount)
    {
        this.grossAmount = grossAmount;
    }

    public Integer getAdvanceSalary()
    {
        return advanceSalary;
    }

    public void setAdvanceSalary(Integer advanceSalary)
    {
        this.advanceSalary = advanceSalary;
    }

    public Integer getUtilities()
    {
        return utilities;
    }

    public void setUtilities(Integer utilities)
    {
        this.utilities = utilities;
    }

    public Integer getNetAmount()
    {
        return netAmount;
    }

    public void setNetAmount(Integer netAmount)
    {
        this.netAmount = netAmount;
    }

    public String getSalaryType()
    {
        return salaryType;
    }

    public void setSalaryType(String salaryType)
    {
        this.salaryType = salaryType;
    }
    
    
    
    
}