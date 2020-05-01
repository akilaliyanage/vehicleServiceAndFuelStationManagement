<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="img/akila/Reddy Roadster (1).png" type="image/x-iconx" />
    <!-- bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
       <link rel="stylesheet" href="css/akila/homepage.css">
    <link rel="stylesheet" href="css/akila/dashboard.css">
    <!-- end of the bootsrtap -->
    <title>Welcome</title>
</head>
<body style="overflow-x: hidden;">

	<nav class="navbar navbar-dark primary-color" style="background-color: #162447">
  <a class="navbar-brand" href="index.jsp">Login</a>
</nav>

    <div class="row">
        <div class="col-lg-6">
        <!-- Default form login -->
        <form class="text-center border border-light p-5" action="AdminLoginServlet" method="POST" style="margin-top: 100px;">
        
            <p class="h4 mb-4">Welcome to CarCare Systems</p>
        
            <!-- Email -->
            <input type="text"  name="username" class="form-control mb-4" placeholder="Username">
        
            <!-- Password -->
            <input type="password" id="defaultLoginFormPassword" name="password" class="form-control mb-4" placeholder="Password">
        
            <!-- Sign in button -->
            <button class="btn btn-info btn-block my-4" type="submit">Sign in</button>
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#fullHeightModalRight">
                Sign Up
            </button>
        
        
        </form>
        <!-- Default form login -->
        </div>

        <div class="col-lg-6" >
            <img src="img/akila/admin.gif" alt="" style="height: 100vh;">
        </div>
    </div>


    
    <!-- Full Height Modal Right -->
    <div class="modal fade right" id="fullHeightModalRight" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
        aria-hidden="true">
    
        <!-- Add class .modal-full-height and then add class .modal-right (or other classes from list above) to set a position to the modal -->
        <div class="modal-dialog modal-full-height modal-right" role="document">
    
    
            <div class="modal-content">
                <!-- Default form register -->
                <form class="text-center border border-light p-5" action="NewAdminServlet" method="post">
                
                    <p class="h4 mb-4">Admin Sign Up</p>
                
                    <div class="form-row mb-4">
                        <div class="col">
                            <!-- First name -->
                            <input type="text" name="adminname" id="defaultRegisterFormFirstName" class="form-control"
                                placeholder="Full Name">
                        </div>
                        <div class="col">
                            <!-- Last name -->
                            <input type="text" name="adminusername" id="defaultRegisterFormLastName" class="form-control"
                                placeholder="User Name">
                        </div>
                    </div>
                
                    <!-- E-mail -->
                    <input type="email" name="adminemail" id="defaultRegisterFormEmail" class="form-control mb-4" placeholder="E-mail">
                
                    <!-- Password -->
                    <input type="password" name="adminpass" id="defaultRegisterFormPassword" class="form-control" placeholder="Password"
                        aria-describedby="defaultRegisterFormPasswordHelpBlock">
                    <small id="defaultRegisterFormPasswordHelpBlock" class="form-text text-muted mb-4">
                        At least 8 characters and 1 digit
                    </small>
                
                    <!-- Phone number -->
                    <input type="text" name="adminphone" id="defaultRegisterPhonePassword" class="form-control"
                        placeholder="Phone number" aria-describedby="defaultRegisterFormPhoneHelpBlock">
                    <small id="defaultRegisterFormPhoneHelpBlock" class="form-text text-muted mb-4">
                        Optional!!
                    </small>
                
                
                    <!-- Phone number -->
                    <input type="text" name="adminsal" class="form-control" placeholder="Salary"
                        aria-describedby="defaultRegisterFormPhoneHelpBlock">
                    <small id="defaultRegisterFormPhoneHelpBlock" class="form-text text-muted mb-4">
                        Optional!!
                    </small>
                
                    <select class="browser-default custom-select form-control" name="admingender">
                        <option selected>Gender</option>
                        <option value="male">male</option>
                        <option value="female">female</option>
                    </select>
                
                
                    <!-- Sign up button -->
                    <button class="btn btn-info my-4 btn-block" type="submit">Sign in</button>
                
                
                
                    <hr>
                
                    <!-- Terms of service -->
                    <p>By clicking
                        <em>Sign up</em> you agree to our
                        <a href="" target="_blank">terms of service</a>
                
                </form>
                <!-- Default form register -->
            </div>
        </div>
    </div>
    <!-- Full Height Modal Right -->
    
      <jsp:include page="/WEB-INF/views/akila/footer.jsp"></jsp:include>
    
    



    <!--font awsome cdn-->
    <script src="https://kit.fontawesome.com/61a479e883.js" crossorigin="anonymous"></script>
    <!--end of the font awsone cdn-->
    
    <!-- bootstrap js -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
    <!--end of the bootstrap js -->
</body>
</html>