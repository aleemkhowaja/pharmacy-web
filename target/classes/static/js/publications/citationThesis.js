/**
 * Submit Form while Save/Update
 */
	function citationThesis_Crud(event)
	{
		var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
		var flag = validateForm();
		if(flag)
		{
			url ='/QEC_HEC_SU/qec/thesis/save.htm';
			event.preventDefault();
			$.ajax({
				url :url,
				 type: "POST",
		         data: new FormData(document.getElementById("citationThesis_form")),
		         beforeSend: function(xhr) {
		             xhr.setRequestHeader(header, token);
		         },
		         enctype: 'multipart/form-data',
		         processData: false,
		         contentType: false,
				 async:false,
				 success : function(data) {
					if(data != undefined) {
						jQuery("#thesis-detail-grid-list").trigger("reloadGrid");
						toaster_success(data);
						citationThesis_Clear_FromData();
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
	
	function citationThesis_Clear_FromData()
	{
		clearFields("citationThesis_form");
		remove_child_Elements('citationThesis-delete-btn');
	}
	
	function citationThesis_Db_Click(rowId)
	{
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		url ='/QEC_HEC_SU/qec/thesis/returnCitationThesisById';
		var rowData = jQuery("#thesis-detail-grid-list").getRowData(rowId); 
		var citationThesisId = rowData['citationThesisId'];
//		event.preventDefault();
		$.ajax({
			url :url,
			 type: "POST",
			 data:{citationThesisId : citationThesisId},
			 async:false,
	         beforeSend: function(xhr) {
	             xhr.setRequestHeader(header, token);
	         },
			 async:false,
			 success : function(data) {
				citationThesis_Set_FormData(data);
				var myElem = document.getElementById('citationThesis-delete-btn');
				if (myElem == null)
				{
					$("#citationThesis-save-btn").after("<input type='button' id='citationThesis-delete-btn' style='margin-left: 1%;' class='btn' value='Delete' onclick='citationThesis_DeleteCitationThesis() ;'/>");
				}
			 }
		});
	}
	
	function citationThesis_Set_FormData(data)
	{
		$("#citationThesis_citationThesisId").val(data.citationThesisId);
		$("#citationThesis_employeeId").val(data.employeeId);
		$("#citationThesis_title").val(data.title);
		$("#citationThesis_url").val(data.url);
		$("#citationThesis_author").val(data.authors);
		$("#citationThesis_publication_date").val(data.publicationDate);
		$("#citationThesis_institution").val(data.institution);
		$("#citationThesis_description").val(data.description);
		pageAniamateScroll();
	}
	
	function citationThesis_DeleteCitationThesis()
	{
		var result = confirm("Do you want to Delete?");
		if(result)
		{
			var token = $("meta[name='_csrf']").attr("content");
		    var header = $("meta[name='_csrf_header']").attr("content");
			url ='/QEC_HEC_SU/qec/thesis/deleteCitationThesisById';
			var citationThesisId = $("#citationThesis_citationThesisId").val();
			
			//event.preventDefault();
			$.ajax({
				url :url,
				 type: "POST",
		         data:{citationThesisId : citationThesisId},
				 async:false,
				 beforeSend: function(xhr) 
		         {
					 xhr.setRequestHeader(header, token);
		         },
				 success : function(data) {
					if(data != undefined) {
						jQuery("#thesis-detail-grid-list").trigger("reloadGrid");
						toaster_success(data);
						citationThesis_Clear_FromData();
					}
					else {
						toaster_error(data);
					}
				}
			});
		}
	}