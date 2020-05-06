<!DOCTYPE html>
<%-- <%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%> --%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.oop.model.PackageForAppoint"%>
<%@page import="com.oop.model.VehicalServices"%>
<%@page import="com.oop.model.VehicleModel"%>
<%@page import="com.oop.model.AppointmentModel"%>
<%@page import="com.oop.model.UserModel"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="img/akila/Reddy Roadster (1).png" type="image/x-icon" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <!-- Google Fonts -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
    <!-- Bootstrap core CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.16.0/css/mdb.min.css" rel="stylesheet">
    <!--akila css-->
    <link rel="stylesheet" href="css/akila/homepage.css">
    <link rel="stylesheet" href="css/akila/dashboard.css" />
    <!--Mahen css-->
    <link rel="stylesheet" href="css/Mahen/sendrequest.css" />

    <title>Frontend Template</title>
</head>

<body>

	<%
		UserModel User = (UserModel) request.getAttribute("User");
		AppointmentModel Appointment = (AppointmentModel) request.getAttribute("Appointment");
		VehicleModel Vehicle = (VehicleModel) request.getAttribute("Vehicle");
		VehicalServices Service = (VehicalServices) request.getAttribute("Service");
		PackageForAppoint Package = (PackageForAppoint)request.getAttribute("Package");
		
		
		List<PackageForAppoint> Allpacks = (ArrayList<PackageForAppoint>) request.getAttribute("Allpacks");
		List<VehicalServices> AllvehiServices = (ArrayList<VehicalServices>) request.getAttribute("AllvehiServices");
	%>

    <div class="section-1" id="section-1">
        <!--Navbar -->
        <nav class="mb-1 navbar navbar-expand-lg navbar-dark transparent lighten-1"
            style="box-shadow: none;font-weight: bolder; border: none;">
            <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbarSupportedContent-555" aria-controls="navbarSupportedContent-555"
                aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent-555">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="homepage.html">Home
                            <span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="userProfile.jsp">My profile</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="userProfile.jsp">Make payment</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Log out</a>
                    </li>
                    <!-- Dropdown -->

                </ul>
                <ul class="navbar-nav ml-auto nav-flex-icons">
                    <li class="nav-item avatar">
                        <a class="nav-link p-0" href="#">
                            <img src="https://mdbootstrap.com/img/Photos/Avatars/avatar-5.jpg"
                                class="rounded-circle z-depth-0" alt="avatar image" height="35">
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
        <!--/.Navbar -->

        <!--Start of Middle Part -->
        <div class="col-12 d-flex justify-content-center">


            <div class=" col-10 container my-5 py-5 z-depth-1" style="background-color: white;">


                <!--Section: Content-->
                <section class="px-md-5 mx-md-5 text-center text-lg-left dark-grey-text">

                    <!--Grid row-->
                    <div class="row">

                        <!--Grid column-->
                        <div class="col-md-6 mb-4 mb-md-0">

                            <h1 class="font-weight-bold"><%=Service.getServiceName() %></h1>

                            <p class="text-muted"><%=Service.getDescription() %></p>

                            <div class="row">
                                <h3 class="col-6">Request No :</h3>
                                <h3 class="text-right col-5"><%=Appointment.getAppId() %></h3>
                            </div>
                            <div class="row">
                                <h3 class="col-6">Date :</h3>
                                <h3 class="text-right col-5"><%=Appointment.getPrefDate() %></h3>
                            </div>
                            <div class="row">
                                <h3 class="col-6">Time :</h3>
                                <h3 class="text-right col-5"><%=Appointment.getPrefTime() %></h3>
                            </div>

                            <a class="btn btn-purple btn-md ml-0" role="button" disabled> <%=Appointment.getStatus() %> <i
                                    class="fa fa-gem ml-2"></i></a>

                        </div>
                        <!--Grid column-->

                        <!--Grid column-->
                        <div class="col-md-6 mb-4 mb-md-0">

                            <!--Image-->
                            <div class="view overlay z-depth-1-half">
                                <img src="<%=Service.getServiceImg() %>" class="img-fluid" alt="">
                                <a href="#">
                                    <div class="mask rgba-white-light"></div>
                                </a>
                            </div>

                        </div>
                        <!--Grid column-->

                    </div>
                    <!--Grid row-->


                </section>
                <!--Section: Content-->


            </div>

        </div>

        <div class="d-flex justify-content-center">

            <!-- News jumbotron -->
            <div class="col-10 jumbotron text-center hoverable p-4">

                <!-- Grid row -->
                <div class="row">

                    <!-- Grid column -->
                    <div class="col-md-4 offset-md-1 mx-3 my-3">


                        <!-- Featured image -->
                        <div class="view overlay" style="height: 500px;">
                            <img src="img/Mahen/FrontendReqDetails.jpg" class="img-fluid"
                                style="height: 500px;width: 390px;"
                                alt="Sample image for first version of blog listing">
                            <a>
                                <div class="mask rgba-white-slight"></div>
                            </a>
                        </div>

                        <button type="button" class="btn btn-lg btn-block btn-primary ml-0" data-toggle="modal"
                            data-target="#Edit_requestModel">EditRequest
                        </button>
                        <button type="button" class="btn btn-lg btn-block btn-warning ml-0" data-toggle="modal" 
                            data-target="#ContactUsModal">Contact Us
                        </button>
                        <button type="button" class="btn btn-lg btn-block btn-success ml-0"data-toggle="modal"
                            data-target="#FeedbackModal">Feedback
                        </button>
                        <button type="button" class="btn btn-lg btn-block btn-danger ml-0" data-toggle="modal"
                            data-target="#ConfirmDelete">Delete Request
                        </button>

                    </div>
                    <!-- Grid column -->

                    <!-- Grid column -->
                    <div class="col-md-7 text-md-left ml-3 mt-3">

                        <!-- Excerpt -->
                        <a href="#!" class="green-text">
                            <h6 class="h6 pb-1"><i class="fas fa-desktop pr-1"></i> Customer</h6>
                        </a>

                        <h3 style="color: #4285F4;"> <i class="fas fa-car-side"></i> More Details</h3>
                        <hr style="border-width: 5px; border-color: #0d47a1;">

                        <div class="row">
                            <div class="col-6 border-right" style="line-height: 0px;">

                                <p class="ml-4"> <i class="fas fa-user-alt"></i> <strong> Customer name : </strong> </p>
                                <p class="text-right"> <%=User.getUserName()%></p>

                                <p class="ml-4"> <i class="fas fa-box"></i> <strong> Package : </strong> </p>
                                <p class="text-right >"><%=Package.getPackName() %></p>

                            </div>
                            <div class="col-6 " style="line-height: 0px;">
                                <p class="ml-4"> <i class="fas fa-car"></i> <strong> Vehicle No : </strong> </p>
                                <p class="text-right "><%=Vehicle.getVehicleId() %></p>

                            </div>
                        </div>

                        <h3 style="color: #4285F4;"> <i class="fas fa-car-side" ></i> Vehicle details</h3>
                        <hr style="border-width: 5px; border-color: #0d47a1;">

                        <div class="row">
                            <div class="col-6 border-right" style="line-height: 0px;">

                                <p class="ml-4"> <i class="fab fa-bootstrap"></i> <strong> Brand : </strong> </p>
                                <p class="text-right"><%=Vehicle.getBrand() %></p>

                                <p class="ml-4"> <i class="fab fa-medium-m"></i> <strong> Model: </strong> </p>
                                <p class="text-right"><%=Vehicle.getModel() %></p>

                                <p class="ml-4"> <i class="fas fa-tachometer-alt"></i> <strong> Year: </strong> </p>
                                <p class="text-right"><%=Vehicle.getManuYear() %></p>

                            </div>
                            <div class="col-6 " style="line-height: 0px;">
                                <p class="ml-4"> <i class="fas fa-cogs"></i> <strong> Transmission : </strong> </p>
                                <p class="text-right"><%=Vehicle.getTransmission() %></p>

                                <p class="ml-4"> <i class="fas fa-gas-pump"></i> <strong> Fuel Type : </strong> </p>
                                <p class="text-right"><%=Vehicle.getFuelType() %></p>

                                <p class="ml-4"> <i class="fas fa-oil-can"></i> <strong> Engine Capacity : </strong>
                                </p>
                                <p class="text-right"><%=Vehicle.getEngineCap() %></p>
                            </div>
                        </div>

                        <h3 style="color: #4285F4;" class="mt-4"> <i class="fab fa-cc-amazon-pay"></i> Payment details
                        </h3>
                        <hr style="border-width: 5px; border-color: #0d47a1;">


                        <div class="row">
                            <div class="col-6 border-right" style="line-height: 0px;">

                                <p class="ml-4"> <i class="fas fa-money-check-alt"></i> <strong> Bill No : </strong>
                                </p>
                                <p class="text-right"> Not Available</p>

                                <p class="ml-4"> <i class="fas fa-hand-holding-usd"></i> <strong> Total Payment :
                                    </strong> </p>
                                <p class="text-right"><%=Appointment.getAmmount() %> Rs</p>

                            </div>
                            <div class="col-6 " style="line-height: 0px;">
                                <p class="ml-4"> <i class="far fa-file-alt"></i> <strong> Payment Status : </strong>
                                </p>
                                <p class="text-right"> <%=Appointment.getStatus() %> </p>
                            </div>
                            <a href="" class="ml-4 mb-4 mb-2"><strong> Click here to view bill</strong></a>
                        </div>

                        <h4 class="h4 mb-4">Company Remarks</h4>
                        <p class="text-right"><%=Appointment.getRemarks() %></p>



                    </div>
                    <!-- Grid column -->

                </div>
                <!-- Grid row -->

            </div>
            <!-- End of jumbotron -->


            <!--Stat of Edit Request Model -->
            <div class="modal fade" id="Edit_requestModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                aria-hidden="true">

                
                <div class="modal-dialog modal-lg " role="document">


                    <div class="modal-content">
                        <div class="modal-header peach-gradient">
                            <h2 class="modal-title w-100" id="myModalLabel">Edit Request</h2>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="row row row-cols-3">
                                  <div class="col-xl-3 col-md-1 ml-4 mb-3 text-center">

                                      <img src="https://mdbootstrap.com/img/Photos/Avatars/img(31).jpg"
                                          class="img-fluid z-depth-1 rounded-circle" alt="Responsive image">

                                  </div>
                                <div class="col-5 mt-4 pt-4">
                                    <h4 class="ml-4"> <i class="fas fa-envelope-open-text"></i> <strong> Request No : </strong> </h4>
                                    <h4 class="ml-4"> <i class="fas fa-user-alt"></i> <strong> Customer name : </strong> </h4>
                                    <h4 class="ml-4"> <i class="fas fa-car"></i> <strong> Vehicle No : </strong> </h4>
                                    
                                </div>
                                <div class="col-3 mt-4 pt-4">
                                    <h5 class="text-right" name = "Appoint_no" ><%=Appointment.getAppId()%></p>
                                   
                                    <h5 class="text-right" > <%=User.getUserName() %></h5>
                                    
                                    <h5 class="text-right" > <%=Vehicle.getVehicleId() %></h5>
                                </div>
                            </div>
                            <hr style="border-width: 3px; border-color: #ff9100;">

                            

                            <form action="EditAppointmentServlet" method="get">
                            	<input type="hidden" name="CurrentAppID" value="<%=Appointment.getAppId()%>">
                            	<input type="hidden" name="CurrentVehiId" value="<%=Vehicle.getVehicleId() %>">
                            	
                            	 <h3  style="color: orange;font-weight: bold;"> Service Details</h3>
                            	 
                            	 <div class="row">
                            	 
                            	 	<div class="form-group col-5 ml-4">
                                        <label for="inputState"> <i class="fas fas fa-box grey-text fa-2x"></i>Package</label>
                                        <select id="inputState" class="form-control ml-3" name="Edit_pack" >
                                            <option selected><%=Package.getPackName() %></option>
                                            <% for(PackageForAppoint psckList : Allpacks) { %>
                                            	<option value="<%= psckList.getPackName() %>"><%= psckList.getPackName() %></option>
                                            <% } %>
                                        </select>
                                    </div>
                                    
                                    <div class="form-group col-5 ml-4">
                                        <label for="inputState"> <i class="fas fa-hands-helping grey-text fa-2x"></i>Service</label>
                                        <select id="inputState" class="form-control ml-3" name="Edit_Service">
                                            <option selected><%= Service.getServiceName() %></option>
                                            <% for(VehicalServices serviceList : AllvehiServices) { %>
                                            	<option value="<%= serviceList.getServiceName() %>"><%= serviceList.getServiceName() %></option>
                                            <% } %>
                                        </select>
                                    </div>
                            	 	
                            	 </div>
                                <h3  style="color: orange;font-weight: bold;"> Vehicle Details</h3>

                                <div class="row">
                                    
                                    
                                    <div class="form-group col-md-3 ml-4">
                                        <label for="inputState"><i class="fab fa-bootstrap grey-text fa-2x"></i> Brand</label>
                                        <input id="inputState" class="form-control ml-3" name="Edit_brand">
                                    </div>     
                                        
                                    <div class="form-group col-md-3 ml-4">
                                        <label for="inputState"> <i class="fab fa-medium-m grey-text fa-2x"></i> Model</label>
                                        <input id="inputState" class="form-control ml-3" name = "Edit_model">
                                            
                                    </div>

                                    <div class="form-group col-md-3 ml-4">
                                        <label for="inputState"> <i class="fas fa-cogs grey-text fa-2x"></i> Transmission</label>
                                        <select id="inputState" class="form-control ml-3" name="Edit_transmission">
                                            <option selected>Choose...</option>
                                            <option value="Auto">Auto</option>
                                            <option value="Manual">Manual</option>
                                            <option value="Tiptronic">Tiptronic</option>
                                        </select>
                                    </div>

                                    <div class="form-group col-md-3 ml-4">
                                        <label for="inputState"> <i class="fas fa-gas-pump grey-text fa-2x"></i> fuel type</label>
                                        <select id="inputState" class="form-control ml-3" name="Edit_fuel">
                                            <option selected>Choose...</option>
                                            <option value="1">Petrol</option>
                                            <option value="2">Diesel</option>
                                            <option value="3">Gasoline</option>
                                        </select>
                                    </div>
                                </div>

                                <h3 style="color: orange; font-weight: bold;"> Date & Time</h3>
                                <div class="row">
                                    
                                    <div class="md-form col-5 ml-4 mr-4">
                                        <i class="far fa-calendar-alt fa-2x grey-text"></i>
                                        <input placeholder="Selected date" type="date" id="date-picker" class="form-control" 
                                        value="<%=Appointment.getPrefDate() %>" name="Edit_date">
                                        
                                    </div>
                                    <div class="md-form col-5 ml-4 mr-4">
                                        <i class="far fa-clock fa-2x grey-text"></i>
                                        <input placeholder="Selected date" type="time" id="date-picker" class="form-control"
                                        value="<%=Appointment.getPrefTime() %>" name="Edit_time">
                                        
                                    </div>
                                </div>

                                <h3 style="color: orange; font-weight: bold;"> Payment Options</h3>
                                <div class="row">
                                    
                                    <div class="form-group col-md-6 ml-4">
                                        <label for="inputState"> <i class="fab fa-cc-amazon-pay grey-text fa-2x"></i> Your Payment Option</label>
                                        <select id="inputState" class="form-control ml-3" name="Edit_pay_option">
                                            <option selected>Pay by credit/debit card</option>
                                            <option value="1">Pay by PayPal</option>
                                            <option value="2">Pay by cash</option>
                                            <option value="3">Pay by cash</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="modal-footer">
                            		<button type="button" class="btn btn-secondary btn-sm" data-dismiss="modal">Close</button>
                            		<button type="submit" class="btn btn-primary btn-sm">Save changes</button>
                       	 		</div>
                                
                            </form>



                        </div>
                        
                    </div>
                </div>
            </div>
           <!--End of Edit Request Model -->


        <!--Start of modal Confirm Delete-->
        <div class="modal fade" id="ConfirmDelete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
            aria-hidden="true">
            <div class="modal-dialog modal-sm modal-notify modal-danger" role="document">
                <!--Content-->
                <div class="modal-content text-center">
                    <!--Header-->
                    <div class="modal-header d-flex justify-content-center">
                        <p class="heading">Are you sure?</p>
                    </div>
        
                    <!--Body-->
                    <div class="modal-body">
        
                        <i class="fas fa-times fa-4x animated rotateIn"></i>
        
                    </div>
        
                    <!--Footer-->
                    <div class="modal-footer flex-center">
                        <a href="" class="btn  btn-outline-danger">Yes</a>
                        <a type="button" class="btn  btn-danger waves-effect" data-dismiss="modal">No</a>
                    </div>
                </div>
                <!--/.Content-->
            </div>
        </div>
        <!--End of modal Confirm Delete-->


        <!-- Start of contact US -->
        <div class="modal fade" id="ContactUsModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
            aria-hidden="true">
            <div class="modal-dialog modal-notify modal-warning" role="document">
                <!--Content-->
                <div class="modal-content">
                    <!--Header-->
                    <div class="modal-header text-center">
                        <h4 class="modal-title white-text w-100 font-weight-bold py-2">Contact us</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true" class="white-text">&times;</span>
                        </button>
                    </div>
        
                    <!--Body-->
                    <form class="text-center border border-light p-5" action="#!">
                    
                        <!-- Name -->
                        <input type="text" id="defaultContactFormName" class="form-control mb-4" placeholder="Name">
                    
                        <!-- Email -->
                        <input type="email" id="defaultContactFormEmail" class="form-control mb-4" placeholder="E-mail">
                    
                        <!-- Subject -->
                        <label>Subject</label>
                        <select class="browser-default custom-select mb-4">
                            <option value="" disabled>Choose option</option>
                            <option value="1">Report a bug</option>
                            <option value="2">Feature request</option>
                            <option value="3">Feature request</option>
                            <option value="4" >Other</option>
                        </select>
                    
                        <!-- Message -->
                        <div class="form-group">
                            <textarea class="form-control rounded-0" id="exampleFormControlTextarea2" rows="3"
                                placeholder="Message"></textarea>
                        </div>
                    
                        <!-- Copy -->
                        <div class="custom-control custom-checkbox mb-4">
                            <input type="checkbox" class="custom-control-input" id="defaultContactFormCopy">
                            <label class="custom-control-label" for="defaultContactFormCopy">Send me a copy of this message</label>
                        </div>
                    
                    </form>
        
                    <!--Footer-->
                    <div class="modal-footer justify-content-center">
                        <a type="button" class="btn btn-outline-warning waves-effect">Send <i
                                class="fas fa-paper-plane-o ml-1"></i></a>
                    </div>
                </div>
                <!--/.Content-->
            </div>
        </div>
        <!-- End of contact US modal -->

        <!--Start of feedback Modal-->
        <div class="modal fade" id="FeedbackModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
            aria-hidden="true">
            <div class="modal-dialog modal-notify modal-success" role="document">
                <!--Content-->
                <div class="modal-content text-center">
                    <!--Header-->
                    <div class="modal-header d-flex justify-content-center">
                        <p class="heading">Feedback</p>
                    </div>
        
                    <!--Body-->
                    <div class="modal-body">
                        <h4 class="text-center mb-4">We would like your feedback to improve our services</h4>
                        <h5 class="text-center">What would your openion of our service ? </h5>
                        <div class="row d-flex justify-content-center text-center">
                            <div class="col-2">
                                <a onclick="setRating(1)"><i class="far fa-tired fa-3x"></i></a>
                                <p>Very Poor</p>
                            </div>
                            <div class="col-2">
                                <a onclick="setRating(2)"><i class="far fa-frown fa-3x"></i></a>
                                <p>Poor</p>
                            </div>
                            <div class="col-2">
                                <a onclick="setRating(3)"><i class="far fa-meh fa-3x"></i></a>
                                <p>Fair</p>
                            </div>
                            <div class="col-2">
                                <a onclick="setRating(4)"><i class="far fa-smile fa-3x"></i></a>
                                <p>Good</p>
                            </div>
                            <div class="col-2">
                                <a onclick="setRating(5)"><i class="far fa-laugh fa-3x"></i></a>
                                <p>Very Good</p>
                            </div>
                        </div>
                        <hr class="my-4">

                        <label>Please select your feedback category below</label>
                        <select class="browser-default custom-select mb-4">
                            <option value="" disabled>Choose option</option>
                            <option value="1">Suggestion</option>
                            <option value="2">Something is nor quite right</option>
                            <option value="3">Compliment</option>
                            <option value="4">Other</option>
                        </select>
                        <hr class="my-2">
                        <!-- Message -->
                        <label>Please leave your feedback below</label>
                        <div class="form-group">
                            <textarea class="form-control rounded-0" id="exampleFormControlTextarea2" rows="3" placeholder="Message"></textarea>
                        </div>
        
                    </div>
        
                    <!--Footer-->
                    <div class="modal-footer flex-center">
                        <a href="https://mdbootstrap.com/products/jquery-ui-kit/" class="btn btn-success">Yes</a>
                        <a type="button" class="btn btn-outline-success waves-effect" data-dismiss="modal">No</a>
                    </div>
                </div>
                <!--/.Content-->
            </div>
        </div>
        <!--End of feedback Modal-->



        </div>
        <!--End of Middle Part -->
    </div>
    <div class="section-2">
        <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-6 d-none d-md-block sec2-left">
                <img src="img/akila/wait.gif" alt="">
            </div>

            <div class="col-lg-6 col-md-6 col-sm-6 col-sm-12 col-xs-12 sec2-right">
                <h1 class="font-weight-bold">STOP WAITING....... <br> SCHEDULE AND GO</h1> <br>
                <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Dolor qui porro totam explicabo quam,
                    aspernatur maxime. Accusantium magnam vel fugit maxime magni, aspernatur ad adipisci dolor dolore
                    nisi! Eligendi, quod. Lorem ipsum dolor sit amet consectetur adipisicing elit. Incidunt nulla omnis
                    ex placeat, tenetur dolorum quia atque voluptates quasi neque explicabo voluptatibus ut eveniet
                    voluptatum iure culpa saepe vel. Culpa? Lorem ipsum dolor sit amet consectetur, adipisicing elit.
                    Molestiae laborum corporis delectus placeat cum quis beatae, nisi ab totam corrupti in architecto,
                    amet nesciunt dolorem quasi error harum perferendis porro.</p>
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
                            alt="Card image cap">
                        <a href="#!">
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
                            alt="Card image cap">
                        <a href="#!">
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
                            alt="Card image cap">
                        <a href="#!">
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
                            alt="Card image cap">
                        <a href="#!">
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


    <footer class="new_footer_area bg_color">
        <div class="new_footer_top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3 col-md-6">
                        <div class="f_widget company_widget wow fadeInLeft" data-wow-delay="0.2s"
                            style="visibility: visible; animation-delay: 0.2s; animation-name: fadeInLeft;">
                            <h3 class="f-title f_600 t_color f_size_18">Get in Touch</h3>
                            <p>Don’t miss any updates of our new templates and extensions.!</p>
                            <form action="#" class="f_subscribe_two mailchimp" method="post" novalidate="true"
                                _lpchecked="1">
                                <input type="text" name="EMAIL" class="form-control memail" placeholder="Email">
                                <button class="btn btn_get btn_get_two" type="submit">Subscribe</button>
                                <p class="mchimp-errmessage" style="display: none;"></p>
                                <p class="mchimp-sucmessage" style="display: none;"></p>
                            </form>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="f_widget about-widget pl_70 wow fadeInLeft" data-wow-delay="0.4s"
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
                        <div class="f_widget about-widget pl_70 wow fadeInLeft" data-wow-delay="0.6s"
                            style="visibility: visible; animation-delay: 0.6s; animation-name: fadeInLeft;">
                            <h3 class="f-title f_600 t_color f_size_18">Navigate to other pages</h3>
                            <ul class="list-unstyled f_list">
                                <li><a href="#">FAQ</a></li>
                                <li><a href="#">Login</a></li>
                                <li><a href="#">User Admin</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="f_widget social-widget pl_70 wow fadeInLeft" data-wow-delay="0.8s"
                            style="visibility: visible; animation-delay: 0.8s; animation-name: fadeInLeft;">
                            <h3 class="f-title f_600 t_color f_size_18">Social Media</h3>
                            <div class="f_social_icon">
                                <a href="#" class="fab fa-facebook"></a>
                                <a href="#" class="fab fa-twitter"></a>
                                <a href="#" class="fab fa-linkedin"></a>
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
                        <p class="mb-0 f_400">© CarCare System Solutions All rights reserved.</p>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!--end of the footer-->




    <!-- JQuery -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js">
    </script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.16.0/js/mdb.min.js">
    </script>
    <!--Mahen js-->
    <script src="js/Mahen/RequestDetailsFrontend.js"></script>
    <!--end of the Mahen js-->
</body>

</html>