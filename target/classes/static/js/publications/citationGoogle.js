/**
 * Submit Form while Save/Update
 */
	function citationGoogle_Crud(event)
	{
		var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
		var flag = validateForm();
		if(flag)
		{
			url ='/QEC_HEC_SU/qec/google/save.htm';
			var citationGoogleData = {}
			$('#citationGoogle_form input, #citationGoogle_form select, #citationGoogle_form textarea').each(function (index)
			{
				if($(this).attr('name') != undefined && $(this).attr('id') != undefined)
				{
					citationGoogleData[$(this).attr('name')] = $("#"+$(this).attr('id')).val();
				}

			});
			event.preventDefault();
			$.ajax({
				url :url,
				 type: "POST",
		         contentType: "application/json",
				 data: JSON.stringify(citationGoogleData),
				 
		         beforeSend: function(xhr) {
		             xhr.setRequestHeader("Accept", "application/json");
		             xhr.setRequestHeader("Content-Type", "application/json");
		             xhr.setRequestHeader(header, token);
		         },
				 async:false,
				 success : function(data) {
					if(data != undefined) {
						jQuery("#google-detail-grid-list").trigger("reloadGrid");
						toaster_success(data);
						citationGoogle_Clear_FromData();
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
	
	function citationGoogle_Clear_FromData()
	{
		clearFields("citationGoogle_form");
		remove_child_Elements('citationGoogle-delete-btn');
	}
	
	function citationGoogle_Db_Click(rowId)
	{
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		url ='/QEC_HEC_SU/qec/google/returnCitationGoogleById';
		var rowData = jQuery("#google-detail-grid-list").getRowData(rowId); 
		var citationGoogleId = rowData['citationGoogleId'];
//		event.preventDefault();
		$.ajax({
			url :url,
			 type: "POST",
			 data:{citationGoogleId : citationGoogleId},
			 async:false,
	         beforeSend: function(xhr) {
	             xhr.setRequestHeader(header, token);
	         },
			 async:false,
			 success : function(data) {
				citationGoogle_Set_FormData(data);
				citationGoogle_loadGoogle();
				var myElem = document.getElementById('citationGoogle-delete-btn');
				if (myElem == null)
				{
					$("#citationGoogle-save-btn").after("<input type='button' id='citationGoogle-delete-btn' style='margin-left: 1%;' class='btn' value='Delete' onclick='citationGoogle_DeleteCitationGoogle() ;'/>");
				}
			 }
		});
	}
	
	
	function citationGoogle_Set_FormData(data)
	{
		$("#citationGoogle_citationGoogleId").val(data.citationGoogleId);
		$("#google_employeeId").val(data.employeeId);
		$("#google_url").val(data.url);
		pageAniamateScroll();
		$("#google_content").html("");
	}
	
	function citationGoogle_DeleteCitationGoogle()
	{
		var result = confirm("Do you want to Delete?");
		if(result)
		{
			var token = $("meta[name='_csrf']").attr("content");
		    var header = $("meta[name='_csrf_header']").attr("content");
			url ='/QEC_HEC_SU/qec/google/deleteCitationGoogleById';
			var citationGoogleId = $("#citationGoogle_citationGoogleId").val();
			
			//event.preventDefault();
			$.ajax({
				 url :url,
				 type: "POST",
		         data:{citationGoogleId : citationGoogleId},
				 async:false,
				 beforeSend: function(xhr) 
		         { 
					 xhr.setRequestHeader(header, token);
		         },
				 success : function(data) {
					if(data != undefined) {
						jQuery("#google-detail-grid-list").trigger("reloadGrid");
						toaster_success(data);
						citationGoogle_Clear_FromData();
					}
					else {
						toaster_error(data);
					}
				}
			});
		}
	}
	
	
	function citationGoogle_loadGoogle()
	{
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		url ='/QEC_HEC_SU/qec/google/returnGoogleData';
		var googleUrl = $("#google_url").val();
//		event.preventDefault();
		$.ajax({
			url :url,
			 type: "POST",
			 data:{googleUrl : googleUrl},
			 async:false,
	         beforeSend: function(xhr) {
	             xhr.setRequestHeader(header, token);
	         },
			 async:false,
			 success : function(data) {
				$("#google_content").html(data);
			 }
		});
	}