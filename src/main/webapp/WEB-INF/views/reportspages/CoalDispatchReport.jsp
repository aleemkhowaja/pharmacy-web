<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url var="saveDispatchParty" value="/dispatchparty/save" ></c:url>


			<h2>Coal Dispatch Details Report</h2>
			<!-- Start Search Fields -->
			<div class="col-md-8">
            	<form:form servletRelativeAction="${saveDispatchParty}" cssClass="m-t-md ajax-form-login validate-form" method="post" modelAttribute="coaldispatchedreport" id="coaldispatchedreport_form">
	                
	               	
	               	<div class="form-group">
	               		<form:label  path="fromDate" > From Date * </form:label>
	               		<form:input  path="fromDate" cssClass="form-control validate-required datetimepicker" id="coaldispatchedreport_fromDate" placeholder="From Date"/>
	               	</div>
	               	
	               	<div class="form-group">
	               		<form:label  path="toDate" > To Date * </form:label>
	               		<form:input  path="toDate" cssClass="form-control validate-required datetimepicker" id="coaldispatchedreport_toDate" placeholder="To Date"/>
	               	</div>

		        	<button id="coaldispatchedreport-save-btn" type="submit" class="btn" >View Report</button>

                </form:form>
			</div>
        <div id="pager"></div>

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
