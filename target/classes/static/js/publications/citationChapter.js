/**
 * Submit Form while Save/Update
 */
	function citationChapter_Crud(event)
	{
		var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
		var flag = validateForm();
		if(flag)
		{
			url ='/QEC_HEC_SU/qec/chapter/save.htm';
			
			event.preventDefault();
			$.ajax({
				url :url,
				 type: "POST",
		         contentType: "application/json",
		         data: new FormData(document.getElementById("citationChapter_form")),
		         beforeSend: function(xhr) {
		             xhr.setRequestHeader(header, token);
		         },
		         enctype: 'multipart/form-data',
		         processData: false,
				 async:false,
				 contentType: false,
				 success : function(data) {
					if(data != undefined) {
						jQuery("#chapter-detail-grid-list").trigger("reloadGrid");
						toaster_success(data);
						citationChapter_Clear_FromData();
					}
					else {
						toaster_error(data);
					}
				}
			});
			event.preventDefault();
			
			/*var citationChapterData = {}
			$('#citationChapter_form input, #citationChapter_form select, #citationChapter_form textarea').each(function (index)
			{
				if($(this).attr('name') != undefined && $(this).attr('id') != undefined)
				{
					citationChapterData[$(this).attr('name')] = $("#"+$(this).attr('id')).val();
				}

			});
	
			event.preventDefault();
			$.ajax({
				url :url,
				 type: "POST",
		         contentType: "application/json",
				 data: JSON.stringify(citationChapterData),
				 
		         beforeSend: function(xhr) {
		             xhr.setRequestHeader("Accept", "application/json");
		             xhr.setRequestHeader("Content-Type", "application/json");
		             xhr.setRequestHeader(header, token);
		         },
				 async:false,
				 success : function(data) {
					if(data != undefined) {
						jQuery("#chapter-detail-grid-list").trigger("reloadGrid");
						toaster_success(data);
						citationChapter_Clear_FromData();
					}
					else {
						toaster_error(data);
					}
				}
			});*/
		}
		event.preventDefault();
		return true;
	}
	
	function citationChapter_Clear_FromData()
	{
		clearFields("citationChapter_form");
		remove_child_Elements('citationChapter-delete-btn');
	}
	
	function citationChapter_Db_Click(rowId)
	{
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		url ='/QEC_HEC_SU/qec/chapter/returnCitationChapterById';
		var rowData = jQuery("#chapter-detail-grid-list").getRowData(rowId); 
		var citationChapterId = rowData['citationChapterId'];
//		event.preventDefault();
		$.ajax({
			url :url,
			 type: "POST",
			 data:{citationChapterId : citationChapterId},
	         beforeSend: function(xhr) {
	             xhr.setRequestHeader(header, token);
	         },
			 async:false,
			 success : function(data) {
				citationChapter_Set_FormData(data);
				var myElem = document.getElementById('citationChapter-delete-btn');
				if (myElem == null)
				{
					$("#citationChapter-save-btn").after("<input type='button' id='citationChapter-delete-btn' style='margin-left: 1%;' class='btn' value='Delete' onclick='citationChapter_DeleteCitationChapter() ;'/>");
				}
			 }
		});
	}
	
	
	function citationChapter_Set_FormData(data)
	{
		$("#citationChapter_citationChapterId").val(data.citationChapterId);
		$("#citationChapter_employeeId").val(data.employeeId);
		$("#citationChapter_title").val(data.title);
		$("#citationChapter_url").val(data.url);
		$("#citationChapter_author").val(data.authors);
		$("#citationChapter_publication_date").val(data.publicationDate);
		$("#citationChapter_book").val(data.book);
		$("#citationChapter_volume").val(data.volume);
		$("#citationChapter_issue").val(data.issue);
		$("#citationChapter_pages").val(data.pages);
		$("#citationChapter_publisher").val(data.publisher);
		$("#citationChapter_description").val(data.description);
		pageAniamateScroll();
	}
	
	function citationChapter_DeleteCitationChapter()
	{
		var result = confirm("Do you want to Delete?");
		if(result)
		{
			var token = $("meta[name='_csrf']").attr("content");
		    var header = $("meta[name='_csrf_header']").attr("content");
			url ='/QEC_HEC_SU/qec/chapter/deleteCitationChapterById';
			var citationChapterId = $("#citationChapter_citationChapterId").val();
			
			//event.preventDefault();
			$.ajax({
				url :url,
				 type: "POST",
		         data:{citationChapterId : citationChapterId},
				 async:false,
				 beforeSend: function(xhr) 
		         {
					 xhr.setRequestHeader(header, token);
		         },
				 success : function(data) {
					if(data != undefined) {
						jQuery("#chapter-detail-grid-list").trigger("reloadGrid");
						toaster_success(data);
						citationChapter_Clear_FromData();
					}
					else {
						toaster_error(data);
					}
				}
			});
		}
	}