   	<meta name="_csrf" content="${_csrf.token}" />
	<meta name="_csrf_header" content="${_csrf.headerName}" />
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div class="overlay"></div>
    
    <!--  start page urls -->
    <c:url var="returnEmployeePage" value="/employee.htm" ></c:url> 
    <c:url var="returnDispatchPartyPage" value="/dispatchparty.htm" ></c:url>
    <c:url var="returnDispatchPartyDetailsPage" value="/dispatchpartydetails.htm" ></c:url>
    <c:url var="returnDispatchPartyLedgerPage" value="/dispatchpartyledger.htm" ></c:url>
    <c:url var="returnEmployeeSalaryPage" value="/employeesalary.htm" ></c:url>

    
    <c:url var="logout" value="/logout" ></c:url>
    <!-- end page urls -->  
    <main class="page-content content-wrap">
    	<div class="navbar">
        	<div class="navbar-inner container">
            	<div class="sidebar-pusher">
                	<a href="javascript:void(0);" class="waves-effect waves-button waves-classic push-sidebar">
                    	<i class="fa fa-bars"></i>
                    </a>
                </div>
                <div class="logo-box">
                	<a href="http://3melements.com/sindhuni/" class="logo-text"><img src="/images/logo.png" width="200"></a>
                </div><!-- Logo Box -->
                <div class="search-button">
                	<a href="javascript:void(0);" class="waves-effect waves-button waves-classic show-search"><i class="fa fa-search"></i></a>
                </div>
                <div class="topmenu-outer">
                	<div class="top-menu">
                    	<ul class="nav navbar-nav navbar-right">
                        	<li class="dropdown">
                            	<a href="index.html#" class="dropdown-toggle waves-effect waves-button waves-classic" data-toggle="dropdown">
                                	<span class="user-name">admin<i class="fa fa-angle-down"></i></span>
                                	<!-- <img class="img-circle avatar" src="http://3melements.com/sindhuni/assets/images/avatar1.png" width="40" height="40" alt=""> -->
                                </a>
                                <ul class="dropdown-menu dropdown-list" role="menu">
                                	<li role="presentation"><a href="http://3melements.com/sindhuni/users/editprofile"><i class="fa fa-user"></i>Profile</a></li>
                                    <li role="presentation"><a href="${logout}"><i class="fa fa-sign-out m-r-xs"></i>Log out</a></li>
                                </ul>
                           	</li>
                     	</ul><!-- Nav -->
                  	</div><!-- Top Menu -->
                </div>
           	</div>
       </div><!-- Navbar -->
       <div class="page-sidebar sidebar">
       <div class="page-sidebar-inner">
	        <%-- <c:if test="${employee.role == 'admin'}"> --%>
		       	<ul class="menu accordion-menu">
		        	<li class="nav-heading"><span>Navigation</span></li>
		            <li class="active"><a href="${dashboardPage}"><span class="menu-icon icon-speedometer"></span><p>Dashboard</p></a></li>
		            
		            <li class="droplink "><a href="#" onclick="returnPage('${returnEmployeePage}',event);" ><span class="menu-icon fa fa-building"></span><p>Employee</p><span class="arrow"></span></a>
		            	<%-- <ul class="sub-menu">
		                    <li><a href="#" onclick="returnPage('${returnFacultyPage}',event);">Employee</a></li>
		                </ul> --%>
		            </li>
		            
		             <li class="droplink "><a href="#" onclick="returnPage('${returnDispatchPartyPage}',event);"  ><span class="menu-icon fa fa-building"></span><p>Dispatch Party</p><span class="arrow"></span></a>
		            	<%-- <ul class="sub-menu">
		                    <li><a href="#" onclick="returnPage('${returnDepartmentPage}',event);">Dispatch Party</a></li>
		                </ul> --%>
		            </li>
		            
		             <li class="droplink "><a href="#" onclick="returnPage('${returnDispatchPartyDetailsPage}',event);"  ><span class="menu-icon fa fa-building"></span><p>Dispatch Party Details</p><span class="arrow"></span></a>
		            	<%-- <ul class="sub-menu">
		                    <li><a href="#" onclick="returnPage('${returnDepartmentPage}',event);">Dispatch Party</a></li>
		                </ul> --%>
		            </li>
		            
		            <li class="droplink "><a href="#" onclick="returnPage('${returnDispatchPartyLedgerPage}',event);"  ><span class="menu-icon fa fa-building"></span><p>Dispatch Party Ledger</p><span class="arrow"></span></a>
		            	<%-- <ul class="sub-menu">
		                    <li><a href="#" onclick="returnPage('${returnDepartmentPage}',event);">Dispatch Party</a></li>
		                </ul> --%>
		            </li>
		            
		            <h4>Company Ledger</h4>
		            <li class="droplink "><a href="#" onclick="returnPage('${returnEmployeeSalaryPage}',event);"  ><span class="menu-icon fa fa-building"></span><p>Employee Salary</p><span class="arrow"></span></a>
		            </li>
		     	</ul>
	        <%-- </c:if> --%>
        </div><!-- Page Sidebar Inner -->
	</div><!-- Page Sidebar -->
            
            <script>
            
            function login_logut()
            {
            	var token = $("meta[name='_csrf']").attr("content");
                var header = $("meta[name='_csrf_header']").attr("content");
            	url ='/logout';
            	event.preventDefault();
            	$.ajax({
            		url :url,
            		 type: "POST",
                     contentType: "application/json",
                     beforeSend: function(xhr) {
                         xhr.setRequestHeader("Accept", "application/json");
                         xhr.setRequestHeader("Content-Type", "application/json");
                         xhr.setRequestHeader(header, token);
                     },
            		 async:false,
            		 success : function(data) {}
            	});
            	event.preventDefault();
            }
            
            </script>