<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.model.AppointmentModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
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

<link rel="stylesheet"
	href="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.css">
<!-- <link href="css/bootstrap-dropdownhover.min.css" rel="stylesheet" /> -->

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

<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">

<script
	src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script
	src="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.15.1/moment.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/css/bootstrap-datetimepicker.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/js/bootstrap-datetimepicker.min.js"></script>



<!--end of the bootstrap-->

<!--akila css-->
<link rel="stylesheet" href="css/akila/dashboard.css" />
<!--end of the akila css-->
<link rel="stylesheet" href="css/Mahen/New_req.css" />

<title>AllRequests</title>
</head>
<body>
	<%
		List<AppointmentModel> Appointmentlist = (ArrayList<AppointmentModel>)request.getAttribute("AppointmentList");
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
							class="dropdown-item" href="#"><i
							class="fas fa-id-card-alt"></i> Profile Details</a> <a
							class="dropdown-item" href="#"><i
							class="far fa-money-bill-alt"></i> Billing Status</a> <a
							class="dropdown-item" href="#"><i
							class="fas fa-bullhorn"></i> Notifications <span
							class="badge badge-danger">1</span></a>
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

			<a href="" class="btn btn-light"><i
				class="fas fa-flag-checkered"></i>&nbsp;&nbsp; Pending Requests</a> <a
				href="" class="btn btn-light"><i
				class="fas fa-file-word"></i>&nbsp;&nbsp; Reports</a> <a href=""
				class="btn btn-light"><i class="fas fa-reply"></i>&nbsp;&nbsp;
				User Feedback</a> <a href="" class="btn btn-light"><i
				class="fas fa-box"></i>&nbsp;&nbsp; Packages</a> <a href=""
				class="btn btn-light"><i class="fas fa-receipt"></i>&nbsp;&nbsp;
				Bill</a>

			<h6 class="dropdown-header">Fuel Station</h6>

			<a href="" class="btn btn-light"><i
				class="fas fa-briefcase"></i>&nbsp;&nbsp; Employees</a> <a href=""
				class="btn btn-light"><i
				class="fas fa-parachute-box"></i>&nbsp;&nbsp; Suppliers</a> <a href=""
				class="btn btn-light"><i
				class="fas fa-thermometer-quarter"></i>&nbsp;&nbsp; Status</a>
		</div>
		<!--end of the side bar-->

		<!--Start middle part-->
		<div class="col-10 ">

			<div class="container m-4 ">

				<div class="alert alert-info mb-2 ml-4 col-12 " role="alert"
					style="width: 100%; background-color: white;">

					<div class="row">
						<div class="col-5">
							<form class="form-inline my-2 my-lg-0">
								<input class="form-control mr-sm-2 border-primary search"
									type="search" placeholder="Search" aria-label="Search" />
								<button class="btn btn-outline-primary search-btn my-2 my-sm-0"
									type="submit">Search</button>
							</form>
						</div>
						<div class="col-7 d-flex justify-content-end">
							<a class="text-right d-flex align-self-end" id="csstesthide"
								href="#" onclick="ShowAdvance()">
								<h5 style="color: #428bca">Advance Search</h5>
							</a>
						</div>
					</div>


				</div>

				<div class="alert alert-success mt-2 ml-4 advance_search_area"
					role="alert">

					<span
						style="color: #428bca; font-style: italic; font-weight: bold;">Advanced
						Search</span>
					<form action="AdvanceSearchServlet" method="get">
					<div class="row row-cols-4 ">
						<div class="col-md-4 d-flex justify-content-center">
							<input type="text" placeholder="Customer ID" class="serch_in Text_val"
							name="Search_by_CusId">
						</div>

						<div class="col-md-4 d-flex justify-content-center">
							<input type="text" placeholder="Vehicle No"
								class="serch_in Text_val" name="Search_by_VehiNo">
						</div>

						<div class="col-md-4 d-flex justify-content-center">
							<input type="text" placeholder="Ammount"
								class="serch_in Text_val" name="Search_by_Ammount">
						</div>


						<div class="col-md-4 d-flex justify-content-center">
							<input type="text" placeholder="Service"
								class="serch_in Sel_val" name="Search_by_Service">
						</div>

						<div class="col-md-4 d-flex justify-content-center">
							<select class="serch_in Sel_val" name="Search_by_Status">
								<option disabled selected value="">Choose
									Status</option>
								<option>Pending</option>
								<option>Accepted</option>
								<option>Rejected</option>
							</select>
						</div>

						<div class="col-md-4 d-flex justify-content-center">

							<input placeholder="Date" class="textbox-n serch_in Sel_val"
								type="text" onfocus="(this.type='date')" id="picker"
								name="Search_by_Date">
						</div>



						<div class="col-md-12 d-flex justify-content-end mt-3">
							<button type="submit" class="btn btn-primary"
								style="margin-right: 20px; width: 160px">Apply</button>
							<button type="reset" class="btn btn-secondary"
								style="width: 160px">Delete</button>
						</div>



					</div>
					</form>

				</div>
				<div id="testhide">
					<table class="table table-hover thead-dark ml-4" id="All_req_table">
						<thead>
							<tr>
								<th scope="col">Request No</th>
								<th scope="col">Customer Id</th>
								<th scope="col">Vehicle No</th>
								<th scope="col">Service</th>
								<th scope="col">Date</th>
								<th scope="col">Time</th>
								<th scope="col">Amount</th>
								<th scope="col">Status</th>
								<th scope="col">Action</th>

							</tr>
						</thead>
						<tbody>
							<%for(AppointmentModel Appointment : Appointmentlist) { %>
							<tr>
								<th scope="row"><%= Appointment.getAppId() %></th>
								<td><%= Appointment.getUserRegNo() %></td>
								<td><%= Appointment.getVehicleI_No() %></td>
								<td><%= Appointment.getService_id() %></td>
								<td><%= Appointment.getPrefDate() %></td>
								<td><%= Appointment.getPrefTime() %></td>
								<td><%= Appointment.getAmmount() %></td>
								<td><%= Appointment.getStatus() %></td>

								<td>
								<div class="row">
									<form action="FullRequestservlet">
										<input type="hidden" value="<%=Appointment.getAppId()%>" name="Id_Of_Appointment">
										<button type="submit" class="btn btn-secondary"
										data-toggle="tooltip" data-placement="top"
										title="Tooltip on top">
										<i class="far fa-edit"></i>
									</button>
									
									</form>
									
									<form action="">
									<button type="submit" class="btn btn-danger"
										data-toggle="tooltip" data-placement="top"
										title="Tooltip on top">
										<i class="far fa-trash-alt"></i>
									</button>
									</form>
									</div>
								</td>
							</tr>
							<% } %>
							
						</tbody>

					</table>
				</div>

			</div>



			<script type="text/javascript">


$(document)
.ready(function () {
    $('#All_req_table').dataTable({
        "autoWidth": false,
        "lengthChange": false,
        "pageLength": 10,
        searching: false,
        
    });
});</script>








		</div>
		<!--end of the middle part-->


	</div>

	<!--end of the body part-->

	<!--footer-->


	<footer class="new_footer_area bg_color">
		<div class="new_footer_top">
			<div class="container">
				<div class="row">
					<div class="col-lg-3 col-md-6">
						<div class="f_widget company_widget wow fadeInLeft"
							data-wow-delay="0.2s"
							style="visibility: visible; animation-delay: 0.2s; animation-name: fadeInLeft;">
							<h3 class="f-title f_600 t_color f_size_18">Get in Touch</h3>
							<p>Don’t miss any updates of our new templates and
								extensions.!</p>
							<form action="#" class="f_subscribe_two mailchimp" method="post"
								novalidate="true" _lpchecked="1">
								<input type="text" name="EMAIL" class="form-control memail"
									placeholder="Email">
								<button class="btn btn_get btn_get_two" type="submit">Subscribe</button>
								<p class="mchimp-errmessage" style="display: none;"></p>
								<p class="mchimp-sucmessage" style="display: none;"></p>
							</form>
						</div>
					</div>
					<div class="col-lg-3 col-md-6">
						<div class="f_widget about-widget pl_70 wow fadeInLeft"
							data-wow-delay="0.4s"
							style="visibility: visible; animation-delay: 0.4s; animation-name: fadeInLeft;">
							<h3 class="f-title f_600 t_color f_size_18">Services</h3>
							<ul class="list-unstyled f_list">
								<li><a href="#">Packages</a></li>
								<li><a href="#">Requexts App</a></li>
								<li><a href="#">Status</a></li>
								<li><a href="#">Reports</a></li>
								<li><a href="#">Bills</a></li>
								<li><a href="#">Notifications</a></li>
							</ul>
						</div>
					</div>
					<div class="col-lg-3 col-md-6">
						<div class="f_widget about-widget pl_70 wow fadeInLeft"
							data-wow-delay="0.6s"
							style="visibility: visible; animation-delay: 0.6s; animation-name: fadeInLeft;">
							<h3 class="f-title f_600 t_color f_size_18">Navigate to
								other pages</h3>
							<ul class="list-unstyled f_list">
								<li><a href="#">FAQ</a></li>
								<li><a href="#">Login</a></li>
								<li><a href="#">User Admin</a></li>
							</ul>
						</div>
					</div>
					<div class="col-lg-3 col-md-6">
						<div class="f_widget social-widget pl_70 wow fadeInLeft"
							data-wow-delay="0.8s"
							style="visibility: visible; animation-delay: 0.8s; animation-name: fadeInLeft;">
							<h3 class="f-title f_600 t_color f_size_18">Social Media</h3>
							<div class="f_social_icon">
								<a href="#" class="fab fa-facebook"></a> <a href="#"
									class="fab fa-twitter"></a> <a href="#" class="fab fa-linkedin"></a>
								<a href="#" class="fab fa-pinterest"></a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="footer_bg">
				<div class="footer_bg_one"></div>
				<div class="footer_bg_two"></div>
			</div>
		</div>
		<div class="footer_bottom">
			<div class="container">
				<div class="row align-items-center">
					<div class="col-lg-6 col-sm-7">
						<p class="mb-0 f_400">© CarCare System Solutions All rights
							reserved.</p>
					</div>
				</div>
			</div>
		</div>
	</footer>


	<!--akila js-->
	<script src="js/akila/dashboard.js"></script>
	<!--end of the akila js-->
	<!--mahen js-->
	<script src="js/Mahen/SendRequest.js"></script>
	<!--end of the mahen js-->


	<!--font awsome cdn-->
	<script src="https://kit.fontawesome.com/61a479e883.js"
		crossorigin="anonymous"></script>
	<!--end of the font awsone cdn-->

	<!--chart.js-->
	<script src="https://cdn.jsdelivr.net/npm/chart.js@2/dist/Chart.min.js"></script>
	<!--end of the chart.js-->



	<!--charts-->
	<script>
      let user = document.getElementById("user").getContext("2d");

      let lineOne = new Chart(user, {
        type: "line",
        data: {
          labels: [
            "Sunday",
            "Monday",
            "Tuesday",
            "Wednsday",
            "Thursday",
            "Friday",
            "Saturday"
          ],
          datasets: [
            {
              label: "Count",
              data: [10, 30, 1, 30, 50, 70, 90],
              backgroundColor: ["#fa163f"],
              borderColor: "#FFFF",
              borderWidth: "3px"
            }
          ]
        },
        options: {
          scales: {
        xAxes: [{
            gridLines: {
                color: "rgba(0, 0, 0, 0)",
            }
        }],
        yAxes: [{
            gridLines: {
               display : true
            }   
        }]
    }
        }
      });

      let imcome = document.getElementById("income").getContext("2d");

      let pieOne = new Chart(income, {
        type: "doughnut",
        data: {
          labels: [
            "Sunday",
            "Monday",
            "Tuesday",
            "Wednsday",
            "Thursday",
            "Friday",
            "Saturday"
          ],
          datasets: [
            {
              label: "Count",
              data: [10, 30, 1, 30, 50, 70, 90],
              backgroundColor: [
                "#fa163f",
                "#f0134d",
                "#40bfc1",
                "#1b262c",
                "#52de97",
                "#3e206d",
                "#12cad6"
              ],
              //borderColor : '#FFFF',
              borderWidth: "3px"
            }
          ]
        },
        options: {
          cutoutPercentage: 50,
          scales: {
        xAxes: false,
        yAxes: false,
    },
    legend: {
                display: true,
                position: 'right',
                labels: {
                    fontColor: 'rgb(255, 99, 132)'
                }
            }
        }
      });

      let req = document.getElementById("req").getContext("2d");

let bar = new Chart(req, {
  type: "bar",
  data: {
    labels: [
      "Sunday",
      "Monday",
      "Tuesday",
      "Wednsday",
      "Thursday",
      "Friday",
      "Saturday"
    ],
    datasets: [
      {
        label: "Count",
        data: [10, 30, 1, 30, 50, 70, 90],
        backgroundColor: [
          "#fa163f",
          "#f0134d",
          "#40bfc1",
          "#1b262c",
          "#52de97",
          "#3e206d",
          "#12cad6"
        ],
        //borderColor : '#FFFF',
        borderWidth: "3px"
      }
    ]
  },
  options: {
    cutoutPercentage: 50,
    scales: {
  xAxes: [{
      gridLines: {
          color: "rgba(0, 0, 0, 0)",
      }
  }],
  yAxes: [{
      gridLines: {
          display: true
      }   
  }]
}
  }
});

       let tank = document.getElementById("tank").getContext("2d");

      let statOne = new Chart(tank, {
        type: "line",
        data: {
          labels: [
            "Sunday",
            "Monday",
            "Tuesday",
            "Wednsday",
            "Thursday",
            "Friday",
            "Saturday",
            "Sunday",
            "Monday",
            "Tuesday",
            "Wednsday",
            "Thursday",
            "Friday",
            "Saturday"
          ],
          datasets: [
            {
              label: "Liters",
              data: [10, 30, 1, 30, 50, 70, 60,10, 30, 1, 30, 50, 70, 90],
             
              //borderColor : '#FFFF',
              borderWidth: "3",          
              borderColor: "red",
              fill: false,
              pointBackgroundColor : 'red',
              pointBorderWidth : '5'
              //backgroundColor: 'red'
            }
          ],

        },
        options: {
          cutoutPercentage: 50,
          scales: {
        xAxes: [{
            gridLines: {
                color: "rgba(0, 0, 0, 0)",
            }
        }],
        yAxes: [{
            gridLines: {
                display: true
            }   
        }]
    }
        }
      });
      
    </script>
	<!--end of the charts-->
</body>
</html>
