<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url var="saveEmployee" value="/employee/save" ></c:url>
<script src="<c:url value="/js/employeesalary/employeeSalary.js" />"> </script>
<body class="page-header-fixed compact-menu page-horizontal-bar">
<div class="page-title">
	<div class="container">
		<div class="adv_ser_row" >
			<h2>Balance Sheet</h2>
			<!-- Start Search Fields -->
			<div class="col-md-6">
				<form:form servletRelativeAction="${saveEmployee}" cssClass="m-t-md ajax-form-login validate-form" method="post" modelAttribute="balanceSheet" id="balancesheet_form">
	    			<div class="form-group">
	               		<form:label  path="fromDate" > From Date * </form:label>
	               		<form:input path="fromDate" cssClass="form-control validate-required datetimepicker" id="balanceSheet_fromDate" placeholder="From Date"/>
	               	</div>
	               	
	               	<div class="form-group">
	               		<form:label  path="toDate" > To Date * </form:label>
	               		<form:input path="toDate" cssClass="form-control validate-required datetimepicker" id="balanceSheet_toDate" placeholder="To Date"/>
	               	</div>
	            </form:form>
			</div>
			<div class="col-md-8" style="width: 100%">
            	


					<h3>  Details</h3>
							<table border="2" cellspacing="3" class="custom-table"  style="overflow: scroll;text-align: center; width: 100%" id="balanceSheet_balancesheetDtsTbl">
							<thead>
				            	<tr> 
				               		<th class="verticalTableHeader">S.No</th>
				           			<th class="verticalTableHeader">Date</th>
				           			<th class="verticalTableHeader">Amount</th>
				           			<th class="verticalTableHeader">Description</th>
				           			<th class="verticalTableHeader">Total Credit Amount</th>
				           			<th class="verticalTableHeader">Total Debit Amount</th>
				           			<th class="verticalTableHeader">Closing Balance</th>
				               	</tr>
			               	</thead>
		               	</table>
		               	<br />
		               	
		               	
                    <button id="balanceSheet-save-btn" type="submit" class="btn" onclick="return balanceSheet_save(event);">Save</button>
                </div>
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
