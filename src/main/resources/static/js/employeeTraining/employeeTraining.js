/**
 * Submit Form while Save/Update
 */
	function employeeTraining_Crud(event)
	{
		var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
		var flag = validateForm();
		if(flag)
		{
			url ='/QEC_HEC_SU/qec/employeeTraining/save.htm';
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
				 data: new FormData(document.getElementById("employeeTraining_form")),
		         beforeSend: function(xhr) {
		             xhr.setRequestHeader(header, token);
		         },
		         enctype: 'multipart/form-data',
		         processData: false,
		         contentType: false,
				 success : function(data) {
					if(data != undefined) {
						toaster_success(data);
						employeeTraining_Clear_FromData();
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
	
	function employeeTraining_Clear_FromData()
	{
		clearFields("employeeTraining_form");
		remove_child_Elements('employeeTraining-delete-btn');
		jQuery("#employee-training-detail-grid-list").trigger("reloadGrid");
	}
	
	function employeeTraining_Db_Click(rowId)
	{
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		url ='/QEC_HEC_SU/qec/employeeTraining/returnEmployeeTrainingById';
		var rowData = jQuery("#employee-training-detail-grid-list").getRowData(rowId); 
		var employeeTrainingId = rowData['employeeTrainingsId'];
//		event.preventDefault();
		$.ajax({
			url :url,
			 type: "POST",
			 data:{employeeTrainingId : employeeTrainingId},
			 async:false,
	         beforeSend: function(xhr) {
	             xhr.setRequestHeader(header, token);
	         },
			 async:false,
			 success : function(data) {
				employeeTraining_Set_FormData(data);
				var myElem = document.getElementById('employeeTraining-delete-btn');
				if (myElem == null)
				{
					$("#employeeTraining-save-btn").after("<input type='button' id='employeeTraining-delete-btn' style='margin-left: 1%;' class='btn' value='Delete' onclick='employeeTraining_delete();'/>");
				}
			 }
		});
	}
	
	function employeeTraining_Set_FormData(data)
	{
		$("#employeeTraining_employeeTrainingId").val(data.employeeTrainingsId);
		$("#employeeTraining_employeeId").val(data.employeeId);
		$("#employeeTraining_dateof").val(data.dateof);
		$("#employeeTraining_eventName").val(data.name);
		
		if(data.trainingCondition == "Attended")
		{
			$("#trainingCondition1").attr('checked', true);
		}
		else if(data.trainingCondition == "Organized")
		{
			$("#trainingCondition2").attr('checked', true);
		}
				
		if(data.locality == "HEC")
		{
			$("#locality1").attr('checked', true);
		}
		else if(data.locality == "National")
		{
			$("#locality2").attr('checked', true);
		}
		else if(data.locality == "International")
		{
			$("#locality3").attr('checked', true);
		}
		$("#employeeTraining_institutionName").val(data.instituteName);
		pageAniamateScroll();
	}
	
	function employeeTraining_delete()
	{
		var result = confirm("Do you want to Delete?");
		if(result)
		{
			var token = $("meta[name='_csrf']").attr("content");
		    var header = $("meta[name='_csrf_header']").attr("content");
			url ='/QEC_HEC_SU/qec/employeeTraining/deleteEmployeeTrainingById';
			var employeeTrainingId = $("#employeeTraining_employeeTrainingId").val();
			
			//event.preventDefault();
			$.ajax({
				url :url,
				 type: "POST",
		         data:{employeeTrainingId : employeeTrainingId},
				 async:false,
				 beforeSend: function(xhr) 
		         {
					 xhr.setRequestHeader(header, token);
		         },
				 success : function(data) {
					if(data != undefined) {
						toaster_success(data);
						employeeTraining_Clear_FromData();
					}
					else {
						toaster_error(data);
					}
				}
			});
		}
	}