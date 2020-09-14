package com.samcm.repository.employeesalary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.samcm.model.EmployeeSalary;

/**
 * 
 * Copyright 2020, Geeks Solutions
 * Geeks Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 *
 * EmployeeSalaryRepository.java used to perform crud operation in employee_salary table
 */
@Repository
public interface EmployeeSalaryRepository extends JpaRepository<EmployeeSalary, Integer>, CrudRepository<EmployeeSalary, Integer>
{
    
    
}
