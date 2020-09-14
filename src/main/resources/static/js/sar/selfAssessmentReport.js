/**
 * Add tables row
 * @param headingId
 * @returns
 */ 
function selfAssessmentReport_addObjectiveTableRow(headingId)
 {
	 var rowCount = $('#criteriaTable_'+headingId+' tr').length;
	 $("#criteriaTable_"+headingId).each(function () {
		 var tds = '<tr style="padding:5px;">';
		 tds+='<input type="hidden" name="sarMode" id="sarMode_'+rowCount+'" value="new"  />'
		 
	     jQuery.each($('tr:last td', this), function () 
	     {
	    	 var childNodes = $(this)[0].childNodes;
	    	 
	    	 var columnHiddenField ;
	    	 if(childNodes.length==2)
	    	 {
	    		 columnHiddenField = childNodes[0];
	    	 }
	    	 else
	         {
	    		 columnHiddenField = childNodes[1];
	         }
	    	 var columnHiddenFieldValue =columnHiddenField.value;
	    	 var columnHiddenId = "selfAssesmentDetailColumnId_"+columnHiddenFieldValue+"_"+rowCount;
	    	 var culumnHiddenHtml = '<input type="hidden" name="selfAssesmentDetailColumnId" id="'+columnHiddenId+'" value="'+columnHiddenFieldValue+'"  />';
	    	 
	    	 var textAreaId = "sarCriteriaDetailColumnValue_"+columnHiddenFieldValue+"_"+rowCount;
	    	 var textAreaHtml = '<textarea class="form-control validate-required" style="width:100%; height:10%" name="selfAssesmentDetailColumnValue" id="'+textAreaId+'"></textarea>';
	    	 tds += '<td style="padding:5px;">' +culumnHiddenHtml + textAreaHtml + '</td>';
	     });
		 
	     tds += '</tr>';
	     if ($('tbody', this).length > 0) 
	     {
	    	 $('tbody', this).append(tds);
	     } else 
	     {
	    	 $(this).append(tds);
	     }
	 });
 }
 var table = $("table tbody");

 /**
  * save SAR data
  * @param event
  * @param selfAssesmentCriteriaId
  * @returns
  */
 function sar_Crud(event, selfAssesmentCriteriaId)
 {
	var formId = "#sar_form_"+selfAssesmentCriteriaId;
 	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    var tabNo = $("#sarTabNumber").val();
 	var flag = validateFormByFormId(formId);
 	if(flag)
 	{
 		url ='/QEC_HEC_SU/qec/sar/save.htm';
 		var sarCriteriaDetailsDTO = {};
 		var sarCriteriaTableColumnsDTO = {};
 		
 		var sarCriteriaDetailValues = [];
 		var sarCriteriaTableColumnValues = [];
 		var sarCriteriaNewTableColumnValues = [];
 		var sarCriteriaDetailColumnId =0;
 		var sarCriteriaDetailColumnId = "";
 		var mode = "";
 		$('#sar_form_'+selfAssesmentCriteriaId+' input, #sar_form_'+selfAssesmentCriteriaId+':radio, #sar_form_'+selfAssesmentCriteriaId+' select, #sar_form_'+selfAssesmentCriteriaId+' textarea').each(function (index)
 		{
 			if($(this).attr('name') != undefined && $(this).attr('id') != undefined)
 			{
 				if($(this).attr('name') == 'selfAssesmentDetailId')
 				{
 					var sarDetailValues = {};
 					var sarCriteriaDetailId = $("#"+$(this).attr('id')).val();
 					var sarCriteriaDetailValue = $("#selfAssesmentReport_"+sarCriteriaDetailId).val();
 					sarDetailValues["sarCriteriaDetailsId"] = sarCriteriaDetailId;
 					sarDetailValues["sarCriteriaDetailsValues"] = sarCriteriaDetailValue;
 					sarCriteriaDetailValues.push(sarDetailValues);
 				}
 				else if($(this).attr('name') == 'sarMode')
 	 			{
 					mode = "new";
 	 			}
 				else if($(this).attr('name') == 'selfAssesmentDetailColumnId')
 				{
 					sarCriteriaDetailColumnId = $("#"+$(this).attr('id')).val();
 				}
 				else if($(this).attr('name') == 'selfAssesmentDetailColumnValue')
 	 			{
 					//var sarDetailValues = {};
 	 				
 	 				var varsarCriteriaDetailColumnValue = $("#"+$(this).attr('id')).val();
 	 				var sarCriteriaTableValues = {};
 	 				sarCriteriaTableValues["sarCriteriaTableColumnsId"] = sarCriteriaDetailColumnId;
 	 				sarCriteriaTableValues["value"] = varsarCriteriaDetailColumnValue;
 	 				sarCriteriaTableValues["mode"] = mode;
 	 				sarCriteriaTableColumnValues.push(sarCriteriaTableValues);
 	 				mode = "";
 					
 	 				/*sarDetailValues["sarCriteriaDetailsId"] = sarCriteriaDetailId;
 	 				sarDetailValues["sarCriteriaDetailsValues"] = sarCriteriaDetailValue;
 	 				sarCriteriaDetailValues.push(sarDetailValues);*/
 	 			}
 				else
 				{
 					var varsarCriteriaDetailColumnValue = $("#sarCriteriaDetailColumnValue_"+sarCriteriaDetailColumnId).val();
 					
 				}
 			}
 		});
 		sarCriteriaDetailsDTO["sarCriteriaDetailsValuesDTOs"] = sarCriteriaDetailValues;
 		sarCriteriaTableColumnsDTO["sarCriteriaDetailsDTO"] = sarCriteriaDetailsDTO;
 		sarCriteriaTableColumnsDTO["sarCriteriaTableValuesDTOs"] = sarCriteriaTableColumnValues;
 		sarCriteriaTableColumnsDTO["tabId"] = tabNo;
         		

 		event.preventDefault();
 		$.ajax({
 			url :url,
 			 type: "POST",
 	         contentType: "application/json",
 			 data: JSON.stringify(sarCriteriaTableColumnsDTO),
 			 
 	         beforeSend: function(xhr) 
 	         {
 	             xhr.setRequestHeader("Accept", "application/json");
 	             xhr.setRequestHeader("Content-Type", "application/json");
 	             xhr.setRequestHeader(header, token);
 	         },
 			 async:false,
 			 success : function(data) 
 			 {
 				if(data != undefined && data == "Record Inserteed Successfully") 
 				{
 					//jQuery("#journal-detail-grid-list").trigger("reloadGrid");
 					toaster_success(data);
 					//returnPage('${returnSARPage}', event);
 					//clearFields("sar_form_"+selfAssesmentCriteriaId);
 					
 					returnPage('sar/selfAssesmentReport.htm', event);
 				}
 				else 
 				{
 					toaster_error(data);
 				}
 			}
 		});
 	}
 	event.preventDefault();
 	return flag;
 }

 /**
  * call function while db click the record
  * @param rowId
  * @returns
  */
 function selfAssessmentReport_Db_Click(rowId)
 {
		url ='/QEC_HEC_SU/qec/sar/returnSelfAssesmentReportDetailValues';
		var rowData = jQuery("#self-assessment-criteria-grid-list").getRowData(rowId); 
		var sarYearId = rowData['sarYearId'];
		$("#sarYear").val(sarYearId);
		selfAssessmentReport_retrieveRecord(sarYearId, 0);
 }

 /**
  * retrive data from spring mvc to form
  * @param sarYearId
  * @returns
  */
 function selfAssessmentReport_retrieveRecord(sarYearId, tabNumber)
 {
	 var token = $("meta[name='_csrf']").attr("content");
	 var header = $("meta[name='_csrf_header']").attr("content");
	 $("#sarTabNumber").val(tabNumber);
	 //check this function call from tab after dbclick the record
	 if(sarYearId == "")
	 {
		 sarYearId = $("#sarYear").val();
	 }
	 //check this function call from tab before dbclick the record
	 if(sarYearId == "" || typeof sarYearId == "undefined")
	 {
		 return;
	 }
	 
	 
	 $.ajax({
		 url :url,
		 type: "POST",
		 data:{
			 sarYearId : sarYearId,
			 tabNumber : tabNumber
		 },
		 async:false,
		 beforeSend: function(xhr) {
			 xhr.setRequestHeader("Accept", "application/json");
	         xhr.setRequestHeader(header, token);
	     },
		 success : function(data) 
		 {
			 selfAssessmentReport_Set_FormData(data);
			// selfAssessmentReport_setFormData(data);
			/*citationJournal_Set_FormData(data);
			var myElem = document.getElementById('citationJournal-delete-btn');
			if (myElem == null)
			{
				$("#citationJournal-save-btn").after("<input type='button' id='citationJournal-delete-btn' style='margin-left: 1%;' class='btn' value='Delete' onclick='citationJournal_DeleteCitationJournal() ;'/>");
			}*/
		 }
	});
 }
 
 /**
  * set data in form
  * @param data
  * @returns
  */
 function selfAssessmentReport_Set_FormData(data)
 {
	 if(data != undefined)
	 {
		 
		 var sarCriteriaDetailsDTOs = data.sarCriteriaDetailsDTOs;
		 
		 for(var i=0; i<sarCriteriaDetailsDTOs.length; i++)
	     {
			 if(sarCriteriaDetailsDTOs[i].fieldType == "text_area")
		     {
				//heading details values
				 var sarCriteriaDetailsValuesDTOs = sarCriteriaDetailsDTOs[i].sarCriteriaDetailsValuesDTOs;
				 for(var j=0; j<sarCriteriaDetailsValuesDTOs.length; j++)
			     {
					 $("#selfAssesmentReport_"+sarCriteriaDetailsDTOs[i].sarCriteriaDetailsId).val(sarCriteriaDetailsValuesDTOs[j].sarCriteriaDetailsValues);
			     }
		     }
			 else
				 if(sarCriteriaDetailsDTOs[i].fieldType == "table")
				 {
					 var sarCriteriaTableCoulumns = sarCriteriaDetailsDTOs[i].sarCriteriaTableColumnsDTOs;
					 if(typeof sarCriteriaTableCoulumns != "undefined" && sarCriteriaTableCoulumns.length > 0)
					 {
						 //create table rows according to tables data retrieve from db 
						 if(sarCriteriaTableCoulumns[0].sarCriteriaTableValuesDTOs.length > 1)
						 {
							 var rows = sarCriteriaTableCoulumns[0].sarCriteriaTableValuesDTOs.length;
							 for(var m=1; m<rows; m++)
						     {
								 var sarCriteriaDetailsId = sarCriteriaTableCoulumns[m].sarCriteriaDetailsId;
								 selfAssessmentReport_addObjectiveTableRow(sarCriteriaDetailsId);
						     }
						 }
						 
						 
						 for(var j=0; j<sarCriteriaTableCoulumns.length; j++)
					     {
							 var sarCriteriaTableColumnValues = sarCriteriaTableCoulumns[j].sarCriteriaTableValuesDTOs;
							 for(var k=0; k<sarCriteriaTableColumnValues.length; k++)
						     {
								 $("#sarCriteriaDetailColumnValue_"+sarCriteriaTableCoulumns[j].sarCriteriaTableColumnsId+"_"+(k+1)).val(sarCriteriaTableColumnValues[k].value);
						     }
					     } 
						 
					 }
				 }
			 else if(sarCriteriaDetailsDTOs[i].fieldType == "sub_headings")
		     {
				//child headings
				 var childCarCriteriaDetailsDTOs = sarCriteriaDetailsDTOs[i].sarCriteriaDetailsDTOs;
				 for(var j=0; j<childCarCriteriaDetailsDTOs.length; j++)
			     {
					 if(childCarCriteriaDetailsDTOs[j].fieldType == "text_area")
					 {
						 var childSarCriteriaDetailsValuesDTOs = childCarCriteriaDetailsDTOs[j].sarCriteriaDetailsValuesDTOs;
						 for(var k=0; k<childSarCriteriaDetailsValuesDTOs.length; k++)
					     {
							 $("#selfAssesmentReport_"+childCarCriteriaDetailsDTOs[j].sarCriteriaDetailsId).val(childSarCriteriaDetailsValuesDTOs[k].sarCriteriaDetailsValues);
					     } 
					 }
					 
					 if(childCarCriteriaDetailsDTOs[j].fieldType == "table")
					 {
						 var childSarCriteriaTableCoulumns = childCarCriteriaDetailsDTOs[j].sarCriteriaTableColumnsDTOs;
						 
						 if(typeof childSarCriteriaTableCoulumns != "undefined" && childSarCriteriaTableCoulumns.length > 0)
						 {
							//create table rows according to tables data retrieve from db 
							if(childSarCriteriaTableCoulumns[0].sarCriteriaTableValuesDTOs.length > 1)
							{
								 var rows = childSarCriteriaTableCoulumns[0].sarCriteriaTableValuesDTOs.length;
								 for(var m=1; m<rows; m++)
							     {
									 var sarCriteriaDetailsId = childCarCriteriaDetailsDTOs[j].sarCriteriaDetailsId;
									 selfAssessmentReport_addObjectiveTableRow(sarCriteriaDetailsId);
							     }
							}
							 
							for(var k=0; k<childSarCriteriaTableCoulumns.length; k++)
						    {
								var childSarCriteriaTableColumnValues = childSarCriteriaTableCoulumns[k].sarCriteriaTableValuesDTOs;
								for(var l=0; l<childSarCriteriaTableColumnValues.length; l++)
							    {
									$("#sarCriteriaDetailColumnValue_"+childSarCriteriaTableCoulumns[k].sarCriteriaTableColumnsId+"_"+(l+1)).val(childSarCriteriaTableColumnValues[l].value);
							    }
						     } 
						 }
						 
					 }
			     }
		     }
	     }
	 }
 }