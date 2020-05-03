<!DOCTYPE html>
<html lang="en">
<head>
	<title>Inquity Page</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/akila/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/akila/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/akila/vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/akila/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/akila/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/akila/vendor/select2/select2.min.css">

<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/akila/util.css">
	<link rel="stylesheet" type="text/css" href="css/akila/main.css">
<!--===============================================================================================-->
</head>
<body style="overflow-x: hidden">


	   <div style="background-color: #222831;">
      <jsp:include page="\WEB-INF\views\akila\navbar.jsp"></jsp:include>
    </div>

	<div class="row">
		<div class="col-lg-6">
			
			<div class="container-contact100">
		<div class="wrap-contact100">
		
			<form class="contact100-form validate-form" action="InquiryServlet" method="post">
				<span class="contact100-form-title">
					Talk to a Human!
				</span>


				<div class="wrap-input100 input100-select">
					<span class="label-input100">Inquiry Type</span>
					<div>
						<select class="selection-2" name="type">
							<option>Select Type</option>
							<option>General Request</option>
							<option>Payments</option>
							<option>Bills</option>
							<option>Other</option>
						</select>
					</div>
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input" data-validate = "Message is required">
					<span class="label-input100">Message</span>
					<textarea class="input100" name="message" placeholder="Your message here..."></textarea>
					<span class="focus-input100"></span>
				</div>

				<div class="container-contact100-form-btn">
					<div class="wrap-contact100-form-btn">
						<div class="contact100-form-bgbtn"></div>
						<button class="contact100-form-btn">
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
		
		<div class="col-lg-6">
			<img alt="" src="img/shalini/inq.jpg" style="width: 100%;height: auto">
		</div>
		</div>
		
		


	<div id="dropDownSelect1"></div>

<!--===============================================================================================-->
	<script src="css/akila/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="css/akila/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="css/akila/vendor/bootstrap/js/popper.js"></script>
	<script src="css/akila/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="css/akila/vendor/select2/select2.min.js"></script>
	<script>
		$(".selection-2").select2({
			minimumResultsForSearch: 20,
			dropdownParent: $('#dropDownSelect1')
		});
	</script>
	<script src="js/akila/main.js"></script>


</body>
</html>
