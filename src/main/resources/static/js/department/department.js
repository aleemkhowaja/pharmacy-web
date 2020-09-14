/**
 * Submit Form while Save/Update
 */
	function department_crud(event)
	{
		var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
		var flag = validateForm();
		if(flag)
		{
			url ='/QEC_HEC_SU/department/save.htm';
			/*var departmentData = {};
			departmentData['facultyId'] = $("#department_facultyId").val();
			departmentData['name'] = $("#department_departmentName").val();
			departmentData['detail'] = $("#department_description").val();
			departmentData['departmentId'] = $("#department_departmentId").val();
			departmentData['isDeleted'] = false;*/
			
			event.preventDefault();
			
			$.ajax({
	            url: url,
	            type: "POST",
	            data: new FormData(document.getElementById("department_form")),
	            beforeSend: function(xhr) {
		             xhr.setRequestHeader(header, token);
		         },
	            enctype: 'multipart/form-data',
	            processData: false,
	            contentType: false
	          }).done(function(data) 
	          {
	        	  if(data != undefined) 
	        	  {
	        		  jQuery("#department-detail-grid-list").trigger("reloadGrid");
						toaster_success(data);
						department_Clear_FromData();
	        	  }
	        	  else 
	        	  {
	        		  toaster_error(data);
	        	  }
	          }).fail(function(jqXHR, textStatus) {
	        	  toaster_error(data);
	          });
			event.preventDefault();
		}
		return flag;
	}

/**
 * get record and set data in form while double click on Grid Row
 * @param rowId
 */
function department_Db_Click(rowId)
{
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
	url ='/QEC_HEC_SU/department/returnDepartmentById';
	var rowData = jQuery("#department-detail-grid-list").getRowData(rowId); 
	var departmentId = rowData['departmentId'];
	//event.preventDefault();
	$.ajax({
		url :url,
		 type: "POST",
		 async:false,
		 data:{departmentId : departmentId},
		 beforeSend: function(xhr) 
         {
			 xhr.setRequestHeader(header, token);
         },
		 success : function(data) {
			department_Set_FormData(data);
			var myElem = document.getElementById('department-delete-btn');
			if (myElem == null)
			{
				$("#department-save-btn").after("<input type='button' id='department-delete-btn' style='margin-left: 1%;' class='btn' value='Delete' onclick='department_deleteDeaprtment();'/>");
			}
		 }
	});
	
	
	
/*	$.post(url,
	beforeSend: function(xhr) 
	{
		xhr.setRequestHeader(header, token);
	},
	{
		departmentId : departmentId,
	}
	 function(data) {
		department_Set_FormData(data);
		
		var myElem = document.getElementById('department-delete-btn');
		if (myElem == null)
		{
			$("#department-save-btn").after("<input type='button' id='department-delete-btn' style='margin-left: 1%;' class='btn' value='Delete' onclick='department_deleteDeaprtment();'/>");
		}
		
	});*/
}

/**
 * Delete Record from db while click on Delete Button
 */
function department_deleteDeaprtment() 
{
	var result = confirm("Do you want to Delete?");
	if(result)
	{
		var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
		url ='/QEC_HEC_SU/department/deleteDepartmentById';
		var departmentId = $("#department_departmentId").val();
		//event.preventDefault();
		$.ajax({
			url :url,
			 type: "POST",
	         data:{departmentId : departmentId},
			 async:false,
			 beforeSend: function(xhr) 
	         {
				 xhr.setRequestHeader(header, token);
	         },
			 success : function(data) {
				if(data != undefined) {
					
					jQuery("#department-detail-grid-list").trigger("reloadGrid");
					toaster_success(data);
					department_Clear_FromData();
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
 * Set Form Data while get record from db
 * @param data
 */
function department_Set_FormData(data)
{
	$("#department_facultyId").val(data.facultyId);
	$("#department_departmentId").val(data.departmentId);
	$("#department_departmentName").val(data.name);
	$("#department_description").val(data.detail);
	pageAniamateScroll();
}

/**
 * Clear form after save/Update/Delete 
 */
function department_Clear_FromData()
{

	clearFields("department_form");
	
	//remove Delete Button
	remove_child_Elements('department-delete-btn');
	addValidationClass('department_form', 'department_data_upload_file', 'validate-required');
	
}

