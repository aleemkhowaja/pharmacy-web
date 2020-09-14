	
	/**
	 * save employee salary details
	 * @returns
	 */
	function employeeSalary_save(event)
	{
		var requestEmployeeSalaryDTOs = [];
		var requestEmployeeSalaryDTO = {};
		
		/**
		 * Form validation
		 */
		var formId = "employeeSalary_form";
		var flag = validateForm(formId);
		if(!flag) return flag;
		
		
		$('#employeeSalary_form table input').each(function (index)
		{
			
			if($(this).attr('id') != undefined)
			{
				console.log($(this).attr('id') + ""+$("#"+$(this).attr('id')).val());
				
				
				if($(this).attr('id').match("^employeeId_"))
 				{
					requestEmployeeSalaryDTO["employeeId"] = $("#"+$(this).attr('id')).val();
 				}
				else if($(this).attr('id').match("^totalDays_"))
				{
					requestEmployeeSalaryDTO["days"] = $("#"+$(this).attr('id')).val();
				}
				else if($(this).attr('id').match("^totalDaysSalary_"))
				{
					requestEmployeeSalaryDTO["totalDaysAmount"] = $("#"+$(this).attr('id')).val();	
				}
				else if($(this).attr('id').match("^overtimedays_"))
				{
					requestEmployeeSalaryDTO["otDays"] = $("#"+$(this).attr('id')).val();	
				}
				else if($(this).attr('id').match("^totalOvertimeAmount_"))
				{
					requestEmployeeSalaryDTO["totalOtAmount"] = $("#"+$(this).attr('id')).val();	
				}
				else if($(this).attr('id').match("^publicHolidays_"))
				{
					requestEmployeeSalaryDTO["publicHolidays"] = $("#"+$(this).attr('id')).val();	
				}
				else if($(this).attr('id').match("^totalPublicHolidayAmount_"))
				{
					requestEmployeeSalaryDTO["totalPublicHolidaysAmount"] = $("#"+$(this).attr('id')).val();
				}
				else if($(this).attr('id').match("^totalGrossAmount_"))
				{
					requestEmployeeSalaryDTO["grossAmount"] = $("#"+$(this).attr('id')).val();
				}
				else if($(this).attr('id').match("^advanceAmount_"))
				{
					requestEmployeeSalaryDTO["advanceSalary"] = $("#"+$(this).attr('id')).val();
				}
				else if($(this).attr('id').match("^totalNetAmount_"))
				{
					requestEmployeeSalaryDTO["netAmount"] = $("#"+$(this).attr('id')).val();
				}
				else if($(this).attr('id').match("^utilities_"))
				{	
					requestEmployeeSalaryDTO["utilities"] = $("#"+$(this).attr('id')).val();
					requestEmployeeSalaryDTOs.push(requestEmployeeSalaryDTO);
					requestEmployeeSalaryDTO = {};
				}
				
			}
		});
		
		
		var fromDate = $("#employeeSalary_fromDate").val();
		var toDate = $("#employeeSalary_toDate").val();
		
		
		var createDto = {};
		
		createDto["requestEmployeeSalaryDTOs"] = requestEmployeeSalaryDTOs;
		createDto["fromDate"] = fromDate;
		createDto["toDate"] = toDate;
		
		url ='/employeesalary/save';
		event.preventDefault();
		$.ajax({
			url :url,
			 type: "POST",
			 contentType: "application/json",
	         data: JSON.stringify(createDto),
	         processData: false,
			 async:false,
			 dataType: 'json',
		     cache: false,
			 success : function(data) {
				if(data != undefined) {
					toaster_success("Record Saved Successfully");
					
					//clear form
					clear_FromData("employeeSalary_form");
					
					//remove delete button after deouble click 
//					remove_child_Elements(controllerName+'-delete-btn');
					
					//remove detail button after deouble click 
//					remove_child_Elements(controllerName+'-details-btn');
				}
				else {
					toaster_error(data);
				}
			}
		});
		
			 
		return false;
	}
	
	/**
	 * return employee details and create the table according to employee type
	 * @returns
	 */
	function employeeSalary_returnEmployeeBySalaryType()
	{
		
		/**
		 * Form validation
		 */
		var formId = "employeeSalary_form";
		var flag = validateForm(formId);
		if(!flag) return flag;
		
		var token   = $("meta[name='_csrf']").attr("content");
		var header  = $("meta[name='_csrf_header']").attr("content");
		
		var url     ='/employeesalary/findAllEmpoyeesBySalaryType';
		var salaryType = $("#employeeSalary_salaryType").val();
		var fromDate = $("#employeeSalary_fromDate").val();
		var toDate = $("#employeeSalary_toDate").val();
		
		var dataJson = {
			"salaryType"        :  	$("#employeeSalary_salaryType").val(),
			"fromDate" 			: 	$("#employeeSalary_fromDate").val(),
			"toDate" 			: 	$("#employeeSalary_toDate").val(),
		};
		

		$.ajax({
			url :url,
			 contentType: "application/json",
			 type: "POST",
			 data:  JSON.stringify(dataJson),
			 async:false,
			 success : function(data) 
			 {
				 employeeSalary_createEmployeeTable(data);
			 }
		});
	}
	
	
	/**
	 * Create table for employee and its salary details 
	 * @param data
	 * @returns
	 */
	function employeeSalary_createEmployeeTable(data)
	{
		$("#employeeSalary_dailyEmployeSalaryDtsTbl > tbody").empty();
		var employeeSalaryDtls = data;
		var tableData = "";
		
		/**
		 * check if employee details are empty
		 */
		if(employeeSalaryDtls.length <= 0) return;
		
		employeeSalary_calculateDatesBetweenDates 
		
		/**
		 * Populate all employees and its details
		 */
		for(var i=0; i<employeeSalaryDtls.length; i++)
		{
			var tr = "<tr> ";
			tr += " <td> "+(i+1)+"  </td>"
			tr += " <td> <input type='hidden' value="+employeeSalaryDtls[i].employeeId+" id='employeeId_"+i+"'/>" +
					"   <input type='hidden' value="+employeeSalaryDtls[i].employeeSalaryId+" id='employeeSalaryId_"+i+"'/>" "+employeeSalaryDtls[i].employeeName+" </td>"
			tr += " <td> "+employeeSalaryDtls[i].fatherName+" </td>"
			tr += " <td> "+employeeSalaryDtls[i].designation+" </td>"
			tr += " <td> "+(employeeSalaryDtls[i].salary == null ? 0 : employeeSalaryDtls[i].salary) +" </td>"
			tr += " <td> <input type='hidden' value="+(employeeSalaryDtls[i].salary == null ? 0 : employeeSalaryDtls[i].salary)+" id='salaryPerDay_"+i+"'/> " +
						 "<input type='hidden' value='' id='totalDaysSalary_"+i+"'/> "+
					"<input type='text' onchange='employeeSalary_calculateDailyWagesSalary(this);' id='totalDays_"+i+"' style='width:50px' value='"+(employeeSalaryDtls[i].responseEmployeeSalaryDTO.days == null ? 0 : employeeSalaryDtls[i].responseEmployeeSalaryDTO.days)+"'/> </td>"
			tr += " <td> "+(employeeSalaryDtls[i].responseEmployeeSalaryDTO.totalDaysAmount == null ? 0 : employeeSalaryDtls[i].responseEmployeeSalaryDTO.totalDaysAmount)+" </td>"
			tr += " <td> "+(employeeSalaryDtls[i].overtimeAmount == null ? 0 : employeeSalaryDtls[i].overtimeAmount) +" </td>"
			tr += " <td>  <input type='hidden' value='' id='totalOvertimeAmount_"+i+"'/> " +
					"<input type='text' onchange='employeeSalary_calculateDailyOverTime(this);' id='overtimedays_"+i+"' style='width:50px' value='"+(employeeSalaryDtls[i].responseEmployeeSalaryDTO.otDays == null ? 0 : employeeSalaryDtls[i].responseEmployeeSalaryDTO.otDays)+"' /> </td>"
			tr += " <td> "+(employeeSalaryDtls[i].responseEmployeeSalaryDTO.totalOtAmount == null ? 0 : employeeSalaryDtls[i].responseEmployeeSalaryDTO.totalOtAmount)+" </td>"
			tr += " <td> "+(employeeSalaryDtls[i].publicHolidayAmount == null ? 0 : employeeSalaryDtls[i].publicHolidayAmount)+" </td>"
			tr += " <td> <input type='hidden' value='' id='totalPublicHolidayAmount_"+i+"'/> " +
					"<input type='text' onchange ='employeeSalary_calculateDailyPublicHoliday(this);'  id='publicHolidays_"+i+"' style='width:50px' value='"+(employeeSalaryDtls[i].responseEmployeeSalaryDTO.publicHolidays == null ? 0 : employeeSalaryDtls[i].responseEmployeeSalaryDTO.publicHolidays)+"'/> </td>"
			tr += " <td> "+(employeeSalaryDtls[i].responseEmployeeSalaryDTO.totalPublicHolidaysAmount == null ? 0 : employeeSalaryDtls[i].responseEmployeeSalaryDTO.totalPublicHolidaysAmount)+" </td>"
			tr += " <td> "+(employeeSalaryDtls[i].responseEmployeeSalaryDTO.grossAmount == null ? 0 : employeeSalaryDtls[i].responseEmployeeSalaryDTO.grossAmount)+" </td>"
			tr += " <td> <input type='hidden' value='' id='totalGrossAmount_"+i+"'/>" +
					"	 <input type='hidden' value='' id='totalNetAmount_"+i+"'/>"+
					"<input type='text' onchange ='employeeSalary_calculateDailyWagesNetAmount(this);'  id='advanceAmount_"+i+"' style='width:50px' value='"+(employeeSalaryDtls[i].responseEmployeeSalaryDTO.advanceSalary == null ? 0 : employeeSalaryDtls[i].responseEmployeeSalaryDTO.advanceSalary)+"' /> </td>"
			tr += " <td> <input type='text' onchange ='employeeSalary_calculateDailyWagesNetAmount(this);'  id='utilities_"+i+"' style='width:50px' value='"+(employeeSalaryDtls[i].responseEmployeeSalaryDTO.utilities == null ? 0 : employeeSalaryDtls[i].responseEmployeeSalaryDTO.utilities)+"' /> </td>"
			tr += " <td> "+(employeeSalaryDtls[i].responseEmployeeSalaryDTO.netAmount == null ? 0 : employeeSalaryDtls[i].responseEmployeeSalaryDTO.netAmount)+" </td>"
			tr += " </tr>";
			
			tableData+= tr;
		}
	    $("#employeeSalary_dailyEmployeSalaryDtsTbl").append(tableData);
	}
	
	/**
	 * Calculate Days between days
	 * @returns
	 */
	function employeeSalary_calculateDatesBetweenDates()
	{
		
		var fromDate = $("#employeeSalary_fromDate").val();
		var toDate = $("#employeeSalary_toDate").val();
		
		// To calculate the time difference of two dates 
		var totalTimeBtwDates = toDate.getTime() - fromDate.getTime(); 
		  
		// To calculate the no. of days between two dates 
		var daysBtwDates = totalTimeBtwDates / (1000 * 3600 * 24); 
		
		return daysBtwDates;
	}
	
	
	/**
	 * Calculate Daily Amount
	 * @param evt
	 * @returns
	 */
	function employeeSalary_calculateDailyWagesSalary(evt)
	{
		var totalDaysFldId = evt.id.split("_");
		var totalDays = $("#"+evt.id).val();
		var dailySalary = parseInt($.trim($("#employeeSalary_dailyEmployeSalaryDtsTbl").find("tr:eq("+(parseInt(totalDaysFldId[1])+1)+")").find('td:eq(4)').text()));
		$("#employeeSalary_dailyEmployeSalaryDtsTbl").find("tr:eq("+(parseInt(totalDaysFldId[1])+1)+")").find('td:eq(6)').text(totalDays * dailySalary);
		
		/**
		 * Total Days Salary set in hidden field
		 */
		$("#totalDaysSalary_"+totalDaysFldId[1]).val(totalDays * dailySalary);
		
		/**
		 * Call Calculate Gross Salary
		 */
		employeeSalary_calculateDailyWagesGrossAmount(evt);
	}
	
	/**
	 * Calculate Overtime Amount
	 * @param evt
	 * @returns
	 */
	function employeeSalary_calculateDailyOverTime(evt)
	{
		var rowId = evt.id.split("_");
		var overTimeDays = $("#"+evt.id).val();
		var perDayOvertimeAmount = parseInt($.trim($("#employeeSalary_dailyEmployeSalaryDtsTbl").find("tr:eq("+(parseInt(rowId[1])+1)+")").find('td:eq(7)').text()));
		$("#employeeSalary_dailyEmployeSalaryDtsTbl").find("tr:eq("+(parseInt(rowId[1])+1)+")").find('td:eq(9)').text(overTimeDays * perDayOvertimeAmount);
		
		/**
		 * Total Overtime Days Amount set in hidden field
		 */
		$("#totalOvertimeAmount_"+rowId[1]).val(overTimeDays * perDayOvertimeAmount);
		
		/**
		 * Call Calculate Gross Salary
		 */
		employeeSalary_calculateDailyWagesGrossAmount(evt);
	}
	
	/**
	 * Calculate Public Holidays
	 * @param evt
	 * @returns
	 */
	function employeeSalary_calculateDailyPublicHoliday(evt)
	{
		var rowId = evt.id.split("_");
		var publicHolidays = $("#"+evt.id).val();
		var publicHolidayAmount = parseInt($.trim($("#employeeSalary_dailyEmployeSalaryDtsTbl").find("tr:eq("+(parseInt(rowId[1])+1)+")").find('td:eq(10)').text()));
		$("#employeeSalary_dailyEmployeSalaryDtsTbl").find("tr:eq("+(parseInt(rowId[1])+1)+")").find('td:eq(12)').text(publicHolidays * publicHolidayAmount);
		
		/**
		 * Total Public Holiday Amount set in hidden field
		 */
		$("#totalPublicHolidayAmount_"+rowId[1]).val(publicHolidays * publicHolidayAmount);
		
		/**
		 * Call Calculate Gross Salary
		 */
		employeeSalary_calculateDailyWagesGrossAmount(evt);
	}
	
	/**
	 * Calculate Gross Salary
	 * @param evt
	 * @returns
	 */
	function employeeSalary_calculateDailyWagesGrossAmount(evt)
	{
		var rowId = evt.id.split("_");
		
		var totalDaysAmount = isNaN($("#employeeSalary_dailyEmployeSalaryDtsTbl").find("tr:eq("+(parseInt(rowId[1])+1)+")").find('td:eq(6)').text()) ? 0 :
				$("#employeeSalary_dailyEmployeSalaryDtsTbl").find("tr:eq("+(parseInt(rowId[1])+1)+")").find('td:eq(6)').text();
		
		var totalOvertimeAmount = isNaN($("#employeeSalary_dailyEmployeSalaryDtsTbl").find("tr:eq("+(parseInt(rowId[1])+1)+")").find('td:eq(9)').text()) ? 0 : 
			$("#employeeSalary_dailyEmployeSalaryDtsTbl").find("tr:eq("+(parseInt(rowId[1])+1)+")").find('td:eq(9)').text();
		
		var totalPublicHolidaysAmount = isNaN($("#employeeSalary_dailyEmployeSalaryDtsTbl").find("tr:eq("+(parseInt(rowId[1])+1)+")").find('td:eq(12)').text()) ? 0 :
			$("#employeeSalary_dailyEmployeSalaryDtsTbl").find("tr:eq("+(parseInt(rowId[1])+1)+")").find('td:eq(12)').text();
		
		$("#employeeSalary_dailyEmployeSalaryDtsTbl").find("tr:eq("+(parseInt(rowId[1])+1)+")").find('td:eq(13)').text(	parseInt(totalDaysAmount) + 
																														parseInt(totalOvertimeAmount) + 
																														parseInt(totalPublicHolidaysAmount));
		/**
		 * set Gross Amount in hidden field
		 */
		$("#totalGrossAmount_"+rowId[1]).val(parseInt(totalDaysAmount) + parseInt(totalOvertimeAmount) + parseInt(totalPublicHolidaysAmount));
		
		employeeSalary_calculateDailyWagesNetAmount(evt);
	}
	
	/**
	 * Calculate Daily Wages Net Amount
	 * @param evt
	 * @returns
	 */
	function employeeSalary_calculateDailyWagesNetAmount(evt)
	{
		var rowId = evt.id.split("_");

		var advanceAmount = $("#advanceAmount_"+parseInt(rowId[1])).val();
		var utilities = $("#utilities_"+parseInt(rowId[1])).val();
		
		var grossAmount = $("#employeeSalary_dailyEmployeSalaryDtsTbl").find("tr:eq("+(parseInt(rowId[1])+1)+")").find('td:eq(13)').text();
		
		if(typeof advanceAmount == "undefined"  || advanceAmount == "") advanceAmount = 0;
		
		if(typeof utilities		== "undefined"  || utilities 	 == "") utilities = 0;
		
		
		$("#employeeSalary_dailyEmployeSalaryDtsTbl").find("tr:eq("+(parseInt(rowId[1])+1)+")").find('td:eq(16)').text(	parseInt(grossAmount) - (parseInt(advanceAmount)
																																				 + parseInt(utilities)) );
		/**
		 * set Net Amount in Hidden field
		 */
		$("#totalNetAmount_"+rowId[1]).val(parseInt(grossAmount) - (parseInt(advanceAmount) + parseInt(utilities)));

																																				 
	}