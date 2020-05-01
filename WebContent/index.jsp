<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%> 
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Welcome</title>
    <link
      rel="shortcut icon"
      href="img/akila/Reddy Roadster (1).png"
      type="image/x-iconx"
    />

    <!--akila's css-->
    <link rel="stylesheet" href="css/akila/index.css" />
    <link rel="stylesheet" href="css/akila/dashboard.css">
    <!--end of akila's css-->
    
    <!-- bootstrap -->
    	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <!-- end of the bootsrtap -->
  </head>
  <body>
  
  	<div class="alert alert-warning alert-dismissible fade show" role="alert" style="text-align: center;">
  <strong>WELCOME TO CarCare SYSTEMS!!!</strong> Log in if you are already a registered customer of JZT create a account below <br> <span style="text-align: center; font-weight: bolder;color: red;font-size: 20px"><c:out value="${error}"></c:out></span>
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
  
    <div class="back">
      <div class="slide fade">
        <img src="img/akila/agustin-segura-eDXRq-2LfNM-unsplash.jpg" alt="">
      </div>
      <div class="slide fade">
        <img src="img/akila/alex-holyoake-Sc42XrdQlSc-unsplash.jpg" alt="">
      </div>
      <div class="slide fade">
        <img src="img/akila/alex-holyoake-zsRFoL7Cjvg-unsplash.jpg" alt="">
      </div>
      <div class="slide fade">
        <img src="img/akila/jonathan-gallegos-Up4VB9_T9BA-unsplash.jpg" alt="">
        <img src="img/akila/agustin-segura-eDXRq-2LfNM-unsplash.jpg" alt="" />
      </div>
      <div class="slide fade">
        <img src="img/akila/alex-holyoake-Sc42XrdQlSc-unsplash.jpg" alt="" />
      </div>
      <div class="slide fade">
        <img src="img/akila/alex-holyoake-zsRFoL7Cjvg-unsplash.jpg" alt="" />
      </div>
      <div class="slide fade">
        <img
          src="img/akila/jonathan-gallegos-Up4VB9_T9BA-unsplash.jpg"
          alt=""
        />
      </div>
    </div>
    <div>
      <div class="back-container" id="back-container">
        <div class="form-container sign-up">
          <form action="NewUserServlet" onsubmit="check()" method="post">
            <h1>Create Account</h1>
            <div class="social-links">
              <a href=""><i class="fab fa-facebook"></i></a>
              <a href=""><i class="fab fa-twitter-square"></i></a>
              <a href=""><i class="fab fa-linkedin"></i></a>
            </div>
            <span>Or, just enter your Email/Username and password</span>
            <input
              type="text"
              name="signusername"
              class="username"
              id="username"
              placeholder="Username"
            />
            <input
              type="text"
              name="signemail"
              class="email"
              placeholder="Email"
            />
            <input type="password" name="signpass" id="pass" placeholder="Password"/>
            <button>Sign Up</button>
          </form>
        </div>
        <div class="form-container sign-in">
          <form action="" method="post">
              
            <input
              type="password"
              name="pass"
              id="passNew"
              placeholder="Password"
            />
            <button type="submit">Sign Up</button>
          </form>
        </div>
        <div class="form-container sign-in">
          <form action="LoginServlet" onsubmit="login()" method="post">
            <h1>Sign In</h1>
            <div class="social-links">
              <a href=""><i class="fab fa-facebook"></i></a>
              <a href=""><i class="fab fa-twitter-square"></i></a>
              <a href=""><i class="fab fa-linkedin"></i></a>
            </div>
            <span>Or, just use your account</span>
            <input
              type="text"
              name="loginemail"
              class="email"
              placeholder="Email or Username"
            />
            
            <input
              type="password"
              name="loginpassword"
              class="email"
              placeholder="Enter your password"
            />
      
            <button type="submit" value="signin" name="signin">Sign In</button>
            <a href="adminLogin.jsp" class="btn btn-danger" style="margin-top: 10px">Admin Login</a>
            <a href="addEmp.jsp" class="btn btn-danger" style="margin-top: 10px">Mechanic Login</a>
          </form>
        </div>
        <div class="overlay-container">
          <div class="overlay">
            <div class="overlay-panel left-panel">
              <h1>welcome to CarCare managemnt system.</h1>
              <p>
                Please enter your account credentials to log in to the system.
              </p>
              <button id="signIn" class="ghost">Sign In</button>
            </div>
  

            <div class="overlay-panel right-panel">
              <h1>Drive your car with Care.</h1>
              <p>Sign up and feel the control!!</p>
              <button id="signUp" class="ghost">Sign Up</button>
            </div>
          </div>
        </div>
      </div>
    </div>


   

    <!--akila's js-->
    <script src="js/akila/index.js"></script>
    <!--end of akila's js-->

    <!--font awsome cdn-->
    <script
      src="https://kit.fontawesome.com/61a479e883.js"
      crossorigin="anonymous"
    ></script>
    <!--end of the font awsone cdn-->
    
    <!-- bootstrap js -->
    	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<!--end of the bootstrap js -->
  </body>
</html>
