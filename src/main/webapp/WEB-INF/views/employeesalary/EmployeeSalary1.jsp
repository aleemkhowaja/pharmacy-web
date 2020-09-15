<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url var="saveDispatchParty" value="/dispatchparty/save" ></c:url>

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
<script src="<c:url value="/js/employeesalary/employeeSalary.js" />"> </script>


<div class="page-title">
	<div class="container">
		<div class="adv_ser_row" >
			<h2>Employee Salaries</h2>
			<!-- Start Search Fields -->
			<div class="col-md-8">
              	<form:form servletRelativeAction="${saveEmployee}" cssClass="m-t-md ajax-form-login validate-form" method="post" modelAttribute="employeeSalary" id="employeeSalary_form">
	                
	               	
					<div class="form-group">
	    				<form:label cssClass="control-label" 		path="salaryType"> Salary Type :</form:label>
	        			
	        			<form:select 		cssClass="form-control validate-required" path="salaryType" id="employeeSalary_salaryType"  onchange="employeeSalary_returnEmployeeBySalaryType()" >
		 					<form:option 	value="salaryType" 		label="Select Salary Type" />
		 					<form:option 	value="daily" 			label="Daily" />
		 					<form:option 	value="monthly" 		label="Monthly" />
		 				</form:select>
	    			</div>
	    			
	    			<div class="form-group">
	               		<form:label  path="fromDate" > From Date * </form:label>
	               		<form:input path="fromDate" cssClass="form-control validate-required datetimepicker" id="employeeSalary_fromDate" placeholder="From Date" onchange="employeeSalary_returnEmployeeBySalaryType()"  />
	               	</div>
	               	
	               	<div class="form-group">
	               		<form:label  path="toDate" > To Date * </form:label>
	               		<form:input path="toDate" cssClass="form-control validate-required datetimepicker" id="employeeSalary_toDate" placeholder="To Date" onchange="employeeSalary_returnEmployeeBySalaryType()" />
	               	</div>

					<h3>  Employee Salary Details</h3>
							<table border="2" cellspacing="3" class="custom-table"  style="overflow: scroll;text-align: center; width: 100%" id="employeeSalary_dailyEmployeSalaryDtsTbl">
							<thead>
				            	<tr> 
				               		<th class="verticalTableHeader">S.No</th>
				           			<th class="verticalTableHeader">Name</th>
				           			<th class="verticalTableHeader">Father Name</th>
				           			<th class="verticalTableHeader">Designation</th>
				           			<th class="verticalTableHeader">Per Day</th>
				           			<th class="verticalTableHeader">Total Days</th>
				           			<th class="verticalTableHeader">Total Days Amount</th>
				           			<th class="verticalTableHeader">Per Day Over Time</th>
				           			<th class="verticalTableHeader">Over Time Days</th>
				           			<th class="verticalTableHeader">Over Time Total Amount</th>
				           			<th class="verticalTableHeader">Per Day Public Holiday</th>
				           			<th class="verticalTableHeader">Public Holidays</th>
				           			<th class="verticalTableHeader">Public Holiday Total Amount</th>
				           			<th class="verticalTableHeader">Gross Amount</th>
				           			<th class="verticalTableHeader">Advance</th>
				           			<th class="verticalTableHeader">Utilities</th>
				           			<th class="verticalTableHeader">Net Amount</th>
				               	</tr>
			               	</thead>
		               	</table>
		               	<br />
                    <button id="employee-save-btn" type="submit" class="btn" onclick="return employeeSalary_save(event);">Save</button>
                        <!-- Hidden fields -->
                        <form:hidden path="employeeId" id="employee_employeeId" />        

                </form:form>
			</div>
		</div>
        <div id="pager"></div>
	</div>
</div>



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
