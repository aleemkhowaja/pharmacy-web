/**
 * Submit Form while Save/Update
 */
	function citationJournal_Crud(event)
	{
		var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
		var flag = validateForm();
		if(flag)
		{
			url ='/QEC_HEC_SU/qec/journal/save.htm';
			event.preventDefault();
			$.ajax({
				url :url,
				 type: "POST",
		         data: new FormData(document.getElementById("citationJournal_form")),
		         beforeSend: function(xhr) {
		             xhr.setRequestHeader(header, token);
		         },
		         enctype: 'multipart/form-data',
		         processData: false,
				 async:false,
		         contentType: false,
				 success : function(data) {
					if(data != undefined) {
						jQuery("#journal-detail-grid-list").trigger("reloadGrid");
						toaster_success(data);
						citationJournal_Clear_FromData();
					}
					else {
						toaster_error(data);
					}
				}
			});
			event.preventDefault();
		}
		return flag;
	}


	/**
	 * clear Form Data
	 * @returns
	 */
	function citationJournal_Clear_FromData()
	{
		clearFields("citationJournal_form");
		remove_child_Elements('citationJournal-delete-btn');
	}
	
	/**
	 * DBClick for view Record
	 * @param rowId
	 * @returns
	 */
	function citationJournal_Db_Click(rowId)
	{
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		
		url ='/QEC_HEC_SU/qec/journal/returnCitationJournalById';
		var rowData = jQuery("#journal-detail-grid-list").getRowData(rowId); 
		var citationJournalId = rowData['citationJournalId'];
		$.ajax({
			url :url,
			 type: "POST",
			 data:{citationJournalId : citationJournalId},
			 async:false,
	         beforeSend: function(xhr) {
	             xhr.setRequestHeader(header, token);
	         },
			 async:false,
			 success : function(data) {
				citationJournal_Set_FormData(data);
				var myElem = document.getElementById('citationJournal-delete-btn');
				if (myElem == null)
				{
					$("#citationJournal-save-btn").after("<input type='button' id='citationJournal-delete-btn' style='margin-left: 1%;' class='btn' value='Delete' onclick='citationJournal_DeleteCitationJournal() ;'/>");
				}
			 }
		});
	}
	
	/**
	 * set Data into Form Fields
	 * @param data
	 * @returns
	 */
	function citationJournal_Set_FormData(data)
	{
		$("#citationJournal_citationJournalId").val(data.citationJournalId);
		$("#citationJournal_employeeId").val(data.employeeId);
		$("#citationJournal_title").val(data.title);
		$("#citationJournal_url").val(data.url);
		$("#citationJournal_author").val(data.authors);
		$("#citationJournal_publication_date").val(data.publicationDate);
		$("#citationJournal_journal").val(data.journal);
		$("#citationJournal_volume").val(data.volume);
		$("#citationJournal_issue").val(data.issue);
		$("#citationJournal_pages").val(data.pages);
		$("#citationJournal_publisher").val(data.publisher);
		$("#citationJournal_description").val(data.description);
		$("#citationJournal_impactFactor").val(data.impactFactor);
		$("#citationJournal_impactFactorValue").val(data.impactFactorValue);
		$("#citationJournal_hecRecognize").val(data.hecRecognize);
		pageAniamateScroll();
	}
	
	/**
	 * Delete record
	 * @returns
	 */
	function citationJournal_DeleteCitationJournal()
	{
		var result = confirm("Do you want to Delete?");
		if(result)
		{
			var token = $("meta[name='_csrf']").attr("content");
		    var header = $("meta[name='_csrf_header']").attr("content");
			url ='/QEC_HEC_SU/qec/journal/deleteCitationJournalById';
			var citationJournalId = $("#citationJournal_citationJournalId").val();
			
			//event.preventDefault();
			$.ajax({
				url :url,
				 type: "POST",
		         data:{citationJournalId : citationJournalId},
				 async:false,
				 beforeSend: function(xhr) 
		         {
					 xhr.setRequestHeader(header, token);
		         },
				 success : function(data) {
					if(data != undefined) {
						jQuery("#journal-detail-grid-list").trigger("reloadGrid");
						toaster_success(data);
						citationJournal_Clear_FromData();
					}
					else {
						toaster_error(data);
					}
				}
			});
		}
	}