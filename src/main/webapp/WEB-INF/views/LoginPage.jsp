<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>

<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<head>

<!-- Title -->
<title>Moomal & Sindhu Coal Mining Company Pvt Ltd | Login - Sign in</title>

<!-- Title -->
<title>Moomal & Sindhu Coal Mining Company Pvt Ltd</title>
<meta content="width=device-width, initial-scale=1" name="viewport" />
<meta charset="UTF-8">
<meta name="description" content="Admin Dashboard Template" />
<meta name="keywords" content="admin,dashboard" />
<meta name="author" content="Steelcoders" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:url var="home" value="/" scope="request" />

<link
	href="<c:url value="/plugins/uniform/css/uniform.default.min.css" />"
	rel="stylesheet" type="text/css">
<link
	href="<c:url value="/plugins/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet" type="text/css">

<!-- Theme Styles -->
<link href=" <c:url value="/css/modern.min.css" />"
	rel="stylesheet" type="text/css" />
<link href=" <c:url value="/css/custom.css" />"
	rel="stylesheet" type="text/css" />
<script
	src="<c:url value="/plugins/3d-bold-navigation/js/modernizr.js" />"> </script>

<style>
.page-content {
	/*background:url(http://3melements.com/sindhuni/assets/images/sindh_uni_gate.jpg) center -150px no-repeat;*/
	background-size: cover;
}

.page-inner {
	/*background:rgba(0,0,0,.4);*/
	background: rgba(27, 117, 161, 0.88)
}

.login-box {
	margin: auto;
	background: rgb(27, 117, 161);
	border-radius: 3px;
	padding: 6px;
	width: 100%;
	max-width: 100%;
}
</style>

</head>
<body class="page-login" id="body">
	<div class="page-inner">
		<div id="main-wrapper">
			<div class="row">
				<div class="col-md-4 center">
					<div class="login-box">
						<a href="#" class="logo-name text-lg text-center"><img
							src="/images/logo.png"></a>
					</div>
				</div>
				<c:url var="loginUrl" value="/login.htm" />
				<div class="col-md-4 center">
					<div class="login-panel">
						<p class="text-center m-t-md log-p">Please login into your
							account.</p>
						<c:if test="${not empty error}">
							<h5 class="text-center"
								style="border-bottom-color: red; color: red">Wrong Username
								OR Password</h5>
						</c:if>

						<form:form cssClass="m-t-md ajax-form-login" action="${loginUrl}"
							method="POST" modelAttribute="login">
							<div class="form-group">
								<form:label path="username">Username</form:label>
								<form:input path="username" cssClass="form-control"
									placeholder="Username" />
	 							</div>

							<div class="form-group">
								<form:label path="password">Password</form:label>
								<form:password path="password" cssClass="form-control"
									placeholder="Password" />
							</div>
							<button type="submit" class="btn btn-success btn-block login-btn">Login</button>
							<%-- <input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> --%>
						</form:form>
					</div>
				</div>
			</div>
			<!-- Row -->
		</div>
		<!-- Main Wrapper -->
		<div class="page-footer" align="center">
			<jsp:include page="./common/footer.jsp" />
	    </div>
	</div>
	<!-- Page Inner --> </main>
	<!-- Page Content -->
</body>
</html>