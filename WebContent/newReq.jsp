<!-- Created by D.H.M.M.P.Thammita
IT No : IT19120362  -->
<%@page import="com.oop.model.UserAppointmentModel"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.oop.model.NewMechModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.model.AppointmentModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!--bootstrap-->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous" />
<!-- <link href="css/bootstrap-dropdownhover.min.css" rel="stylesheet" /> -->


<!--end of the bootstrap-->

<!--akila css-->
<link rel="stylesheet" href="css/akila/dashboard.css" />
<!--end of the akila css-->
<link rel="stylesheet" href="css/Mahen/New_req.css" />
<style type="text/css">
.my-4 {
	border-style: solid;
	border-width: 2px;
	border-color: #0099CC;
	color: #0099CC;
	background-color: #0099CC;
}
</style>

<title>AllRequests</title>
</head>
<body>

	<%
		//Checking the session variable before accessing the page
		if(session.getAttribute("regno") == null){
		request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	
	
	List<UserAppointmentModel> PendingRequests = (ArrayList<UserAppointmentModel>) request.getAttribute("PendingRequests");
	//List<AppointmentModel> PendingRequests = (ArrayList<AppointmentModel>) request.getAttribute("PendingRequests");
	List<NewMechModel> Mechanics = (ArrayList<NewMechModel>) request.getAttribute("Mechanics");
	String origin = (String) request.getAttribute("origin");
	String Affectedappointment = (String) request.getAttribute("Affectedappointment");
	if (origin == "Deleted") {
	%>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script>
		$(document).ready(function () {
			swal({
				  title: "You Have Deleted The Request",
				  icon: "error",
				});
		});
		</script>
	<%
		}
	if (origin.equals("Accepted")) {
	%>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script>
		$(document).ready(function () {
			swal({
				  title: "You Have Accepted The Request <%=Affectedappointment%> ",
				  icon: "success",
				});
		});
		</script>
	<%
		}
	if (origin.equals("Rejected")) {
	%>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script>
		$(document).ready(function () {
			swal({
				  title: "You Have Rejected The Request <%=Affectedappointment%>",
								icon : "warning",
							});
						});
	</script>
	<%
		}
	%>

	<nav
		class="navbar menu sticky-top navbar-expand-lg navbar-light bg-light"
		id="mynav">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item dropdown"><a class="nav-link" href="#"
					id="navbarDropdown" role="button" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> <img
						src="img/akila/profile_user.jpg" class="profile" alt="" />
				</a>
					<div class="dropdown-menu shadow line-height"
						aria-labelledby="navbarDropdown">
						<h4 class="dropdown-header">
							<i class="fas fa-user-shield"></i> <strong>M.L.Akila
								Liyanage - <span>ADMINISTRATOR</span>
							</strong>
						</h4>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#"><i
							class="far fa-envelope-open"></i> Incomming Mail</a> <a
							class="dropdown-item" href="#"><i class="fas fa-id-card-alt"></i>
							Profile Details</a> <a class="dropdown-item" href="#"><i
							class="far fa-money-bill-alt"></i> Billing Status</a> <a
							class="dropdown-item" href="#"><i class="fas fa-bullhorn"></i>
							Notifications <span class="badge badge-danger">1</span></a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Log Out</a>
					</div></li>

				<li class="nav-item dropdown"><a class="nav-link" href="#"
					id="navbarDropdown" role="button" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> <img
						src="img/akila/message-1767998.png" class="icons" alt="" /><span
						class="badge badge-danger">1</span>
				</a>
					<div class="dropdown-menu shadow" aria-labelledby="navbarDropdown">
						<h4 class="dropdown-header">Latest Notifications</h4>
						<a class="dropdown-item" href="#">
							<div class="alert alert-danger alert-dismissible fade show"
								role="alert">
								<strong>Test user 1</strong> This is a test notification
								<button type="button" class="close" data-dismiss="alert"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
						</a>

						<div class="dropdown-divider"></div>

						<h4 class="dropdown-header">Older Notifications</h4>

						<a class="dropdown-item" href="#">
							<div class="alert alert-success alert-dismissible fade show"
								role="alert">
								<strong>Test user 1</strong> This is a test notification
								<button type="button" class="close" data-dismiss="alert"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
						</a> <a class="dropdown-item" href="#">
							<div class="alert alert-success alert-dismissible fade show"
								role="alert">
								<strong>Test user 1</strong> This is a test notification
								<button type="button" class="close" data-dismiss="alert"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
						</a>
					</div></li>

				<li class="nav-item dropdown"><a class="nav-link" href="#"
					id="navbarDropdown" role="button" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> <img
						src="img/akila/setting-1820017.png" class="icons" alt="" /><span
						class="badge badge-danger">1</span>
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#">Action</a> <a
							class="dropdown-item" href="#">Another action</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Something else here</a>
					</div></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2 search" type="search"
					placeholder="Search" aria-label="Search" />
				<button class="btn btn-outline-success search-btn my-2 my-sm-0"
					type="submit">Search</button>
			</form>
		</div>
	</nav>



	<!--breadcrumb-->
	<nav aria-label="breadcrumb" style="border-bottom: #8e8e8e solid 1px;">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Login</a></li>
			<li class="breadcrumb-item active" aria-current="page">Admin</li>
		</ol>
	</nav>
	<!--end of the breadcrumb-->

	<!--body part-->

	<div class="row row row-cols-2">
		<!--sidebar-->
		<div class="col-2 sidebar">
			<div id="container">
				<h1 class="style-3">ADMIN PANEL</h1>
			</div>

			<h6 class="dropdown-header">Vehicle Service Center</h6>

			<a href="" class="btn btn-light"><i class="fas fa-flag-checkered"></i>&nbsp;&nbsp;
				Pending Requests</a> 
				<a href="AdvanceSearchServlet" class="btn btn-light"><i class="fas fa-flag-checkered"></i>&nbsp;&nbsp; All requests</a>
				<a href="" class="btn btn-light"><i
				class="fas fa-file-word"></i>&nbsp;&nbsp; Reports</a> <a href="InquieryNavigateServlet" class="btn btn-light"><i class="fas fa-reply"></i>&nbsp;&nbsp; User Feedback</a> 
				<a href="PackageManagerServlet" class="btn btn-light"><i
				class="fas fa-box"></i>&nbsp;&nbsp; Packages</a> <a href=""
				class="btn btn-light"><i class="fas fa-receipt"></i>&nbsp;&nbsp;
				Bill</a>

			<h6 class="dropdown-header">Fuel Station</h6>

			<a href="" class="btn btn-light"><i class="fas fa-briefcase"></i>&nbsp;&nbsp;
				Employees</a> <a href="" class="btn btn-light"><i
				class="fas fa-parachute-box"></i>&nbsp;&nbsp; Suppliers</a> <a href=""
				class="btn btn-light"><i class="fas fa-thermometer-quarter"></i>&nbsp;&nbsp;
				Status</a>
		</div>
		<!--end of the side bar-->

		<!--Start middle part-->
		<div class="col-10 ">


			<%
				for (UserAppointmentModel Appointment : PendingRequests) {
			%>

			<div class="Act_new_req m-4">

				<div class="jumbotron"
					style="background-color: white; border-style: solid; border-color: black;">

					<div class="row row-cols-3 d-flex align-items-center">

						<div
							class="col-md-3 d-flex align-items-center justify-content-center">
							<img src="img/Mahen/newapp.gif"
								style="width: 120px; height: 120px; position: relative; top: -100px; left: -60px">
							<img src="img/userImages/<%=Appointment.getUserImage() %>"
								class="img-circle">
						</div>
						<div class="col-md-3  text-left">
							<h3>
								<i class="fas fa-user-check"></i> <u> <%=Appointment.getUserFullName() %>
								</u>
							</h3>
							<p class="mt-3"><%=Appointment.getAddress_line_1() %></p>
							<p class="mt-3" style="color: #4285F4"><%=Appointment.getUserEmail() %></p>
						</div>
						<div class="col-md-6 text-right">
							<h3>Appointment No</h3>
							<h4 style="color: gray;"><%=Appointment.getAppId()%></h4>
						</div>

					</div>

					<hr class="my-4">


					<div class="row row-cols-3">


						<div class="col-md-4 text-left border-right ">
							<h4 class="text-center">Request Details</h4>
							<hr class="my-4">
							<div class="requ_inf">
								<strong>Requested Service : </strong>
								<p class="text-right"><%=Appointment.getService_id()%></p>
							</div>

							<div class="requ_inf">
								<strong>Vehicle NO : </strong>
								<p class="text-right"><%=Appointment.getVehicleI_No()%></p>
							</div>
							<div class="requ_inf">
								<strong>Total Amount : </strong>
								<p class="text-right"><%=Appointment.getAmmount()%></p>
							</div>
							<div class="requ_inf">
								<strong>Service Date & Time : </strong>
								<p class="text-right"><%=Appointment.getPrefDate()%></p>
								<p class="text-right"><%=Appointment.getPrefTime()%></p>
							</div>
							<div class="requ_inf">
								<strong>Mechanic : </strong>
								<p class="text-right" id="MacAssignStatus">Not yet Assigned</p>
							</div>
						</div>

						<div class="col-md-7 text-right ml-4">
							<div
								class="alert alert-danger alert-dismissible fade show text-center"
								role="alert">
								<strong>Mechanics are not assigned to this job</strong>
								<p>Please Assign a mechanic first.</p>
								<button type="button" class="close" data-dismiss="alert"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>


							<button type="button" data-toggle="modal"
								data-target="#<%=Appointment.getAppId()%>"
								class="btn btn btn-outline-primary btn-lg btn-block">
								<i class="fas fa-cogs"></i> Assign Mechanic
							</button>

							<form action="PlaceRemarkServlet" method="get"
								class="border border-primary rounded p-4 mt-4 text-left">
								<div class="form-group ">
									<label><h3>Add Remarks</h3></label>
									<textarea class="form-control" rows="3" name="remark"></textarea>
								</div>
								<input type="hidden" value="<%=Appointment.getAppId()%>"
									name="appointment1">
								<div class="d-flex justify-content-end">
									<input type="submit" value="Place Remark"
										class="btn btn-primary">
								</div>

							</form>
						</div>


					</div>

					<hr class="my-4">

					<div class="">
						<div class="row mt-4 d-flex justify-content-center">

							<a type="button"
								href="ChangeStatusServlet?appointment2=<%=Appointment.getAppId()%>&Status=Accepted&Page=Newrequest"
								class="btn btn-success mr-4"> <i
								class="fas fa-clipboard-check"></i> Accept Job Request
							</a> <a type="button"
								href="ChangeStatusServlet?appointment2=<%=Appointment.getAppId()%>&Status=Rejected&Page=Newrequest"
								class="btn btn-warning mr-4"> <i class="far fa-window-close"></i>
								Reject Job Request
							</a> <a type="button"
								href="ChangeStatusServlet?appointment2=<%=Appointment.getAppId()%>&Status=Delete&Page=Newrequest&Vehicle_to_dele=<%=Appointment.getVehicleI_No()%>"
								class="btn btn-danger mr-4" class="btn btn-danger mr-4"> <i
								class="far fa-trash-alt"></i> Delete Job Request
							</a> <a type="button"
								href="FullRequestservlet?Id_Of_Appointment=<%=Appointment.getAppId()%>"
								class="btn btn-secondary mr-4"> <i
								class="fas fa-info-circle"></i> More Details
							</a>


						</div>
					</div>



				</div>

			</div>
			<%
				}
			%>

			<%
				for (UserAppointmentModel Appointment : PendingRequests) {
			%>

			<!-- Modal: modalCart -->
			<div class="modal fade conferm_assigning"
				id="<%=Appointment.getAppId()%>" tabindex="0" role="dialog"
				aria-labelledby="exampleModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<!--Header-->
						<div class="modal-header">
							<h4 class="modal-title" id="myModalLabel">Select A mechanic</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">×</span>
							</button>
						</div>
						<!--Body-->
						<div class="modal-body">

							<table class="table table-hover btn-table">
								<thead>
									<tr>
										<th>Mechanic name</th>
										<th>Mechanic Id</th>
										<th>Select</th>
									</tr>
								</thead>
								<tbody>
									<%
										for (NewMechModel mech : Mechanics) {
									%>
									<tr>
										<td><%=mech.getFullnameString()%></td>
										<td><%=mech.getUserregNoString()%></td>
										<td>
											<form action="AssignMechServelet" method="get">
												<input type="hidden" value="<%=mech.getUserregNoString()%>"
													name="AssignrdMec"> <input type="hidden"
													value="<%=Appointment.getAppId()%>" name="appointment">
												<button type="submit" class="btn btn-primary btn-sm m-0"
													data-toggle="modal" data-target="#SuccessfullyAssigned"
													onclick="AssignConfermation('<%=mech.getFullnameString()%>')">
													Assign</button>
											</form> <script type="text/javascript">
											function AssignConfermation(appID) {
												 document.getElementById("MacAssignStatus").innerHTML = appID;
												 $('.conferm_assigning').modal('hide'); 
											}
											</script>

										</td>
									</tr>
									<%
										}
									%>
								</tbody>
							</table>

						</div>
						<!--Footer-->

					</div>
				</div>
			</div>

			<!-- Modal: modalCart -->
			<script type="text/javascript">
				
				function CloseallMods() {
					  $(".conferm_assigning .close").click(); 	 
				}
			</script>

			<%
				}
			%>




			<!-- Mechanic Assigning confermation Model -->
			<div class="modal fade " id="SuccessfullyAssigned" tabindex="1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-notify modal-success" role="document">
					<!--Content-->
					<div class="modal-content">
						<!--Header-->
						<div class="modal-header" style="background-color: #28a745;">
							<p class="heading lead center">Mechanic Assigned</p>

							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true" class="white-text">&times;</span>
							</button>
						</div>

						<!--Body-->
						<div class="modal-body">
							<div class="text-center">
								<img src="img/Mahen/success_png_gif.gif">
								<h3>Mechanic Assigned Successfully</h3>
							</div>
						</div>

						<!--Footer-->
						<div class="d-flex justify-content-center">
							<button type="button"
								class="btn btn-outline-success waves-effect mb-4"
								data-dismiss="modal" onclick="CloseallMods()">OK</button>
						</div>
					</div>
					<!--/.Content-->
				</div>
			</div>
			<!-- Mechanic Assigning confermation Model-->




		</div>
		<!--end of the middle part-->


	</div>

	<!--end of the body part-->

	<!--footer-->
    <jsp:include page="/WEB-INF/views/akila/footer.jsp"></jsp:include>
   <!--end of the footer-->

	<!--bootstrap-->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
	<!--end of the bootstrap-->


	<!--akila js-->
	<script src="js/akila/dashboard.js"></script>
	<!--end of the akila js-->

	<!--font awsome cdn-->
	<script src="https://kit.fontawesome.com/61a479e883.js"
		crossorigin="anonymous"></script>
	<!--end of the font awsone cdn-->

	<!--chart.js-->
	<script src="https://cdn.jsdelivr.net/npm/chart.js@2/dist/Chart.min.js"></script>
	<!--end of the chart.js-->


</body>
</html>
