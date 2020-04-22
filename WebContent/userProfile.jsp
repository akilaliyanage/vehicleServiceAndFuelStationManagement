<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="img/akila/Reddy Roadster (1).png" type="image/x-icon"/>   
    <!-- bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <!-- end of the bootsrtap -->
    <!--userprofile css-->
    <link rel="stylesheet" href="css/akila/userProfile.css">
    <link rel="stylesheet" href="css/akila/main.css">
    <link rel="stylesheet" href="css/akila/dashboard.css">
    <link rel="stylesheet" href="css/akila/util.css">
    <link rel="stylesheet" href="css/akila/vendor/animate/animate.css">
    <link rel="stylesheet" href="css/akila/vendor/animsition/css/animsition.min.css">
    <link rel="stylesheet" href="css/akila/vendor/css-hamburgers/hamburgers.min.css">
    <link rel="stylesheet" href="css/akila/vendor/perfect-scrollbar/perfect-scrollbar.css">
    <link rel="stylesheet" href="css/akila/vendor/select2/select2.min.css">
    <link rel="stylesheet" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

      <!-- Font Awesome -->
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
  <!-- Google Fonts -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
  <!-- Bootstrap core CSS -->
 
  <!-- Material Design Bootstrap -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.16.0/css/mdb.min.css" rel="stylesheet">
    <title>Document</title>
</head>
<body>

			<!-- checks the session variable value -->
			  <% 
			
				String unameString = session.getAttribute("regno").toString();
				if(session.getAttribute("regno") == null){
					response.sendRedirect("index.jsp");
				}
				
				//gets the user details arrayList
				
			 ArrayList<String> details =(ArrayList)request.getAttribute("userDetails");
				
			%>
			<!-- end checks the session variable value -->
		

    <div class="card main-back">

        <nav class="navbar navbar-expand-lg navbar-dark indigo mb-4">
        
          <!-- Navbar brand -->
          <a class="navbar-brand" href="#">User Profile</a>
          
           <li class="nav-item">
                        <form action="LogoutServlet">
                        	<button class="nav-link navbar-brand" type="submit" style="background: transparent;border: none;font-weight: bolder;">Log out</button>
                        </form>
                    </li>
        
          <!-- Collapsible content -->
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
        
            <form class="form-inline ml-auto">
              <div class="md-form my-0">
                <input class="form-control" type="text" placeholder="Search" aria-label="Search">
              </div>
              <button href="#!" class="btn btn-outline-white btn-md my-0 ml-sm-2" type="submit">Search</button>
            </form>
        
          </div>
          <!-- Collapsible content -->
        
        </nav>

          <div class="row">

            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>Missig details!</strong> You profile is not fully configured. Please fill the required fields.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              
                           
              
              

            <div class="col-lg-4 col-md-4 col-sm-4 .d-none .d-sm-block left">

                
              <!-- Card Regular -->
              <div class="card card-cascade">
              
                <!-- Card image -->
                <div class="view view-cascade overlay">
                  <img class="card-img-top" src="https://mdbootstrap.com/img/Photos/Others/men.jpg" alt="Card image cap">
                  <a>
                    <div class="mask rgba-white-slight"></div>
                  </a>
                </div>
              
                <!-- Card content -->
                <div class="card-body card-body-cascade text-center">
              
                  <!-- Title -->
                  <h4 class="card-title"><strong><%out.println(details.get(4)); %></strong></h4>
                  <!-- Subtitle -->
                  <h6 class="font-weight-bold indigo-text py-2">Customer</h6>
                  <!-- Text -->
                  <p class="card-text"> <%out.println(details.get(6)); %>
                  </p>
              
                  <!-- Facebook -->
                  <a type="button" class="btn-floating btn-small btn-fb"><i class="fab fa-facebook-f"></i></a>
                  <!-- Twitter -->
                  <a type="button" class="btn-floating btn-small btn-tw"><i class="fab fa-twitter"></i></a>
                  <!-- Google + -->
                  <a type="button" class="btn-floating btn-small btn-dribbble"><i class="fab fa-dribbble"></i></a>
                  
                  
                  <ul class="list-group list-group-flush">
					  <li class="list-group-item">
					  	<div class="alert alert-success" role="alert">
  								Register Number : <%out.println(details.get(0)); %> <br>
  								<hr>
  								User Name : <%out.println(details.get(1)); %> <br>
  								<hr>
  								Phone Number : <%out.println(details.get(2)); %> <br>
  								<hr>
  								Email : <%out.println(details.get(3)); %> <br>
  								<hr>
  								Gender : <%out.println(details.get(5)); %>
						</div>
					  </li>
					  					  
				</ul>
              
                </div>
              
                <!-- Card footer -->
                <div class="card-footer text-muted text-center">
                <div class="alert alert-primary" role="alert">
                  <!-- Button trigger modal -->
                  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#fullHeightModalRight">
                    Update Profile
                  </button>
                </div>
                </div>
                
                 <div class="card-footer text-muted text-center">
                <div class="alert alert-primary" role="alert">
                  <!-- Button trigger modal -->
                  <form action="UploadPhotoServlet" method="post" enctype="multipart/form-data">
                  	<input type="file" name="file"/>
                  	<button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#fullHeightModalRight">
                    Upload Profile Photo
                  </button>
                  </form>
                </div>
                </div>
                
                

                <!-- Default form contact -->
                <form class="text-center border border-light p-5" action="" style="width: 100%;">
                
                  <p class="h4 mb-4">Send a feedback</p>
                
                  <!-- Name -->
                  <input type="text" id="defaultContactFormName" class="form-control mb-4" placeholder="Name">
                
                  <!-- Email -->
                  <input type="email" id="defaultContactFormEmail" class="form-control mb-4" placeholder="E-mail">
                
                  <!-- Subject -->
                  <label>Reason</label>
                  <select class="browser-default custom-select mb-4">
                    <option value="" disabled>Choose option</option>
                    <option value="1" selected>Feedback</option>
                    <option value="2">Report a bug</option>
                    <option value="3">Feature request</option>
                    <option value="4">Feature request</option>
                  </select>
                
                  <!-- Message -->
                  <div class="form-group">
                    <textarea class="form-control rounded-0" id="exampleFormControlTextarea2" rows="3" placeholder="Message"></textarea>
                  </div>
                
                 
                  <button class="btn btn-info btn-block" type="submit">Send</button>
                
                </form>
                <!-- Default form contact -->
              
              </div>


              
              

                <div class="details">

                      <!-- Full Height Modal Right -->
                      <div class="modal fade right" id="fullHeightModalRight" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                        aria-hidden="true">
                      
                        <!-- Add class .modal-full-height and then add class .modal-right (or other classes from list above) to set a position to the modal -->
                        <div class="modal-dialog modal-full-height modal-right" role="document">
                      
                      
                          <div class="modal-content" style="margin: 0; padding: 0;">
                            <div class="modal-header">
                              <h4 class="modal-title " id="myModalLabel">Add/Update Details</h4>
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                              </button>
                            </div>
                            <div class="modal-body">

                              <div class="container-contact100" style="padding: 0; margin: 0;">
                                <div class="wrap-contact100" style="padding: 0; margin-right: 0px;">
                                
                                  <form class="contact100-form validate-form" style="width: 350px;" action="UpdateUserServlet" method="post" enctype="multipart/form-data">
                                  
                                    <div class="wrap-input100 validate-input" data-validate="Name is required">
                                      <span class="label-input100">Your Name</span>
                                      <input class="input100" type="text" name="updateName" placeholder="Enter your name">
                                      <span class="focus-input100"></span>
                                    </div>
                              
                                                             
                                    <div class="wrap-input100 validate-input" data-validate="phone number is required">
                                      <span class="label-input100">Phone Number</span>
                                      <input class="input100" type="text" name="updatePhone" placeholder="Enter your phone number">
                                      <span class="focus-input100"></span>
                                    </div>
                              
                                                         
                              
                                    <div class="wrap-input100 input100-select">
                                      <span class="label-input100">Gender</span>
                                      <div>
                                        <select class="selection-2" name="updateGender">
                                          <option>Select Gender</option>
                                          <option value="male">Male</option>
                                          <option value="female">Female</option>
                                        </select>
                                      </div>
                                      <span class="focus-input100"></span>
                                    </div>
                                    
                                   <div class="wrap-input100 validate-input" data-validate="email is required">
                                      <span class="label-input100">Your Emil Address</span>
                                      <input class="input100" type="email" name="updateEmail" placeholder="Enter your email">
                                      <span class="focus-input100"></span>
                                    </div>
                                    
                                     <div class="wrap-input100 validate-input" data-validate="Username is required">
                                      <span class="label-input100">Enter your new username</span>
                                      <input class="input100" type="text" name="updateUsername" placeholder="Enter your user name" required="required">
                                      <span class="focus-input100"></span>
                                    </div>
                                    
                                     <div class="wrap-input100 validate-input" data-validate="password is required">
                                      <span class="label-input100">Your new password</span>
                                      <input class="input100" type="password" name="updatePassword" placeholder="Enter your password" required="required">
                                      <span class="focus-input100"></span>
                                    </div>
                                    
                                  
                                    <div class="wrap-input100 validate-input" data-validate="Message is required">
                                      <span class="label-input100">Profile Description</span>
                                      <textarea class="input100" name="updateMassege" placeholder="Enter your profile description here..."></textarea>
                                      <span class="focus-input100"></span>
                                    </div>
                              
                                    <div class="container-contact100-form-btn">
                                      <div class="wrap-contact100-form-btn">
                                        <div class="contact100-form-bgbtn"></div>
                                        <button class="contact100-form-btn" type="submit">
                                          <span>
                                            Submit
                                            <i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i>
                                          </span>
                                        </button>
                                      </div>
                                    </div>
                                  </form>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <!-- Full Height Modal Right -->

                      <div id="dropDownSelect1"></div>
                </div>
            </div>

            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12 right">
             
              <div>
                <div class="alert alert-success" role="alert">
                  Service / Fuel
                </div>
                <canvas id="lineChart"></canvas>
              </div>
                <div class="alert alert-warning" role="alert">
                 Payments
                </div>

                <div class="row">
                  <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="alert alert-info" role="alert">
                      Paid payments
                    </div>
                    <canvas id="doughnutChartpaid"></canvas>
                  </div>

                  <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="alert alert-info" role="alert">
                      Pending Payments
                    </div>
                      <canvas id="doughnutCharttotal"></canvas>
                  </div>
                </div>
              <div>

              </div>

              <div class="bill-table">
                <div class="alert alert-dark" role="alert">
                  Bill History
                </div>
                <!--Table-->
                <table id="tablePreview" class="table">
                  <!--Table head-->
                  <thead>
                    <tr>
                      <th>#</th>
                      <th>Bill ID</th>
                      <th>Date</th>
                      <th>Time</th>
                      <th>Amount Paid</th>
                      <th>Download</th>
                    </tr>
                  </thead>
                  <!--Table head-->
                  <!--Table body-->
                  <tbody>
                    <tr>
                      <th scope="row">1</th>
                      <td>bil001</td>
                      <td>2020/01/01</td>
                      <td>8.00AM</td>
                      <td>Rs. 10K</td>
                      <td><button type="button" class="btn btn-primary">PDF</button></td>
                    </tr>
                    <tr>
                      <th scope="row">1</th>
                      <td>bil001</td>
                      <td>2020/01/01</td>
                      <td>8.00AM</td>
                      <td>Rs. 10K</td>
                      <td><button type="button" class="btn btn-primary">PDF</button></td>
                    </tr>
                    <tr>
                      <th scope="row">1</th>
                      <td>bil001</td>
                      <td>2020/01/01</td>
                      <td>8.00AM</td>
                      <td>Rs. 10K</td>
                      <td><button type="button" class="btn btn-primary">PDF</button></td>
                    </tr>
                  </tbody>
                  <!--Table body-->
                </table>
                <!--Table-->
              </div>

             

            </div>
          </div> 

          <div class="row requests" id="section-4">
            <div class="col-lg-12">

              <!--my requests-->
              <div class="requests">
                <div class="alert alert-success" role="alert">
                  My Requests
                </div>
              </div>

              <!--request table-->

            <div class="table-responsive text-nowrap scroll">
            
              <table class="table">
                <thead>
                  <tr>
                    <th scope="col">#</th>
                    <th scope="col">Service Type</th>
                    <th scope="col">Sheduled Date</th>
                    <th scope="col">Location</th>
                    <th scope="col">Vehicle Number</th>
                    <th scope="col">Status</th>
                    <th scope="col">More Details</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <th scope="row">1</th>
                    <td>Vehicle Wash</td>
                    <td>2020-4-20</td>
                    <td>Malabe</td>
                    <td>SG GH 6558</td>
                    <td><span class="badge badge-danger">Rejected</span></td>
                    <td><a href="RequestDetailsFrontend.html" class="btn btn-dark">Full Details</a></td>
                  </tr>
                  <tr>
                    <th scope="row">1</th>
                    <td>Vehicle Wash</td>
                    <td>2020-4-20</td>
                    <td>Malabe</td>
                    <td>SG GH 6558</td>
                    <td><span class="badge badge-success">Approved</span></td>
                    <td><a href="RequestDetailsFrontend.html" class="btn btn-dark">Full Details</a></td>
                  </tr>
                  <tr>
                    <th scope="row">1</th>
                    <td>Vehicle Wash</td>
                    <td>2020-4-20</td>
                    <td>Malabe</td>
                    <td>SG GH 6558</td>
                    <td><span class="badge badge-warning">Pending</span></td>
                    <td><a href="RequestDetailsFrontend.html" class="btn btn-dark">Full Details</a></td>
                  </tr>
                </tbody>
              </table>
            
            </div>

            </div>
          </div>     
         
    </div>
    
    <jsp:include page="/WEB-INF/views/akila/footer.jsp"></jsp:include>
    

    
    	


    <!--bootstrap-->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="../WebContent/js/akila/main.js"></script>
    <script src="../WebContent/css/akila/vendor/select2/select2.min.js"></script>
    <script src="../WebContent/css/akila/vendor/animsition/js/animsition.min.js"></script>
      <!-- JQuery -->
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <!-- Bootstrap tooltips -->
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
  <!-- Bootstrap core JavaScript -->
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.min.js"></script>
  <!-- MDB core JavaScript -->
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.16.0/js/mdb.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  <!--custom js-->
  <script src="js/akila/userProfile.js"></script>
    <!--request table-->
    <script>
     $(document).ready(function () {
        $('#dtBasicExample').DataTable();
        $('.dataTables_length').addClass('bs-select');
      });
    </script>

    <!--line chart-->
      <script>
          //Servive and Fuel usage
        var ctxL = document.getElementById("lineChart").getContext('2d');
          var myLineChart = new Chart(ctxL, {
            type: 'line',
            data: {
              labels: ["January", "February", "March", "April", "May", "June", "July"],
              datasets: [{
                label: "Service",
                data: [65, 59, 80, 81, 56, 55, 40],
                backgroundColor: ['rgba(105, 0, 132, .2)',],
                borderColor: ['rgba(200, 99, 132, .7)',],
                borderWidth: 2
              },
              {
                label: "Fuel",
                data: [28, 48, 40, 19, 86, 27, 90],
                backgroundColor: ['rgba(0, 137, 132, .2)',],
                borderColor: ['rgba(0, 10, 130, .7)',],
                borderWidth: 2
              }
              ]
            },
            options: {
              responsive: true
            }
          });

      </script>



      <script>
        //paid payments details
          var ctxD = document.getElementById("doughnutChartpaid").getContext('2d');
          var myLineChart = new Chart(ctxD, {
            type: 'doughnut',
            data: {
              labels: ["Cash", "Credit", "Debit", "PayPal"],
              datasets: [{
                data: [300, 50, 100, 40],
                backgroundColor: ["#F7464A", "#46BFBD", "#FDB45C", "#949FB1", "#4D5360"],
                hoverBackgroundColor: ["#FF5A5E", "#5AD3D1", "#FFC870", "#A8B3C5", "#616774"]
              }]
            },
            options: {
              responsive: true
            }
          });
      </script>

      <script>
        //pending payents
          var ctxD = document.getElementById("doughnutCharttotal").getContext('2d');
          var myLineChart = new Chart(ctxD, {
            type: 'doughnut',
            data: {
              labels: ["Paid", "Remaining"],
              datasets: [{
                data: [300, 50],
                backgroundColor: ["#F7464A", "#46BFBD", "#FDB45C", "#949FB1", "#4D5360"],
                hoverBackgroundColor: ["#FF5A5E", "#5AD3D1", "#FFC870", "#A8B3C5", "#616774"]
              }]
            },
            options: {
              responsive: true
            }
          });
      </script>
    <!--end of the line chart-->
</body>
</html>