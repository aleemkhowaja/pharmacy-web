/**
 * Submit Form while Save/Update
 */
//$(document).on('submit', '#uniProgram_form', function(event) {
function uniPrograms_crud(event)
{
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
	var flag = validateForm();
	if(flag)
	{
		url ='/QEC_HEC_SU/programs/save.htm';
		event.preventDefault();
		$.ajax({
			url :url,
			 type: "POST",
	         contentType: "application/json",
	         data: new FormData(document.getElementById("uniProgram_form")),
	         beforeSend: function(xhr) {
	             xhr.setRequestHeader(header, token);
	         },
	         enctype: 'multipart/form-data',
	         processData: false,
	         contentType: false,
			 async:false,
			 success : function(data) {
				if(data != undefined) {
					jQuery("#uni-programs-detail-grid-list").trigger("reloadGrid");
					toaster_success(data);
					uniPrograms_Clear_FromData();
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
function uniPrograms_Db_Click(rowId)
{
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
	url ='/QEC_HEC_SU/programs/getUniProgramsById';
	var rowData = jQuery("#uni-programs-detail-grid-list").getRowData(rowId); 
	var uniProgramsId = rowData['uniProgramsId'];
	//event.preventDefault();
	$.ajax({
		url :url,
		 type: "POST",
		 async:false,
		 data:{uniProgramsId : uniProgramsId},
		 beforeSend: function(xhr) 
         {
			 xhr.setRequestHeader(header, token);
         },
		 success : function(data) {
			 uniPrograms_Set_FormData(data);
			var myElem = document.getElementById('uniPrograms-delete-btn');
			if (myElem == null)
			{
				$("#uniPrograms-save-btn").after("<input type='button' id='uniPrograms-delete-btn' style='margin-left: 1%;' class='btn' value='Delete' onclick='uniPrograms_deleteUniPrograms() ;'/>");
			}
		 }
	});
	
}
/**
 * Set Form Data while get record from db
 * @param data
 */
function uniPrograms_Set_FormData(data)
{
	$("#uniPrograms_uniProgramsId").val(data.uniProgramsId);
	$("#uniPrograms_name").val(data.name);
	$("#uniPrograms_code").val(data.code);
	$("#uniPrograms_departmentId").val(data.departmentId);
	pageAniamateScroll();
}

/**
 * Clear form after save/Update/Delete 
 */
function uniPrograms_Clear_FromData()
{
	clearFields("uniProgram_form");
	//remove Delete Button
	remove_child_Elements('uniPrograms-delete-btn');
	addValidationClass('uniProgram_form', 'uni_program_data_upload_file', 'validate-required');
}


/**
 * Delete Record from db while click on Delete Button
 */
function uniPrograms_deleteUniPrograms() 
{
	var result = confirm("Do you want to Delete?");
	if(result)
	{
		var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
		url ='/QEC_HEC_SU/programs/deleteUniProgrmsById';
		var programsData = {};
		programsData['name'] = $("#uniPrograms_name").val();
		programsData['code'] = $("#uniPrograms_code").val();
		programsData['departmentId'] = $("#uniPrograms_departmentId").val();
		programsData['uniProgramsId'] = $("#uniPrograms_uniProgramsId").val();
		//event.preventDefault();
		$.ajax({
			url :url,
			 type: "POST",
	         contentType: "application/json",
			 data: JSON.stringify(programsData),
			 
	         beforeSend: function(xhr) {
	        	 xhr.setRequestHeader(header, token);
	         },
			 async:false,
			 success : function(data) {
				if(data != undefined) {
					
					jQuery("#uni-programs-detail-grid-list").trigger("reloadGrid");
					toaster_success(data);
					uniPrograms_Clear_FromData();
				}
				else {
					toaster_error(data);
				}
			}
		});
	}
	//event.preventDefault();
}
