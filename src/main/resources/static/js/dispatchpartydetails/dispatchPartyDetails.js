
	/**
	 * crud employee
	 * @param event
	 * @returns
	 */
	function dispatchpartyDetails_crud(event)
	{
		var dataJson = {
		    "dispatchparty"             :  	$("#dispatchpartydetails_dispatchParty").val(),
			"dateOf" 					: 	$("#dispatchpartydetails_dateOf").val(),
			"quality" 					: 	$("#dispatchpartydetails_quality").val(),
			"tons" 						: 	$("#dispatchpartydetails_tons").val(),
			"rate"   					:   $("#dispatchpartydetails_rate").val(),
			"amount"   					:   $("#dispatchpartydetails_amount").val(),
			"rebate"   					:   $("#dispatchpartydetails_rebate").val(),
			"dispatchPartyDetailsId"   	:   $("#dispatchpartydetails_dispatchpartydetailsId").val()
		};
		
		/**
		 * Save Record
		 */
		var flag = common_save("dispatchpartydetails", dataJson, event);
		
		return flag;
	}
	
	/**
	 * get record and set data in form while double click on Grid Row
	 * @param rowId
	 */
	function dispatchpartyDetails_Db_Click (rowId)
	{
		url ='/dispatchpartydetails/findById';
		var rowData = jQuery("#dispatchpartydetails-detail-grid-list").getRowData(rowId); 
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
    var GridIds = $("#dispatchpartydetails-detail-grid-list").getDataIDs();
    var last= GridIds[GridIds.length -1 ];   
    last4sel = parseInt(last) + 1;
    var su=$("#dispatchpartydetails-detail-grid-list").addRowData(last4sel, datarow, "last") ;
    return false;
}

/**
 * 
 * @returns
 */
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
			 var GridIds = $("#dispatchpartydetails-detail-grid-list").getDataIDs();
			 var last= GridIds[GridIds.length -1 ];   
			 last4sel = parseInt(last) + 1;
			 var su=$("#dispatchpartydetails-detail-grid-list").addRowData(last4sel, datarow, "last") ;
		}
	}
}

/**
 * Calculate Amount by Ton and Rate
 * @returns
 */
function dispatchpartydetails_CalculateAmount()
{
	var tons = $("#dispatchpartydetails_tons").val();
	var rate = $("#dispatchpartydetails_rate").val();
	/**
	 * if any of one tons or rate will epty then set ammount as empty
	 */
	if(common_isEmpty(tons) || common_isEmpty(rate))
	{
		$("#dispatchpartydetails_amount").val("");
		return;
	}

	$("#dispatchpartydetails_amount").val(parseInt(tons) * parseInt(rate));
	
}


function dispatchpartydetails_CalculateAmountAfterDiscount()
{
	
	var rebate = $("#dispatchpartydetails_rebate").val();
	var rate = $("#dispatchpartydetails_rate").val();
	var tons = $("#dispatchpartydetails_tons").val();
	
	/**
	 * if any of one tons or rate will epty then set ammount as empty
	 */
	if(common_isEmpty(tons) || common_isEmpty(rate))
	{
		$("#dispatchpartydetails_amount").val("");
		return;
	}
	
	/**
	 * check if rebate is applicable then
	 * it will calculate with rate
	 * And rebate must be greater then rate
	 */
	if(!common_isEmpty(rebate) && rebate < rate)
	{
		rate = parseInt(rate) - parseInt(rebate);
	}
	$("#dispatchpartydetails_amount").val(parseInt(tons) * parseInt(rate));
}