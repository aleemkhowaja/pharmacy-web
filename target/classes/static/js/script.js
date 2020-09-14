/**
 * remove child elements of html
 */

function remove_child_Elements(id) 
{
    var elem = document.getElementById(id);
    if(elem != null)
    {
    	elem.parentNode.removeChild(elem);
        return false;
    }
}

function validateFloatValues()
{
	$(".validate-float-value").keypress(function (event) {
		$(this).val($(this).val().replace(/[^0-9\.]/g,''));
        if ((event.which != 46 || $(this).val().indexOf('.') != -1) && (event.which < 48 || event.which > 57)) {
            event.preventDefault();
        }
    });
	checkIfPasteCorrectData('validate-float-value');
}


function validateIntegerValues()
{
	$(".validate-integer-value").keypress(function (e) {	
		if(navigator.userAgent.indexOf("Firefox") != -1 ) {			
			var eventASCII = e.keyCode;
			if(!(eventASCII==9 || (eventASCII >= 35 && eventASCII <= 40) || eventASCII == 46 ))
				return testIntegerValues(e);
			}else{
			return testIntegerValues(e);
			}
	});
	checkIfPasteCorrectData('validate-integer-value');
}

function testIntegerValues(e)
{
	if(e.which!=8 && e.which!=13)
		if(!/^[0-9]*$/.test($(e.target).val()+String.fromCharCode(e.which))){
			return false;
		}
}

function checkIfPasteCorrectData(className)
{
	$("."+className).on("paste", function(e) {
	    var that = this;
	    that.style.color = "#fff";
	    setTimeout(function() {
	        that.value = that.value.replace(/\D/g, "");
	        that.style.color = "#000";
	    }, 100);
	});
}


function validateGenericAllRegex1()
{
	var flag=true;
	$(".validate-form .validate-required-error").remove();
	$(".validate-regex").each(function(i)
	{
		if($(this).val()!="")
		{
			if(!testRegexString($(this).attr("regex"), $(this).val()))
			{
				$(this).closest("div").before($("#validate-regex-error").clone());
				var $validateRequiredError = $(this).closest("div").prev() ;
				$validateRequiredError.removeAttr("id");
				$validateRequiredError.attr("class","validate-regex-error non-readonly msgerror");

				var $validateRequiredMessage = $(this).attr("validate-regex-message");
				if($validateRequiredMessage != undefined)
				{			
					//var $defaultErrorMessage = $validateRequiredError.find(".msgerror");
					$validateRequiredError.html($validateRequiredMessage);
				}		
				if(flag)
				{
					flag=false;
				}
			}
		}
	});
}

function returnPage(url, event)
{
	$(".page-inner").html("");
	var responseData = null;
	//var token = $("meta[name='_csrf']").attr("content");
	//var header = $("meta[name='_csrf_header']").attr("content");
	event.preventDefault();
	$.ajax({
		url :url,
		type: "GET",
		beforeSend: function(xhr) {
			//$('.page-inner').parent().block();
			$(".page-inner").load("../common/loader.jsp");
			/*xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
			xhr.setRequestHeader(header, token);*/
		},
		async:true,
		success : function(response) 
		{
			/*setTimeout(function () {
		        $('.page-inner').parent().unblock();
		    }, 500);*/
			
			$(".page-inner").html(response);
			validateIntegerValues();
			validateFloatValues();
//			responseData = response;
		}
	});
	//return responseData;
}

function pageAniamateScroll(){
	$('body,html').animate({ scrollTop: 400}, 800);
}


/**
 * 
 */

/**
 * 
 */

function common_returnTabPage(url)
{
	var responseData = null;
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	event.preventDefault();
	$.ajax({
		url :url,
		type: "GET",
		beforeSend: function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
			xhr.setRequestHeader(header, token);
		},
		async:false,
		success : function(response) 
		{
			responseData = response;
		}
	});
	return responseData;
}


/**
 * return Self Assessment Criteria Report page
 * @param url
 * @param tabId
 * @param tabNumber
 */
function common_returnSARPage(url, tabId, tabNumber)
{
	 if ($("#"+tabId).html().trim().length <= 0) 
	 {
		 var token = $("meta[name='_csrf']").attr("content");
		 var header = $("meta[name='_csrf_header']").attr("content");
		 $.ajax({
			 url :url,
			 type: "POST",
			 data:{tabNumber:tabNumber},
			 async:false,
			 beforeSend: function(xhr) {
				 xhr.setRequestHeader(header, token);
			 },
			 async:false,
			 success : function(data) {
				 common_setReturnPageInTab(data, tabId, tabNumber);
				 selfAssessmentReport_retrieveRecord('', tabNumber);
			 }
		 });
	 }
}

//get Selected tab id
//("#tabs .ui-tabs-panel:visible").attr("id");
function common_setReturnPageInTab(data, tabId, tabNumber)
{
	$("#"+tabId).html(data);
	
}


/**
 * validaton before Upload File
 */
function beforeUploadValidation(formId, id, removeClass)
{
	 var uploadedFile = $('#'+id).val();
	 if(uploadedFile != null && uploadedFile != undefined && uploadedFile != "")
	 {
		 var extension = uploadedFile.substring(uploadedFile.lastIndexOf('.') + 1).toLowerCase();
		 
		 if(extension != undefined && extension == "csv")
		 {
			 $('#'+formId+' input, #'+formId+' select, #'+formId+' textarea').each(function (index)
			 {
				 if($(this).attr('name') != undefined 
						 && $(this).attr('id') != undefined 
						 && $(this).attr('id') != id)
				 {
					 $("#"+$(this).attr('id')).removeClass(removeClass);
				 }
			 });
		 }
		 else
		 {
			 $("#"+id).val("");
			 alert("Please upload csv file");
		 }
	 }
	 else
	 {
		 addValidationClass(formId, id, removeClass);

	 }
}

/**
 * Add Validation class after submit form
 * @param formId
 * @param excludeId
 * @param addClass
 */
function addValidationClass(formId, excludeId, addClass)
{
	$('#'+formId+' input:text, #'+formId+' select, #'+formId+' textarea').each(function (index)
	{
		 if($(this).attr('name') != undefined 
			 && $(this).attr('id') != undefined 
			 && $(this).attr('id') != excludeId)
		 {
			 $("#"+$(this).attr('id')).addClass(addClass);
		 }
	});
}


function common_loadCombo(selectId, data)
{
$("#"+selectId).find('option').not(':first').remove();
	
	$(data).each(function(){
		//this refers to the current item being iterated over
		var option = $('<option />');
		option.attr('value', this.value1).text(this.value1);

		$('#'+selectId).append(option);
	});
}
