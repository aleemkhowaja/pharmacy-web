<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<!-------------------- crud urls  ---------------------------->
<c:url var="returnAllDispatchPartyForGrid"
	value="/dispatchparty/findAll"></c:url>
<!-- ------------------------------------------------------ -->
<%-- <jsp:include page="../common/header.jsp" /> --%>
<script src="<c:url value="/js/dispatchparty/dispatchParty.js" />"> </script>
<body class="page-header-fixed compact-menu page-horizontal-bar">
	<%-- <jsp:include page="../common/menues.jsp" /> --%>
	<div class="page-title">
		<div class="container">
			<div class="adv_ser_row">
				<h2>Dispatch Party</h2>
				<!-- Start Search Fields -->
				<span> <input class="smallinput" type="text"
					name="dispatchParty" id="dispatchParty"
					placeholder="Dispatch Party" /> <input type="button"
					value="Search" id="search-dispatchparty-button" />
				</span>
			</div>

			<table id="dispatchparty-detail-grid-list">
				<tr>
					<td />
				</tr>
			</table>
			<div id="pager"></div>
		</div>
	</div>
	<div id="main-wrapper" class="container">
		<div id="dispatchparty-detail-grid-list" class="grid-container"></div>
		<div style="clear: both;"></div>

		<jsp:include page="DispatchPartyDetail.jsp" />

		<script type="text/javascript">
				$(document).ready(function(){
					var token = $("meta[name='_csrf']").attr("content");
					var header = $("meta[name='_csrf_header']").attr("content");
					$("#dispatchparty-detail-grid-list").jqGrid({
						url : "${returnAllDispatchPartyForGrid}",
						datatype : "json",
						mtype : 'POST',
						width : 1000,
						height : 400,
						colNames : [ 'Dispatch Party','Dispatch Party Owner','Dispatch Party Id'],
						colModel : [
							{
								name : 'dispatchParty',
								index : 'dispatchParty',
								width : 150,
								editable : false,
							},
							{
								name : 'dispatchPartyOwner',
								index : 'dispatchPartyOwner',
								width : 150,
								editable : false,
							},
							{
								name : 'dispatchPartyId',
						        index : 'dispatchPartyId',
						        width : 150,
						        hidden : true,
								key : true,
							}
						],

						ondblClickRow: function(rowId) {
							dispatchparty_Db_Click(rowId);
						},
					    pager : '#pager',
					    rowNum : 5,
					    height: 'auto',
					    rowList : [ 5,10,20,30,40 ],
					    sortname : 'dispatchParty',
					    sortorder : 'asc',
					    viewrecords : true,
					    gridview : true,
					    multiselect: false,
					    multiboxonly: false,
					    caption : 'Dispatch Party',
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
						
				            
							
					$('#search-dispatchparty-button').on('click',function()
					{
						var dispatchParty =  $("#dispatchParty").val();                             
						jQuery("#dispatchparty-detail-grid-list").jqGrid('setGridParam',{url:"dispatchparty/findAll?dispatchParty="+dispatchParty}).trigger("reloadGrid");
				    });
				  });
				</script>
	</div>
	<!-- Row -->
	<!-- Main Wrapper -->
	<div class="page-footer">
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>
