
 <!DOCTYPE html>
 <!-- Created by D.H.M.M.P.Thammita
IT No : IT19120362  -->
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.model.NewMechModel"%>
<%@page import="java.util.List"%>
<%@page import="com.oop.model.VehicleModel"%>
<%@page import="com.oop.model.AppointmentModel"%>
<%@page import="com.oop.model.VehicalServices"%>
<%@page import="com.oop.model.PackageForAppoint"%>
<%@page import="com.oop.model.UserModel"%>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <!--bootstrap-->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
    integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous" />
  <!-- <link href="css/bootstrap-dropdownhover.min.css" rel="stylesheet" /> -->
  <!--end of the bootstrap-->

  <!--akila css-->
  <link rel="stylesheet" href="css/akila/dashboard.css" />
  <!--end of the akila css-->
  <!--Mahen css-->
  <link rel="stylesheet" href="css/Mahen/FullDetails.css" />
  <!--end of the Mahen css-->

  <title>FullRequestDetails</title>
</head>

<body>
	<%
	//Checking the session variable before accessing the page
		if(session.getAttribute("regno") == null){
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}	
	
		List<NewMechModel> 	Mechanics = (ArrayList<NewMechModel>) request.getAttribute("Mechanics");
		
	
		UserModel Customer = (UserModel) request.getAttribute("Customer");
		PackageForAppoint Package = (PackageForAppoint) request.getAttribute("Package");
		VehicalServices Service = (VehicalServices) request.getAttribute("Service");
		AppointmentModel Appointment = (AppointmentModel) request.getAttribute("Appointment");
		VehicleModel Vehicle = (VehicleModel) request.getAttribute("Vehicle");
	%>

  <nav class="navbar menu sticky-top navbar-expand-lg navbar-light bg-light" id="mynav">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
      aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item dropdown">
          <a class="nav-link" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true"
            aria-expanded="false">
            <img src="img/akila/profile_user.jpg" class="profile" alt="" />
          </a>
          <div class="dropdown-menu shadow line-height" aria-labelledby="navbarDropdown">
            <h4 class="dropdown-header">
              <i class="fas fa-user-shield"></i>
              <strong>M.L.Akila Liyanage - <span>ADMINISTRATOR</span></strong>
            </h4>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#"><i class="far fa-envelope-open"></i> Incomming Mail</a>
            <a class="dropdown-item" href="#"><i class="fas fa-id-card-alt"></i> Profile Details</a>
            <a class="dropdown-item" href="#"><i class="far fa-money-bill-alt"></i> Billing Status</a>
            <a class="dropdown-item" href="#"><i class="fas fa-bullhorn"></i> Notifications
              <span class="badge badge-danger">1</span></a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">Log Out</a>
          </div>
        </li>

        <li class="nav-item dropdown">
          <a class="nav-link" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true"
            aria-expanded="false">
            <img src="img/akila/message-1767998.png" class="icons" alt="" /><span class="badge badge-danger">1</span>
          </a>
          <div class="dropdown-menu shadow" aria-labelledby="navbarDropdown">
            <h4 class="dropdown-header">Latest Notifications</h4>
            <a class="dropdown-item" href="#">
              <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>Test user 1</strong> This is a test notification
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
            </a>

            <div class="dropdown-divider"></div>

            <h4 class="dropdown-header">Older Notifications</h4>

            <a class="dropdown-item" href="#">
              <div class="alert alert-success alert-dismissible fade show" role="alert">
                <strong>Test user 1</strong> This is a test notification
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
            </a>
            <a class="dropdown-item" href="#">
              <div class="alert alert-success alert-dismissible fade show" role="alert">
                <strong>Test user 1</strong> This is a test notification
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
            </a>
          </div>
        </li>

        <li class="nav-item dropdown">
          <a class="nav-link" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true"
            aria-expanded="false">
            <img src="img/akila/setting-1820017.png" class="icons" alt="" /><span class="badge badge-danger">1</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdown">
            <a class="dropdown-item" href="#">Action</a>
            <a class="dropdown-item" href="#">Another action</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">Something else here</a>
          </div>
        </li>
      </ul>
      <form class="form-inline my-2 my-lg-0">
        <input class="form-control mr-sm-2 search" type="search" placeholder="Search" aria-label="Search" />
        <button class="btn btn-outline-success search-btn my-2 my-sm-0" type="submit">
          Search
        </button>
      </form>
    </div>
  </nav>



  <!--breadcrumb-->
  <nav aria-label="breadcrumb" style="border-bottom: #8e8e8e solid 1px;;">
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

      <a href="PendingRequestsServlet" class="btn btn-light"><i class="fas fa-flag-checkered"></i>&nbsp;&nbsp; Pending Requests</a>
      <a href="AdvanceSearchServlet" class="btn btn-light"><i class="fas fa-flag-checkered"></i>&nbsp;&nbsp; All requests</a>
      <a href="" class="btn btn-light"><i class="fas fa-file-word"></i>&nbsp;&nbsp; Reports</a>
      <a href="InquieryNavigateServlet" class="btn btn-light"><i class="fas fa-reply"></i>&nbsp;&nbsp; User Feedback</a>
      <a href="PackageManagerServlet" class="btn btn-light"><i class="fas fa-box"></i>&nbsp;&nbsp; Packages</a>
      <a href="" class="btn btn-light"><i class="fas fa-receipt"></i>&nbsp;&nbsp; Bill</a>

      <h6 class="dropdown-header">Fuel Station</h6>

      <a href="" class="btn btn-light"><i class="fas fa-briefcase"></i>&nbsp;&nbsp; Employees</a>
      <a href="" class="btn btn-light"><i class="fas fa-parachute-box"></i>&nbsp;&nbsp; Suppliers</a>
      <a href="" class="btn btn-light"><i class="fas fa-thermometer-quarter"></i>&nbsp;&nbsp; Status</a>
    </div>
    <!--end of the side bar-->

    <!--middle part-->

    <div class="col-10 ">

      <div class="All_request row row row-cols-2">

        <div class="All_request_left col-3 d-flex justify-content-center m-4 pt-4">

          <div class="card m-3 pt-2" style="width: 18rem; border: none;">
            <div>
              <img src="img/userImages/<%=Customer.getUserImage()%>" class="card-img-top" alt="">
              <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#ContactCustomer"
                style="width: 100%; border-radius: 0px">Contact</button>
            </div>
            <div class="card-body">
              <h2 class="card-title"> <%=Customer.getUserFullName() %> </h2><br />
              <p class="FullReq_1stText">Request NO:</p>
              <p class="text-right FullReq_1stText" style="color: #4285F4;"><%=Appointment.getAppId() %><p>
                  <p class="card-text FullReq_1stText">Request for : </p>
                  <p class="text-right FullReq_1stText" style="color: #4285F4;"><%= Package.getPackName() %></p>
            </div>
            <ul class="list-group list-group-flush">


              <table class="table">

                <tbody>
                  <tr>
                    <th scope="row">Status</th>
                    <td class="d-flex justify-content-end">
                      <span class="badge badge-primary" style="height:25px;" id = "Statusright"><%= Appointment.getStatus() %></span>
                    </td>
                  </tr>
                  <tr>
                    <th scope="row">Job Rating</th>
                    <td class="d-flex justify-content-end">
                    <%
                    	
                    	for(int i = 0 ; i < Integer.parseInt(Appointment.getRating()) ; i++){
                    %>
                      <i class="fas fa-star " style="color: #f0b505;"></i>
                      <%
                    	}
                      %>
                    </td>
                  </tr>
                </tbody>
              </table>

            </ul>

          </div>

        </div>


        <div class="col-8 mt-4 " style="background-color: white;height: 705px;">
          <div class="row " style="background-color: #33b5e5; width: 870px;">
            <ul class="nav nav-pills" id="pills-tab" role="tablist">
              <li class="nav-item">
                <a class="nav-link active tab_button" id="pills-home-tab" data-toggle="pill" href="#pills-home"
                  role="tab" aria-controls="pills-home" aria-selected="true">Request Details</a>
              </li>
              <li class="nav-item">
                <a class="nav-link tab_button" id="pills-profile-tab" data-toggle="pill" href="#pills-profile"
                  role="tab" aria-controls="pills-profile" aria-selected="false">Vehicle & Payment details</a>
              </li>
              <li class="nav-item">
                <a class="nav-link tab_button" id="pills-contact-tab" data-toggle="pill" href="#pills-contact"
                  role="tab" aria-controls="pills-contact" aria-selected="false">Feedbacks And Discussions</a>
              </li>
            </ul>
          </div>

          <div class="tab-content mt-4" id="pills-tabContent">


            <!--Start Of first Tab-->
            <div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
              <div class="row">
                <div class="col-5">
                  <!-- <img src="img/Mahen/carWash_Card.jpg" alt="..." class="rounded img-fluid "> -->
                  <div class="card" style="width: 18rem;">


                    <img src="<%=Service.getServiceImg() %>" class="card-img-top" alt="...">

                    <div class="card-body">
                      <h5 class="card-title"><%=Service.getServiceName() %></h5>
                      <p class="card-text"><%=Service.getDescription() %></p>

                      <h6 class="card-title"> <u class="mt-2">Basic Service Detatis</u> </h6>

                      <div class="row">
                        <div class="col-7">
                          <p>
                            <i class="fas fa-signature"> </i>
                            <strong>Name : </strong>
                          </p>
                        </div>
                        <div class="col-5">
                          <p class="text-right"><%=Service.getServiceName() %></p>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col-7">
                          <p>
                            <i class="far fa-clock"> </i>
                            <strong> Duration : </strong>
                          </p>
                        </div>
                        <div class="col-5">
                          <p class="text-right">1 Hour</p>
                        </div>
                      </div>

                      <div class="row">
                        <div class="col-7">
                          <p>
                            <i class="fas fa-dollar-sign"> </i>
                            <strong> Price : </strong>
                          </p>
                        </div>
                        <div class="col-5">
                          <p class="text-right"><%=Service.getServicePrice() %>Rs</p>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-6">
                  <h3 style="color: #4285F4;" class="mt-4"><i class="far fa-address-card"></i> Basic Details</h3>
                  <hr style="border-width: 5px; border-color: #0d47a1;">
                  <div class="row mt-2">
                    <div class="col-7">
                      <p> <strong> Request No : </strong> </p>
                    </div>
                    <div class="col-5">
                      <p class="text-right"><%=Appointment.getAppId() %></p>
                    </div>
                  </div>

                  <div class="row mt-3">
                    <div class="col-7">
                      <p> <strong> Customer Name : </strong> </p>
                    </div>
                    <div class="col-5">
                      <p class="text-right"><%=Customer.getUserFullName()%></p>
                    </div>
                  </div>
                  <div class="row mt-3">
                    <div class="col-7">
                      <p> <strong> Service date : </strong> </p>
                    </div>
                    <div class="col-5">
                      <p class="text-right"><%=Appointment.getPrefDate()%></p>
                    </div>
                  </div>

                  <div class="row mt-3">
                    <div class="col-7">
                      <p> <strong> Service Time : </strong> </p>
                    </div>
                    <div class="col-5">
                      <p class="text-right"><%=Appointment.getPrefTime() %></p>
                    </div>
                  </div>

                  <hr class="my-3" style="border-width: 3px; border-color: #0d47a1;">

                  <div class="row mt-3">
                    <div class="col-7">
                      <p> <strong> Machenic ID : </strong> </p>
                    </div>
                    <div class="col-5">
                      <p class="text-right" id="mecNameDidplay" ></p>
                    </div>
                  </div>
                  <a href="" class="text-center" data-toggle="modal" data-target="#<%=Appointment.getAppId()%>">Click to change
                    the Machenic</a>
                  <hr class="my-3" style="border-width: 3px; border-color: #0d47a1;">

                  <div class="row mt-3">
                    <div class="col-7">
                      <p> <strong> Status : </strong> </p>
                    </div>
                    <div class="col-5 d-flex justify-content-end">
                      <span class="badge badge-primary" style="height:25px;" id="StatusLeft"> <%=Appointment.getStatus() %> </span>
                    </div>
                  </div>
                  <a href="" class="text-center" data-toggle="modal" data-target="#StatusChanger">Click to change the
                    status</a>
                  <hr class="my-3" style="border-width: 3px; border-color: #0d47a1;">

                  <div class="row mt-3">
                    <div class="col-3">
                      <p> <strong> Remarks : </strong> </p>
                    </div>
                    <div class="col-9">
                      <p class="text-right" id="DispRemark"><%=Appointment.getRemarks() %></p>
                    </div>
                  </div>

                </div>
              </div>
            </div>
            <!--End Of first Tab-->

            <!--Start Of Second Tab-->
            <div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">
              <div class="row row row-cols-2">
                <div class="col-7 tab3_Left_text">
                  <h3 style="color: #4285F4;"> <i class="fas fa-car-side"></i> Vehicle details</h3>
                  <hr style="border-width: 5px; border-color: #0d47a1;">

                  <div class="row">
                    <div class="col-5 mt-4 border-right border-primary ml-4">
                      <p> <i class="fas fa-car"></i> <strong> Vehicle No : </strong> </p>
                      <p class="text-right Blue_text"><%=Vehicle.getVehicleId() %></p>

                      <p> <i class="fab fa-bootstrap"></i> <strong> Brand : </strong> </p>
                      <p class="text-right Blue_text"><%=Vehicle.getBrand() %></p>

                      <p> <i class="fab fa-medium-m"></i> <strong> Model: </strong> </p>
                      <p class="text-right Blue_text"><%=Vehicle.getModel() %></p>

                      <p> <i class="far fa-calendar-alt"></i> <strong> Year : </strong> </p>
                      <p class="text-right Blue_text"><%=Vehicle.getManuYear() %></p>

                    </div>

                    <div class="col-5 mt-4 ">
                      <p> <i class="fas fa-cogs"></i> <strong> Transmission : </strong> </p>
                      <p class="text-right Blue_text"><%=Vehicle.getTransmission() %></p>

                      <p> <i class="fas fa-gas-pump"></i> <strong> Fuel Type : </strong> </p>
                      <p class="text-right Blue_text"><%=Vehicle.getFuelType() %></p>

                      <p> <i class="fas fa-oil-can"></i> <strong> Engine Capacity : </strong> </p>
                      <p class="text-right Blue_text"><%=Vehicle.getEngineCap() %></p>

                    </div>
                  </div>

                  <h3 style="color: #4285F4;" class="mt-4"> <i class="fab fa-cc-amazon-pay"></i> Payment details</h3>
                  <hr style="border-width: 5px; border-color: #0d47a1;">

                  <div class="row">


                    <div class="col-5 mt-4 border-right border-primary ml-4">
                      <p> <i class="fas fa-money-check-alt"></i> <strong> Bill No : </strong> </p>
                      <p class="text-right Blue_text"> Not Available</p>

                      <p> <i class="fas fa-hand-holding-usd"></i> <strong> Total Payment : </strong> </p>
                      <p class="text-right Blue_text"><%=Appointment.getAmmount() %>Rs</p>

                      <p> <i class="fas fa-calendar-alt"></i> <strong> Bill Date: </strong> </p>
                      <p class="text-right Blue_text">Not Available</p>
                    </div>

                    <div class="col-5 mt-4 ">
                      <p> <i class="far fa-file-alt"></i> <strong> Payment Status : </strong> </p>
                      <p class="text-right Blue_text"> Pending </p>

                      <p> <i class="fas fa-hourglass-half"></i> <strong> Due Date : </strong> </p>
                      <p class="text-right Blue_text">Not Available</p>
                    </div>


                  </div>
                </div>


                <div class="col-5">
                  <img src="img/Mahen/Vrrtical car.jfif" class="img-fluid ver_car_img" alt="Responsive image">
                </div>
              </div>
            </div>
            <!--End Of Secound Tab-->

            <!--Start Of Third Tab-->
            <div class="tab-pane fade" id="pills-contact" role="tabpanel" aria-labelledby="pills-contact-tab">

              <div class="row row row-cols-2">
                <div class="col-7">
                  <h3 style="color: #4285F4;" class="mt-4"> <i class="fab fa-angellist"></i> Job Ratings</h3>
                  <hr style="border-width: 5px; border-color: #0d47a1;">
                  <div class="row m-4">
                  	<%
                    	
                    	for(int i = 0 ; i < Integer.parseInt(Appointment.getRating()) ; i++){
                    %>
                    <i class="fas fa-star fa-3x" style="color: #ffc107;"></i>
                    <%} %>
                    
                      <h1 class="mr-4 " style="font-size: 60px; position: relative; top: -15px;left: 44px;" ><%=Appointment.getRating() %></h1>
                      <h5 class="mr-4 pl-4 d-flex align-items-center" style="color: gray;">/5</h5>
                    
                  </div>
                  <h3 style="color: #4285F4;" class="mt-4"> <i class="fas fa-pencil-alt"></i> Detailed Feedback</h3>
                  <hr style="border-width: 5px; border-color: #0d47a1;">
                  
                  <div class="">
                    <p class="text-right"><%=Appointment.getFeedbackDescription() %></p>
                  </div>
                  <h3 style="color: #4285F4;" class="mt-4"> <i class="fas fa-edit"></i> Add Remarks</h3>
                  <hr style="border-width: 5px; border-color: #0d47a1;">

                  <form action="PlaceRemarkServlet" class=" mt-1 text-left">
                    
                      <label>
                        <h6>Add your text here</h6>
                      </label>
                      <textarea class="form-control" rows="3" name="remark" id="remarksText"></textarea>
                      <input type="hidden" value="<%=Appointment.getAppId() %>" name="appointment1">
                    <div class="d-flex justify-content-end">
                      <input type="submit" value="Place Remark" class="mt-2 btn btn-primary" onclick="RemarkChanger()">
                    </div>

                  </form>
                </div>

                <div class="col-5">
                   <img src="img/Mahen/cust_feedback.jpg" class="img-fluid ver_car_img" id="cust_feedback_img" alt="Responsive image">
                </div>
              </div>
                
            </div>
            <!--End Of Third Tab-->

          </div>
        </div>
      </div>


      <!-- Start of Mechanic Changing model -->
			<div class="modal fade conferm_assigning" id="<%=Appointment.getAppId()%>"
				tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
				aria-hidden="true">
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
												<button type="submit" class="btn btn-primary btn-sm m-0" data-toggle="modal" data-target="#SuccessfullyAssigned"
												 onclick="AssignConfermation('<%=mech.getFullnameString()%>')" > Assign </button>
											</form>

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
		<!-- End of Mechanic Changing model -->
		
		<script type="text/javascript">
		
		function AssignConfermation(MechName) {
			document.getElementById("mecNameDidplay").innerHTML = MechName;
			 $('#<%=Appointment.getAppId()%>').modal('hide'); 
		}
		
		function Affectstatus(Status){
			document.getElementById("StatusLeft").innerHTML = Status;
			document.getElementById("Statusright").innerHTML = Status;
			 $('#StatusChanger').modal('hide'); 
		}
		
		function CloseallMods() {
			  $("#StatusChanger.close").click(); 	 
		}
		
		function CloseallMods2() {
			  $("#<%=Appointment.getAppId()%>.close").click(); 	 
		}
		
		function RemarkChanger() {
			document.getElementById("DispRemark").innerHTML = document.getElementById("remarksText").value;
		}
		</script>

      <!--Start Status Changing Model-->
      <div class="modal fade" id="StatusChanger" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
        aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalCenterTitle">Change Status</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
            <div class="row d-flex justify-content-center">
            	<form action="ChangeStatusServlet" method="get">
            		<input type="hidden" value="<%=Appointment.getAppId()%>" name="appointment2"> 
					<input type="hidden" name="Status" value="Pending">
					<input type="hidden" name="Page" value="Fullrequest"> 
              		<button type="submit" class="btn btn-success mr-4 mt-2" data-toggle="modal" data-target="#SuccessfullyChanged"
              		onclick="Affectstatus('pending')"><i class="fas fa-clipboard-check"></i>
                Pending</button>
                </form>
                
                <form action="ChangeStatusServlet" method="get">
                <input type="hidden" value="<%=Appointment.getAppId()%>" name="appointment2"> 
				<input type="hidden" name="Status" value="Accepted">
				<input type="hidden" name="Page" value="Fullrequest">
              		<button type="submit" class="btn btn-warning mr-4 mt-2" data-toggle="modal" data-target="#SuccessfullyChanged"
              		onclick="Affectstatus('Accepted')"><i class="far fa-window-close"></i>
                Accept</button>
                </form>
                
                <form action="ChangeStatusServlet" method="get">
                	<input type="hidden" value="<%=Appointment.getAppId()%>" name="appointment2">
                    <input type="hidden" name="Status" value="Rejected">
                    <input type="hidden" name="Page" value="Fullrequest">
              		<button type="submit" class="btn btn-danger mr-4 mt-2" data-toggle="modal" data-target="#SuccessfullyChanged"
              		onclick="Affectstatus('Rejected')"><i class="far fa-trash-alt"></i>
                Reject</button>
                </form>
                
              </div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
          </div>
        </div>
      </div>
      <!--End Status Changing Model-->
      
      <!-- Status changing confermation Model -->
			<div class="modal fade" id="SuccessfullyChanged" tabindex="1"
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
								<img alt="" src="img/Mahen/success_png_gif.gif">
								<h3>Status Changed Successfully</h3>
							</div>
						</div>

						<!--Footer-->
						<div class="d-flex justify-content-center">
						 <button type="button"
								class="btn btn-outline-success waves-effect mb-4"
								data-dismiss="modal" onclick="CloseallMods()">OK
						</button>
						</div>
					</div>
					<!--/.Content-->
				</div>
			</div>
			<!-- End of Status changing confermation Model-->
			
			<!-- Start of mechanicAssigning confermation Model -->
			<div class="modal fade" id="SuccessfullyAssigned" tabindex="1"
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
								<img alt="" src="img/Mahen/success_png_gif.gif">
								<h3>Mechanic Assigned Successfully</h3>
							</div>
						</div>

						<!--Footer-->
						<div class="d-flex justify-content-center">
						 <button type="button"
								class="btn btn-outline-success waves-effect mb-4"
								data-dismiss="modal" onclick="CloseallMods2()">OK
						</button>
						</div>
					</div>
					<!--/.Content-->
				</div>
			</div>
			<!-- Mechanic Assigning confermation Model-->
			

      <!--Start Customer contact Model-->
      <div class="modal fade" id="ContactCustomer" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">New message</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              <form>
                <div class="form-group">
                  <label for="recipient-name" class="col-form-label">Recipient:</label>
                  <input type="text" class="form-control" id="recipient-name">
                </div>
                <div class="form-group">
                  <label for="message-text" class="col-form-label">Message:</label>
                  <textarea class="form-control" id="message-text"></textarea>
                </div>
              </form>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
              <button type="button" class="btn btn-primary">Send message</button>
            </div>
          </div>
        </div>
      </div>
      <!--End Customer contact Model-->
    </div>
    <!--end of the middle part-->


  </div>

  <!--end of the body part-->

  <!--footer-->
    <jsp:include page="/WEB-INF/views/akila/footer.jsp"></jsp:include>
   <!--end of the footer-->

  <!--bootstrap-->
  <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
    integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous">
  </script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
    integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous">
  </script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
    integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous">
  </script>
  <!--end of the bootstrap-->

  <!--akila js-->
  <script src="js/akila/dashboard.js"></script>
  <!--end of the akila js-->

  <!--font awsome cdn-->
  <script src="https://kit.fontawesome.com/61a479e883.js" crossorigin="anonymous"></script>
  <!--end of the font awsone cdn-->

  <!--chart.js-->
  <script src="https://cdn.jsdelivr.net/npm/chart.js@2/dist/Chart.min.js"></script>
  <!--end of the chart.js-->

 
  <!--end of the charts-->
</body>

</html>
