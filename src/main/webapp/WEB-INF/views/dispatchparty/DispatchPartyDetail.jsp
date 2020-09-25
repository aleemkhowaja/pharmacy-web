<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url var="saveDispatchParty" value="/dispatchparty/save"></c:url>

<h2>Add Dispatch Party</h2>
<!-- Start Search Fields -->
<div class="col-md-8">
	<form:form servletRelativeAction="${saveDispatchParty}"
		cssClass="m-t-md ajax-form-login validate-form" method="post"
		modelAttribute="dispatchparty" id="dispatchparty_form">

		<div class="form-group">
			<form:label path="dispatchParty"> Dispatch Party * </form:label>
			<form:input path="dispatchParty"
				cssClass="form-control validate-required" id="dispatchparty"
				placeholder="Dispatch Party" maxlength="255" />
		</div>

		<div class="form-group">
			<form:label path="dispatchPartyOwner"> Dispatch Party Owner  </form:label>
			<form:input path="dispatchPartyOwner"
				cssClass="form-control validate-required" id="dispatchparty_owner"
				placeholder="Dispatcher Party Owner" maxlength="255" />
		</div>

		<button id="dispatchparty-save-btn" type="submit" class="btn"
			onclick="return dispatchparty_crud(event);">Save</button>

		<!-- Hidden fields -->
		<form:hidden path="dispatchPartyId" id="dispatchparty_dispatchpartyId" />
		<!-- Dispatch Details  Hidden Fields -->
		<%--            <form:hidden path="requestDispatchPartyDetailsDTO.dateOf" id="dispatchParty_dateof" />
                    <form:hidden path="requestDispatchPartyDetailsDTO.quantity" id="dispatchParty_quantity" />
                    <form:hidden path="requestDispatchPartyDetailsDTO.tons" id="dispatchParty_tons" />
                    <form:hidden path="requestDispatchPartyDetailsDTO.rate" id="dispatchParty_rate" />
                    <form:hidden path="requestDispatchPartyDetailsDTO.ammount" id="dispatchParty_ammount" />
                    <form:hidden path="requestDispatchPartyDetailsDTO.rebate" id="dispatchParty_rebate" />
                    <form:hidden path="requestDispatchPartyDetailsDTO.dispatchpartyId" id="dispatchParty_dispatchpartyId" />
                    
 --%>

		<div id="dialogId" title="Dispatch Party Details"></div>
		<input type="hidden" id="dispatchParty_details" />

	</form:form>
</div>
<div id="pager"></div>
