package com.samcm.repository.employee;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.samcm.model.Employee;

/**
 * 
 * Copyright 2020, Geeks Solutions
 * Geeks Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * EmployeeRepository.java used to perform crud operation in employee table
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>, CrudRepository<Employee, Integer>
{
    
	@Query(value = "select distinct empl from Employee empl "
		+ " where "
		+ " (:employeeName is null or :employeeName= '' or  UPPER(empl.employeeName) like '%'|| UPPER(:employeeName)||'%') and "
		+ " (:fatherName is null or :fatherName= '' or  UPPER(empl.fatherName) like '%'||UPPER(:fatherName)||'%')  and "
		+ " (:contactNo is null or :contactNo= '' or  UPPER(empl.contactNo) like '%'||UPPER(:contactNo)||'%')  and "
		+ " (:email is null or :email= '' or  UPPER(empl.email) like '%'||UPPER(:email)||'%')  and "
		+ " (:address is null or :address= '' or  UPPER(empl.address) like '%'||UPPER(:address)||'%')  and "
		+ " (:designation is null or :designation= '' or  UPPER(empl.designation) like '%'||UPPER(:designation)||'%') "
		 )
	Page<Employee> filter(@Param("employeeName") String employeeName, 
			@Param("fatherName") String fatherName,
			@Param("contactNo") String contactNo,
			@Param("email") String email,
			@Param("address") String address,
			@Param("designation") String designation,
			Pageable pageable);
	
	
	@Query(value = "select distinct empl from Employee empl "
			+ " left join empl.employeeSalaries emplSal"
			+ " where "
			+ " (:salaryType is null or :salaryType= '' or  UPPER(empl.salaryType) like '%'||UPPER(:salaryType)||'%') and "
			+ " emplSal.fromDate is null or (:fromDate >= emplSal.fromDate and :toDate <= emplSal.toDate)"
			 )
		List<Employee> filter(@Param("salaryType") String salaryType,
				      @Param("fromDate") Date fromDate,
				      @Param("toDate") Date toDate);

    
}
