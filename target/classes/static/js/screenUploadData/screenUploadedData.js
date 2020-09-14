/**
 * Submit Form while Save/Update
 */
function screenFileUpload_Crud(event)
{
	var flag = validateForm();
	if(flag)
	{	
		var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
		url ='/QEC_HEC_SU/qec/screenData/save.htm';
		
		event.preventDefault();

		$.ajax({
            url: url,
            type: "POST",
            data: new FormData(document.getElementById("screen_file_upload_form")),
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
        		  jQuery("#events-detail-grid-list").trigger("reloadGrid");
        		  toaster_success(data);
        	  }
        	  else 
        	  {
        		  toaster_error(data);
        	  }
          }).fail(function(jqXHR, textStatus) {
        	  toaster_error(data);
          });
		
		
		/*$.ajax({
			url :url,
			 type: "POST",
	         contentType: "application/json",
			 data: JSON.stringify(eventsData),
			
	         beforeSend: function(xhr) {
	             xhr.setRequestHeader("Accept", "application/json");
	             xhr.setRequestHeader("Content-Type", "application/json");
	             xhr.setRequestHeader(header, token);
	         },
			 async:false,
			 success : function(data) {
				if(data != undefined) {
					jQuery("#events-detail-grid-list").trigger("reloadGrid");
					toaster_success(data);
					events_Clear_FromData();
				}
				else {
					toaster_error(data);
				}
			}
		});*/
	}
	event.preventDefault();
	return flag;
}