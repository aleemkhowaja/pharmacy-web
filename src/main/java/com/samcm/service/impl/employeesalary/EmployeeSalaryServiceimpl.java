package com.samcm.service.impl.employeesalary;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samcm.dto.employee.ResponseEmployeeDTO;
import com.samcm.dto.employeesalary.RequestEmployeeSalaryDTO;
import com.samcm.dto.employeesalary.ResponseEmployeeSalaryDTO;
import com.samcm.model.Employee;
import com.samcm.model.EmployeeSalary;
import com.samcm.repository.employee.EmployeeRepository;
import com.samcm.repository.employeesalary.EmployeeSalaryRepository;
import com.samcm.service.interfaces.employee.EmployeeService;
import com.samcm.service.interfaces.employeesalary.EmployeeSalaryService;
import com.samcm.util.CommonConstant;
import com.samcm.util.CommonUtil;
import com.samcm.util.JQGridDTO;
import com.samcm.util.NumberUtil;
import com.samcm.util.PropertiesUtil;

@Service
public class EmployeeSalaryServiceimpl implements EmployeeSalaryService
{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeSalaryRepository employeeSalaryRepository;

    @Autowired
    private EmployeeService employeeService;

    @Override
    public ResponseEmployeeDTO create(RequestEmployeeSalaryDTO createDto)
    {

	ResponseEmployeeDTO responseEmployeeDTO = new ResponseEmployeeDTO();

	if(createDto != null && createDto.getRequestEmployeeSalaryDTOs() != null)
	{
	    EmployeeSalary employeeSalary = null;

	    for(RequestEmployeeSalaryDTO dto : createDto.getRequestEmployeeSalaryDTOs())
	    {
		employeeSalary = new EmployeeSalary();
		PropertiesUtil.copyProperties(dto, employeeSalary);

		CommonUtil.setSaveCreatedFieldValues(employeeSalary, CommonConstant.ACTIVE);

		/**
		 * return Employee by employee id
		 */
		Employee employee = employeeService.getIfExist(dto.getEmployeeId());
		employeeSalary.setEmployee(employee);

		/**
		 * Set From/To Date in EmployeeSalary Model
		 */
		employeeSalary.setFromDate(createDto.getFromDate());
		employeeSalary.setToDate(createDto.getToDate());

		/**
		 * Save Employee Salary Details
		 */
		employeeSalaryRepository.save(employeeSalary);
	    }

	}
	return responseEmployeeDTO;
    }

    @Override
    public ResponseEmployeeDTO findById(Integer modelId)
    {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ResponseEmployeeDTO detail(RequestEmployeeSalaryDTO requestDTO)
    {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public JQGridDTO findAll(HttpServletRequest httpRequest)
    {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<ResponseEmployeeDTO> findAll()
    {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Integer delete(Integer modelId)
    {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Employee getIfExist(Integer modelId)
    {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<ResponseEmployeeDTO> findByParentProperties(HashMap<String, Object> prop)
    {
	String salaryType = (String) prop.get("salaryType");

	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	Date fromDate, toDate;

	List<ResponseEmployeeDTO> responseEmployeeDTOs = new ArrayList<ResponseEmployeeDTO>();
	try
	{
	    fromDate = format.parse(format.format(prop.get("fromDate")));
	    toDate = format.parse(format.format(prop.get("toDate")));

	    List<Employee> employees = employeeRepository.filter(salaryType, fromDate, toDate);

	    if(employees == null || employees.size() < 1)
		return responseEmployeeDTOs;

	    for(Employee employee : employees)
	    {
		ResponseEmployeeDTO dto = new ResponseEmployeeDTO();

		dto.setEmployeeId(employee.getEmployeeId());
		dto.setEmployeeName(employee.getEmployeeName());
		dto.setEmail(employee.getEmail());
		dto.setFatherName(employee.getFatherName());
		dto.setAddress(employee.getAddress());
		dto.setContactNo(employee.getContactNo());
		dto.setDesignation(employee.getDesignation());
		dto.setPublicHolidayAmount(employee.getPublicHolidayAmount());
		dto.setOvertimeAmount(employee.getOvertimeAmount());
		dto.setSalary(employee.getSalary());
		dto.setSalaryType(employee.getSalaryType());
		dto.setStatus(employee.getStatus());

		/**
		 * Calculate the Emplyee Salary
		 */
		if(employee.getEmployeeSalaries() != null && employee.getEmployeeSalaries().size() > 0)
		{
		    ResponseEmployeeSalaryDTO responseEmployeeSalaryDTO = new ResponseEmployeeSalaryDTO();

		    //for(EmployeeSalary salary : employee.getEmployeeSalaries())
		 //   {
		    responseEmployeeSalaryDTO.setEmployeeSalaryId(NumberUtil.integerNullToZero(employee.getEmployeeSalaries().get(0).getEmployeeSalaryId()));
		    responseEmployeeSalaryDTO.setDays(NumberUtil.integerNullToZero(employee.getEmployeeSalaries().get(0).getDays()));
		    responseEmployeeSalaryDTO.setTotalDaysAmount(NumberUtil.integerNullToZero(employee.getEmployeeSalaries().get(0).getTotalDaysAmount()));
		    responseEmployeeSalaryDTO.setOtDays(NumberUtil.integerNullToZero(employee.getEmployeeSalaries().get(0).getOtDays()));
		    responseEmployeeSalaryDTO.setTotalOtAmount(NumberUtil.integerNullToZero(employee.getEmployeeSalaries().get(0).getTotalOtAmount()));
		    responseEmployeeSalaryDTO.setPublicHolidays(NumberUtil.integerNullToZero(employee.getEmployeeSalaries().get(0).getPublicHolidays()));
		    responseEmployeeSalaryDTO.setTotalPublicHolidaysAmount(NumberUtil.integerNullToZero(employee.getEmployeeSalaries().get(0).getTotalPublicHolidaysAmount()));
		    responseEmployeeSalaryDTO.setGrossAmount(NumberUtil.integerNullToZero(employee.getEmployeeSalaries().get(0).getGrossAmount()));
		    responseEmployeeSalaryDTO.setAdvanceSalary(NumberUtil.integerNullToZero(employee.getEmployeeSalaries().get(0).getAdvanceSalary()));
		    responseEmployeeSalaryDTO.setUtilities(NumberUtil.integerNullToZero(employee.getEmployeeSalaries().get(0).getUtilities()));
		    responseEmployeeSalaryDTO.setNetAmount( NumberUtil.integerNullToZero(employee.getEmployeeSalaries().get(0).getNetAmount()));

		    dto.setResponseEmployeeSalaryDTO(responseEmployeeSalaryDTO);
		//    }
		}

		responseEmployeeDTOs.add(dto);
	    }

	}
	catch(ParseException e)
	{
	    e.printStackTrace();
	}
	return responseEmployeeDTOs;
    }
}
