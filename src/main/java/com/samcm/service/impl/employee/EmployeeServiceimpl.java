package com.samcm.service.impl.employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.samcm.dto.employee.RequestEmployeeDTO;
import com.samcm.dto.employee.ResponseEmployeeDTO;
import com.samcm.exception.CommonExceptionMessage;
import com.samcm.exception.Constraints;
import com.samcm.exception.ResourceNotFoundException;
import com.samcm.model.Employee;
import com.samcm.repository.employee.EmployeeRepository;
import com.samcm.service.interfaces.employee.EmployeeService;
import com.samcm.util.CommonConstant;
import com.samcm.util.CommonUtil;
import com.samcm.util.GridUtils;
import com.samcm.util.JQGridDTO;
import com.samcm.util.PropertiesUtil;

@Service
public class EmployeeServiceimpl implements EmployeeService
{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ResponseEmployeeDTO create(RequestEmployeeDTO createDto)
    {
	Employee employee = new Employee();
	
	//copy properties from creat DTO to Model
	PropertiesUtil.copyProperties(createDto, employee);
	
	//set values of created by / create date/ status while saving new record
	CommonUtil.setSaveCreatedFieldValues(employee, CommonConstant.ACTIVE);
	
	 //save employeeModel in db
	employeeRepository.save(employee);
	   
	//return details with Response DTO
	return detail(createDto);
    }

    @Override
    public ResponseEmployeeDTO findById(Integer modelId)
    {
	
	Employee employee = employeeRepository.findById(modelId)
		.orElseThrow(() -> new ResourceNotFoundException(new CommonExceptionMessage(Constraints.EMPLOYEE_NOT_FOUND)));
	
	ResponseEmployeeDTO responseEmployeeDTO = new ResponseEmployeeDTO();
	//copy properties from source to destinition object
	PropertiesUtil.copyProperties(employee, responseEmployeeDTO);
	
	return responseEmployeeDTO;
    }


    @Override
    public ResponseEmployeeDTO detail(RequestEmployeeDTO createDto)
    {
	ResponseEmployeeDTO responseEmployeeDTO = new ResponseEmployeeDTO();
	
	//copy properties from request DTO to response DTO
	PropertiesUtil.copyProperties(createDto, responseEmployeeDTO);
	
	return responseEmployeeDTO;
    }

    @Override
    public JQGridDTO findAll(HttpServletRequest request)
    {
    	JQGridDTO<ResponseEmployeeDTO> jqGridDTO = new JQGridDTO<ResponseEmployeeDTO>();
    	
		String order = request.getParameter("sord");
		String sortingProperty = request.getParameter("sidx");
		int page = Integer.valueOf(request.getParameter("page")).intValue();
		Integer jtPageSize = request.getParameter("rows") == null ? 0 : Integer.parseInt(request.getParameter("rows"));
		Integer jtStartIndex = (page-1)*jtPageSize;
		
		
		String employeeName = request.getParameter("employeeName");
		
		
		Pageable pageable = GridUtils.buildPageable((page-1), jtPageSize,
			sortingProperty, order);
	
		/**
		 * retrieve all records
		 */
		Page<Employee> employeePage = employeeRepository.filter(employeeName, null, null, null, null, null,pageable);
		
		/**
		 * retrieve all Count
		 */
		Long rowCount = employeeRepository.count();
		
		if(employeePage.getContent() == null || employeePage.getContent().size() <= 0) return jqGridDTO;
		
		List<ResponseEmployeeDTO> responseEmployeeDTOs = new  ArrayList<ResponseEmployeeDTO>();
		
		for(Employee employee : employeePage.getContent())
		{
		    ResponseEmployeeDTO responseEmployeeDTO = new ResponseEmployeeDTO();
		    responseEmployeeDTO.setEmployeeId(employee.getEmployeeId());
		    responseEmployeeDTO.setEmployeeName(employee.getEmployeeName());
		    responseEmployeeDTO.setAddress(employee.getAddress());
		    responseEmployeeDTO.setContactNo(employee.getContactNo());
		    responseEmployeeDTO.setDesignation(employee.getContactNo());
		    responseEmployeeDTO.setEmail(employee.getEmail());
		    
		    responseEmployeeDTOs.add(responseEmployeeDTO);
		}
		
		jqGridDTO.setRows(responseEmployeeDTOs);
		jqGridDTO.setTotal(String.valueOf(Math.ceil((double) rowCount / jtPageSize)));
		jqGridDTO.setRecords(String.valueOf(rowCount));
		jqGridDTO.setPage(page);
		return jqGridDTO;
    }

    @Override
    public Integer delete(Integer modelId)
    {
		Employee employee = employeeRepository.findById(modelId)
			.orElseThrow(() -> new ResourceNotFoundException(new CommonExceptionMessage(Constraints.EMPLOYEE_NOT_FOUND)));
		
		employee.setStatus(CommonConstant.DELETE);
		employeeRepository.save(employee);
		return 1;
    }
    
    @Override
	public List<ResponseEmployeeDTO> findByParentProperties(HashMap<String, Object> prop) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    public Employee getIfExist(Integer modelId)
    {
		Employee employee = employeeRepository.findById(modelId)
				.orElseThrow(() -> new ResourceNotFoundException(new CommonExceptionMessage(Constraints.EMPLOYEE_NOT_FOUND)));
		
		return employee;
    }

	@Override
	public List<ResponseEmployeeDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
    

}
