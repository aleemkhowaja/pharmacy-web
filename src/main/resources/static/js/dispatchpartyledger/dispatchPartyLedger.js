
	/**
	 * crud dispatch party ledger crud
	 * @param event
	 * @returns
	 */
	function dispatchPartyLedger_crud(event)
	{
		var dataJson = {
			"recievedAmount" 				   : 	$("#dispatchpartyledger_recievedAmount").val(),
			"remaining" 					   : 	$("#dispatchpartyledger_remainingAmount").val(),
			"sourceOfAmount" 				   : 	$("#dispatchpartyledger_sourceOfAmount").val(),
			"recievedAccount"   			   :  	$("#dispatchpartyledger_accountNo").val(),
			"bank"   						   :	$("#dispatchpartyledger_bank").val(),
			"dispatchPartyLedgerId"   		   :    $("#dispatchpartyledger_dispatchPartyLedgerId").val(),
			"dispatchPartyId"				   : 	$("#dispatchpartyledger_dispatchParty").val()
		};
		
		/**
		 * Save Record
		 */
		var flag = common_save("dispatchpartyledger", dataJson, event);
		
		return flag;
	}
	
	/**
	 * get record and set data in form while double click on Grid Row
	 * @param rowId
	 */
	function dispatchpartyDetails_Db_Click (rowId)
	{
		url ='/dispatchpartydetails/findById';
		var rowData = jQuery("#dispatchpartydetailsgridlist").getRowData(rowId); 
		var id = rowData['dispatchPartyDetailsId'];
		
		$.ajax({
			url :url,
			 type: "POST",
			 async:false,
			 data:{id : id},
			 success : function(data) {
				 dispatchpartydetails_Set_FormData(data);
				 var myElem = document.getElementById('dispatchparty-delete-btn');
				 if (myElem == null)
				 {
					 $("#dispatchparty-save-btn").after("<input type='button' id='dispatchparty-delete-btn' style='margin-left: 1%;' class='btn' value='Delete' onclick='dispatchpartydetails_Delete() ;'/>");
					// $("#dispatchparty-delete-btn").after("<input type='button' id='dispatchparty-details-btn' style='margin-left: 1%;' class='btn' value='Dispatch party Details' onclick='dispatchparty_openDispatchPartyDetails();'/>");
				 }
			 }
		});
	}
	
	/**
	 * Delete Record from db while click on Delete Button
	 */
	function dispatchpartydetails_Delete() 
	{
		common_delete("dispatchpartydetails");
	}
	
	/**
	 * Set Form Data while get record from db
	 * @param data
	 */
	function dispatchpartydetails_Set_FormData(data)
	{
		$("#dispatchpartydetails_dispatchParty").val(data.dispatchparty);
		$("#dispatchpartydetails_dateOf").val(data.dateOf);
		$("#dispatchpartydetails_quality").val(data.quality);
		$("#dispatchpartydetails_tons").val(data.tons);
		$("#dispatchpartydetails_rate").val(data.rate);
		$("#dispatchpartydetails_amount").val(data.amount);
		$("#dispatchpartydetails_rebate").val(data.rebate);
		$("#dispatchpartydetails_dispatchpartydetailsId").val(data.dispatchPartyDetailsId);
		pageAniamateScroll();
	}
	
	

/**
 * Add dispatcher party details in grid 
 */
function adddispatchPartDetails()
{
	var dateOf  =    				$("#dispatchpartydetails_dateOf").val();
	var quality =  					$("#dispatchpartydetails_quality").val();
	var tons    = 					$("#dispatchpartydetails_tons").val();
	var rate    = 					$("#dispatchpartydetails_rate").val();
	var amount  = 					$("#dispatchpartydetails_amount").val();
	var rebate  = 					$("#dispatchpartydetails_rebate").val();
	var dispatchPartyDetailsId  = 	$("#dispatchparty_dispatchPartyDetailsId").val();
	
	
	var datarow = {dateOf:dateOf,quantity:quantity,tons:tons,rate:rate,amount:amount,rebate:rebate, dispatchPartyDetailsId : dispatchPartyDetailsId};
    var GridIds = $("#dispatchpartydetailsgridlist").getDataIDs();
    var last= GridIds[GridIds.length -1 ];   
    last4sel = parseInt(last) + 1;
    var su=$("#dispatchpartydetailsgridlist").addRowData(last4sel, datarow, "last") ;
    return false;
}

function loaddispatachPartyDetails()
{
	var partyDetails = $("#dispatchParty_details").val();
	
	if(partyDetails != null && partyDetails != "" && typeof partyDetails != "undefined")
	{
		partyDetails = JSON.parse(partyDetails);
		
		for(var i=0; i<partyDetails.length; i++)
		{
			 var detail = partyDetails[i];
			 
			 var dateOf =    		detail.dateOf;
			 var quality =  		detail.quality;
			 var tons = 			detail.tons;
			 var rate = 			detail.rate;
			 var amount = 			detail.amount;
			 var rebate = 			detail.rebate;
			 var dispatchPartyDetailsId  = 	detail.dispatchPartyDetailsId;
				
				
			 var datarow = {dateOf:dateOf,quality:quality,tons:tons,rate:rate,amount:amount,rebate:rebate, dispatchPartyDetailsId : dispatchPartyDetailsId};
			 var GridIds = $("#dispatchpartydetailsgridlist").getDataIDs();
			 var last= GridIds[GridIds.length -1 ];   
			 last4sel = parseInt(last) + 1;
			 var su=$("#dispatchpartydetailsgridlist").addRowData(last4sel, datarow, "last") ;
		}
	}

}


/**
 * return Dispatch Party Details on change of dispatch combobox
 * dispatchId
 * @returns
 */
function dispatchPartyLedger_loadDispatchPartyDetails()
{
	var dispatchPartyId = $("#dispatchpartyledger_dispatchParty").val();
	
	var url ='/dispatchpartyledger/findDetailsByDispatchId';
	
	$.ajax({
		url :url,
		 type: "POST",
		 async:false,
		 data:{dispatchPartyId : dispatchPartyId},
		 success : function(data) {
		 dispatchPartyLedger_showDispatchPartyDetails(data);
		 }
	});
}


function dispatchPartyLedger_showDispatchPartyDetails(data)
{
	$("#dispatchpartyledger_dispatchPartyDetailsTbl > tbody").empty();
	var responseDispatchPartyDetailsDTOs = data.responseDispatchPartyDetailsDTOs;
	var tableData = "";
	var totalAmount = 0;
	var paidAmount = 0;
	var remaining = 0;
	if(responseDispatchPartyDetailsDTOs.length <= 0) return;
	for(var i=0; i<responseDispatchPartyDetailsDTOs.length; i++)
	{
		var tr = "<tr> ";
		tr += " <td> "+responseDispatchPartyDetailsDTOs[i].dateOf+"  </td>"
		tr += " <td> "+responseDispatchPartyDetailsDTOs[i].quality+" </td>"
		tr += " <td> "+responseDispatchPartyDetailsDTOs[i].tons+"    </td>"
		tr += " <td> "+responseDispatchPartyDetailsDTOs[i].rate+"    </td>"
		tr += " <td> "+responseDispatchPartyDetailsDTOs[i].rebate+"  </td>"
		tr += " <td> "+responseDispatchPartyDetailsDTOs[i].amount+"  </td>"
		tr += " </tr>";
		
		tableData+= tr;
		totalAmount += responseDispatchPartyDetailsDTOs[i].amount;
	}
	
	tableData += " <tr> <td> <b> Total 		</b>  	</td> 	<td colspan='4'>  	</td>  	<td id='dispatchpartyledger_detailTotalAmount'> "+	totalAmount	+" 	</td> 	</tr>"
	tableData += " <tr> <td> <b> Paid  		</b>  	</td> 	<td colspan='4'>   	</td>  	<td id='dispatchpartyledger_detailPaidAmount'>  "+(data.paidAmount == null ? 0 : data.paidAmount)+" 	</td> 	</tr>"
	tableData += " <tr> <td> <b> Remaining 	</b> 	</td> 	<td colspan='4'>   	</td>  	<td id='dispatchpartyledger_detailPaidAmount'>  "+(data.remainingAmount == null ? 0 : data.remainingAmount)+" 	</td> 	</tr>"
	
    $("#dispatchpartyledger_dispatchPartyDetailsTbl").append(tableData);
	
	/**
	 * Set values in hidden fields
	 * @param data
	 * @returns
	 */
	$("#dispatchpartyledger_paidAmount").val((data.paidAmount == null ? 0 : data.paidAmount));
	$("#dispatchpartyledger_amount").val(totalAmount);
}

function dispatchPartyLedge_Set_DispatchDetailsFormData(data)
{
	dispatchPartyLedge_Clear_DispatchDetailsFormData();
	
	$("#dispatchpartyledger_dateOf").val(data.dateOf);
	$("#dispatchpartyledger_quality").val(data.quality);
	$("#dispatchpartyledger_tons").val(data.tons);
	$("#dispatchpartyledger_rate").val(data.rate);
	$("#dispatchpartyledger_amount").val(data.amount);
	$("#dispatchpartyledger_rebate").val(data.rebate);
	$("#dispatchpartyledger_paidAmount").val(data.paidAmount);
	$("#dispatchpartyDetlledger_remainingAmount").val(data.remainingAmount);
	$("#dispatchpartydetails_dispatchpartydetailsId").val(data.dispatchPartyDetailsId);
}

function dispatchPartyLedge_Clear_DispatchDetailsFormData()
{
	$("#dispatchpartyledger_dateOf").val("");
	$("#dispatchpartyledger_quality").val("");
	$("#dispatchpartyledger_tons").val("");
	$("#dispatchpartyledger_rate").val("");
	$("#dispatchpartyledger_amount").val("");
	$("#dispatchpartyledger_rebate").val("");
	$("#dispatchpartyledger_paidAmount").val("");
	$("#dispatchpartyDetlledger_remainingAmount").val("");
	$("#dispatchpartydetails_dispatchpartydetailsId").val("");
}


/*
 * Calculate the Received Amount
 */
function dispatchPartyLedger_calculateRecievedAmount()
{
	var dispatchParty = $("#dispatchpartyledger_dispatchParty").val();
	if(dispatchParty == "")
							return;
	
	var totalAmount = 	 $("#dispatchpartyledger_amount").val();

	//	var rebate = 		 $("#dispatchpartyledger_rebate").val();
//	if(typeof rebate != "undefined" && rebate != "")
//	{
//		totalAmount =  parseInt(totalAmount) -  parseInt(rebate);
//	}
//	
	
	var recievedAmount = $("#dispatchpartyledger_recievedAmount").val();
	
	if(typeof recievedAmount == "undefined" ||  recievedAmount == "")
	{
		$("#dispatchpartyledger_remainingAmount").val("0");
		return;
	}
	
	var paidAmount =     $("#dispatchpartyledger_paidAmount").val();
	
	var totalRecievedAmount = parseInt(paidAmount) +  parseInt(recievedAmount);
	
	if(totalRecievedAmount > totalAmount)
	{
		alert("Recieved Amount is Greater then Total Amount");
		$("#dispatchpartyledger_remainingAmount").val("0");
		return;
	}
	
	var remainAmount = totalAmount - totalRecievedAmount;
	$("#dispatchpartyledger_remainingAmount").val(remainAmount);
	
	
}