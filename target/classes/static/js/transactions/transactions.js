	/**
	 * return all transactions for balance sheet
	 * @returns
	 */
	function transactions_returnTransactionsByDates()
	{
		
		var token   = $("meta[name='_csrf']").attr("content");
		var header  = $("meta[name='_csrf_header']").attr("content");
		
		var url     ='/transactions/findByDates';
		var fromDate = $("#balanceSheet_fromDate").val();
		var toDate = $("#balanceSheet_toDate").val();
		
		if(fromDate != "" && typeof fromDate != "undefined" && toDate != "" && typeof toDate != "undefined")
		
		var dataJson = {
			"fromDate" 			: 	$("#balanceSheet_fromDate").val(),
			"toDate" 			: 	$("#balanceSheet_toDate").val(),
		};
		

		$.ajax({
			url :url,
			 contentType: "application/json",
			 type: "POST",
			 data:  JSON.stringify(dataJson),
			 async:false,
			 success : function(data) 
			 {
				 transactions_createBalanceSheetTable(data);
			 }
		});
	}
	
	
	/**
	 * Create table for Balance sheet
	 * @param data
	 * @returns
	 */
	function transactions_createBalanceSheetTable(data)
	{
		$("#balanceSheet_balancesheetDtsTbl > tbody").empty();
		var transactions = data;
		var tableData = "";
		
		/**
		 * check if transactions details are empty
		 */
		if(transactions.length <= 0) return;
		
		/**
		 * Populate all transactions and its details
		 */
		for(var i=0; i<transactions.length; i++)
		{
			var tr = "<tr> ";
			tr += " <td> "+(i+1)+"  </td>"
			tr += " <td> "+transactions[i].date+" </td>"
			tr += " <td> "+transactions[i].amount+" </td>"
			tr += " <td> "+transactions[i].description+" </td>"
			tr += " <td> "+(transactions[i].totalCreditAmount == null ? 0 : transactions[i].totalCreditAmount)+" </td>"
			tr += " <td> "+(transactions[i].totalDebitAmount == null ? 0 : transactions[i].totalDebitAmount) +" </td>"
			tr += " <td> "+(transactions[i].closingBalance == null ? 0 : transactions[i].closingBalance)+" </td>"
			tr += " </tr>";
			tableData+= tr;
		}
	    $("#balanceSheet_balancesheetDtsTbl").append(tableData);
	}