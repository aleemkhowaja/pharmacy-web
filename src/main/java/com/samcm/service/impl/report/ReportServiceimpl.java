package com.samcm.service.impl.report;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.samcm.config.ConnectionConfiguration;
import com.samcm.service.interfaces.report.ReportService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@Service
public class ReportServiceimpl implements ReportService
{

	@Override
	public byte[] getPdfReport(HashMap<String, Object> jasperParameter, String reportName, HttpServletRequest request,
			HttpServletResponse response) 
	{
		String serverPath = request.getServletContext().getRealPath("");
		byte[] pdfData = null;
		OutputStream output = null;
		int employeeId = 0;
		long time = System.currentTimeMillis();
		try {
			
//			EmployeeModel employeeModel = (EmployeeModel)request.getSession().getAttribute("employee");
//			
//			if(employeeModel != null){
//				employeeId = employeeModel.getEmployeeId();
//			}			
			Connection connection = new ConnectionConfiguration().getConnection();
			InputStream inputStream = new FileInputStream(serverPath + "/WEB-INF/reports/"+reportName);
			// filling report with data from data source
			JasperReport jasperReport = (JasperReport)JRLoader.loadObject(inputStream);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, jasperParameter, connection);
			pdfData = JasperExportManager.exportReportToPdf(jasperPrint);
			// Initialize response.
			response.reset();
			response.setContentType("application/pdf");
			response.setHeader("Content-disposition","attachment; filename=\""+reportName.replace("Report.jasper", "_")+ employeeId+"_"+time +".pdf\"");
			// Write file to response.
			output = response.getOutputStream();
			output.write(pdfData);
			output.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
   
	
}
