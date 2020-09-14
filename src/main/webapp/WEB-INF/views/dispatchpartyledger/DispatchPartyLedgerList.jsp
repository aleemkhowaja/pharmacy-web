<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
 
<!-------------------- crud urls  ---------------------------->
 <c:url var="returnAllDispatchPartyLedgerForGrid" value="/dispatchpartyledger/findAll">
</c:url> --%>
<!-- ------------------------------------------------------ -->
<%-- <jsp:include page="../common/header.jsp" /> --%>
<script src="<c:url value="/js/dispatchpartyledger\dispatchPartyLedger.js" />"> </script>
<body class="page-header-fixed compact-menu page-horizontal-bar">
	<%-- <jsp:include page="../common/menues.jsp" /> --%>
		<div class="page-title">
			<div class="container">
				<div class="adv_ser_row">
					<!-- <h2>Dispatch Party Details</h2> -->
					<!-- Start Search Fields -->
					
						<%-- <form:form cssClass="m-t-md ajax-form-login validate-form" method="post" modelAttribute="dispatchpartyledger" id="dispatchpartySearch_form">
							<div class="row">
								<div class="col-25" style="float: left;width: 11%;margin-top: 6px;">
						        	<form:label  path="requestDispatchPartyDetailsDTO.dispatchparty" cssStyle="padding: 7px 12px 12px 0;display: inline-block;"> Dispatch Party </form:label>
						      	</div>
						      	<div class="col-75" style="float: left; width: 21%;margin-top: 6px;">
						      		<form:select 	path="requestDispatchPartyDetailsDTO.dispatchparty" cssClass="form-control" id="searcDispatchpartydetails_dispatchParty" 
						      						cssStyle="width: 95%; padding: 6px; border: 1px solid #ccc; border-radius: 4px; resize: vertical;" >
		                    			<form:option value="">Select DispatchParty</form:option>
		                    			<form:options items="${dispatchPartyList}" itemValue="dispatchPartyId" itemLabel="dispatchParty"   />
	                    			</form:select>
								</div>
							</div>
							<div class="col-25" style="float: left;width: 11%;margin-top: 6px;"> </div>
							<div class="row">
								<div class="col-25" style="float: left;width: 11%;margin-top: 6px;">
											 <input type="button" value="Search" id="search-dispatchpartydetails-button" />
								</div>
							</div>
						</form:form> --%>
					</div>
				</div>

				<table id="dispatchpartydetailsgridlist">
					<tr>
						<td />
					</tr>
				</table>
				<div id="pager"></div>
			</div>
		</div>
		<div id="main-wrapper" class="container">
			<!-- <div id="dispatchpartyledgergridlist" class="grid-container"></div> -->
			<div style="clear: both;"></div>

			<jsp:include page="DispatchPartyLedger.jsp" />

			<script type="text/javascript">
				$(document).ready(function(){
					var token = $("meta[name='_csrf']").attr("content");
					var header = $("meta[name='_csrf_header']").attr("content");
					$("#dispatchpartyledgergridlist").jqGrid({
						url : "${returnAllDispatchPartyLedgerForGrid}",

						datatype : "json",
						mtype : 'POST',
						width : 800,
						height : 400,
						colNames : [ "Dispatch Party",'Date', 'Quality','Tons','Rate','Amount','Rebate','dispatchPartyDetailsId'],
						colModel : [
							{
								name : 'dispatchParty.dispatchParty',
								index : 'dateOf',
								width : 100,
								editable : false,
							},
							{
								name : 'dateOf',
								index : 'dateOf',
								width : 100,
								editable : false,
							},
							{
								name : 'quality',
								index : 'quality',
								width : 100,
								editable : false,
							},
							{
								name : 'tons',
								index : 'tons',
								width : 100,
								editable : false,
							},
							{
								name : 'rate',
								index : 'rate',
								width : 100,
								editable : false,
							},
							{
								name : 'amount',
								index : 'amount',
								width : 100,
								editable : false,
							},
							{
								name : 'rebate',
								index : 'rebate',
								width : 100,
								editable : false,
							},
							{
								name : 'dispatchPartyDetailsId',
						        index : 'dispatchPartyDetailsId',
						        width : 150,
						        hidden : true,
								key : true,
							}
						],

						ondblClickRow: function(rowId) {
							dispatchpartyDetails_Db_Click(rowId);
						},
				        loadComplete: function() {
				        	loaddispatachPartyDetails();
				        },
					    pager : '#pager',
					    rowNum : 5,
					    height: 'auto',
					    rowList : [ 5,10,20,30,40 ],
					    sortname : 'dispatchPartyDetailsId',
					    sortorder : 'asc',
					    viewrecords : true,
					    gridview : true,
					    multiselect: false,
					    multiboxonly: false,
					    editinline : true,
					   /*  onSelectRow: editRow, */
					    editurl : '${returnAllDispatchPartyDetailsForGrid}',
					    caption : 'Dispatch Party Details',
					    jsonReader : {
					    	repeatitems : false,
					    }
					});

					// activate the toolbar searching
				    $('#jqGrid').jqGrid('filterToolbar',{
				    	// JSON stringify all data from search, including search toolbar operators
				        stringResult: true,
				        // instuct the grid toolbar to show the search options
				        searchOperators: true
					});

				    var lastSelection;

				    function editRow(id) {
		                if (id && id !== lastSelection) {
		                    var grid = $("#dispatchpartydetailsgridlist");
		                    grid.jqGrid('restoreRow',lastSelection);
		                    grid.jqGrid('editRow',id, {keys: true} );
		                    lastSelection = id;
		                }
		            }

				    /* Serche by Dispatch Party */
				    $('#search-dispatchpartydetails-button').on('click',function()
					{
						var dispatchParty =  $("#searcDispatchpartydetails_dispatchParty").val();                             
						jQuery("#dispatchpartydetailsgridlist").jqGrid('setGridParam',{url:"dispatchpartydetails/findAll?dispatchParty="+dispatchParty}).trigger("reloadGrid");
				    });
				  });
				</script>
		<!-- Row -->
</body>
</html>
