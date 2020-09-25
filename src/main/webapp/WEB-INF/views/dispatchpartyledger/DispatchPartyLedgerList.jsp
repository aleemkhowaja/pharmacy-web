<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">

<!-------------------- crud urls  ---------------------------->
<c:url var="saveDispatchParty" value="/dispatchparty/save"></c:url>

<!-- ------------------------------------------------------ -->
<%-- <jsp:include page="../common/header.jsp" /> --%>
<script
	src="<c:url value="/js/dispatchpartyledger\dispatchPartyLedger.js" />"> 
</script>
<body class="page-header-fixed compact-menu page-horizontal-bar">
	<%-- <jsp:include page="../common/menues.jsp" /> --%>
	<div class="page-title">
		<div class="container">
			<h2>Add Dispatch Party Ledger</h2>
			<!-- Start Search Fields -->
			<div class="col-md-8">
				<form:form servletRelativeAction="${saveDispatchParty}"
					cssClass="m-t-md ajax-form-login validate-form" method="post"
					modelAttribute="dispatchpartyledger" id="dispatchpartyledger_form">

					<div class="row" style="margin-bottom: 5px">
						<div class="row"></div>
						<div class="col-25"
							style="float: left; width: 15%; margin-top: 15px;">
							<form:label path="requestDispatchPartyDetailsDTO.dispatchparty">Dispatch Party * </form:label>
						</div>
						<div class="col-75"
							style="float: left; width: 25%; margin-top: 6px;">
							<form:select path="requestDispatchPartyDetailsDTO.dispatchparty"
								cssClass="form-control" id="dispatchpartyledger_dispatchParty"
								onchange="dispatchPartyLedger_loadDispatchPartyDetails();">
								<form:option value="">Select Dispatch Party</form:option>
								<form:options items="${dispatchPartyList}"
									itemValue="dispatchPartyId" itemLabel="dispatchParty" />
							</form:select>
						</div>


						<%-- 						
						<div class="col-25" style="float: left;width: 18%;margin-top: 15px;margin-left: 70px;">							<form:label  path="requestDispatchPartyDetailsDTO.dateOf" > Dispatch Date </form:label>
				      	</div>
				      	<div class="col-75" style="float: left; width: 21%;margin-top: 6px;">
							<form:input path="requestDispatchPartyDetailsDTO.dateOf" cssClass="form-control" readonly="true" 
										id="dispatchpartyledger_dateOf" />
						</div> --%>
					</div>

					<br />
					<h3>Dispatch Party Details</h3>
					<table border="1" class="custom-table"
						style="text-align: center; width: 100%"
						id="dispatchpartyledger_dispatchPartyDetailsTbl">
						<thead>
							<tr>
								<th>Date</th>
								<th>Quality</th>
								<th>Tons</th>
								<th>Rate</th>
								<th>Discount</th>
								<th>Amount</th>
							</tr>
						</thead>
					</table>

					<%-- 					<div class="row">
						<div class="col-25" style="float: left;width: 15%;margin-top: 15px;">
				        	<form:label  path="requestDispatchPartyDetailsDTO.quality" >Quality  </form:label>
				      	</div>
				      	<div class="col-75" style="float: left; width: 25%;margin-top: 6px;">
							<form:input path="requestDispatchPartyDetailsDTO.quality" cssClass="form-control validate-integer-value" 
										readonly="true" id="dispatchpartyledger_quality" maxlength="11" />
						</div>
						<div class="col-25" style="float: left;width: 18%;margin-top: 15px;margin-left: 70px;">
							<form:label  path="requestDispatchPartyDetailsDTO.tons" >Tons </form:label>
				      	</div>
				      	<div class="col-75" style="float: left; width: 21%;margin-top: 6px;">
							<form:input path="requestDispatchPartyDetailsDTO.tons" cssClass="form-control validate-integer-value" 
										readonly="true" id="dispatchpartyledger_tons" maxlength="11" />
						</div>
					</div>
					
					<div class="row">
						<div class="col-25" style="float: left;width: 15%;margin-top: 15px;">
				        	<form:label  path="requestDispatchPartyDetailsDTO.rate" >Rate </form:label>
				      	</div>
				      	<div class="col-75" style="float: left; width: 25%;margin-top: 6px;">
							<form:input path="requestDispatchPartyDetailsDTO.rate" cssClass="form-control validate-integer-value" 
										id="dispatchpartyledger_rate" readonly="true" maxlength="11" />
						</div>
						<div class="col-25" style="float: left;width: 18%;margin-top: 15px;margin-left: 70px;">
							<form:label  path="requestDispatchPartyDetailsDTO.amount" >Amount</form:label>
				      	</div>
				      	<div class="col-75" style="float: left; width: 21%;margin-top: 6px;">
							<form:input path="requestDispatchPartyDetailsDTO.amount" cssClass="form-control validate-integer-value" id="dispatchpartyledger_amount" 
										readonly="true" maxlength="11" />
						</div>
					</div>
					
					<div class="row">
						
						<div class="col-25" style="float: left;width: 15%;margin-top: 15px;">
				        	<form:label  path="requestDispatchPartyDetailsDTO.rebate" >Rebate </form:label>
				      	</div>
				      	<div class="col-75" style="float: left; width: 25%;margin-top: 6px;">
							<form:input path="requestDispatchPartyDetailsDTO.rebate" cssClass="form-control validate-integer-value" id="dispatchpartyledger_rebate" 
										readonly="true" maxlength="11"  />
						</div>
						
						<div class="col-25" style="float: left;width: 18%;margin-top: 15px;margin-left: 70px;">
							<form:label  path="requestDispatchPartyDetailsDTO.paidAmount" >Paid Amount</form:label>
				      	</div>
				      	<div class="col-75" style="float: left; width: 21%;margin-top: 6px;">
							<form:input path="requestDispatchPartyDetailsDTO.paidAmount" cssClass="form-control validate-integer-value" id="dispatchpartyledger_paidAmount" 
										readonly="true" maxlength="11" />
						</div>
					</div>
					<div class="row">
						<div class="col-25" style="float: left;width: 15%;margin-top: 15px;">
							<form:label  path="requestDispatchPartyDetailsDTO.remainingAmount" >Remaining Amount</form:label>
				      	</div>
				      	<div class="col-75" style="float: left; width: 25%;margin-top: 6px;">
							<form:input path="requestDispatchPartyDetailsDTO.remainingAmount" cssClass="form-control validate-integer-value" 
										id="dispatchpartyDetlledger_remainingAmount" readonly="true" maxlength="11" />
						</div>
					</div> --%>
					<br />

					<div class="row">
						<div class="form-group">
							<form:label path="recievedAmount">Received Amount *</form:label>
							<form:input path="recievedAmount"
								cssClass="form-control validate-required validate-integer-value"
								id="dispatchpartyledger_recievedAmount"
								placeholder="Received Amount" maxlength="11"
								onchange="dispatchPartyLedger_calculateRecievedAmount()" />
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<form:label path="remaining">Remaining Amount</form:label>
							<form:input path="remaining"
								cssClass="form-control validate-required validate-integer-value"
								id="dispatchpartyledger_remainingAmount"
								placeholder="Remaining Amount" maxlength="11" readonly="true" />
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<form:label path="sourceOfAmount">Source of Amount * </form:label>
							<form:select path="sourceOfAmount"
								cssClass="form-control validate-required"
								id="dispatchpartyledger_sourceOfAmount">
								<form:option value="">Select Source of Amount</form:option>
								<form:options items="${sourceOfAmount}" />
							</form:select>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<form:label path="recievedAccount">Account No.</form:label>
							<form:input path="recievedAccount"
								cssClass="form-control validate-integer-value"
								id="dispatchpartyledger_accountNo" placeholder="Account No"
								maxlength="11" />
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<form:label path="bank">Bank</form:label>
							<form:select path="bank" cssClass="form-control"
								id="dispatchpartyledger_bank">
								<form:option value="">Select Bank</form:option>
								<form:options items="${bank}" />
							</form:select>
						</div>
					</div>


					<form:hidden
						path="requestDispatchPartyDetailsDTO.dispatchPartyDetailsId"
						id="dispatchpartydetails_dispatchpartydetailsId" />
					<form:hidden path="dispatchPartyLedgerId"
						id="dispatchpartyledger_dispatchPartyLedgerId" />
					<form:hidden path="requestDispatchPartyDetailsDTO.paidAmount"
						id="dispatchpartyledger_paidAmount" />
					<form:hidden path="requestDispatchPartyDetailsDTO.amount"
						id="dispatchpartyledger_amount" />

					<div class="row">
						<div class="col-25"
							style="float: left; width: 15%; margin-top: 15px;">
							<button id="dispatchparty-save-btn" type="submit" class="btn"
								onclick="return dispatchPartyLedger_crud(event);">Save</button>
						</div>
					</div>

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
.ui-datepicker-month {
	background-color: #275064
}

.ui-datepicker-year {
	background-color: #275064
}
</style>
		</div>
	</div>
</body>
</html>
