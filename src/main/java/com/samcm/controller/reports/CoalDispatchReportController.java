package com.samcm.controller.reports;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samcm.dto.dispatchpartydetails.RequestDispatchPartyDetailsDTO;
import com.samcm.service.interfaces.report.ReportService;
import com.samcm.util.DateUtil;

@RestController
@RequestMapping(value = "/coaldispatchreport")
public class CoalDispatchReportController
{
	
	@Autowired
	private ReportService reportService;

	@RequestMapping(value="/report/coaldispatchreport.htm")
	public byte[] returnAllAttendanceDetailForGrid(
			@ModelAttribute("coaldispatchedreport") RequestDispatchPartyDetailsDTO requestDispatchPartyDetailsDTO , 
			HttpServletRequest request, HttpServletResponse response) 
	{
		
		System.out.println(requestDispatchPartyDetailsDTO.getFromDate()+"-"+
	requestDispatchPartyDetailsDTO.getToDate());
		String serverPath = request.getServletContext().getRealPath("");
		HashMap<String,Object> jasperParameter = new HashMap<String,Object>();
		jasperParameter.put("fromDate",/* DateUtil.dateToString(*/requestDispatchPartyDetailsDTO.getFromDate());
		jasperParameter.put("toDate",  /* DateUtil.dateToString(*/requestDispatchPartyDetailsDTO.getToDate());
		
		//jasperParameter.put("imagePath", serverPath+ "/resources/theme/images/path1.jpg");
		//jasperParameter.put("holidays", DateUtil.getHolyDaysByMonthAndYear(attendanceDetailModel.getYear(), attendanceDetailModel.getMonth()));
		return reportService.getPdfReport(jasperParameter, "weekly-coal-report.jasper", request, response);

	}

    @GetMapping(value = "/coaldispatchreport.htm")
    public String returnEmployeePage(Model model,  HttpServletRequest request)
    {
    	model.addAttribute("coaldispatchedreport", new RequestDispatchPartyDetailsDTO());
    	return "reportspages/CoalDispatchReport";
    }
}
