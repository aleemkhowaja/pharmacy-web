/**
 * Submit Form while Save/Update
 */
	function citationConference_Crud(event)
	{
		var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
		var flag = validateForm();
		if(flag)
		{
			url ='/QEC_HEC_SU/qec/conference/save.htm';
			event.preventDefault();
			$.ajax({
				url :url,
				 type: "POST",
		         data: new FormData(document.getElementById("citationConference_form")),
		         beforeSend: function(xhr) {
		             xhr.setRequestHeader(header, token);
		         },
		         enctype: 'multipart/form-data',
		         processData: false,
		         contentType: false,
				 async:false,
				 success : function(data) {
					if(data != undefined) {
						jQuery("#conference-detail-grid-list").trigger("reloadGrid");
						toaster_success(data);
						citationConference_Clear_FromData();
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
	
			
			/*var citationConferenceData = {}
			$('#citationConference_form input, #citationConference_form select, #citationConference_form textarea').each(function (index)
			{
				if($(this).attr('name') != undefined && $(this).attr('id') != undefined)
				{
					citationConferenceData[$(this).attr('name')] = $("#"+$(this).attr('id')).val();
				}

			});
	
			event.preventDefault();
			$.ajax({
				url :url,
				 type: "POST",
		         contentType: "application/json",
				 data: JSON.stringify(citationConferenceData),
				 
		         beforeSend: function(xhr) {
		             xhr.setRequestHeader("Accept", "application/json");
		             xhr.setRequestHeader("Content-Type", "application/json");
		             xhr.setRequestHeader(header, token);
		         },
				 async:false,
				 success : function(data) {
					if(data != undefined) {
						jQuery("#conference-detail-grid-list").trigger("reloadGrid");
						toaster_success(data);
						citationConference_Clear_FromData();
					}
					else {
						toaster_error(data);
					}
				}
			});
*/	
	function citationConference_Clear_FromData()
	{
		clearFields("citationConference_form");
		remove_child_Elements('citationConference-delete-btn');
	}
	
	function citationConference_Db_Click(rowId)
	{
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		url ='/QEC_HEC_SU/qec/conference/returnCitationConferenceById';
		var rowData = jQuery("#conference-detail-grid-list").getRowData(rowId); 
		var citationConferenceId = rowData['citationConferenceId'];
//		event.preventDefault();
		$.ajax({
			url :url,
			 type: "POST",
			 data:{citationConferenceId : citationConferenceId},
			 async:false,
	         beforeSend: function(xhr) {
	             xhr.setRequestHeader(header, token);
	         },
			 async:false,
			 success : function(data) {
				citationConference_Set_FormData(data);
				var myElem = document.getElementById('citationConference-delete-btn');
				if (myElem == null)
				{
					$("#citationConference-save-btn").after("<input type='button' id='citationConference-delete-btn' style='margin-left: 1%;' class='btn' value='Delete' onclick='citationConference_DeleteCitationConference() ;'/>");
				}
			 }
		});
	}
	
	
	function citationConference_Set_FormData(data)
	{
		$("#citationConference_citationConferenceId").val(data.citationConferenceId);
		$("#citationConference_employeeId").val(data.employeeId);
		$("#citationConference_title").val(data.title);
		$("#citationConference_url").val(data.url);
		$("#citationConference_author").val(data.authors);
		$("#citationConference_publication_date").val(data.publicationDate);
		$("#citationConference_conference").val(data.conference);
		$("#citationConference_volume").val(data.volume);
		$("#citationConference_issue").val(data.issue);
		$("#citationConference_pages").val(data.pages);
		$("#citationConference_publisher").val(data.publisher);
		$("#citationConference_description").val(data.description);
		$("#citationConference_impactFactor").val(data.impactFactor);
		$("#citationConference_impactFactorValue").val(data.impactFactorValue);
		$("#citationConference_hecRecognize").val(data.hecRecognize);
		pageAniamateScroll();
	}
	
	function citationConference_DeleteCitationConference()
	{
		var result = confirm("Do you want to Delete?");
		if(result)
		{
			var token = $("meta[name='_csrf']").attr("content");
		    var header = $("meta[name='_csrf_header']").attr("content");
			url ='/QEC_HEC_SU/qec/conference/deleteCitationConferenceById';
			var citationConferenceId = $("#citationConference_citationConferenceId").val();
			
			//event.preventDefault();
			$.ajax({
				url :url,
				 type: "POST",
		         data:{citationConferenceId : citationConferenceId},
				 async:false,
				 beforeSend: function(xhr) 
		         {
					 xhr.setRequestHeader(header, token);
		         },
				 success : function(data) {
					if(data != undefined) {
						jQuery("#conference-detail-grid-list").trigger("reloadGrid");
						toaster_success(data);
						citationConference_Clear_FromData();
					}
					else {
						toaster_error(data);
					}
				}
			});
		}
	}