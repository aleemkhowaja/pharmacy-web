package com.samcm.controller.employee;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.samcm.dto.employee.RequestEmployeeDTO;
import com.samcm.dto.employee.ResponseEmployeeDTO;
import com.samcm.service.interfaces.employee.EmployeeService;
import com.samcm.util.JQGridDTO;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController
{

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/save")
    public ResponseEntity<ResponseEmployeeDTO> create(@RequestBody RequestEmployeeDTO createDto)
    {
    	return new ResponseEntity<ResponseEmployeeDTO>(employeeService.create(createDto), HttpStatus.OK);
    }

    @PostMapping(value = "/findById")
    public ResponseEntity<ResponseEmployeeDTO> findById(@RequestParam int employeeId)
    {
    	return new ResponseEntity<ResponseEmployeeDTO>(employeeService.findById(employeeId), HttpStatus.OK);
    }
    
    @PostMapping(value = "/findAll")
    public JQGridDTO findAll(HttpServletRequest request)
    {
    	return employeeService.findAll(request);
    }
    	
    @PostMapping(value = "/delete")
    public ResponseEntity<Integer> delete(@RequestParam int id) {
    	return new ResponseEntity<Integer>(employeeService.delete(id), HttpStatus.OK);
    }

}
