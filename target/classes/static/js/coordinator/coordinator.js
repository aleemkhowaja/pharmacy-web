/**
 * Submit Form while Save/Update
 */
function coordinator_Crud(event)
{
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
	var flag = validateForm();
	if(flag)
	{	
		url ='/QEC_HEC_SU/qec/coordinator/save.htm';
		var usersData = {};
		$('#users_form input, #users_form select, #users_form textarea').each(function (index)
		{
			if($(this).attr('name') != undefined && $(this).attr('id') != undefined)
			{
				usersData[$(this).attr('name')] = $("#"+$(this).attr('id')).val();
			}
		});		
		event.preventDefault();
		$.ajax({
			url :url,
			 type: "POST",
	         contentType: "application/json",
	         data: new FormData(document.getElementById("users_form")),
			
	         beforeSend: function(xhr) 
	         {
	             xhr.setRequestHeader(header, token);
	         },
	         enctype: 'multipart/form-data',
	         processData: false,
	         contentType: false,
			 async:false,
			 success : function(data) 
			 {
				if(data != undefined)
				{
					jQuery("#users-detail-grid-list").trigger("reloadGrid");
					if(data == "Duplicate")
					{
						toaster_error("Username Already Exist");
					}
					else
					{
						toaster_success(data);
						users_Clear_FromData();
					}
				}
				else {
					toaster_error(data);
				}
			}
		});
	}
	event.preventDefault();
	return flag;
}

/**
 * get record and set data in form while double click on Grid Row
 * @param rowId
 */
function coordinator_Db_Click(rowId)
{
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
	url ='/QEC_HEC_SU/qec/coordinator/returnCoordinatorById';
	var rowData = jQuery("#users-detail-grid-list").getRowData(rowId); 
	var userId = rowData['userId'];
	//event.preventDefault();
	$.ajax({
		url :url,
		 type: "POST",
		 async:false,
		 data:{userId : userId},
		 beforeSend: function(xhr) 
         {
			 xhr.setRequestHeader(header, token);
         },
		 success : function(data) {
			 users_Set_FormData(data);
			 var myElem = document.getElementById('users-delete-btn');
				if (myElem == null)
				{
					$("#users-save-btn").after("<input type='button' id='users-delete-btn' style='margin-left: 1%;' class='btn' value='Delete' onclick='users_DeleteUsers() ;'/>");
				}
		 }
	});
}

/**
 * Set Form Data while get record from db
 * @param data
 */
function users_Set_FormData(data)
{
	$("#users_departmentId").val(data.departmentId);
	users_returnEmployeeListAndProgramListByDepartmentId();
	$("#users_roleId").val(data.role);
	$("#users_userId").val(data.userId);
	$("#users_username").val(data.username);
	$("#users_oldUsername").val(data.username);
	$("#users_fullName").val(data.fullName);
	$("#users_Email").val(data.email);
	$("#users_password").val(data.password);
	if(data.isActive)
	{
		$("#users_status").val("true");
	}
	else
	{
		$("#users_status").val("false");
	}
	
	$("#users_employee").val(data.employeeId);
	$("#users_campusId").val(data.campusesId);
	$("#users_programId").val(data.programId);
	users_changeRole();
	pageAniamateScroll();
}
/**
 * clear form 
 */
function users_Clear_FromData()
{
	clearFields("users_form");
	//remove Delete button after update/ delete operation
	remove_child_Elements('users-delete-btn');
	addValidationClass('users_form', 'coordinator_data_upload_file', 'validate-required');
}


/**
 * Delete Record from db while click on Delete Button
 */
function users_DeleteUsers() 
{
	
	var result = confirm("Do you want to Delete?");
	if(result)
	{
		var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
		url ='/QEC_HEC_SU/qec/coordinator/deleteCoordinatorById';
		var usersData = {};
		usersData['userId'] = $("#users_userId").val();
		//event.preventDefault();
		$.ajax({
			url :url,
			 type: "POST",
	         contentType: "application/json",
			 data: JSON.stringify(usersData),
			 beforeSend: function(xhr) {
	        	 xhr.setRequestHeader(header, token);
	         },
	         /*beforeSend: function(xhr) {
	             xhr.setRequestHeader("Accept", "application/json");
	             xhr.setRequestHeader("Content-Type", "application/json");
	         },*/
			 async:false,
			 success : function(data) 
			 {
				if(data != undefined) 
				{
					jQuery("#users-detail-grid-list").trigger("reloadGrid");
					toaster_success(data);
					users_Clear_FromData();
				}
				else {
					toaster_error(data);
				}
			 }
		});
	}
	//event.preventDefault();
}

/**
 * change Role
 */
function users_changeRole()
{
	var role = $("#users_roleId").val();
	
	if(role == "PTMember")
	{
		$("#users_programIdDiv").show();
	}
	else
	{
		$("#users_programIdDiv").hide();
	}
}

function users_returnEmployeeListAndProgramListByDepartmentId()
{
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	url ='/QEC_HEC_SU/qec/coordinator/returnEmployeeListAndProgramListByDepartmentId';
	var departmentId = $("#users_departmentId").val();
	$.ajax({
		url :url,
		 type: "POST",
		 data:{departmentId : departmentId},
		 async:false,
         beforeSend: function(xhr) 
         {
             xhr.setRequestHeader(header, token);
         },
		 async:false,
		 success : function(data) 
		 {
			 users_loadEmployeeComboBox(data.employeeDTOs);
			 users_loaduniProgramComboBox(data.uniProgramsDTOs);
			 
		 }
	});
}

/**
 * return all employee combobox
 * @param data
 */
function users_loadEmployeeComboBox(data)
{
	$("#users_employee").find('option').not(':first').remove();
	
	$(data).each(function(){
		//this refers to the current item being iterated over
		var option = $('<option />');
		option.attr('value', this.employeeId).text(this.fullName);

		$('#users_employee').append(option);
	});
}

function users_loaduniProgramComboBox(data)
{
	$("#users_programId").find('option').not(':first').remove();
		
	$(data).each(function(){
		//this refers to the current item being iterated over

		var option = $('<option />');
		option.attr('value', this.uniProgramsId).text(this.name);

		$('#users_programId').append(option);
	});
}