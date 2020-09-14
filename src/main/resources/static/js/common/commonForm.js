/**
 * save/update
 * @param controllerName = controller request mapping name;
 * @param datajson = form json
 * @param event event of button
 * @returns flag if it is validated 
 */
function common_save(controllerName, dataJson, event)
{
	var formId = controllerName+"_form";
	
	var flag = validateForm(formId);
	if(flag)
	{
		url ='/'+controllerName+'/save';
		event.preventDefault();
		$.ajax({
			url :url,
			 type: "POST",
			 contentType: "application/json",
	         data: JSON.stringify(dataJson),
	         processData: false,
			 async:false,
			 dataType: 'json',
		     cache: false,
			 success : function(data) {
				if(data != undefined) {
					jQuery("#"+controllerName+"-detail-grid-list").trigger("reloadGrid");
					toaster_success("Record Saved Successfully");
					
					//clear form
					clear_FromData(controllerName);
					
					//remove delete button after deouble click 
					remove_child_Elements(controllerName+'-delete-btn');
					
					//remove detail button after deouble click 
					remove_child_Elements(controllerName+'-details-btn');
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
 * 
 * @param controllerName controller request mapping name;
 * @returns
 */
function common_delete(controllerName) 
{
	var result = confirm("Do you want to Delete?");
	if(result)
	{
		url ='/'+controllerName+'/delete';
		var id = $("#"+controllerName+"_"+controllerName+"Id").val();
		
		$.ajax({
			url :url,
			 type: "POST",
	         data:{id : id},
			 async:false,
			 success : function(data) 
			 {
				if(data != undefined) {
					jQuery("#"+controllerName+"-detail-grid-list").trigger("reloadGrid");
					toaster_success("Record Deleted Successfully");
					clear_FromData(controllerName);
				}
				else {
					toaster_error(data);
				}
			}
		});
	}
}


/**
 * Clear form after save/Update/Delete 
 */

/**
 * Clear form after save/Update/Delete 
 * @param controllerName
 * @returns
 */
function clear_FromData(controllerName)
{
	clearFields(""+controllerName+"_form");
	remove_child_Elements(''+controllerName+'-delete-btn');
}

/**
 * check if empty form
 * @param value
 * @returns
 */
function common_isEmpty(value)
{
	if(value == null || typeof value == "undefined" || value == "")
		return true;
}