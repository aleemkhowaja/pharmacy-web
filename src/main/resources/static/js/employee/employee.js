
	/**
	 * crud employee
	 * @param event
	 * @returns
	 */
	function employee_crud(event)
	{
		var dataJson = {
				"employeeId" 			: 		$("#employee_employeeId").val(),
				"employeeName" 			: 		$("#employee_name").val(),
				"fatherName" 			: 		$("#employee_fatherName").val(),
				"contactNo" 			: 		$("#employee_contactNo").val(),
				"email" 				:  		$("#employee_email").val(),
				"designation" 			:  		$("#employee_designation").val(),
				"address" 				: 		$("#employee_address").val(),
				"salaryType" 			: 		$("#employee_salaryType").val(),
				"salary" 				: 		$("#employee_salary").val(),
				"overtimeAmount" 		: 		$("#employee_overtimeAmount").val(),
				"publicHolidayAmount" 	: 		$("#employee_publicHolidayAmount").val(),
		};
		
		/**
		 * Save Record
		 */
		var flag = common_save("employee", dataJson, event);
		
		return flag;
	}
	
	/**
	 * get record and set data in form while double click on Grid Row
	 * @param rowId
	 */
	function employee_Db_Click(rowId)
	{
		url ='/employee/findById';
		var rowData = jQuery("#employee-detail-grid-list").getRowData(rowId); 
		var employeeId = rowData['employeeId'];
		
		$.ajax({
			url :url,
			 type: "POST",
			 async:false,
			 data:{employeeId : employeeId},
			 success : function(data) {
				 employee_Set_FormData(data);
				 var myElem = document.getElementById('employee-delete-btn');
				 if (myElem == null)
				 {
					 $("#employee-save-btn").after("<input type='button' id='employee-delete-btn' style='margin-left: 1%;' class='btn' value='Delete' onclick='employee_DeleteEmployee() ;'/>");
				 }
			 }
		});
	}
	
	/**
	 * Set Form Data while get record from db
	 * @param data
	 */
	function employee_Set_FormData(data)
	{
		$("#employee_employeeId").val(data.employeeId);
		$("#employee_name").val(data.employeeName);
		$("#employee_fatherName").val(data.fatherName);
		$("#employee_contactNo").val(data.contactNo);
		$("#employee_email").val(data.email);
		$("#employee_address").val(data.address);
		$("#employee_designation").val(data.designation);
		$("#employee_salaryType").val(data.salaryType);
	    $("#employee_salary").val(data.salary);
		$("#employee_overtimeAmount").val(data.overtimeAmount);
		$("#employee_publicHolidayAmount").val(data.publicHolidayAmount);
		pageAniamateScroll();
	}
	
	/**
	 * Delete Record from db while click on Delete Button
	 */
	function employee_DeleteEmployee() 
	{
		common_delete("employee");
	}