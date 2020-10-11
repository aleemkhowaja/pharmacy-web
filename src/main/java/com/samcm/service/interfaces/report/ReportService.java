package com.samcm.service.interfaces.report;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * Copyright 2020, Geeks Solutions
 * Geeks Solutions retains all ownership rights to this source code 
 * 
 * @author: Alim Khowaja
 * 
 * CoalDispatchRepotService.java used to take request from controller and send to repository
 * and send response back to controller
 */
public interface ReportService
{
	public byte[] getPdfReport (HashMap<String, Object> jasperParameter,String reportName,HttpServletRequest request,HttpServletResponse response);
}