
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%> 
    
    

<!DOCTYPE html>
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
    <link rel="stylesheet" href="css/akila/dashboard.css">
    <link rel="stylesheet" href="css/sandamali/swiper.min.css">
    <link rel="stylesheet" href="css/sandamali/packages-page.css">

    <title>HomePage</title>
</head>
<body>
	    <% 
			//this will check wether the user is logges or not by using the session variable
			
		String unameString = (String)session.getAttribute("regno");
		if(session.getAttribute("regno").equals(null)){
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		}
	%>
	

    <div class="section-1" id="section-1">
    
        <!--Navbar -->
        
        <nav class="mb-1 navbar navbar-expand-lg fixed-top  navbar-dark transparent lighten-1" style="box-shadow: none;font-weight: bolder; border: none;">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-555"
                aria-controls="navbarSupportedContent-555" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent-555">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active" style="background-color: transparent;">
                        <a class="nav-link" href="HomePageRedirectServlet">Home
                            <span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="UpdateUserDashboard">My profile</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="UpdatePaymentServlet">Make payment</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="inquiry.jsp">Make Inquiry</a>
                    </li>
                    <li class="nav-item">
                        <form action="LogoutServlet">
                        	<button class="nav-link" type="submit" style="background: transparent;border: none;font-weight: bolder;">Log out</button>
                        </form>
                    </li>
                    
                    <!-- Dropdown -->
                   
                </ul>
                
            </div>
        </nav>
        
        <!--/.Navbar -->

        <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-6 d-none d-md-block left">
                <h1>Welcome to <br><strong>CarCare </strong> Systems</h1>
                <p class="font-weight-lighter"> DRIVE SAFE | SERVIVE MORE</p>
            </div>

            <div class="col-lg-6 col-md-6 col-sm-6 col-sm-12 col-xs-12 right">
                <!-- Card -->
                <div class="card">
                
                
                    <!-- Card content -->
                    <div class="card-body">
                
                        <!-- Title -->
                        <h4 class="card-title" style="font-weight: bolder">We'll do the job. U just sit down and watch</h4>
                        <!-- Text -->
                        <p class="card-text">Make an appointment as your wish. We will cover up everything for you!!</p>

                    <a href="NewAppointmentServlet" class="btn btn-success">New Appointment</a>  <!-- this link will navigate to make a new appointment -->
                    <a href="userProfile.jsp" class="btn btn-info">My Appointments</a>
                        <!-- Button -->
                   
                
                    </div>
                
                </div>
                <!-- Card -->
            </div>
        </div>
    </div>

    <div class="section-2">
        <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-6 d-none d-md-block sec2-left">
                <img src="img/akila/wait.gif" alt="">
            </div>
            
            <div class="col-lg-6 col-md-6 col-sm-6 col-sm-12 col-xs-12 sec2-right">
                <h1 class="font-weight-bold">STOP WAITING....... <br> SCHEDULE AND GO</h1> <br>
                <p>Regular maintenance service is a key component to keeping your vehicle running and reliable. So we have put together service packages that give you the mechanic work you need all bundled up to save you money. Making sure your car is services will save you money in the long run, but take advantage of savings sooner.</p>
                <a href="#section-1" class="btn btn-success">Shedule an <strong>Apponitment</strong></a>
                <a href="#section-3" class="btn btn-danger">See the <strong>Packages</strong></a>
            </div>
        </div>
    </div>
    
    <div class="section-2" style="overflow: hidden;">
        <div class="row">
                        
            <div class="col-lg-6 col-md-6 col-sm-6 col-sm-12 col-xs-12 sec2-right">
                <h1 class="font-weight-bold">SHOP WITH TECHNOLOGY<br></h1> <br>
                <p>" We make it possible for anyone with drive <br>
																to operate a successful business! "</p>
                <a href="#section-1" class="btn btn-success">Purshase<strong> Items</strong></a>
            </div>
            
            <div class="col-lg-6 col-md-6 col-sm-6 d-none d-md-block sec2-left">
                <img src="img/akila/item.gif" alt="">
            </div>
        </div>
    </div>

	<div class="section-3" id="section-3">
		<div class="row">
			<div class="col" style="padding: 30px;">
				<h1>Packages Available</h1>
			</div>
		</div>

		<div class="container">
			<div class="swiper-container">
				<div class="swiper-wrapper">

				<!-- for each loop to display the available packages in the system -->

					<c:forEach items="${packageList}" var="ServicePackage">

						<div class="swiper-slide slide-color">
							<div class="card" style="width: 300px;">

								<!-- Card image -->
								<div class="view overlay">
									<img class="card-img-top"
										src="./img/sandamali/${ServicePackage.packImage}"
										alt="Card image cap"> <a href="#!">
										<div class="mask rgba-white-slight"></div>
									</a>
								</div>

								<!-- Card content -->
								<div class="card-body">

									<!-- Title -->
									<h4 class="card-title">${ServicePackage.packId}</h4>
									<!-- Text -->
									<p class="card-text">Package Details :</p>
									<ul>
										<li>${ServicePackage.packName}</li>
										<li>Price LKR : ${ServicePackage.price}0</li>
									</ul>
									<!-- Button -->
									<a href="PackageExplore?id=${ServicePackage.packId}"
										class="btn btn-primary">SCHEDULE</a>

								</div>

							</div>
						</div>

					</c:forEach>

				</div>
				<!-- Add Pagination -->
				<div class="swiper-pagination"></div>
			</div>

		</div>

	</div>

	<div class="section-3 section-4" id="section-3">
        <div class="row">
            <div class="col" style="padding: 30px;">
                <h1>Our Services</h1>
            </div>
        </div>
        <div class="row ">
            <div class="col-lg-12 flex">
    
                <!-- Card -->
                <div class="card" style="width: 300px;">
    
                    <!-- Card image -->
                    <div class="view overlay">
                        <img class="card-img-top"
                            src="img/akila/car-repair-2.jpg"
                            alt="Card image cap">
                        <a href="#!">
                            <div class="mask rgba-white-slight"></div>
                        </a>
                    </div>
    
                    <!-- Card content -->
                    <div class="card-body">
    
                        <!-- Title -->
                        <h4 class="card-title">vehicle Wash</h4>
                        <!-- Text -->
                        <p class="card-text">Service Details :</p>
                       
    
                    </div>
    
                </div>
                <!-- Card -->
    
            <!-- Card -->
            <div class="card" style="width: 300px;">
            
                <!-- Card image -->
                <div class="view overlay">
                    <img class="card-img-top" src="img/akila/car-repair-2.jpg" alt="Card image cap">
                    <a href="#!">
                        <div class="mask rgba-white-slight"></div>
                    </a>
                </div>
            
                <!-- Card content -->
                <div class="card-body">
            
                    <!-- Title -->
                    <h4 class="card-title">vehicle Wash</h4>
                    <!-- Text -->
                    <p class="card-text">Service Details :</p>
            
            
                </div>
            
            </div>
            <!-- Card -->
    
                <!-- Card -->
                <div class="card" style="width: 300px;">
                
                    <!-- Card image -->
                    <div class="view overlay">
                        <img class="card-img-top" src="img/akila/car-repair-2.jpg" alt="Card image cap">
                        <a href="#!">
                            <div class="mask rgba-white-slight"></div>
                        </a>
                    </div>
                
                    <!-- Card content -->
                    <div class="card-body">
                
                        <!-- Title -->
                        <h4 class="card-title">vehicle Wash</h4>
                        <!-- Text -->
                        <p class="card-text">Service Details :</p>
                
                
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
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.16.0/js/mdb.min.js"></script>
	<script src="js/sandamali/packages.js"></script>
	<script src="js/sandamali/swiper.min.js"></script>
	<script>
		var swiper = new Swiper('.swiper-container', {
			slidesPerView : 3,
			spaceBetween : 30,
			freeMode : true,
			pagination : {
				el : '.swiper-pagination',
				clickable : true,
			},
		});
	</script>
</body>

</html>