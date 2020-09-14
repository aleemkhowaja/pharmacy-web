<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<!-------------------- crud urls  ---------------------------->
<c:url var="returnAllEmployeeForGrid" value="/employee/findAll"></c:url>
<!-- ------------------------------------------------------ -->
<%-- <jsp:include page="../common/header.jsp" /> --%>
<script src="<c:url value="/js/employee/employee.js" />"> </script>
<body class="page-header-fixed compact-menu page-horizontal-bar">
	<%-- <jsp:include page="../common/menues.jsp" /> --%>
		<div class="page-title">
			<div class="container">
				<div class="adv_ser_row">
					<h2>Employees</h2>
					<!-- Start Search Fields -->
					<span> <input class="smallinput" type="text"
						name="employeeName" id="employeeName" placeholder="Employee Name" />
						<input type="button" value="Search" id="search-employee-button" />
					</span>
				</div>

				<table id="employee-detail-grid-list">
					<tr>
						<td />
					</tr>
				</table>
				<div id="pager"></div>
			</div>
		</div>
		<div id="main-wrapper" class="container">
			<div id="employee-detail-grid-list" class="grid-container"></div>
			<div style="clear: both;"></div>

			<jsp:include page="EmployeeDetail.jsp" />

			<script type="text/javascript">
					
					$(document).ready(function(){
						var token = $("meta[name='_csrf']").attr("content");
					    var header = $("meta[name='_csrf_header']").attr("content");
						 $("#employee-detail-grid-list").jqGrid({
							url : "${returnAllEmployeeForGrid}",
							datatype : "json",
							mtype : 'POST',
							width : 1000,
							height : 400,
							colNames : [ 'Employee Name','Father Name','Contact No','Email','Address','Designation','Employee Id'],
							colModel : [
								{
									name : 'employeeName',
									index : 'employeeName',
									width : 150,
									editable : false,
								},
								{
									name : 'fatherName',
									index : 'fatherName',
									width : 150,
									editable : false,
								},
								{
									name : 'contactNo',
							        index : 'contactNo',
							        width : 150,
							        editable : false
								},
								{
									name : 'email',
									index : 'email',
									width : 150
								}, 
								{
									name : 'address',
							        index : 'address',
							        width : 150,
							        editable : false,
								},
								{
									name : 'designation',
							        index : 'designation',
							        width : 150,
							        editable : false
								},
								{
									name : 'employeeId',
							        index : 'employeeId',
							        width : 150,
							        hidden : true,
									key : true,
								}
								],
								ondblClickRow: function(rowId) {
									employee_Db_Click(rowId);
								},
							    pager : '#pager',
							    rowNum : 5,
							    height: 'auto',
							    rowList : [ 5,10,20,30,40 ],
							    sortname : 'employeeName',
							    sortorder : 'asc',
							    viewrecords : true,
							    gridview : true,
							    multiselect: false,
							    multiboxonly: false,
							    caption : 'Employee',
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
						
				            /* jQuery("#department-detail-grid-list").jqGrid('navGrid','#pager',{del:false,add:false,edit:false,search:true});
				            jQuery("#department-detail-grid-list").jqGrid('filterToolbar',{stringResult: true,searchOnEnter : true}); */
							

							$('#search-employee-button').on('click',function(){
								var employeeName =  $("#employeeName").val();                             
								jQuery("#employee-detail-grid-list").jqGrid('setGridParam',{url:"employee/findAll?employeeName="+employeeName}).trigger("reloadGrid");
								
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
