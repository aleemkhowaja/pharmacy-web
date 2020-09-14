
function selfAssessmentReport_Crud(event, selfAssesmentCriteriaId)
{
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
	var flag = validateForm();
	if(flag)
	{
		url ='/QEC_HEC_SU/qec/selfAssessmentReportFactor/save.htm';
		var selfAssesmentCriteriaFactorDTO = {};
		var  selfAssessmentCriteriaFactor = [];
		$('#selfAssesmentCriteria_form_'+selfAssesmentCriteriaId+' input, #selfAssesmentCriteria_form_'+selfAssesmentCriteriaId+':radio, #selfAssesmentCriteria_form_'+selfAssesmentCriteriaId+' select, #selfAssesmentCriteria_form_'+selfAssesmentCriteriaId+' textarea').each(function (index)
		{
			if($(this).attr('name') != undefined && $(this).attr('id') != undefined)
			{
				if($(this).attr('name') == 'selfAssessmentFactorId')
				{
					var selfAssesmentCriteriaFactorScore = {};
					var selfAssessmentFactorId = $("#"+$(this).attr('id')).val();
					var selfAssessmentFactorAnswerValue = $('input[name=answer_'+selfAssessmentFactorId+']:checked').val();
					selfAssesmentCriteriaFactorScore["selfAssesmentCriteriaFactorId"] = selfAssessmentFactorId;
					selfAssesmentCriteriaFactorScore["score"] = selfAssessmentFactorAnswerValue;
					selfAssessmentCriteriaFactor.push(selfAssesmentCriteriaFactorScore);
				} else
				{
					//selfAssessmentCriteriaData[$(this).attr('name')] = $("#"+$(this).attr('id')).val();
				}
			}
		});
		selfAssesmentCriteriaFactorDTO["selfAssesmentCriteriaFactorScoreDTOs"] = selfAssessmentCriteriaFactor;
        		

		event.preventDefault();
		$.ajax({
			url :url,
			 type: "POST",
	         contentType: "application/json",
			 data: JSON.stringify(selfAssesmentCriteriaFactorDTO),
			 
	         beforeSend: function(xhr) {
	             xhr.setRequestHeader("Accept", "application/json");
	             xhr.setRequestHeader("Content-Type", "application/json");
	             xhr.setRequestHeader(header, token);
	         },
			 async:false,
			 success : function(data) {
				if(data != undefined) {
					//jQuery("#journal-detail-grid-list").trigger("reloadGrid");
					toaster_success(data);
					nextAndPrevtab("right");
					//citationJournal_Clear_FromData();
				}
				else {
					toaster_error(data);
				}
			}
		});
	}
	event.preventDefault();
	return flag;
}

function selfAssessmentReport_Db_Click(rowId)
{
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	url ='/QEC_HEC_SU/qec/selfAssesmentReport/returnSelfAssesmentCriteriaById';
	var rowData = jQuery("#self-assessment-criteria-grid-list").getRowData(rowId); 
	var selfAssesmentCriteriaId = rowData['selfAssesmentCriteriaId'];
	$.ajax({
		url :url,
		 type: "POST",
		 data:{selfAssesmentCriteriaId : selfAssesmentCriteriaId},
		 async:false,
         beforeSend: function(xhr) {
             xhr.setRequestHeader(header, token);
         },
		 async:false,
		 success : function(data) {
			 selfAssessmentReport_setFormData(data);
			/*citationJournal_Set_FormData(data);
			var myElem = document.getElementById('citationJournal-delete-btn');
			if (myElem == null)
			{
				$("#citationJournal-save-btn").after("<input type='button' id='citationJournal-delete-btn' style='margin-left: 1%;' class='btn' value='Delete' onclick='citationJournal_DeleteCitationJournal() ;'/>");
			}*/
		 }
	});
}

function selfAssessmentReport_setFormData(data)
{
	var selfAssesmentCriteriaId = data.selfAssesmentCriteriaId;
	var selfAssesmentCriteria = data.selfAssesmentCriteria;
	var tabNumber = data.tabId;
	// set Tab data
	selfAssesmentReport_setTabData(tabNumber);
	
	$("#tabs").tabs({active: tabNumber});
	var selfAssesmentCriteriaFactorDTOs = data.selfAssesmentCriteriaFactorDTOs;
	for(var i=0; i<selfAssesmentCriteriaFactorDTOs.length; i++)
	{
		var selfAssesmentCriteriaFactorId = selfAssesmentCriteriaFactorDTOs[i].selfAssesmentCriteriaFactorId;
		var selfAssesmentCriteriaFactor = selfAssesmentCriteriaFactorDTOs[i].selfAssesmentCriteriaFactor;
		var selfAssesmentCriteriaFactorScoreDTOs = selfAssesmentCriteriaFactorDTOs[i].selfAssesmentCriteriaFactorScoreDTOs;
		for(var j=0; j<selfAssesmentCriteriaFactorScoreDTOs.length; j++)
		{
			var selfAssesmentCriteriaFactorScoreId = 
					selfAssesmentCriteriaFactorScoreDTOs[j].selfAssesmentCriteriaFactorScoreId;
			
			var score = selfAssesmentCriteriaFactorScoreDTOs[j].score;
			
			console.log(selfAssesmentCriteriaFactorId+" -- "+score);
			//$("#selfAssesment_answerId_"+selfAssesmentCriteriaFactorId).val(score);
			$("input[id=selfAssesment_answerId_"+selfAssesmentCriteriaFactorId+"][value=" + score + "]").attr('checked', 'checked');
		}
	}
}
function selfAssesmentReport_setTabData(tabNumber)
{
	var tabId = "";
	if(tabNumber == 0)	
	{
		tabId = "criterionOne";
	} else if(tabNumber == 1)	
	{
		tabId = "criterionTwo";
	} else if(tabNumber == 2)	
	{
		tabId = "criterionThree";
	} else if(tabNumber == 3)	
	{
		tabId = "criterionFour";
	} else if(tabNumber == 4)	
	{
		tabId = "criterionFive";
	} else if(tabNumber == 5)	
	{
		tabId = "criterionSix";
	} else if(tabNumber == 6)	
	{
		tabId = "criterionSeven";
	} else if(tabNumber == 7)	
	{
		tabId = "criterionEight";
	}
	
	selfAssessmentReport_CriteriaOpenData(tabId, tabNumber);
}