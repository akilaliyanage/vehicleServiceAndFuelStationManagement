<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.model.NewMechModel"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/shalini/emp.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Google Fonts -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
<!-- Bootstrap core CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.16.0/css/mdb.min.css" rel="stylesheet">
    <title>Document</title>
</head>
<body>

	<% NewMechModel mech = (NewMechModel)request.getAttribute("mech"); %>
    
    
    <nav class="navbar navbar-dark primary-color">
       	<ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Login Page
        </a>
      </li>
    
    </ul>
    </nav>

    <div class="row main">
        <div class="col-lg-6 left">
            <img src="img/shalini/mech2.gif" alt="">
        </div>

        <div class="col-lg-6 right">

            

        <form class="text-center p-4" action="SaveMechDetailsServlet"  method="post" style="background-color: white; height: 100vh;">
            <h1>Welcome to <strong>CarCare</strong> Systems!</h1>
            <p class="h4 mb-4">Update your details</p>
        
            <div class="form-row mb-4">
                <div class="col">
                    <!-- First name -->
                    <input type="text" name="mechusername" value=<%=mech.getUsernameString() %> id="defaultRegisterFormFirstName" class="form-control"
                        placeholder="Username">
                </div>
                <div class="col">
                    <!-- Last name -->
                    <input type="password" name="mechpass" value="${mech.passwordString }" id="defaultRegisterFormLastName" class="form-control"
                        placeholder="Password">
                </div>
            </div>

            <div class="form-row mb-4">
                <div class="col">
                    <!-- First name -->
                    <input type="text" name="mechful" value="${mech.fullnameString }"  id="defaultRegisterFormFirstName" class="form-control"
                        placeholder="Full Name">
                </div>
                <div class="col">
                    <!-- Last name -->
                    <input type="text" name="mechemail" value="${mech.emailString }"  id="defaultRegisterFormLastName" class="form-control"
                        placeholder="Email">
                </div>
            </div>

            <div class="form-row mb-4">
                <div class="col">
                    <!-- First name -->
                    <input type="text" name="mechsal" value="${mech.sal }" id="defaultRegisterFormFirstName" class="form-control"
                        placeholder="Salary">
                </div>
                <div class="col">
                    <!-- Last name -->
                    <input type="text" name="mechspe" value="${mech.specString }" id="defaultRegisterFormLastName" class="form-control"
                        placeholder="Speciality">
                </div>
            </div>

            <div class="form-row mb-4">
                <div class="col">
                    <!-- First name -->
                    <input type="text" name="mechex" value="${mech.ex }" id="defaultRegisterFormFirstName" class="form-control"
                        placeholder="Experience">
                </div>
                <div class="col">
                    <!-- Last name -->
                    <input type="text" name="mechwork" value="${mech.wh }" id="defaultRegisterFormLastName" class="form-control"
                        placeholder="Working Hours">
                </div>
            </div>
        
            
        
            <!-- Phone number -->
            <input type="text" name="mechphone" id="defaultRegisterPhonePassword" value="${mech.phoneString }" class="form-control"
                placeholder="Phone number" aria-describedby="defaultRegisterFormPhoneHelpBlock">
            

    
            
        
            <select class="browser-default custom-select form-control my-4"  name="mechgender">
                <option selected>${mech.genderString }</option>
                <option value="male">male</option>
                <option value="female">female</option>
            </select>

           

            
        
            <!-- Sign up button -->
            <button class="btn btn-info my-4 btn-block" type="submit">Update Info</button>
        
        
        
            <hr>
        
           
        </form>
        <!-- Default form register -->
        </div>


        
        
        <!-- Modal -->
        <div class="modal fade" id="basicExampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
            aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                
               			 <form class="text-center p-4" action="NewMechServlet"  method="post">
            <h1>Welcome to <strong>CarCare</strong> Systems!</h1>
            <p class="h4 mb-4">Mechanic Sign Up</p>
        
            <div class="form-row mb-4">
                <div class="col">
                    <!-- First name -->
                    <input type="text" name="mechusername" id="defaultRegisterFormFirstName" class="form-control"
                        placeholder="Username">
                </div>
                <div class="col">
                    <!-- Last name -->
                    <input type="password" name="mechpass" id="defaultRegisterFormLastName" class="form-control"
                        placeholder="Password">
                </div>
            </div>

            <div class="form-row mb-4">
                <div class="col">
                    <!-- First name -->
                    <input type="text" name="mechful" id="defaultRegisterFormFirstName" class="form-control"
                        placeholder="Full Name">
                </div>
                <div class="col">
                    <!-- Last name -->
                    <input type="text" name="mechemail" id="defaultRegisterFormLastName" class="form-control"
                        placeholder="Email">
                </div>
            </div>

            <div class="form-row mb-4">
                <div class="col">
                    <!-- First name -->
                    <input type="text" name="mechsal" id="defaultRegisterFormFirstName" class="form-control"
                        placeholder="Salary">
                </div>
                <div class="col">
                    <!-- Last name -->
                    <input type="text" name="mechspe" id="defaultRegisterFormLastName" class="form-control"
                        placeholder="Speciality">
                </div>
            </div>

            <div class="form-row mb-4">
                <div class="col">
                    <!-- First name -->
                    <input type="text" name="mechex" id="defaultRegisterFormFirstName" class="form-control"
                        placeholder="Experience">
                </div>
                <div class="col">
                    <!-- Last name -->
                    <input type="text" name="mechwork" id="defaultRegisterFormLastName" class="form-control"
                        placeholder="Working Hours">
                </div>
            </div>
        
            
        
            <!-- Phone number -->
            <input type="text" name="mechphone" id="defaultRegisterPhonePassword" class="form-control"
                placeholder="Phone number" aria-describedby="defaultRegisterFormPhoneHelpBlock">
            

    
            
        
            <select class="browser-default custom-select form-control my-4" name="mechgender">
                <option selected>Gender</option>
                <option value="male">male</option>
                <option value="female">female</option>
            </select>

           

            
        
            <!-- Sign up button -->
            <button class="btn btn-info my-4 btn-block" type="submit">Sign in</button>
        
        
        
            <hr>
        
           
        </form>
                </div>
            </div>
        </div>

    </div>




<!-- JQuery -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript"
    src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.16.0/js/mdb.min.js"></script>

			<script type="text/javascript">
			var form = document.getElementById("mech");
			function handleForm(event) { event.preventDefault(); } 
			form.addEventListener('submit', handleForm);
			</script>
</body>
</html>