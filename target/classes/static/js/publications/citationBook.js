/**
 * Submit Form while Save/Update
 */
	function citationBook_Crud(event)
	{
		
		var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
		var flag = validateForm();
		if(flag)
		{
			url ='/QEC_HEC_SU/qec/book/save.htm';
			event.preventDefault();
			$.ajax({
				url :url,
				 type: "POST",
		         data: new FormData(document.getElementById("citationBook_form")),
		         beforeSend: function(xhr) {
		             xhr.setRequestHeader(header, token);
		         },
		         enctype: 'multipart/form-data',
		         processData: false,
		         contentType: false,
				 async:false,
				 success : function(data) {
					if(data != undefined) {
						jQuery("#book-detail-grid-list").trigger("reloadGrid");
						toaster_success(data);
						citationBook_Clear_FromData();
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
	
	function citationBook_Clear_FromData()
	{
		clearFields("citationBook_form");
		remove_child_Elements('citationBook-delete-btn');
	}
	
	function citationBook_Db_Click(rowId)
	{
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		url ='/QEC_HEC_SU/qec/book/returnCitationBookById';
		var rowData = jQuery("#book-detail-grid-list").getRowData(rowId); 
		var citationBookId = rowData['citationBookId'];
//		event.preventDefault();
		$.ajax({
			url :url,
			 type: "POST",
			 data:{citationBookId : citationBookId},
			 async:false,
	         beforeSend: function(xhr) {
	             xhr.setRequestHeader(header, token);
	         },
			 async:false,
			 success : function(data) {
				citationBook_Set_FormData(data);
				var myElem = document.getElementById('citationBook-delete-btn');
				if (myElem == null)
				{
					$("#citationBook-save-btn").after("<input type='button' id='citationBook-delete-btn' style='margin-left: 1%;' class='btn' value='Delete' onclick='citationBook_DeleteCitationBook() ;'/>");
				}
			 }
		});
	}
	
	
	function citationBook_Set_FormData(data)
	{
		$("#citationBook_citationBookId").val(data.citationBookId);
		$("#citationBook_employeeId").val(data.employeeId);
		$("#citationBook_title").val(data.title);
		$("#citationBook_url").val(data.url);
		$("#citationBook_author").val(data.authors);
		$("#citationBook_publication_date").val(data.publicationDate);
		$("#citationBook_book").val(data.book);
		$("#citationBook_volume").val(data.volume);
		$("#citationBook_issue").val(data.issue);
		$("#citationBook_pages").val(data.pages);
		$("#citationBook_publisher").val(data.publisher);
		$("#citationBook_description").val(data.description);
		pageAniamateScroll();
	}
	
	function citationBook_DeleteCitationBook()
	{
		var result = confirm("Do you want to Delete?");
		if(result)
		{
			var token = $("meta[name='_csrf']").attr("content");
		    var header = $("meta[name='_csrf_header']").attr("content");
			url ='/QEC_HEC_SU/qec/book/deleteCitationBookById';
			var citationBookId = $("#citationBook_citationBookId").val();
			//event.preventDefault();
			$.ajax({
				url :url,
				 type: "POST",
		         data:{citationBookId : citationBookId},
				 async:false,
				 beforeSend: function(xhr) 
		         {
					 xhr.setRequestHeader(header, token);
		         },
				 success : function(data) {
					if(data != undefined) {
						jQuery("#book-detail-grid-list").trigger("reloadGrid");
						toaster_success(data);
						citationBook_Clear_FromData();
					}
					else {
						toaster_error(data);
					}
				}
			});
		}
	}