<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url var="saveDispatchParty" value="/dispatchparty/save" ></c:url>

<div class="page-title">
	<div class="container">
		<div class="adv_ser_row" >
			<h2>Add Dispatch Party Details</h2>
			<!-- Start Search Fields -->
			<div class="col-md-8">
            	<form:form servletRelativeAction="${saveDispatchParty}" cssClass="m-t-md ajax-form-login validate-form" method="post" modelAttribute="dispatchpartydetails" id="dispatchpartydetails_form">
	                
	               	<div class="form-group">
	                	<form:label  path="dispatchparty" >Dispatch Party * </form:label>
						<form:select path="dispatchparty" cssClass="form-control validate-required" id="dispatchpartydetails_dispatchParty" >
	                    	<form:option value="">Select DispatchParty</form:option>
	                    	<form:options items="${dispatchPartyList}" itemValue="dispatchPartyId" itemLabel="dispatchParty"   />
                    	</form:select>
	               	</div>
	               	
	               	<div class="form-group">
	               		<form:label  path="dateOf" > Date * </form:label>
	               		<form:input path="dateOf" cssClass="form-control validate-required datetimepicker" id="dispatchpartydetails_dateOf" placeholder="Date"/>
	               	</div>

					<div class="form-group">
						<form:label  path="quality" >Quality *  </form:label>
						<form:input path="quality" cssClass="form-control validate-required" id="dispatchpartydetails_quality" placeholder="Quality" maxlength="255" />
					</div>
					<div class="form-group">
						<form:label  path="tons" >Tons *  </form:label>
						<form:input path="tons" cssClass="form-control validate-required validate-integer-value" id="dispatchpartydetails_tons" placeholder="Tons" maxlength="11" onchange="dispatchpartydetails_CalculateAmountAfterDiscount();" />
					</div>
					<div class="form-group">
						<form:label  path="rate" >Rate *  </form:label>
						<form:input path="rate" cssClass="form-control validate-required validate-integer-value" id="dispatchpartydetails_rate" placeholder="Rate" maxlength="11" onchange="dispatchpartydetails_CalculateAmountAfterDiscount()" />
					</div>
					<div class="form-group">
						<form:label  path="rebate" >Discount </form:label>
						<form:input path="rebate" cssClass="form-control validate-integer-value" id="dispatchpartydetails_rebate" placeholder="Discount" maxlength="11" onchange="dispatchpartydetails_CalculateAmountAfterDiscount()"  />
					</div>
					<div class="form-group">
						<form:label  path="amount" >Amount *</form:label>
						<form:input path="amount" cssClass="form-control validate-required validate-integer-value" id="dispatchpartydetails_amount" placeholder="Amount" maxlength="11"  readonly="readonly" />
					</div>

	               	
<%-- 	               	<div class="form-group">
	                	<form:label  path="quality" >Quality *  </form:label>
	                	<form:input path="quality" cssClass="form-control validate-required validate-integer-value" id="dispatchpartydetails_quality" placeholder="Quality" maxlength="11" />
	               	</div>
	
	              	<div class="form-group">
	                	<form:label  path="tons" >Tons *  </form:label>
	                	<form:input path="tons" cssClass="form-control validate-required validate-integer-value" id="dispatchpartydetails_tons" placeholder="Tons" maxlength="11" />
	               	</div> --%>
	               	
<%-- 	               	<div class="form-group">
	                	<form:label  path="rate" >Rate *  </form:label>
	                	<form:input path="rate" cssClass="form-control validate-require validate-integer-value" id="dispatchpartydetails_rate" placeholder="Rate" maxlength="11" />
	               	</div>
	               	
	               	<div class="form-group">
	                	<form:label  path="amount" >Amount *  </form:label>
	                	<form:input path="amount" cssClass="form-control validate-require validate-integer-value" id="dispatchpartydetails_amount" placeholder="Amount" maxlength="11" />
	               	</div> --%>
	               	
	               	<%-- <div class="form-group">
	                	<form:label  path="rebate" >Rebate *  </form:label>
	                	<form:input path="rebate" cssClass="form-control validate-require validate-integer-value" id="dispatchpartydetails_rebate" placeholder="Rebate" maxlength="11"  />
	               	</div> --%>
	
		        	<button id="dispatchparty-save-btn" type="submit" class="btn" onclick="return dispatchpartyDetails_crud(event);">Save</button>

                    <form:hidden path="dispatchPartyDetailsId" id="dispatchpartydetails_dispatchpartydetailsId" />

                </form:form>
			</div>
		</div>
        <div id="pager"></div>
	</div>
</div>

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
