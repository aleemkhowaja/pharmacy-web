/**
 * Submit Form while Save/Update
 */
function event_Crud(event)
{
	var flag = validateForm();
	if(flag)
	{	
		var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
		url ='/QEC_HEC_SU/qec/events/save.htm';
		var eventsData = {};
		eventsData['departmentId'] = $("#events_departmentId").val();
		eventsData['eventsId'] =$("#events_eventsId").val() || null;
		eventsData['eventTitle'] =$("#events_eventTitle").val();
		eventsData['dateof'] =$("#events_dateof").val();
		eventsData['endDate'] = $("#events_endDate").val();
		eventsData['quota'] = $("#events_quota").val();
		eventsData['eventDetail'] = $("#events_eventDetail").val();
		var formData = $("#events_form").serialize();
		event.preventDefault();

		$.ajax({
            url: url,
            type: "POST",
            data: new FormData(document.getElementById("events_form")),
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
        		  events_Clear_FromData();
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
	
/**
 *  get record and set data in form while double click on Grid Row
 * @param rowId
 * @returns
 */
function events_Db_Click(rowId)
{
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    
	url ='/QEC_HEC_SU/qec/events/returnEventByEventId';
	var rowData = jQuery("#events-detail-grid-list").getRowData(rowId); 
	var eventsId = rowData['eventsId'];
	$.ajax({
		url :url,
		 type: "POST",
		 async:false,
		 data:{eventsId : eventsId,},
		 beforeSend: function(xhr) 
         {
			 xhr.setRequestHeader(header, token);
         },
		 success : function(data) {
			 events_Set_FormData(data);
			 var myElem = document.getElementById('events-delete-btn');
			 if (myElem == null)
			 {
				 $("#events-save-btn").after("<input type='button' id='events-delete-btn' style='margin-left: 1%;' class='btn' value='Delete' onclick='events_deleteEvents() ;'/>");
				 //$("#qec_downloadEvent").html("<a href='/QEC_HEC_SU/qec/events/downloadEvent'>Click here to download file</a>");
				 $("#qec_downloadEvent").html("<input type='button' id='events-download-btn' style='margin-left: 1%;' class='btn' value='Download Event' onclick='events_dowloadEventFile(); '/>");
			 }
		 }
	});
}

/**
 * Set Form Data while get record from db
 * @param data
 * @returns
 */
function events_Set_FormData(data)
{
	$("#events_departmentId").val(data.departmentId)
	$("#events_eventsId").val(data.eventsId)
	$("#events_eventTitle").val(data.eventTitle)
	$("#events_dateof").val(data.dateof)
	$("#events_quota").val(data.quota)
	$("#events_eventDetail").val(data.eventDetail);
	$("#events_endDate").val(data.endDate);
	$("#events_fileName").val(data.fileName);
	pageAniamateScroll();
}

/**
 * Clear form after save/Update/Delete 
 * @returns
 */
function events_Clear_FromData()
{
	$("#events_departmentId").val("");
	$("#events_eventsId").val("");
	$("#events_eventTitle").val("");
	$("#events_dateof").val("");
	$("#events_quota").val("");
	$("#events_eventDetail").val("");
	$("#events_endDate").val("");
	$("#events_file").val("");
	remove_child_Elements('events-delete-btn');
}

/**
 * delete event record
 * @returns
 */
function events_deleteEvents() 
{
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
	url ='/QEC_HEC_SU/events/deleteEventsById';
	var eventsData = {};
	eventsData['departmentId'] = $("#events_departmentId").val();
	eventsData['eventsId'] =$("#events_eventsId").val()|| null;
	eventsData['eventTitle'] =$("#events_eventTitle").val();
	eventsData['dateof'] =$("#events_dateof").val();
	eventsData['endDate'] = $("#events_endDate").val();
	eventsData['quota'] = $("#events_quota").val();
	eventsData['eventDetail'] = $("#events_eventDetail").val();
	//event.preventDefault();
	$.ajax({
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
	});
	//event.preventDefault();
}

function events_dowloadEventFile()
{
	var fileName = $("#events_fileName").val();
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
	$.ajax({
        type: 'GET',
        url : '/QEC_HEC_SU/qec/events/downloadEvent',
/*        contentType: 'application/json; charset=UTF-8',
*/        data:{fileName : fileName},
        beforeSend: function(xhr) 
        {
			 xhr.setRequestHeader(header, token);
        },
        success: function (data) {
            // or window.location.href = data.fileUrl;
        },
        error:function (xhr, ajaxOptions, thrownError) {
            console.log("in error");
        } 
    });

}
