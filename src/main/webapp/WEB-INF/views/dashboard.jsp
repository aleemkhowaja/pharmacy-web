<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />


<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<jsp:include page="./common/header.jsp" />
   <head>
   		<script>
			var today = new Date();
			var dd = today.getDate();
			var mm = today.getMonth()+1; //January is 0!
		
			var yyyy = today.getFullYear();
			if(dd<10){
			    dd='0'+dd;
			} 
			if(mm<10){
			    mm='0'+mm;
			} 
			var today = dd+'/'+mm+'/'+yyyy;
			$("#title-with-date").val("Quality Assurance System "+today);
    </script>
   </head>
    <body class="page-header-fixed compact-menu page-horizontal-bar">
    	<!-- <form  action="#" > -->
    		<jsp:include page="./common/menues.jsp" />
				<div class="page-inner">
			    <div class="page-title">
			        <div class="container">
			            <h3 id="title-with-date"> Welcome </h3>
			        </div>
			    </div>
			    <div id="main-wrapper" class="container">
			        <div class="row"  id="dashboard-charts">
			            <div class="col-lg-12 col-md-12">
			            	<!-- HEC XY Publication Chart Start -->
			            	<span class="chart-label-hec-research-paper">Year of HEC XY Publication</span>
							<select id="dashboardHECXYPublicationYearCombo" name="researhPaperYearCombo" class="select" onchange="dashboard_returnHECXYResearchPapersByYearForChart();">
								<option value="0">All</option>
							</select>
							<div class="panel panel-white">
			                    <div class="row">
			                    </div>
			                </div>
			                <div class="panel panel-white">
			                    <div class="row">
			                        <div class="col-sm-12">
			                            <div id="journal_Hec_Category"></div>
			                        </div>
			                    </div>
			                </div>
			                <!-- HEC XY Publication Chart End -->
			                
			                <!-- Impact FactorBy HEC Start -->
			                <span class="chart-label-hec-research-paper">Year of Impact Factor By HEC</span>
							<select id="dashboardMonthlyImpactFactorByHECYearCombo" name="monthlyImpactFactorYearCombo" class="select" onchange="dashboard_returnMonthlyImpactFactorByYearForChart();">
								<option value="0">All</option>
							</select>
							<div class="panel panel-white">
			                    <div class="row">
			                    </div>
			                </div>
			                <div class="panel panel-white">
			                    <div class="row">
			
			                        <div class="col-sm-12">
			                            <div id="impact_factor"></div>
			                        </div>
			                    </div>
			                </div>
			                 <!-- Impact FactorBy HEC End -->
			                
			                <!-- Employee Travel Grant by department Start  -->
			                <span class="chart-label-hec-research-paper">Year of Travel Grant</span>
							<select id="dashboardEmployeeTravelGrantYearCombo" name="dashboardEmployeeTravelGrantYearCombo" class="select" onchange="dashboard_returnEmployeeTravelGrantByYearForChart();">
								<option value="0">All</option>
							</select>
							<div class="panel panel-white">
			                    <div class="row">
			                    </div>
			                </div>
			                
			                <div class="panel panel-white">
			                    <div class="row">
			
			                        <div class="col-sm-12">
			                            <div id="emp_travelgrands_new"></div>
			                        </div>
			                    </div>
			                </div>
			                <!-- Employee Travel Grant by department end -->
			                
			                
			                <!-- Employee Research Funding Grant by department Start  -->
			                <span class="chart-label-hec-research-paper">Year of Research Funding</span>
							<select id="dashboardEmployeeResearchFundingYearCombo" name="dashboardEmployeeResearchFundingYearCombo" class="select" onchange="dashboard_returnChartByYear('RFG',this);">
								<option value="0">All</option>
							</select>
							<div class="panel panel-white">
			                    <div class="row">
			                    </div>
			                </div>
			                <div class="panel panel-white">
			                    <div class="row">
			
			                        <div class="col-sm-12">
			                            <div id="research_funding_grants"></div>
			                        </div>
			                    </div>
			                </div>
			                 <!-- Employee Research Funding Grant by department End  -->
			                 
			                 <!-- Employee Community Services Start  -->
			                <span class="chart-label-community-ervices-year">Year of Community Services</span>
							<select id="dashboardEmployeeCommunityServicesYearCombo" name="dashboardEmployeeCommunitySerYearCombo" class="select" onchange="dashboard_returnChartByYear('CSG',this);">
								<option value="0">All</option>
							</select>
							<div class="panel panel-white">
			                    <div class="row">
			                    </div>
			                </div>
			                
			                <div class="panel panel-white">
			                    <div class="row">
			
			                        <div class="col-sm-12">
			                            <div id="community_services"></div>
			                        </div>
			                    </div>
			                </div>
			                 <!-- Employee Community Services End  -->
			                 
			                 <div class="panel panel-white">
			                    <div class="row">
			
			                        <div class="col-sm-12">
			                            <div id="ifh"></div>
			                        </div>
			                    </div>
			                </div>
			
			            </div>
			
			
			
			
			
			        </div>
			    </div><!-- Main Wrapper -->
			    <div class="page-footer">
			        <jsp:include page="./common/footer.jsp" />
			    </div></div>
			<%-- <script src="<c:url value="/resources/theme/js/pages/dashboard.js" />"></script> --%>
			</main><!-- Page Content -->
			<div class="cd-overlay"></div>
			<script src="<c:url value="/js/qec-charts/dashboardCharts.js" />"></script>
</body>
</html>