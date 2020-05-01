<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%> 

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
  <title>Payment</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
  <link rel="stylesheet" href="css/shalini/payment.css">
  <link rel="stylesheet" href="css/akila/dashboard.css" />
   <link rel="stylesheet" href="css/akila/homepage.css" />
</head>
<body>

	 <div style="background-color: #142850">
	 	 <!--Navbar -->
        <nav class="mb-1 navbar navbar-expand-lg navbar-dark transparent lighten-1" style="box-shadow: none;font-weight: bolder; border: none;">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-555"
                aria-controls="navbarSupportedContent-555" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent-555">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
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
                        <form action="LogoutServlet">
                        	<button class="nav-link" type="submit" style="background: transparent;border: none;font-weight: bolder;">Log out</button>
                        </form>
                    </li>
                    <!-- Dropdown -->
                   
                </ul>
                <ul class="navbar-nav ml-auto nav-flex-icons">
                    <li class="nav-item avatar">
                        <a class="nav-link p-0" href="userProfile.jsp">
                            <img src="https://mdbootstrap.com/img/Photos/Avatars/avatar-5.jpg" class="rounded-circle z-depth-0"
                                alt="avatar image" height="35">
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
        <!--/.Navbar -->
	 </div>
   

    <div class="row">
        <div class="col-lg-6">
            <main class="page payment-page">
                <section class="payment-form dark">
                    <div class="container">
                       
                       
                         <h3 class="products title">Checkout</h3>
                            <div class="products" style="overflow-y: scroll;height: 200px">
                                                               
                                <c:forEach items="${info}" var="obj">
                                	
                                	<div class="item" name="listForm">
                                    <span class="price">Rs.${obj.total }</span>
                                    <p class="item-name">${obj.idString }</p>
                                   		<!-- Default unchecked -->
										<div class="custom-control custom-checkbox">
										    <input type="checkbox" name="choice" class="custom-control-input" id="${obj.idString }" value="${obj.total }" onclick="update('${obj.idString}')" onchange="checkTotal(this)">
										    <label class="custom-control-label" for="${obj.idString }">Add to payment</label>
										</div>
                                </div>
                                	
                                </c:forEach>
                                
                                
                            </div>
                            <div class="products total">Total<span class="price"><div id="total"></div></span></div>
                            <form action="PaymentServlet" method="post">
                            <div class="card-details">
                            	
                                <h3 class="title">Payment Details</h3>
                               	
                               
                               		 <div class="row">
                                    <div class="form-group col-sm-7">
                                        <label for="card-holder">ID</label>
                                        <input  name="id" id ="id" type="text" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1">
                                    </div>
                                    
                                     <div class="form-group col-sm-7">
                                        <label for="card-holder">Total Amount</label>
                                        <input  name="tot" id ="sum" type="text" class="form-control" aria-label="Card Holder" aria-describedby="basic-addon1">
                                    </div>
                                   
                                   
                                   
                                    <div class="form-group col-sm-12">
                                        <button type="submit" class="btn btn-primary btn-block">Pay</button>
                                    </div>
                                </div>
                              
                               	
                            </div>
						</form>
                    </div>
                </section>
            </main>
        </div>

        <div class="col-lg-6 right">
        	<h1 style="margin-top: 50px">Welcome to <strong>CarCare</strong> payemnt gateway </h1>
            <img class="img" src="img/shalini/pay.gif" alt="">
        </div>
    </div>
    
      <jsp:include page="/WEB-INF/views/akila/footer.jsp"></jsp:include>
    
    
    		<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
			<script type="text/javascript">
			
			var total = 0;
			function CalculateTotal(){
			    $("input:checkbox").each(function(){
			        if($(this).is(":checked")){
			            total += parseFloat($(this).val());	
			            }
			    });
			    $("#total").html(total);
			    document.getElementById("sum").value = total;
			   
			   
			}

			$("input:checkbox").change(function(){
			    total = 0;
			    CalculateTotal();
			}).trigger("change");	
			
			
			
			function edValueKeyPress() {
			    var edValue = document.getElementById("sum");
			    var s = edValue.value;

			    var pay = document.getElementById("pay").value;
			    var rem = s - pay;
			    
			    if(rem < 0){
			    	alert("Sorry!!, You cant pay beyond the total limit");
			    	document.getElementById("pay").value = null;
			    	 document.getElementById("remm").value = null;
			    }
			    else{
			    	 document.getElementById("remm").value = rem;
			    }
			    
			   

			    //var s = $("#edValue").val();
			    //$("#lblValue").text(s);    
			}
			
			function update(x) {
				 document.getElementById("id").value = x;
			}
				
				
			</script>
</body>
</html>