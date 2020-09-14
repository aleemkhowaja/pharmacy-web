<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<html xmlns="http://www.w3.org/1999/xhtml">
	
	<!-------------------- crud urls  ---------------------------->
	<c:url var="returnAllDepartmentForGrid" value="/qec/department/returnAllDepartmentsForGrid/" ></c:url>
	<!-- ------------------------------------------------------ -->
	<%-- <jsp:include page="../common/header.jsp" /> --%>
	<body class="page-header-fixed compact-menu page-horizontal-bar">
		<div class="loader"></div>
		
		<style>	
			 .loader 
			    {
				  border: 16px solid #f3f3f3;
				  border-radius: 50%;
				  border-top: 16px solid #3498db;
				  width: 120px;
				  height: 120px;
				  -webkit-animation: spin 2s linear infinite; /* Safari */
				  animation: spin 2s linear infinite;
				  margin-left: 50%;
    				margin-top: 10%;
				}
			
				/* Safari */
				@-webkit-keyframes spin 
				{
				  0% { -webkit-transform: rotate(0deg); }
				  100% { -webkit-transform: rotate(360deg); }
				}
			
				@keyframes spin 
				{
				  0% { transform: rotate(0deg); }
				  100% { transform: rotate(360deg); }
				}
		</style>
	</body>
</html>