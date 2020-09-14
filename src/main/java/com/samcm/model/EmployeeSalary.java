package com.samcm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "employee_salary")
@Where(clause = "status='A'")
public class EmployeeSalary extends Common
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_salary_id")
    private Integer employeeSalaryId;

    @Column(name = "from_date")
    private Date fromDate;

    @Column(name = "to_date")
    private Date toDate;

    @Column(name = "days")
    private Integer days;

    @Column(name = "total_days_amount")
    private Integer totalDaysAmount;

    @Column(name = "ot_days")
    private Integer otDays;

    @Column(name = "total_ot_amount")
    private Integer totalOtAmount;
    
    @Column(name = "public_holidays") 
    private Integer publicHolidays;
    
    @Column(name = "total_public_holidays_amount") 
    private Integer totalPublicHolidaysAmount;
    
    @Column(name = "gross_amount") 
    private Integer grossAmount;
    
    @Column(name = "advance_salary") 
    private Integer advanceSalary;
    
    @Column(name = "utilities") 
    private Integer utilities;
    
    @Column(name = "net_amount") 
    private Integer netAmount;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

	/**
	 * @return the employeeSalaryId
	 */
	public Integer getEmployeeSalaryId() {
		return employeeSalaryId;
	}

	/**
	 * @param employeeSalaryId the employeeSalaryId to set
	 */
	public void setEmployeeSalaryId(Integer employeeSalaryId) {
		this.employeeSalaryId = employeeSalaryId;
	}

	/**
	 * @return the fromDate
	 */
	public Date getFromDate() {
		return fromDate;
	}

	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * @return the toDate
	 */
	public Date getToDate() {
		return toDate;
	}

	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	/**
	 * @return the days
	 */
	public Integer getDays() {
		return days;
	}

	/**
	 * @param days the days to set
	 */
	public void setDays(Integer days) {
		this.days = days;
	}

	/**
	 * @return the totalDaysAmount
	 */
	public Integer getTotalDaysAmount() {
		return totalDaysAmount;
	}

	/**
	 * @param totalDaysAmount the totalDaysAmount to set
	 */
	public void setTotalDaysAmount(Integer totalDaysAmount) {
		this.totalDaysAmount = totalDaysAmount;
	}

	/**
	 * @return the otDays
	 */
	public Integer getOtDays() {
		return otDays;
	}

	/**
	 * @param otDays the otDays to set
	 */
	public void setOtDays(Integer otDays) {
		this.otDays = otDays;
	}

	/**
	 * @return the totalOtAmount
	 */
	public Integer getTotalOtAmount() {
		return totalOtAmount;
	}

	/**
	 * @param totalOtAmount the totalOtAmount to set
	 */
	public void setTotalOtAmount(Integer totalOtAmount) {
		this.totalOtAmount = totalOtAmount;
	}

	/**
	 * @return the publicHolidays
	 */
	public Integer getPublicHolidays() {
		return publicHolidays;
	}

	/**
	 * @param publicHolidays the publicHolidays to set
	 */
	public void setPublicHolidays(Integer publicHolidays) {
		this.publicHolidays = publicHolidays;
	}

	/**
	 * @return the totalPublicHolidaysAmount
	 */
	public Integer getTotalPublicHolidaysAmount() {
		return totalPublicHolidaysAmount;
	}

	/**
	 * @param totalPublicHolidaysAmount the totalPublicHolidaysAmount to set
	 */
	public void setTotalPublicHolidaysAmount(Integer totalPublicHolidaysAmount) {
		this.totalPublicHolidaysAmount = totalPublicHolidaysAmount;
	}

	/**
	 * @return the grossAmount
	 */
	public Integer getGrossAmount() {
		return grossAmount;
	}

	/**
	 * @param grossAmount the grossAmount to set
	 */
	public void setGrossAmount(Integer grossAmount) {
		this.grossAmount = grossAmount;
	}

	/**
	 * @return the advanceSalary
	 */
	public Integer getAdvanceSalary() {
		return advanceSalary;
	}

	/**
	 * @param advanceSalary the advanceSalary to set
	 */
	public void setAdvanceSalary(Integer advanceSalary) {
		this.advanceSalary = advanceSalary;
	}

	/**
	 * @return the utilities
	 */
	public Integer getUtilities() {
		return utilities;
	}

	/**
	 * @param utilities the utilities to set
	 */
	public void setUtilities(Integer utilities) {
		this.utilities = utilities;
	}

	/**
	 * @return the netAmount
	 */
	public Integer getNetAmount() {
		return netAmount;
	}

	/**
	 * @param netAmount the netAmount to set
	 */
	public void setNetAmount(Integer netAmount) {
		this.netAmount = netAmount;
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}