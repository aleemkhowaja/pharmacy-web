package com.samcm.controller.employeesalary;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.samcm.dto.employee.ResponseEmployeeDTO;
import com.samcm.dto.employeesalary.RequestEmployeeSalaryDTO;
import com.samcm.service.interfaces.employeesalary.EmployeeSalaryService;

@RestController
@RequestMapping(value = "/employeesalary")
public class EmployeeSalaryController
{

    @Autowired
    private EmployeeSalaryService employeeSalaryService;

    
    @PostMapping(value = "/save")
    public ResponseEntity<ResponseEmployeeDTO> create(@RequestBody RequestEmployeeSalaryDTO createDto)
    {
    	return new ResponseEntity<ResponseEmployeeDTO>(employeeSalaryService.create(createDto), HttpStatus.OK);
    }
    
    @PostMapping(value = "/findAllEmpoyeesBySalaryType")
    public List<ResponseEmployeeDTO> findAllEmpoyeesBySalaryType(@RequestBody RequestEmployeeSalaryDTO dto)
    {
    	HashMap<String, Object> prop = new HashMap<String, Object>();
    	prop.put("salaryType", dto.getSalaryType());
    	prop.put("fromDate", dto.getFromDate());
    	prop.put("toDate", dto.getToDate());
    	return employeeSalaryService.findByParentProperties(prop);
    }

}
