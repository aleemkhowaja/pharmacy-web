<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url var="saveDispatchPartyDetails" value="/dispatchpartydetails/save" ></c:url>


<div class="page-title" class="disptach_party_details">
	<div class="container">
		<div class="adv_ser_row" >
			<h2>Add Dispatch Party Details</h2>
			<!-- Start Search Fields -->
			<div class="col-md-8">
            	<form:form 		servletRelativeAction="${saveDispatchPartyDetails}" cssClass="m-t-md ajax-form-login validate-form" 
            					method="post" modelAttribute="dispatchpartydetails" id="dispatchpartydetails_form">
					
					<div class="row">
						<div class="col-25" style="float: left;width: 11%;margin-top: 6px;">
				        	<form:label  path="dateOf" cssStyle="padding: 7px 12px 12px 0;display: inline-block;"> Date * </form:label>
				      	</div>
				      	<div class="col-75" style="float: left; width: 21%;margin-top: 6px;">
					    	<form:input path="dateOf" cssClass="validate-required datetimepicker" id="dispatchpartydetails_dateOf" placeholder="Date"
					    		cssStyle="width: 95%; padding: 6px; border: 1px solid #ccc; border-radius: 4px; resize: vertical;"  />
						</div>
					</div>
					
	            	<div class="row">
				    	<div class="col-25" style="float: left;width: 11%;margin-top: 6px;">
				        	<form:label  path="quantity" cssStyle="padding: 7px 12px 12px 0;display: inline-block;"> Quantity * </form:label>
				      	</div>
				      	<div class="col-75" style="float: left; width: 21%;margin-top: 6px;">
					    	<form:input path="quantity" cssClass="validate-required" id="dispatchpartydetails_quantity" placeholder="Quanity"
					    		cssStyle="width: 95%; padding: 6px; border: 1px solid #ccc; border-radius: 4px; resize: vertical;"  />
						</div>
						
						<div class="col-25" style="float: left;width: 11%;margin-top: 6px;">
				        	<form:label  path="tons" cssStyle="padding: 7px 12px 12px 0;display: inline-block;"> Tons * </form:label>
				      	</div>
				      	<div class="col-75" style="float: left; width: 21%;margin-top: 6px;">
					    	<form:input path="tons" cssClass="validate-required" id="dispatchpartydetails_tons" placeholder="Tons"
					    		cssStyle="width: 95%; padding: 6px; border: 1px solid #ccc; border-radius: 4px; resize: vertical;"  />
						</div>
    				</div>
    				
    				<div class="row">
				    	<div class="col-25" style="float: left;width: 11%;margin-top: 6px;">
				        	<form:label  path="rate" cssStyle="padding: 7px 12px 12px 0;display: inline-block;"> Rate * </form:label>
				      	</div>
				      	<div class="col-75" style="float: left; width: 21%;margin-top: 6px;">
					    	<form:input path="rate" cssClass="validate-required" id="dispatchpartydetails_rate" placeholder="Rate"
					    		cssStyle="width: 95%; padding: 6px; border: 1px solid #ccc; border-radius: 4px; resize: vertical;"  />
						</div>
						
						<div class="col-25" style="float: left;width: 11%;margin-top: 6px;">
				        	<form:label  path="amount" cssStyle="padding: 7px 12px 12px 0;display: inline-block;"> Amount * </form:label>
				      	</div>
				      	<div class="col-75" style="float: left; width: 21%;margin-top: 6px;">
					    	<form:input path="amount" cssClass="validate-required" id="dispatchpartydetails_amount" placeholder="Amount"
					    		cssStyle="width: 95%; padding: 6px; border: 1px solid #ccc; border-radius: 4px; resize: vertical;"  />
						</div>
    				</div>
    				
    				
    				<div class="row">
				    	<div class="col-25" style="float: left;width: 11%;margin-top: 6px;">
				        	<form:label  path="rebate" cssStyle="padding: 7px 12px 12px 0;display: inline-block;"> Rebate * </form:label>
				      	</div>
				      	<div class="col-75" style="float: left; width: 21%;margin-top: 6px;">
					    	<form:input path="rebate" cssClass="validate-required" id="dispatchpartydetails_rebate" placeholder="Rebate"
					    		cssStyle="width: 95%; padding: 6px; border: 1px solid #ccc; border-radius: 4px; resize: vertical;"  />
						</div>
    				</div>
    				<div class="row">
    					<div class="col-25">
    						  <button id="dispatchpartydetail-add-btn" class="btn" onclick="return adddispatchPartDetails();">Add</button>
    					</div>
    				</div>
    				 <form:hidden path="dispatchPartyDetailsId" id="dispatchpartydetails_dispatchPartyDetailsId" />
                </form:form>
			</div>
		</div>
	</div>
</div>

<style>

		
/* 		div.disptach_party_detail input[type=text], select, textarea {
		  width: 100%;
		  padding: 12px;
		  border: 1px solid #ccc;
		  border-radius: 4px;
		  resize: vertical;
		}
		
		div.disptach_party_detail label {
		  padding: 12px 12px 12px 0;
		  display: inline-block;
		}
		
		div.disptach_party_detail input[type=submit] {
		  background-color: #4CAF50;
		  color: white;
		  padding: 12px 20px;
		  border: none;
		  border-radius: 4px;
		  cursor: pointer;
		  float: right;
		}
		
		div.disptach_party_detail input[type=submit]:hover {
		  background-color: #45a049;
		}
		
		div.disptach_party_detail .container {
		  border-radius: 5px;
		  background-color: #f2f2f2;
		  padding: 20px;
		}
		
		div.disptach_party_detail .col-25 {
		  float: left;
		  width: 25%;
		  margin-top: 6px;
		}
		
		div.disptach_party_detail .col-75 {
		  float: left;
		  width: 75%;
		  margin-top: 6px;
		}
		
		/* Clear floats after the columns */
		div.disptach_party_detail .row:after {
		  content: "";
		  display: table;
		  clear: both;
		}
		
		/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
		@media screen and (max-width: 600px) {
		  .col-25, .col-75, input[type=submit] {
		    width: 100%;
		    margin-top: 0;
		  }
		} */
</style>


<script>
	$(document).ready(function()
	{
		$("#dialogId").css("overflow-x", "hidden");
			$('.datepicker').datepicker({
				dateFormat: 'yy-m-dd',
				showButtonPanel: true,
				changeMonth: true,
				buttonImage: "calendar.gif",
				buttonText: "Calendar"
			});
	});
</script>
