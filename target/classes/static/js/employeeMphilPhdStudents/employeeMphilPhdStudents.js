/**
 * Submit Form while Save/Update
 */
	function employeeMphilPhdStudent_Crud(event)
	{
		var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
		var flag = validateForm();
		if(flag)
		{
			url ='/QEC_HEC_SU/qec/employeeMphilPhdStudents/save.htm';
			/*var employeeTrainingData = {}
			$('#employeeTraining_form input, #employeeTraining_form select, #employeeTraining_form textarea').each(function (index)
			{
				if($(this).attr('name') != undefined && $(this).attr('id') != undefined)
				{
					employeeTrainingData[$(this).attr('name')] = $("#"+$(this).attr('id')).val();
				}
			});
			console.log(employeeTrainingData);*/
			event.preventDefault();
			$.ajax({
				url :url,
				 type: "POST",
		         contentType: "application/json",
				 data: new FormData(document.getElementById("employeeMphilPhdStudent_form")),
		         beforeSend: function(xhr) {
		             xhr.setRequestHeader(header, token);
		         },
		         enctype: 'multipart/form-data',
		         processData: false,
		         contentType: false,
				 success : function(data) {
					if(data != undefined) {
						toaster_success(data);
						employeeMphilPhdStudent_Clear_FromData();
					}
					else {
						toaster_error(data);
					}
				}
			});
		}
		event.preventDefault();
		return true;
	}
	
	/**
	 * Clear Form Data
	 */
	function employeeMphilPhdStudent_Clear_FromData()
	{
		clearFields("employeeMphilPhdStudent_form");
		remove_child_Elements('employeeMphilPhdStudent-delete-btn');
		jQuery("#employee-mphil-phd-students-detail-grid-list").trigger("reloadGrid");
	}
	
	/**
	 * Dbclick of record from grid and set data in form
	 * @param rowId
	 */
	function employeeMphilPhdStudent_Db_Click(rowId)
	{
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		url ='/QEC_HEC_SU/qec/employeeMphilPhdStudents/returnEmployeeMphilPhdStudentsById';
		var rowData = jQuery("#employee-mphil-phd-students-detail-grid-list").getRowData(rowId); 
		var employeeMphilPhdStudentsId = rowData['employeeMphilPhdStudentsId'];
//		event.preventDefault();
		$.ajax({
			url :url,
			 type: "POST",
			 data:{employeeMphilPhdStudentsId : employeeMphilPhdStudentsId},
			 async:false,
	         beforeSend: function(xhr) {
	             xhr.setRequestHeader(header, token);
	         },
			 async:false,
			 success : function(data) {
				employeeMphilPhdStudents_Set_FormData(data);
				var myElem = document.getElementById('employeeMphilPhdStudent-delete-btn');
				if (myElem == null)
				{
					$("#employeeMphilPhdStudent-save-btn").after("<input type='button' id='employeeMphilPhdStudent-delete-btn' style='margin-left: 1%;' class='btn' value='Delete' onclick='employeeMphilPhdStudents_delete();'/>");
				}
			 }
		});
	}
	
	function employeeMphilPhdStudents_Set_FormData(data)
	{
		$("#employeeMphilPhdStudent_employeeMphilPhdStudentsId").val(data.employeeMphilPhdStudentsId);
		$("#employeeMphilPhdStudent_employeeId").val(data.employeeId);
		$("#employeeMphilPhdStudent_departmentId").val(data.departmentId);
		$("#employeeMphilPhdStudent_studentName").val(data.studentName);
		$("#employeeMphilPhdStudent_gender").val(data.gender);
		$("#employeeMphilPhdStudent_degreeType").val(data.dtype);
		$("#employeeMphilPhdStudent_startDate").val(data.startDate);
		$("#employeeMphilPhdStudent_registrationDate").val(data.registrationDate);
		$("#employeeMphilPhdStudent_studentId").val(data.studentId);
		$("#employeeMphilPhdStudent_approvedTopic").val(data.approvedTopic);
		pageAniamateScroll();
	}
	
	function employeeMphilPhdStudents_delete()
	{
		var result = confirm("Do you want to Delete?");
		if(result)
		{
			var token = $("meta[name='_csrf']").attr("content");
		    var header = $("meta[name='_csrf_header']").attr("content");
			url ='/QEC_HEC_SU/qec/employeeMphilPhdStudents/deleteEmployeeMphilPhdStudentsById';
			var employeeMphilPhdStudentsId = $("#employeeMphilPhdStudent_employeeMphilPhdStudentsId").val();
			//event.preventDefault();
			$.ajax({
				url :url,
				 type: "POST",
		         data:{employeeMphilPhdStudentsId : employeeMphilPhdStudentsId},
				 async:false,
				 beforeSend: function(xhr) 
		         {
					 xhr.setRequestHeader(header, token);
		         },
				 success : function(data) {
					if(data != undefined) {
						toaster_success(data);
						employeeMphilPhdStudent_Clear_FromData();
					}
					else {
						toaster_error(data);
					}
				}
			});
		}
	}