<!doctype html>
<html lang="en">

<jsp:include page="./common/header.jsp" />
<body>
	<!-- WRAPPER -->
	<div id="wrapper">

		<!-- NAVBAR -->
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="brand">
				<a href="index-2.jsp"><img src="assets/img/logo-dark.png" alt="Klorofil Logo" class="img-responsive logo"></a>
			</div>
			<div class="container-fluid">
				<div class="navbar-btn">
					<button type="button" class="btn-toggle-fullwidth"><i class="lnr lnr-arrow-left-circle"></i></button>
				</div>
				<form class="navbar-form navbar-left">
					<div class="input-group">
						<input type="text" value="" class="form-control" placeholder="Search dashboard...">
						<span class="input-group-btn"><button type="button" class="btn btn-primary">Go</button></span>
					</div>
				</form>
				<div class="navbar-btn navbar-btn-right">
					<a class="btn btn-success update-pro" href="https://www.themeineed.com/downloads/klorofil-pro-bootstrap-admin-dashboard-template/?utm_source=klorofil&amp;utm_medium=template&amp;utm_campaign=KlorofilPro" title="Upgrade to Pro" target="_blank"><i class="fa fa-rocket"></i> <span>UPGRADE TO PRO</span></a>
				</div>

				<div id="navbar-menu">
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle icon-menu" data-toggle="dropdown">
								<i class="lnr lnr-alarm"></i>
								<span class="badge bg-danger">5</span>
							</a>
							<ul class="dropdown-menu notifications">
								<li><a href="#" class="notification-item"><span class="dot bg-warning"></span>System space is almost full</a></li>
								<li><a href="#" class="notification-item"><span class="dot bg-danger"></span>You have 9 unfinished tasks</a></li>
								<li><a href="#" class="notification-item"><span class="dot bg-success"></span>Monthly report is available</a></li>
								<li><a href="#" class="notification-item"><span class="dot bg-warning"></span>Weekly meeting in 1 hour</a></li>
								<li><a href="#" class="notification-item"><span class="dot bg-success"></span>Your request has been approved</a></li>
								<li><a href="#" class="more">See all notifications</a></li>
							</ul>
						</li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="lnr lnr-question-circle"></i> <span>Help</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
							<ul class="dropdown-menu">
								<li><a href="#">Basic Use</a></li>
								<li><a href="#">Working With Data</a></li>
								<li><a href="#">Security</a></li>
								<li><a href="#">Troubleshooting</a></li>
							</ul>
						</li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"><img src="assets/img/user.png" class="img-circle" alt="Avatar"> <span>Samuel</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
							<ul class="dropdown-menu">
								<li><a href="#"><i class="lnr lnr-user"></i> <span>My Profile</span></a></li>
								<li><a href="#"><i class="lnr lnr-envelope"></i> <span>Message</span></a></li>
								<li><a href="#"><i class="lnr lnr-cog"></i> <span>Settings</span></a></li>
								<li><a href="#"><i class="lnr lnr-exit"></i> <span>Logout</span></a></li>
							</ul>
						</li>
						<!-- <li>
							<a class="update-pro" href="https://www.themeineed.com/downloads/klorofil-pro-bootstrap-admin-dashboard-template/?utm_source=klorofil&utm_medium=template&utm_campaign=KlorofilPro" title="Upgrade to Pro" target="_blank"><i class="fa fa-rocket"></i> <span>UPGRADE TO PRO</span></a>
						</li> -->
					</ul>
				</div>
			</div>
		</nav>
		<!-- END NAVBAR -->

		<!-- LEFT SIDEBAR -->
		<div id="sidebar-nav" class="sidebar">
			 <div class="sidebar-scroll">
				<nav>
					
	<ul class="nav">
					<li><a href="index-2.jsp" class=""><i class="lnr lnr-home"></i> <span>Dashboard</span></a></li>

							<li><a href="elements.jsp" class=""><i class="lnr lnr-code"></i> <span>Elements</span></a></li>

							<li><a href="charts.jsp" class=""><i class="lnr lnr-chart-bars"></i> <span>Charts</span></a></li>

							<li><a href="panels.jsp" class=""><i class="lnr lnr-cog"></i> <span>Panels</span></a></li>

							<li><a href="notifications.jsp" class=""><i class="lnr lnr-alarm"></i> <span>Notifications</span></a></li>

						
			<li>
				<a href="#subPages" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>Pages</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
				<div id="subPages" class="collapse ">
					<ul class="nav">
													<li><a href="page-profile.jsp" class="">Profile</a></li>
													<li><a href="page-login.jsp" class="">Login</a></li>
													<li><a href="page-lockscreen.jsp" class="">Lockscreen</a></li>
											</ul>
				</div>
			</li>

							<li><a href="tables.jsp" class="active"><i class="lnr lnr-dice"></i> <span>Tables</span></a></li>

							<li><a href="typography.jsp" class=""><i class="lnr lnr-text-format"></i> <span>Typography</span></a></li>

							<li><a href="icons.jsp" class=""><i class="lnr lnr-linearicons"></i> <span>Icons</span></a></li>

				
	</ul>				</nav>
			</div>
		</div>
		<!-- END LEFT SIDEBAR -->

		<!-- MAIN -->
		<div class="main">

			<!-- MAIN CONTENT -->
			<div class="main-content">
				<div class="container-fluid">
	<h3 class="page-title">Tables</h3>

	<div class="row">
		<div class="col-md-6">

			<!-- BASIC TABLE -->
			<div class="panel">
				<div class="panel-heading">
					<h3 class="panel-title">Basic Table</h3>
				</div>
				<div class="panel-body">
					<table class="table">
						<thead>
							<tr><th>#</th><th>First Name</th><th>Last Name</th><th>Username</th></tr>
						</thead>
						<tbody>
							<tr><td>1</td><td>Steve</td><td>Jobs</td><td>@steve</td></tr>
							<tr><td>2</td><td>Simon</td><td>Philips</td><td>@simon</td></tr>
							<tr><td>3</td><td>Jane</td><td>Doe</td><td>@jane</td></tr>
						</tbody>
					</table>
				</div>
			</div>
			<!-- END BASIC TABLE -->

		</div>
		<div class="col-md-6">

			<!-- TABLE NO PADDING -->
			<div class="panel">
				<div class="panel-heading">
					<h3 class="panel-title">Table Inside No Padding</h3>
				</div>
				<div class="panel-body no-padding">
					<table class="table">
						<thead>
							<tr><th>#</th><th>First Name</th><th>Last Name</th><th>Username</th></tr>
						</thead>
						<tbody>
							<tr><td>1</td><td>Steve</td><td>Jobs</td><td>@steve</td></tr>
							<tr><td>2</td><td>Simon</td><td>Philips</td><td>@simon</td></tr>
							<tr><td>3</td><td>Jane</td><td>Doe</td><td>@jane</td></tr>
						</tbody>
					</table>
				</div>
			</div>
			<!-- END TABLE NO PADDING -->

		</div>
	</div>
	<div class="row">
		<div class="col-md-6">

			<!-- TABLE STRIPED -->
			<div class="panel">
				<div class="panel-heading">
					<h3 class="panel-title">Striped Row</h3>
				</div>
				<div class="panel-body">
					<table class="table table-striped">
						<thead>
							<tr><th>#</th><th>First Name</th><th>Last Name</th><th>Username</th></tr>
						</thead>
						<tbody>
							<tr><td>1</td><td>Steve</td><td>Jobs</td><td>@steve</td></tr>
							<tr><td>2</td><td>Simon</td><td>Philips</td><td>@simon</td></tr>
							<tr><td>3</td><td>Jane</td><td>Doe</td><td>@jane</td></tr>
						</tbody>
					</table>
				</div>
			</div>
			<!-- END TABLE STRIPED -->

		</div>
		<div class="col-md-6">

			<!-- TABLE HOVER -->
			<div class="panel">
				<div class="panel-heading">
					<h3 class="panel-title">Hover Row</h3>
				</div>
				<div class="panel-body">
					<table class="table table-hover">
						<thead>
							<tr><th>#</th><th>First Name</th><th>Last Name</th><th>Username</th></tr>
						</thead>
						<tbody>
							<tr><td>1</td><td>Steve</td><td>Jobs</td><td>@steve</td></tr>
							<tr><td>2</td><td>Simon</td><td>Philips</td><td>@simon</td></tr>
							<tr><td>3</td><td>Jane</td><td>Doe</td><td>@jane</td></tr>
						</tbody>
					</table>
				</div>
			</div>
			<!-- END TABLE HOVER -->

		</div>
	</div>
	<div class="row">
		<div class="col-md-6">

			<!-- BORDERED TABLE -->
			<div class="panel">
				<div class="panel-heading">
					<h3 class="panel-title">Bordered Table</h3>
				</div>
				<div class="panel-body">
					<table class="table table-bordered">
						<thead>
							<tr><th>#</th><th>First Name</th><th>Last Name</th><th>Username</th></tr>
						</thead>
						<tbody>
							<tr><td>1</td><td>Steve</td><td>Jobs</td><td>@steve</td></tr>
							<tr><td>2</td><td>Simon</td><td>Philips</td><td>@simon</td></tr>
							<tr><td>3</td><td>Jane</td><td>Doe</td><td>@jane</td></tr>
						</tbody>
					</table>
				</div>
			</div>
			<!-- END BORDERED TABLE -->

		</div>
		<div class="col-md-6">

			<!-- CONDENSED TABLE -->
			<div class="panel">
				<div class="panel-heading">
					<h3 class="panel-title">Condensed Table</h3>
				</div>
				<div class="panel-body">
					<table class="table table-condensed">
						<thead>
							<tr><th>#</th><th>First Name</th><th>Last Name</th><th>Username</th></tr>
						</thead>
						<tbody>
							<tr><td>1</td><td>Steve</td><td>Jobs</td><td>@steve</td></tr>
							<tr><td>2</td><td>Simon</td><td>Philips</td><td>@simon</td></tr>
							<tr><td>3</td><td>Jane</td><td>Doe</td><td>@jane</td></tr>
						</tbody>
					</table>
				</div>
			</div>
			<!-- END CONDENSED TABLE -->

		</div>
	</div>
	

				</div>
			</div>
			<!-- END MAIN CONTENT -->
		</div>
		<!-- END MAIN -->

		<div class="clearfix"></div>
		<footer>
			<div class="container-fluid">
				<p class="copyright">&copy; 2017 <a href="https://www.themeineed.com/" target="_blank">Theme I Need</a>. All Rights Reserved.</p>
			</div>
		</footer>
	</div>
	<!-- END WRAPPER -->


</body>

<!-- Mirrored from demo.thedevelovers.com/dashboard/klorofil-v2.0/tables.jsp by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 13 Feb 2021 12:19:41 GMT -->
</html>