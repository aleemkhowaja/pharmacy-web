<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url var="saveEmployee" value="/employee/save" ></c:url>

<div class="page-title">
	<div class="container">
		<div class="adv_ser_row" >
			<h2>Add Employee</h2>
			<!-- Start Search Fields -->
			<div class="col-md-8">
            	<form:form servletRelativeAction="${saveEmployee}" cssClass="m-t-md ajax-form-login validate-form" method="post" modelAttribute="employee" id="employee_form">
	                
	                <div class="form-group">
	                	<form:label  path="employeeName" > Employee Name * </form:label>
						<form:input  path="employeeName" cssClass="form-control validate-required" id="employee_name" placeholder="Employee Name" maxlength="255" />
	               	</div>
	               	
	               	<div class="form-group">
	                	<form:label  path="fatherName" > Father's Name  </form:label>
						<form:input  path="fatherName" cssClass="form-control validate-required" id="employee_fatherName" placeholder="Father's Name" maxlength="255"  />
	               	</div>
	               	
	               	<div class="form-group">
	                	<form:label  path="contactNo" > Contact No  </form:label>
						<form:input  path="contactNo" cssClass="form-control validate-required" id="employee_contactNo" placeholder="Contact No" maxlength="255" />
	               	</div>
	               	
					<div class="form-group">
	                	<form:label  path="email" >Email * </form:label>
						<form:input  path="email" cssClass="form-control validate-required" id="employee_email" placeholder="Email" maxlength="100" />
	               	</div>
	               	
	               	<div class="form-group">
	                	<form:label  path="designation" > Designation * </form:label>
						<form:input  path="designation" cssClass="form-control validate-required" id="employee_designation" placeholder="Designation"  />
	               	</div>
	               	
	               	<div class="form-group">
	                	<form:label    path="address" >Postal Address * </form:label>
						<form:textarea path="address" cssClass="form-control validate-required" id="employee_address" placeholder="Address"   />
	               	</div>
	               	
	               	<div class="form-group">
	    				<form:label cssClass="control-label" 		path="salaryType"> Salary Type :</form:label>
	        			
	        			<form:select 		cssClass="form-control" path="salaryType" id="employee_salaryType"  >
		 					<form:option 	value="salaryType" 		label="Select Salary Type" />
		 					<form:option 	value="daily" 			label="Daily" />
		 					<form:option 	value="monthly" 		label="Monthly" />
		 				</form:select>
	    			</div>
	    			
	    			<div class="form-group">
	    				<form:label cssClass="control-label" path="salary">Salary :</form:label>
	        			<form:input cssClass="form-control"  path="salary" id="employee_salary" placeholder="Salary"  />
	    			</div>
	    			
	    			<div class="form-group">
	    				<form:label cssClass="control-label" path="overtimeAmount">Overtime Amount :</form:label>
	        			<form:input cssClass="form-control"  path="overtimeAmount" id="employee_overtimeAmount" placeholder="Overtime Amount" />
	    			</div>
	    			
	    			<div class="form-group">
	    				<form:label cssClass="control-label" path="publicHolidayAmount">Public Holiday Amount :</form:label>
	        			<form:input cssClass="form-control"  path="publicHolidayAmount" id="employee_publicHolidayAmount" placeholder="Public Holiday Amount"  />
	    			</div>
	               	
                    <button id="employee-save-btn" type="submit" class="btn" onclick="return employee_crud(event);">Save</button>
                        <!-- Hidden fields -->
                        <form:hidden path="employeeId" id="employee_employeeId" />        
                   </form:form>
                </div>
		</div>
        <div id="pager"></div>
	</div>
</div>
