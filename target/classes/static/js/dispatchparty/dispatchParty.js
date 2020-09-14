
	/**
	 * crud employee
	 * @param event
	 * @returns
	 */
	function dispatchparty_crud(event)
	{
		var partyDetails = $("#dispatchParty_details").val();
		
		var dataJson = {
			"dispatchPartyId" 					: 	$("#dispatchparty_dispatchpartyId").val(),
			"dispatchParty" 					: 	$("#dispatchparty").val(),
			"dispatchPartyOwner" 				: 	$("#dispatchparty_owner").val()
		};
		
		/**
		 * Save Record
		 */
		var flag = common_save("dispatchparty", dataJson, event);
		
		return flag;
	}
	
	/**
	 * get record and set data in form while double click on Grid Row
	 * @param rowId
	 */
	function dispatchparty_Db_Click (rowId)
	{
		url ='/dispatchparty/findById';
		var rowData = jQuery("#dispatchparty-detail-grid-list").getRowData(rowId); 
		var id = rowData['dispatchPartyId'];
		
		$.ajax({
			url :url,
			 type: "POST",
			 async:false,
			 data:{id : id},
			 success : function(data) {
				 dispatchparty_Set_FormData(data);
				 var myElem = document.getElementById('dispatchparty-delete-btn');
				 if (myElem == null)
				 {
					 $("#dispatchparty-save-btn").after("<input type='button' id='dispatchparty-delete-btn' style='margin-left: 1%;' class='btn' value='Delete' onclick='dispatchparty_Delete() ;'/>");
				 }
			 }
		});
	}
	
	/**
	 * Set Form Data while get record from db
	 * @param data
	 */
	function dispatchparty_Set_FormData(data)
	{
		$("#dispatchparty_dispatchpartyId").val(data.dispatchPartyId);
		$("#dispatchparty").val(data.dispatchParty);
		$("#dispatchparty_owner").val(data.dispatchPartyOwner);
		pageAniamateScroll();
	}
	
	/**
	 * Delete Record from db while click on Delete Button
	 */
	function dispatchparty_Delete() 
	{
		common_delete("dispatchparty");
	}
	
	/**
	 * Open dialog for Dispatch Part Details
	 * @returns
	 */
	function dispatchparty_openDispatchPartyDetails()
	{
		var dispatchPartyId = $("#dispatchparty_dispatchpartyId").val();
		
		 $( "#dialogId" ).dialog({  
             autoOpen: false,   
             hide: "slide",  
             show : "slide",  
             width:1000,
 		     height:500,
 		     closeOnEscape: true,
 		     open: function(event, ui) {
 		  	  // $(".ui-dialog-titlebar-close", ui.dialog | ui).hide();
 		     },
 		     close: function(event, ui) {
			  	return;
			 },
			 buttons: {
				 OK:function()
				 {
					 /**
					  * set dispatch party details data in hidden fields
					  */
					dispatchparty_setDispatcherPartyDetails();
					var theDialog = $(this);
					theDialog.dialog("close");
					//theDialog.remove();
				 },
				 Cancel: function()
				 {
					var theDialog = $(this);
					theDialog.dialog("close");
					//theDialog.remove();
				 }
			 }
          }); 
		 
		 var url = "/dispatchpartydetails.htm";
		 $("#dialogId").load(url,{dispatchPartyId : dispatchPartyId}, function() {
		 });
		 $("#dialogId").dialog("open");
	}
	
	
	function dispatchparty_loadDispatchPartyDetailsGrid()
	{
		var dispatchPartyId = $("#dispatchparty_dispatchpartyId").val();
		jQuery("#dispatchpartydetails-detail-grid-list").jqGrid('setGridParam',{url:"dispatchpartydetails/findAll?dispatchPartyId="+dispatchPartyId}).trigger("reloadGrid");
	}
	
	/**
	 * set Dispatcher party details
	 * @returns
	 */
	function dispatchparty_setDispatcherPartyDetails()
	{
		var lista = $("#dispatchpartydetails-detail-grid-list").getDataIDs();
		 var details = new Array();
		 for(var i=0;i<lista.length;i++){
			 rowData=$("#dispatchpartydetails-detail-grid-list").getRowData(lista[i]);
			 if(rowData != null && typeof rowData != "undefined")
			 {
				 if(rowData.dispatchPartyDetailsId == "" || typeof rowData.dispatchPartyDetailsId == "undefined")
				 {
					 //	var datarow = {dateOf:dateOf,quantity:quantity,tons:tons,rate:rate,amount:amount,rebate:rebate, dispatchPartyDetailsId : dispatchPartyDetailsId};
					 var detail = {};
					 detail.dateOf = rowData.dateOf;
					 detail.quantity = rowData.quantity;
					 detail.tons = rowData.tons;
					 detail.rate = rowData.rate;
					 detail.amount = rowData.amount;
					 detail.rebate = rowData.rebate;
					 detail.dispatchPartyDetailsId = rowData.dispatchPartyDetailsId;
					 details.push(detail);
				 }
			 }
		 }
		 $("#dispatchParty_details").val(JSON.stringify(details));
	}