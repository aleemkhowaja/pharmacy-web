<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url var="saveEmployee" value="/employee/save" ></c:url>
<script src="<c:url value="/js/transactions/transactions.js" />"> </script>
<body class="page-header-fixed compact-menu page-horizontal-bar">
<div class="page-title">
	<div class="container">
		<div class="adv_ser_row" >
			<h2>Balance Sheet</h2>
			<!-- Start Search Fields -->
			<form:form servletRelativeAction="${saveEmployee}" cssClass="m-t-md ajax-form-login validate-form" method="post" modelAttribute="balanceSheet" id="balancesheet_form">
			<div class="col-md-6">
	    			<div class="form-group">
							<form:label path="fromDate"> From Date * </form:label>
							<form:input path="fromDate"
								cssClass="form-control validate-required datetimepicker"
								id="balanceSheet_fromDate" placeholder="From Date"
								onchange="transactions_returnTransactionsByDates()" />
						</div>
	               	
	               	<div class="form-group">
	               		<form:label  path="toDate" > To Date * </form:label>
							<form:input path="toDate"
								cssClass="form-control validate-required datetimepicker"
								id="balanceSheet_toDate" placeholder="To Date"
								onchange="transactions_returnTransactionsByDates()" />
					</div>
			</div>
			<div class="col-md-8" style="width: 100%">
            	


					<h3>  Details</h3>
							<table border="2" cellspacing="3" class="custom-table"  style="overflow: scroll;text-align: center; width: 100%" id="balanceSheet_balancesheetDtsTbl">
							<thead>
				            	<tr> 
				               		<th class="verticalTableHeader">S.No</th>
				           			<th class="verticalTableHeader">Date</th>
				           			<th class="verticalTableHeader">Amount</th>
				           			<th class="verticalTableHeader">Transaction Type</th>
				           			<th class="verticalTableHeader">Description</th>
				               	</tr>
			               	</thead>
		               	</table>
		               	<br />
		               	
		               	<div class="form-group">
	               		<form:label  path="totalCreditAmount" > Total Credit Amount </form:label>
							<form:input path="totalCreditAmount"
								cssClass="form-control" readonly="true"
								id="balanceSheet_totalCreditAmount" />
					</div>
					
					<div class="form-group">
	               		<form:label  path="totalDebitAmount" > Total Debit Amount </form:label>
							<form:input path="totalDebitAmount"
								cssClass="form-control" readonly="true"
								id="balanceSheet_totalDebitAmount" />
					</div>
					
					<div class="form-group">
	               		<form:label  path="closingBalance" > Closing Balance </form:label>
							<form:input path="closingBalance"
								cssClass="form-control" readonly="true"
								id="balanceSheet_closingBalance" />
					</div>
                </div>
              </form:form>
		</div>
        <div id="pager"></div>
	</div>
</div>
</body>

<script type="text/javascript">
	$(document).ready(function(){
		$('.datetimepicker').datepicker({
			dateFormat: 'yy-mm-dd',
			showButtonPanel: true,
			changeMonth: true,
			changeYear: true,
			buttonImage: "calendar.gif",
			buttonText: "Calendar",
			orientation : "bottom right",
		});
	});
</script>

<style>
	.ui-datepicker-month
	{
		background-color : #275064
	}
	.ui-datepicker-year
	{
		background-color : #275064
	}
</style>
