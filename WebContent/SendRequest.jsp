<!-- Created by D.H.M.M.P.Thammita
IT No : IT19120362  
This page used JSTL
-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="img/akila/Reddy Roadster (1).png"
	type="image/x-icon" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Google Fonts -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
<!-- Bootstrap core CSS -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Material Design Bootstrap -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.16.0/css/mdb.min.css"
	rel="stylesheet">
<!--akila css-->
<link rel="stylesheet" href="css/akila/homepage.css">
<link rel="stylesheet" href="css/akila/dashboard.css" />
<!--Mahen css-->
<link rel="stylesheet" href="css/Mahen/sendrequest.css" />

<title>Send Request</title>


</head>
<body>


	<%
		//Checking the session variable before accessing the page
		if(session.getAttribute("regno") == null){
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	%>

	<div class="section-1" id="section-1">
		<!--Navbar -->
		<nav
			class="mb-1 navbar navbar-expand-lg navbar-dark transparent lighten-1"
			style="box-shadow: none; font-weight: bolder; border: none;">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent-555"
				aria-controls="navbarSupportedContent-555" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent-555">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link"
						href="HomePageRedirectServlet">Home <span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="UpdateUserDashboard">My profile</a></li>
					<li class="nav-item"><a class="nav-link"
						href="UpdatePaymentServlet">Make payment</a></li>
					<li class="nav-item"><a class="nav-link" href="LogoutServlet">Log out</a>
					</li>
					<!-- Dropdown -->

				</ul>
				<ul class="navbar-nav ml-auto nav-flex-icons">
					<li class="nav-item avatar"><a class="nav-link p-0" href="#">
							<img
							src="https://mdbootstrap.com/img/Photos/Avatars/avatar-5.jpg"
							class="rounded-circle z-depth-0" alt="avatar image" height="35">
					</a></li>
				</ul>
			</div>
		</nav>
		<!--/.Navbar -->

		<!--Start of Middle Part -->
		<div class="d-flex justify-content-center">


			<div class="jumbotron col-10 p-0 pb-2 m-0 mb-4 ">

				<!---------------------------------------------------------------------------------------------------->


				<div
					class="col-12 d-flex justify-content-center embed-responsive-1by1m-0 p-0">
					<img class="embed-responsive-item" src="img/Mahen/carFront.png"
						style="width: 2000px; height: 25rem;">
					<div
						class="card-img-overlay d-flex align-items-center justify-content-center">

						<div class="row ">
							<div class="col-lg-12 ">
								<button type="button" class="btn btn-success btn-lg btn-block"
									id="btn_newReq">
									New Request <i class="fas fa-pencil-alt"></i>
								</button>
							</div>
							<br> <br> <br>
							<div class="col-lg-12">
								<a href="userProfile.jsp"
									class="btn btn-success btn-lg btn-block" id="btn_myReq">My
									Requests <i class="fas fa-check-double"></i>
								</a>
							</div>
						</div>

					</div>

				</div>

				<!--Bigining of row 1 section 1-->
				<div class="row1 " id="ro1_section1">
					<!--Bigining of the calender details-->
					<div class="row pt-4 pl-4 open-days">
						<div class="card p-0 col-4 ">
							<div class="card-header" style="height: 100px;">
								<div class="row">
									<div class="col">
										<div class="row">
											<h1>20</h1>
										</div>
										<div class="row">
											<h6>Friday</h6>
										</div>
									</div>
									<div class="col d-flex justify-content-end">
										<i class=" far fa-calendar-alt fa-5x"></i>
									</div>
								</div>
							</div>
							<div class="card-body">
								<div class="row d-flex justify-content-center">
									<h1 class=" pb-4">Opening Hours</h1>
								</div>
								<div class="row">
									<table class="table open-days-table">
										<tbody>
											<tr>
												<th scope="row"><strong>MON</strong></th>
												<td class="d-flex justify-content-end">9.00-18.00</td>
											</tr>
											<tr>
												<th scope="row"><strong>TUE</strong></th>
												<td class="d-flex justify-content-end">9.00-18.00</td>
											</tr>
											<tr>
												<th scope="row"><strong>WED</strong></th>
												<td class="d-flex justify-content-end">9.00-18.00</td>
											</tr>
											<tr>
												<th scope="row"><strong>THU</strong></th>
												<td class="d-flex justify-content-end">9.00-18.00</td>
											</tr>
											<tr>
												<th scope="row"><strong>FRI</strong></th>
												<td class="d-flex justify-content-end">9.00-18.00</td>
											</tr>
											<tr>
												<th scope="row"><strong>SAT</strong></th>
												<td class="d-flex justify-content-end">Closed</td>
											</tr>
											<tr style="border-bottom: none;">
												<th scope="row"><strong>SUN</strong></th>
												<td class="d-flex justify-content-end">Closed</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<!--End of calender details-->

						<!--Bigining of services details-->
						<div class="our_services  col-8 pr-4 ">
							<div class="card">
								<div class="card-body">
									<h1 class="card-title mb-4 text-center">Our Services</h1>
									<div class="row row-cols-2">

										<div class="media p-3 mb-4" style="background-color: skyblue;">
											<div class="media-body mr-3">
												<h5 class="mt-0 text-right">Vehicle Wash</h5>
												<p class="text-right">If your car is not becoming to you, you should be coming to us..</p>
											</div>
											<img src="img/Mahen/wash_car.jpg" class="mr-3" alt="">
										</div>

										<div class="media p-3 mb-4" style="background-color: #fc9803;">
											<img src="img/Mahen/interior.jpg" class="mr-3" alt="">
											<div class="media-body ">
												<h5 class="mt-0">Interior Detailing</h5>
												Interior detailing involves cleaning the inner parts of a vehicle.
											</div>
										</div>



										<div class="media p-3 mb-4" style="background-color: magenta;">
											<div class="media-body mr-3">
												<h5 class="mt-0  text-right">Exterior Detailing</h5>
												<p class="text-right">It involves vacuuming, restoring, and surpassing the  exterior constituents.</p>
											</div>
											<img src="img/Mahen/exterior.jpg" class="mr-3" alt="...">
										</div>

										<div class="media p-3 mb-4" style="background-color: #fcff33;">
											<img src="img/Mahen/hybrid.jpg" class="mr-3" alt="...">
											<div class="media-body">
												<h5 class="mt-0">Hybrid services</h5>
												Our experts carry out all the hybrid specific checks your car needs.
											</div>
										</div>



										<div class="media p-3  mb-4"
											style="background-color: greenyellow;">
											<div class="media-body mr-3">
												<h5 class="mt-0 text-right">Wheel Alignment</h5>
												<p class="text-right">Enim est reprehenderit commodo
													aute magna cillum sunt veniam esse ex esse officia.</p>
											</div>
											<img src="img/Mahen/wheel_align.jpg" class="mr-3" alt="...">
										</div>

										<div class="media p-3  mb-4" style="background-color: #ff4d4d">
											<img src="img/Mahen/engine_tune.jpg" class="mr-3" alt="...">
											<div class="media-body">
												<h5 class="mt-0">Engine tune-up</h5>
												Regular engine tune-ups bring power and efficiency back to your car.We Complete Auto Care.
											</div>
										</div>

									</div>

								</div>
							</div>
						</div>
						<!--End of services details-->



					</div>
				</div>
				<!--End of row 1 section 1-->

				<!--start of Progression-->
				<div class="shadow category mr-3 ml-3 mb-5" id="cate_sel">

					<div
						class="row row-cols-4 prog_area m-3 mt-5 d-flex justify-content-center"
						style="background-color: inherit;">

						<h5 class="text-center">
							<strong>Package</strong>
						</h5>
						<h5 class="text-center">
							<strong>Service</strong>
						</h5>
						<h5 class="text-center">
							<strong>Vehicle Details</strong>
						</h5>
						<h5 class="text-center">
							<strong>Time</strong>
						</h5>
					</div>
					<!--Begining of Selection desplay area-->
					<div class="exp_change">
						<dv class="row row-cols-4  status_Display_Area  m-3"
							style="height: 250px;">

						<div class="card col-2 mr-5 ml-5 mt-0 p-0">
							<img class="card-img-top"
								src="img/Mahen/gold-package-720x940.png" alt="Card image cap" id="PackageSelectionImg">
							<div class="card-body">
								<h5 class="card-title text-center" id="SelectedPackName"></h5>
								<p class="card-text">
								<p class="card-text" id="SelectedPackDescription"></p>

								<div class="d-flex justify-content-center align-self-center">

								</div>
							</div>
						</div>

						<div class="card col-2 mr-5 ml-5 mt-0  p-0" id="pack_demo">
							<img class="card-img-top" src="img/Mahen/interior-HD_card.jpg"
								alt="Card image cap" id="ServiceSelectionImg">
							<div class="card-body">
								<h5 class="card-title" id="SelectedServiceName"></h5>
								<p class="card-text" id="SelectedServiceDescription"></p>
								<div class="d-flex justify-content-center align-self-center">

								</div>
							</div>
						</div>


						<div class="card col-2 mr-5 ml-5 mb-0 mt-0 p-0"
							id="Vehicle_details_Demo">
							<img class="card-img-top" src="img/Mahen/rotatingCar.gif"
								alt="Card image cap">
							<div class="card-body">
								<h5 class="card-title text-center" id="Vehicle_no_temperory">ASD 4512</h5>
								<p class="card-text">
									<i class="fab fa-bootstrap"></i> Brand : Toyota
								</p>
								<p class="card-text" id="Vehicle_model_temperory">
									<i class="fab fa-maxcdn"></i> Model : CHR
								</p>
								<p class="card-text" id="Vehicle_Year_temperory">
									<i class="far fa-calendar-alt"></i> Year : 2018
								</p>
							</div>
						</div>

						<div class="card col-2 mr-5 ml-5 mt-0 p-0" id="Time_dimo">
							<img class="card-img-top" src="img/Mahen/TimingWatchGif.gif"
								alt="Card image cap">
							<div class="card-body">
								<h5 class="card-title" >Your Time</h5>
								<p class="card-text">
								<p class="card-text" id="app_date_temperory">
									<i class="far fa-calendar-alt"></i> 25-03-2020
								</p>
								<p class="card-text">
								<p class="card-text" id="app_time_temperory">
									<i class="far fa-clock"></i> 9.00
								</p>
								<div class="d-flex justify-content-center align-self-center">

								</div>
							</div>
						</div>
					</div>

					<div
						class="row row-cols-4 prog_area m-3 mt-5 d-flex justify-content-center"
						style="background-color: inherit;">
						<i class="fas fa-check-circle fa-3x d-flex justify-content-center"
							id="land_M_1"></i> <i
							class="fas fa-check-circle fa-3x d-flex justify-content-center"
							id="land_M_2"></i> <i
							class="fas fa-check-circle fa-3x d-flex justify-content-center"
							id="land_M_3"></i> <i
							class="fas fa-check-circle fa-3x d-flex justify-content-center"
							id="land_M_4"></i>

						<div class="progress col-10 p-0 m-0">
							<div class="progress-bar  p-0 m-0 " role="progressbar"
								data-progress="10%" id="p_bar"></div>
						</div>
					</div>
				</div>

				<!--End of progression area-->

				<!-- Start of package selaction are -->

				<div class="Pack_selection" id="P_selection">
					<div
						class="row row-cols-3 d-flex justify-content-center pack_select">

						<c:forEach items="${AllPackages}" var="Package">
							<div class="card col-3 m-3 p-0">

								<!-- Card image -->
								<div class="view overlay">
									<img class="card-img-top"
										src="img/Mahen/bronze-package-720x940.png"
										alt="Card image cap"> <a>
										<div class="mask rgba-white-slight"></div>
									</a>
								</div>

								<!-- Card content -->
								<div class="card-body elegant-color white-text rounded-bottom">


									<!-- Title -->
									<h4 class="card-title text-center">
										<i class="fas fa-box-open"></i>${Package.getPackName()}
									</h4>
									<hr class="hr-light">
									<!-- Text -->
									<p class="card-text white-text mb-4">${Package.getPackDescription()}</p>
									<!-- Link   -->
									<c:url value="SelectPackServlet" var="SelectPackServletURL">
										<c:param name="SelectedPackgeNo" value="${Package.getPackId()}"/>
										<c:param name="SelectedPackgePrice" value="${Package.getPrice()}"/>
									</c:url>
									
									<a type="button" class="btn btn-light btn-lg pcg_btn"
										href="${SelectPackServletURL}"
										onclick="goService(25) ; DispPack('${Package.getPackName()}' , '${Package.getPackDescription()}' , '${Package.getPrice()}') ; getSpricejs('${Package.getPrice()}'); PackageImgSetter('${Package.getPackImage()}')">Select</a>



								</div>

							</div>
						</c:forEach>





					</div>
				</div>

				<!-- End of package selection area -->

				<!--Start of  row 1 Section 2-->

				<div class="mah" id="mah1">
					<div
						class="row row-cols-3 d-flex justify-content-center pack_select">


						<c:forEach items="${AllServices}" var="Service">
							<div class="card col-3 m-3 p-0" id="pcg_card">

								<img class="card-img-top" src="${Service.getServiceImg()} "
									alt="Card image cap">
								<div class="card-body">
									<h5 class="card-title">${Service.getServiceName()}</h5>
									<input type="hidden" name="ServiceID" value="SER04">
									<p class="card-text">${Service.getDescription()}</p>
									<p class="card-text">
										<small class="text-muted">Last updated 3 mins ago</small>
									</p>
									<div class="d-flex justify-content-center">
									
										<c:url value="SelectServiceServelet" var="SelectServiceServeletURL">
											<c:param name="ServiceID" value="${Service.getServiceId()}"/>
											
										</c:url>

										<a type="button"
											href="${SelectServiceServeletURL}"
											class="btn btn-success btn-lg pcg_btn"
											onclick="goDetails(50 , '${Service.getServiceName()}' , '${Service.getDescription()}') ; DispInvoiceServiceprice('${Service.getServicePrice()}') ;  ServiceImgSetter('${Service.getServiceImg()}')">Select</a>


									</div>
								</div>

							</div>
						</c:forEach>




						<div class="card col-3 m-3 p-0" id="pcg_card">
							<img class="card-img-top" src="img/Mahen/interior-HD_card.jpg"
								alt="Card image cap">
							<div class="card-body">
								<h5 class="card-title">Interior Detailing</h5>
								<p class="card-text">This card has supporting text below as
									a natural lead-in to additional content.</p>
								<p class="card-text">
									<small class="text-muted">Last updated 3 mins ago</small>
								</p>
								<div class="d-flex justify-content-center align-self-center">
									<button type="button" class="btn btn-success btn-lg pcg_btn"
										onclick="goDetails(50)">Select</button>
								</div>
							</div>
						</div>

						<div class="card col-3 m-3 p-0" id="pcg_card">
							<img class="card-img-top" src="img/Mahen/car_exterior_card.jpg"
								alt="Card image cap">
							<div class="card-body">
								<h5 class="card-title">Exterior Detailing</h5>
								<p class="card-text">This is a wider card with supporting
									text below as a natural lead-in to additional content. This
									card has even longer content than the first to show that equal
									height action.</p>
								<p class="card-text">
									<small class="text-muted">Last updated 3 mins ago</small>
								</p>
								<div class="d-flex justify-content-center align-self-center">
									<button type="button" class="btn btn-success btn-lg pcg_btn"
										onclick="goDetails(50)">Select</button>
								</div>
							</div>
						</div>

						<div class="card col-3 m-3 p-0" id="pcg_card">
							<img class="card-img-top" src="img/Mahen/Hybrid_dard.jpg"
								alt="Card image cap">
							<div class="card-body">
								<h5 class="card-title">Hybrid services</h5>
								<p class="card-text">This is a longer card with supporting
									text below as a natural lead-in to additional content. This
									content is a little bit longer.</p>
								<p class="card-text">
									<small class="text-muted">Last updated 3 mins ago</small>
								</p>
								<div class="d-flex justify-content-center">
									<button type="button" class="btn btn-success btn-lg pcg_btn"
										onclick="goDetails(50)">Select</button>
								</div>
							</div>
						</div>
						<div class="card col-3 m-3 p-0" id="pcg_card">
							<img class="card-img-top"
								src="img/Mahen/Wheel-alignment-card.jpg" alt="Card image cap">
							<div class="card-body">
								<h5 class="card-title">Wheel Alignment</h5>
								<p class="card-text">This card has supporting text below as
									a natural lead-in to additional content.</p>
								<p class="card-text">
									<small class="text-muted">Last updated 3 mins ago</small>
								</p>
								<div class="d-flex justify-content-center">
									<button type="button" class="btn btn-success btn-lg pcg_btn"
										onclick="goDetails(50)">Select</button>
								</div>
							</div>
						</div>
						<div class="card col-3 m-3 p-0" id="pcg_card">
							<img class="card-img-top" src="img/Mahen/Engine_tine_up_card.png"
								alt="Card image cap">
							<div class="card-body">
								<h5 class="card-title">Engine tune-up</h5>
								<p class="card-text">This is a wider card with supporting
									text below as a natural lead-in to additional content. This
									card has even longer content than the first to show that equal
									height action.</p>
								<p class="card-text">
									<small class="text-muted">Last updated 3 mins ago</small>
								</p>
								<div class="d-flex justify-content-center">
									<button type="button" class="btn btn-success btn-lg pcg_btn"
										onclick="goDetails(50)">Select</button>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!--End of  row 1 Section 2-->
				
				<!-- Frame Modal Bottom -->
<div class="modal fade bottom" id="frameModalTop" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
  aria-hidden="true">

  <!-- Add class .modal-frame and then add class .modal-bottom (or other classes from list above) to set a position to the modal -->
  <div class="modal-dialog modal-frame modal-top" role="document">


    <div class="modal-content">
      <div class="modal-body">
        <div class="row d-flex justify-content-center align-items-center">

          <p class="pt-3 pr-2" style="color: red;font-size: 30px;">Please Fill Required Fields
          </p>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- Frame Modal Bottom -->


				<!--Start of  row 1 Section 3-->
				<form action="CreateAppointmentServlet" method="get">
				
					<div class="Vehi_Details mb-2 mt-2 pb-0">
					
					
					
					<!-- Start new vehi Details Model -->
					                    <div class="jumbotron jombo_sec_3 d-flex justify-content-end p-0 m-0">
                        <div class="col-6">
                            <img src="img/Mahen/fillingGif.gif" style="width: 100%; height: 100%;">

                        </div>
                        <div class="col-6 ">

                           
                           

                                <h5 class="text-center py-4">
                                    <strong>Vehicle Details</strong>
                                </h5>

                                <!--Card content-->
                                <div class="card-body px-lg-5 pt-0">

                                   

                                        <div class="md-form input-with-pre-icon">
                                            <i class="fas fa-car-alt input-prefix"></i>
                                            <input type="text" id="Vehicle_Nosa" class="form-control"
                                            name="vehi_No" value="" required>
                                            <label for="Vehicle_Nosa">Vehicle No</label>
                                        </div>

                                        <div class="md-form input-with-pre-icon">
                                            <i class="fab fa-bootstrap input-prefix"></i>
                                            <input type="text" id="Vehicle_brand" class="form-control" required
                                                name="brand" placeholder="" required value="">
                                            <label for="Vehicle_brand">Vehicle Brand </label>
                                        </div>

                                        <div class="md-form input-with-pre-icon">
                                            <i class="fab fa-medium-m input-prefix"></i>
                                            <input type="text" id="Vehicle_model" class="form-control" required
                                                name="model" placeholder="" name="Model" value="">
                                            <label for="Vehicle_model">Vehicle Model </label>
                                        </div>
                                        
                                        

                                        <div class="md-form input-with-pre-icon">
                                            <i class="far fa-calendar-alt input-prefix"></i>
                                            <input type="text" id="Vehicle_year" class="form-control" required
                                                name="year" placeholder="" name="year" required value="">
                                            <label for="Vehicle_year">Manufactured Year </label>
                                        </div>
                                        
                                        <div class="form-row">
                                       
                                        
                                        <div class="form-group col-6">
                                            <label for="Vehicle_trans" class="SelectingLabels">
                                                <i class="fas fa-cogs"></i>Transmission
                                            </label>
                                            <select id="Vehicle_trans" class="browser-default custom-select"
                                                name="Transmission" required>
                                                <option selected>Choose...</option>
                                                <option>Auto</option>
                                                <option>Manual</option>
                                                <option>Tiptronic</option>
                                            </select>
                                        </div>

                                        
                                        
                                        <div class="form-group col-6">
                                            <label for="Vehicle_fuel" class="SelectingLabels">
                                                <i class="fas fa-gas-pump"></i>Fuel Type
                                            </label>
                                            <select id="Vehicle_fuel" class="browser-default custom-select" name="Fuel"
                                                required>
                                                <option selected>Choose...</option>
                                                <option value="Petrol">Petrol</option>
                                                <option value="Diesel">Diesel</option>
                                                <option value="Gasoline">Gasoline</option>
                                                <option value="Electric">Electric</option>
                                            </select>
                                        </div>
                                        </div>

                                        
                                        <div class="md-form input-with-pre-icon">
                                            <i class="fas fa-cog input-prefix"></i>
                                            <input type="text" class="form-control" name="Engine" placeholder=""
                                                id="prefixInside" name="Engine">
                                            <label for="prefixInside">Engine CApacity </label>
                                        </div>

                                        <div class="d-flex justify-content-start vehiclefrmsbmtBtn">
                                            
                                            <button type="button" onclick="goTime(60)"
                                                class="btn btn-info btn-rounded btn-block my-4 waves-effect z-depth-0">
                                                <i class="far fa-hand-point-right fa-2x"><strong>
                                                        Next </strong></i>


                                            </button>
                                        </div>

                            </div>

                        </div>
                    </div>
					<!-- End of new vehi Details Model -->

					
					</div>
					
					<!--End of  row 1 Section 3-->
					<!--Start of  row 1 Section 4-->

					<div class="Jumbo2">
						<div class="row d-flex justify-content-between">



							<div class="ml-4">
								<i class="fas fa-arrow-circle-left fa-3x"></i><br>Previous
								Week
							</div>
							<div class="row">
								<div class="input-group-prepend mt-2">
									<i class="far fa-calendar-alt fa-5x "></i>
								</div>
								<input type="date" id="Week_selector" onchange="weekpick()"
									class="btn btn-primary btn-lg"
									placeholder="Choose your Date here" name="AppDate">
							</div>


							<div class="mr-4">
								<i class="fas fa-arrow-circle-right fa-3x"></i><br>Next
								Week
							</div>

						</div>

						<div class="jumbo2_part2">
							<hr class="my-4">
							<h3 class="text-center">Select Your time below</h3>
							<p class="text-left ml-3">
								<i class="fas fa-circle"
									style="color: #03a9f4; line-height: 0px;"></i> Available times
							</p>
							<p class="text-left ml-3">
								<i class="fas fa-circle"
									style="color: #ec407a; line-height: 0px;"></i> Unavailable
								times
							</p>
							<hr class="my-4">


							<!-- Editable table -->
							<div class="card">

								<div class="card-body">
									<div id="table" class="table-editable table-borderless">

										<table
											class="table table-borderless table-responsive-md  text-center">
											<thead>
												<tr>
													<th class="center">
														<div class="table_head_class">
															<p class="font-weight-light" id="SUN">Mar 24</p>
															<hr class="m-0 p-0">
															<p>SUN</p>
														</div>
													</th>
													<th>
														<div class="table_head_class">
															<p class="font-weight-light" id="MON">Mar 25</p>
															<hr class="m-0 p-0">
															<p>MON</p>
														</div>
													</th>
													<th>
														<div class="table_head_class">
															<p class="font-weight-light" id="TUE">Mar 26</p>
															<hr class="m-0 p-0">
															<p>TUE</p>
														</div>
													</th>
													<th class="center">
														<div class="table_head_class">
															<p class="font-weight-light" id="WED">Mar 27</p>
															<hr class="m-0 p-0">
															<p>WED</p>
														</div>
													</th>
													<th class="center">
														<div class="table_head_class">
															<p class="font-weight-light" id="THU">Mar 28</p>
															<hr class="m-0 p-0">
															<p>THU</p>
														</div>
													</th>
													<th class="center">
														<div class="table_head_class">
															<p class="font-weight-light" id="FRI">Mar 29</p>
															<hr class="m-0 p-0">
															<p>FRI</p>
														</div>
													</th>
													<th class="center">
														<div class="table_head_class">
															<p class="font-weight-light" id="SAT">Mar 30</p>
															<hr class="m-0 p-0">
															<p>SAT</p>
														</div>
													</th>
												</tr>
											</thead>
											<tbody>
											
											<% for(int timeSet = 8 ; timeSet < 17 ; timeSet++){ int nextime = (timeSet + 1); %>
												<tr>
													<td>
														<form action="getDateServlet" method="get">
															<input type="hidden" value="" class="Sunday_date"
																name="Date"> <input type="hidden"
																value="<%=timeSet%>:00:00" name="Time">
															<button type="submit" class="btn btn-pink"
																onclick="goInvoice(value)" disabled>
																<strong><%=timeSet%>.00-<%=nextime%>.00</strong>
															</button>
														</form>
													</td>
													<td>
														<form action="getDateServlet" method="get">
															<input type="hidden" value="1" class="Monday_date"
																name="Date"> <input type="hidden"
																value="<%=timeSet%>:00:00" name="Time">
															<button type="submit" class="btn btn-light-blue"
																onclick="goInvoice(value)">
																<strong><%=timeSet%>.00-<%=nextime%>.00</strong>
															</button>
														</form>
													</td>
													<td>
														<form action="getDateServlet" method="get" name="datform">
															<input type="hidden" value="2" class="Tuesday_date"
																name="Date"> <input type="hidden"
																value="<%=timeSet%>:00:00" name="Time">
															<button type="submit" class="btn btn-light-blue"
																onclick="goInvoice(value)">
																<strong><%=timeSet%>.00-<%=nextime%>.00</strong>
															</button>
														</form>
													</td>
													<td>
														<form action="getDateServlet" method="get" name="datform">
															<input type="hidden" value="3" class="Wednesday_date"
																name="Date"> <input type="hidden"
																value="<%=timeSet%>:00:00" name="Time">
															<button type="submit" class="btn btn-light-blue"
																onclick="goInvoice(value)">
																<strong><%=timeSet%>.00-<%=nextime%>.00</strong>
															</button>
														</form>
													</td>
													<td>
														<form action="getDateServlet" method="get" name="datform">
															<input type="hidden" value="4" class="Thursday_date"
																name="Date"> <input type="hidden"
																value="<%=timeSet%>:00:00" name="Time">
															<button type="submit" class="btn btn-light-blue"
																onclick="goInvoice(value)">
																<strong><%=timeSet%>.00-<%=nextime%>.00</strong>
															</button>
														</form>
													</td>
													<td>
														<form action="getDateServlet" method="get" name="datform">
															<input type="hidden" value="5" class="Friday_date"
																name="Date"> <input type="hidden"
																value="<%=timeSet%>:00:00" name="Time">
															<button type="submit" class="btn btn-light-blue"
																onclick="goInvoice(value)">
																<strong><%=timeSet%>.00-<%=nextime%>.00</strong>
															</button>
														</form>
													</td>
													<td>
														<form action="getDateServlet" method="get">
															<input type="hidden" value="6" class="Saturday_date"
																name="Date"> <input type="hidden"
																value="<%=timeSet%>:00:00" name="Time">
															<button type="submit" class="btn btn-pink"
																onclick="goInvoice(value)" disabled>
																<strong><%=timeSet%>.00-<%=nextime%>.00</strong>
															</button>
														</form>
													</td>

												</tr>
												<%} %>
												<!-- This is our clonable table line -->
												

											</tbody>
										</table>
									</div>
								</div>
							</div>
							<!-- Editable table -->

						</div>

					</div>
					<!--Start of  row 1 Section 4-->

					<!--Start of  row 1 Section 5-->
					<div class="invoice">
						<div class="jumbotron">
							<div
								class="row row-cols-3 Invoice_header d-flex align-items-center">

								<div
									class="col-md-6 d-flex align-items-center justify-content-center">
									<h1 style="font-size: 80px; color: white;">Invoice</h1>
								</div>
								<div class="col-md-3  text-left">
									<p style="color: white;">+94(0)-11-5-555-789</p>
									<p style="color: white;">carservice@gmail.com</p>
									<p style="color: white;">onlinecarservice@gmail.com</p>
								</div>
								<div class="col-md-3  text-left">
									<p style="color: white;">New candy Road</p>
									<p style="color: white;">Malabe</p>
									<p style="color: white;">58642</p>
								</div>

							</div>
							<div class="row row-cols-3 d-flex align-items-center">
								<div class="col-4">
									<p class="text-muted">Billed to</p>
									<strong>
										<p>Akila Liyanage</p>
										<p>Street name</p>
										<p>City, State , Province</p>
										<p>akilaliyanage@gmail.com</p>
									</strong>
								</div>
								<div class="col-4">

									<p class="text-muted">Invoice No</p>
									<strong>
										<p>4564654</p> </br>
									</strong>


									<p class="text-muted">Date of Issue</p>
									<strong>
										<p id="InvoiceDate">24-03-2020</p>
									</strong>

								</div>
								<div class="col-4 text-right">
									<p class="text-muted">Invoice Total</p>
									<p style="font-size: 50px; color: #ff4561;" id="BillValue" ></p>
								</div>
							</div>


							<hr class="my-4"
								style="background-color: #ff4561; height: 3px; border-radius: 3px;">

							<table class="table table-borderless ">
								<thead>
									<tr style="color: #ff4561;">
										<th class=" text-left">Service</th>
										<th class=" text-left">Unit Price</th>
										<th class=" text-left">Qty</th>
										<th class=" text-left">Ammount</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><strong>Package charges</strong><br><p id="InvoicePack_name"></p></td>
										<td id="Invoice_package_price"></td>
										<td>1</td>
										<td><p  id="Invoice_package_price_amm"></p></td>
									</tr>

									<tr>
										<td><strong>Parts</strong><br> Not purchased</td>
										<td>0.00</td>
										<td>0</td>
										<td>0.00</td>
									</tr>
									
									<tr>
										<td><strong>Service Charge</strong><br><p id="Invoice_ServiceName"></p></td>
										<td id="Invoice_service_price_amm"></td>
										<td>1</td>
										<td><p id="Invoice_service_price"></p></td>
									</tr>

								</tbody>
							</table>
							<div class="text-right d-flex justify-content-end">
								<div class="col-3">
									<p style="color: #ff4561;">Sub Total</p>
									<p style="color: #ff4561;">Tax</p>
								</div>
								<div class="col-3">
									<p>
										<strong id="InvoiceTot"></strong>
									</p>
									<p>
										<strong id="InvoiceTax"></strong>
									</p>
								</div>
							</div>
							<hr class="my-4"
								style="background-color: #ff4561; height: 3px; border-radius: 3px;">
							<div class=" d-flex justify-content-end">
								<a class="btn btn-primary btn-lg mr-5 " href="#" role="button">Cancel
									<i class="far fa-window-close"></i>
								</a>
								<button type="submit" class="btn btn-primary btn-lg mr-5 ">
									<i class="fas fa-clipboard-check"></i> Conferm
								</button>

							</div>


						</div>

					</div>
				</form>
				<!---------------------------------------------------------------------------------------------------->


			</div>

		</div>



		<!--End of Middle Part -->
	</div>

	<div class="section-2">
		<div class="row">
			<div class="col-lg-6 col-md-6 col-sm-6 d-none d-md-block sec2-left">
				<img src="img/akila/wait.gif" alt="">
			</div>

			<div
				class="col-lg-6 col-md-6 col-sm-6 col-sm-12 col-xs-12 sec2-right">
				<h1 class="font-weight-bold">
					STOP WAITING....... <br> SCHEDULE AND GO
				</h1>
				<br>
				<p>Lorem ipsum dolor sit amet consectetur, adipisicing elit.
					Dolor qui porro totam explicabo quam, aspernatur maxime.
					Accusantium magnam vel fugit maxime magni, aspernatur ad adipisci
					dolor dolore nisi! Eligendi, quod. Lorem ipsum dolor sit amet
					consectetur adipisicing elit. Incidunt nulla omnis ex placeat,
					tenetur dolorum quia atque voluptates quasi neque explicabo
					voluptatibus ut eveniet voluptatum iure culpa saepe vel. Culpa?
					Lorem ipsum dolor sit amet consectetur, adipisicing elit. Molestiae
					laborum corporis delectus placeat cum quis beatae, nisi ab totam
					corrupti in architecto, amet nesciunt dolorem quasi error harum
					perferendis porro.</p>
				<a href="#section-1" class="btn btn-success">Shedule an <strong>Apponitment</strong></a>
				<a href="#section-3" class="btn btn-danger">See the <strong>Packages</strong></a>
			</div>
		</div>
	</div>

	<div class="section-3" id="section-3">
		<div class="row">
			<div class="col" style="padding: 30px;">
				<h1>Packages Available</h1>
			</div>
		</div>
		<div class="row ">
			<div class="col-lg-12 flex">

				<!-- Card -->
				<div class="card" style="width: 300px;">

					<!-- Card image -->
					<div class="view overlay">
						<img class="card-img-top"
							src="https://mdbootstrap.com/img/Mockups/Lightbox/Thumbnail/img%20(67).jpg"
							alt="Card image cap"> <a href="#!">
							<div class="mask rgba-white-slight"></div>
						</a>
					</div>

					<!-- Card content -->
					<div class="card-body">

						<!-- Title -->
						<h4 class="card-title">Package #1</h4>
						<!-- Text -->
						<p class="card-text">Package Details :</p>
						<ul>
							<li>test</li>
							<li>test</li>
						</ul>
						<!-- Button -->
						<a href="#section-1" class="btn btn-primary">SCHEDULE</a>

					</div>

				</div>
				<!-- Card -->

				<!-- Card -->
				<div class="card" style="width: 300px;">

					<!-- Card image -->
					<div class="view overlay">
						<img class="card-img-top"
							src="https://mdbootstrap.com/img/Mockups/Lightbox/Thumbnail/img%20(67).jpg"
							alt="Card image cap"> <a href="#!">
							<div class="mask rgba-white-slight"></div>
						</a>
					</div>

					<!-- Card content -->
					<div class="card-body">

						<!-- Title -->
						<h4 class="card-title">Package #1</h4>
						<!-- Text -->
						<p class="card-text">Package Details :</p>
						<ul>
							<li>test</li>
							<li>test</li>
						</ul>
						<!-- Button -->
						<a href="#section-1" class="btn btn-primary">SCHEDULE</a>

					</div>

				</div>
				<!-- Card -->

				<!-- Card -->
				<div class="card" style="width: 300px;">

					<!-- Card image -->
					<div class="view overlay">
						<img class="card-img-top"
							src="https://mdbootstrap.com/img/Mockups/Lightbox/Thumbnail/img%20(67).jpg"
							alt="Card image cap"> <a href="#!">
							<div class="mask rgba-white-slight"></div>
						</a>
					</div>

					<!-- Card content -->
					<div class="card-body">

						<!-- Title -->
						<h4 class="card-title">Package #1</h4>
						<!-- Text -->
						<p class="card-text">Package Details :</p>
						<ul>
							<li>test</li>
							<li>test</li>
						</ul>
						<!-- Button -->
						<a href="#section-1" class="btn btn-primary">SCHEDULE</a>

					</div>

				</div>
				<!-- Card -->

				<!-- Card -->
				<div class="card" style="width: 300px;">

					<!-- Card image -->
					<div class="view overlay">
						<img class="card-img-top"
							src="https://mdbootstrap.com/img/Mockups/Lightbox/Thumbnail/img%20(67).jpg"
							alt="Card image cap"> <a href="#!">
							<div class="mask rgba-white-slight"></div>
						</a>
					</div>

					<!-- Card content -->
					<div class="card-body">

						<!-- Title -->
						<h4 class="card-title">Package #1</h4>
						<!-- Text -->
						<p class="card-text">Package Details :</p>
						<ul>
							<li>test</li>
							<li>test</li>
						</ul>
						<!-- Button -->
						<a href="#section-1" class="btn btn-primary">SCHEDULE</a>

					</div>

				</div>
				<!-- Card -->



			</div>


		</div>
	</div>


	<!--footer-->
    <jsp:include page="/WEB-INF/views/akila/footer.jsp"></jsp:include>
   <!--end of the footer-->




	<!-- JQuery -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.min.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.16.0/js/mdb.min.js"></script>
	<!--Mahen js-->
	<script src="js/Mahen/SendRequest.js"></script>
	<!--end of the Mahen js-->
	


</body>
</html>