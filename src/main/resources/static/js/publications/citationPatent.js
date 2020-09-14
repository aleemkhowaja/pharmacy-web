/**
 * Submit Form while Save/Update
 */
	function citationPatent_Crud(event)
	{
		var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
		var flag = validateForm();
		if(flag)
		{
			url ='/QEC_HEC_SU/qec/patent/save.htm';
			event.preventDefault();
			$.ajax({
				url :url,
				 type: "POST",
		         data: new FormData(document.getElementById("citationPatent_form")),
		         beforeSend: function(xhr) {
		             xhr.setRequestHeader(header, token);
		         },
		         enctype: 'multipart/form-data',
		         processData: false,
		         contentType: false,
				 async:false,
				 success : function(data) {
					if(data != undefined) {
						jQuery("#patent-detail-grid-list").trigger("reloadGrid");
						toaster_success(data);
						citationPatent_Clear_FromData();
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
	
	function citationPatent_Clear_FromData()
	{
		clearFields("citationPatent_form");
		remove_child_Elements('citationPatent-delete-btn');
	}
	
	function citationPatent_Db_Click(rowId)
	{
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		url ='/QEC_HEC_SU/qec/patent/returnCitationPatentById';
		var rowData = jQuery("#patent-detail-grid-list").getRowData(rowId); 
		var citationPatentId = rowData['citationPatentId'];
//		event.preventDefault();
		$.ajax({
			url :url,
			 type: "POST",
			 data:{citationPatentId : citationPatentId},
			 async:false,
	         beforeSend: function(xhr) {
	             xhr.setRequestHeader(header, token);
	         },
			 async:false,
			 success : function(data) {
				citationPatent_Set_FormData(data);
				var myElem = document.getElementById('citationPatent-delete-btn');
				if (myElem == null)
				{
					$("#citationPatent-save-btn").after("<input type='button' id='citationPatent-delete-btn' style='margin-left: 1%;' class='btn' value='Delete' onclick='citationPatent_DeleteCitationPatent() ;'/>");
				}
			 }
		});
	}
	
	function citationPatent_Set_FormData(data)
	{
		$("#citationPatent_citationPatentId").val(data.citationPatentId);
		$("#citationPatent_employeeId").val(data.employeeId);
		$("#citationPatent_title").val(data.title);
		$("#citationPatent_url").val(data.url);
		$("#citationPatent_inventors").val(data.inventors);
		$("#citationPatent_publication_date").val(data.publicationDate);
		$("#citationPatent_patentOffice").val(data.patentOffice);
		$("#citationPatent_patentNumber").val(data.patentNumber);
		$("#citationPatent_applicationNumber").val(data.applicationNumber);
		$("#citationPatent_description").val(data.description);
		pageAniamateScroll();
	}
	
	function citationPatent_DeleteCitationPatent()
	{
		var result = confirm("Do you want to Delete?");
		if(result)
		{
			var token = $("meta[name='_csrf']").attr("content");
		    var header = $("meta[name='_csrf_header']").attr("content");
			url ='/QEC_HEC_SU/qec/patent/deleteCitationPatentById';
			var citationPatentId = $("#citationPatent_citationPatentId").val();
			
			//event.preventDefault();
			$.ajax({
				url :url,
				 type: "POST",
		         data:{citationPatentId : citationPatentId},
				 async:false,
				 beforeSend: function(xhr) 
		         {
					 xhr.setRequestHeader(header, token);
		         },
				 success : function(data) {
					if(data != undefined) {
						jQuery("#patent-detail-grid-list").trigger("reloadGrid");
						toaster_success(data);
						citationPatent_Clear_FromData();
					}
					else {
						toaster_error(data);
					}
				}
			});
		}
	}