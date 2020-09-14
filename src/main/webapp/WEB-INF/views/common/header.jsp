<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<head>
	<!-- Title -->
    <title>Moomal & Sindhu Coal Mining Company Pvt Ltd</title>
    <meta content="width=device-width, initial-scale=1" name="viewport"/>
    <meta charset="UTF-8">
    <meta name="description" content="Admin Dashboard Template" />
    <meta name="keywords" content="admin,dashboard" />
    <meta name="author" content="Steelcoders" />
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%-- 	<meta name="_csrf" content="${_csrf.token}" />
	<meta name="_csrf_header" content="${_csrf.headerName}" /> --%>
	
    <c:url var="home" value="/" scope="request" />
        
    <!-- Styles -->
    <link href="<c:url value="/css/jquery-ui.css" />" rel="stylesheet">
    <%--  <link href="<c:url value="http://fonts.googleapis.com/css?family=Ubuntu:300,400,500,700" />" rel="stylesheet" type="text/css"> --%>
    <link href="<c:url value="/plugins/pace-master/themes/blue/pace-theme-flash.css" />" rel="stylesheet" type="text/css">
        
    <link href="<c:url value="/plugins/uniform/css/uniform.default.min.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/plugins/bootstrap/css/bootstrap.min.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/plugins/fontawesome/css/font-awesome.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/plugins/line-icons/simple-line-icons.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/plugins/waves/waves.min.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/plugins/switchery/switchery.min.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/plugins/3d-bold-navigation/css/style.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/plugins/slidepushmenus/css/component.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/plugins/weather-icons-master/css/weather-icons.min.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/plugins/metrojs/MetroJs.min.css" />" rel="stylesheet" type="text/css">
   <%--  <link href="<c:url value="/plugins/toastr/toastr.min.css" />" rel="stylesheet" type="text/css"> --%>
    <!-- notification -->
    <link href="<c:url value="/css/toast/iziToast.min.css" />" rel="stylesheet">
    
    <!-- Theme Styles -->
    <link href=" <c:url value="/css/modern.min.css" />" rel="stylesheet" type="text/css"/>
    <link href=" <c:url value="/css/custom.css" />" rel="stylesheet" type="text/css"/>
    <script  src="<c:url value="/plugins/3d-bold-navigation/js/modernizr.js" />" > </script>
    <link href=" <c:url value="/css/style.css" />" rel="stylesheet" type="text/css"/>
		
	<!-- jq grid -->
	<link href=" <c:url value="/js/jqgrid/style/ui.jqgrid.css" />" rel="stylesheet" type="text/css"/>
	<link href=" <c:url value="/js/jqgrid/style/searchFilter.css" />" rel="stylesheet" type="text/css"/>
	<link href=" <c:url value="/js/jqgrid/style/ui.multiselect.css" />" rel="stylesheet" type="text/css"/>
	
	<!--  High charts css -->
	<link href=" <c:url value="/plugins/highcharts/css/highcharts.css" />" rel="stylesheet" type="text/css"/>
	
	<!-- Smoke Validation -->
	<link href=" <c:url value="/js/formValidation/css/smoke.min.css" />" rel="stylesheet" type="text/css"/>
	
	<!-- bootstrap Date and time picker  -->
	<%-- <link href=" <c:url value="/plugins/bootstrap-datetimepicker\css\bootstrap-datetimepicker.min.css" />" rel="stylesheet" type="text/css"/> --%>
	
    <!-- Javascripts -->
    <script src="<c:url value="/js/jquery-1.10.2.js" />"></script>
    <script src="<c:url value="/js/jquery-ui.js" />"></script>
    <script src="<c:url value="/plugins/pace-master/pace.min.js" />"></script>
    <script src="<c:url value="/plugins/jquery-blockui/jquery.blockui.js" />"></script>
    <script src="<c:url value="/plugins/bootstrap/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/plugins/jquery-slimscroll/jquery.slimscroll.min.js" />"></script>
    <script src="<c:url value="/plugins/switchery/switchery.min.js" />"></script>
    <script src="<c:url value="/plugins/jquery-slimscroll/jquery.slimscroll.min.js" />"></script>
    <script src="<c:url value="/plugins/uniform/jquery.uniform.min.js" />"></script>
    <script src="<c:url value="/plugins/classie/classie.js" />"></script>
    <script src="<c:url value="/plugins/waves/waves.min.js" />"></script>
    <script src="<c:url value="/js/login.js" />"></script>
    <script  src="<c:url value="/js/jquery.flot.js" />" > </script>
	<%-- <script src="<c:url value="/js/style.js" />"></script>
	<script src="<c:url value="/js/jquery.timepicker.min.js" />"></script> --%>
	<script src="<c:url value="/plugins/toastr/toastr.min.js" />"></script> 
	<script src="<c:url value="/js/modern.js" />"></script>
	
	<script src="<c:url value="/js/toast/iziToast.min.js" />"></script>
		
	<!--  jq grid-->
	<script src="<c:url value="/js/jqgrid/i18n/grid.locale-en.js" />"></script>
	<script src="<c:url value="/js/jqgrid/jquery.jqGrid.js" />"></script>

	<!-- Highcharts -->
	<script src="<c:url value="/plugins/highcharts/js/highcharts.js" />"></script>
	<script src="<c:url value="/plugins/highcharts/js/exporting.js" />"></script>
	
	<!-- Smoke Validation Form -->
	<script src="<c:url value="/js/formValidation/js/smoke.min.js" />"></script>
	
	<link href="<c:url value="/css/style.css" />" rel="stylesheet" />
	
	<!-- Datepicker  -->
	<!-- bootstrap Date and time picker  -->
	<%-- <script  src="<c:url value="/plugins/bootstrap-datetimepicker\js\bootstrap-datetimepicker.min.js" />" > </script> --%>
	
	<!-- common script -->
	<script src="<c:url value="/js/script.js" />"></script>
	
	<script src="<c:url value="/js/common/commonForm.js" />"></script>
	
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
    <style>
		.page-content 
		{
			/*background:url(http://3melements.com/sindhuni/assets/images/sindh_uni_gate.jpg) center -150px no-repeat;*/
		    background-size:cover;
		}
		.page-inner
		{
			/*background:rgba(0,0,0,.4);*/
		    /* background:rgba(27, 117, 161, 0.88) */
		}
		.login-box 
		{
			margin: auto;
		    background: rgb(27, 117, 161);
		    border-radius: 3px;
		    padding: 6px;
		    width: 100%;
		    max-width: 100%;
		}
		.ui-jqgrid-titlebar 
		 {
			background: #275064;
		 }
		 .ui-datepicker-div ui-widget-header
		 {
			background: #1B75A1;
		 }
		 .ui-jqgrid ui-widget ui-widget-content ui-corner-all
		 {
		 	margin-left: 0%
		 }
    </style>
</head>
<label id="validate-required-error" style="display: none;" class="non-readonly" >Field is required.</label>
<label id="validate-regex-error" style="display: none;" class="non-readonly" >Please Enter Valid Value.</label>
