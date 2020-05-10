<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/sandamali/itemsPurchase-page.css"
	type="text/css" media="all">
<script src="js/sandamali/angular.js"></script>
<script src="js/sandamali/purchase-item-app.js"></script>
<script src="js/sandamali/jquery-3.1.1.js"></script>
<script src="js/sandamali/bootstrap.js"></script>
</head>
<body class="banner" ng-app="myModule" ng-controller="myController">
	<div>
		<div class="banner-layer">
			<h1 class="title-w3layouts">
				<span class="fa fa-2x fa-cart-arrow-down" aria-hidden="true"></span>DONALD
				SERVICE STATION </br>shopping cart
			</h1>
		</div>
		<div class="container div2">
		<div class="row">
			<button style="float:right" type="button" data-toggle="modal"
				data-target="#update_member" ng-click="selectMember(member)"
				class="btn btn-lg btn-primary">
				<span class="fa fa-lg fa-shopping-cart" aria-hidden="true"></span> View
				Cart
			</button></div>
			<div class="row" style="text-align: center">
				<p style="text-align: center">
				<div class="img-thumbnail div1" ng-repeat="member in members">
					<img class="img1" style="border: solid 1px; border-color: #98b8d4;"
						src="./img/sandamali/items/{{member.itemImage}}" alt="Cinque Terre">
					<ul class="info">
						<li style="font-size: 12px;font-family: Arial, Helvetica, sans-serif;">{{member.itemname}}</li>
						<li class="right-text">500 ml</li>

					</ul>
					<ul class="info">
						<li>{{member.price}}0</li>
						<li style="text-decoration: line-through;" class="right-text">$195.00</li>

					</ul>
					<form>
						<input type="hidden" name="cmd" value="_cart"> <input
							type="hidden" ng-model="item.id"> <input type="hidden"
							ng-model="item.name"> <input type="hidden"
							ng-model="item.price" value="25.00">
						<div class="row" style="margin-bottom: 10px">
							<div class="col-md-6">Qty.</div>
							<div class="col-md-6">
								<input id="{{member.itemId}}" style="width: 50px" type="text"
									ng-model="qty" />
							</div>
						</div>

						<button ng-click="addItem(member)" class="button w3l-cart"
							data-id="cart-4">add to cart</button>
					</form>
				</div>


				</p>
			</div>
		</div>
	</div>
	
	<!--View Cart Section-->
		<div class="modal fade" id="update_member" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form>
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title text-info" id="myModalLabel">Checkout
							Cart</h4>
					</div>
					<div class="modal-body">					
						
					<div class="container-fluid">
				<br /> <br />
				<table class="table table-dark table-hover table-bordered tborder">
					<thead>
						<tr>
							<th>Item ID</th>
							<th>Item Name</th>
							<th>Unit Price</th>
							<th>Qty</th>
							<th>Amount</th>
							<th>Total:<h1 style="color:green;font-size:24px">{{cartTot}}</h1></th> 
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="member in items">
							<td>{{member.itemId}}</td>
							<td>{{member.itemname}}</td>
							<td>{{member.price}}</td>
							<td>{{member.quantity}}</td>
							<td>{{member.totPrice}}</td>
						</tr>
					</tbody>
				</table>
			</div>
				

					</div>
					<div class="modal-footer">
						<button class="btn btn-success" data-dismiss="modal"
							ng-click="checkoutItems()">
							<span class="glyphicon glyphicon-edit"></span> Checkout
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!--End of View Cart Section-->
	
	<!-- Footer -->
	<footer class="page-footer font-small bg-dark"> <!-- Footer Links -->
	<div class="container text-center text-md-left mt-5">

		<!-- Grid row -->
		<div class="row mt-3">

			<!-- Grid column -->
			<div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">

				<!-- Content -->
				<h6 class="text-uppercase font-weight-bold">Company name</h6>
				<hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto"
					style="width: 60px;">
				<p align="justify">Regular maintenance service is a key
					component to keeping your vehicle running and reliable. So we have
					put together service packages that give you the mechanic work you
					need all bundled up to save you money. Making sure your car is
					services will save you money in the long run, but take advantage of
					savings sooner.</p>

			</div>
			<!-- Grid column -->

			<!-- Grid column -->
			<div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">

				<!-- Links -->
				<h6 class="text-uppercase font-weight-bold">Products</h6>
				<hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto"
					style="width: 60px;">
				<p>
					<a href="#!">Packages</a>
				</p>
				<p>
					<a href="#!">Services</a>
				</p>
				<p>
					<a href="#!">Petrolium</a>
				</p>
				<p>
					<a href="#!">Maintenance</a>
				</p>

			</div>
			<!-- Grid column -->


			<!-- Grid column -->
			<div class="col-md-3 mb-md-0 mb-4">

				<!-- Links -->
				<h6 class="text-uppercase font-weight-bold">Contact</h6>
				<hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto"
					style="width: 60px;">
				<p>
					<i class="fa fa-home mr-3"></i>10012, New Kandy Road, Malabe
				</p>
				<p>
					<i class="fa fa-envelope mr-3"></i> info@sliit.com
				</p>
				<p>
					<i class="fa fa-phone mr-3"></i> + 01 234 567 88
				</p>
				<p>
					<i class="fa fa-print mr-3"></i> + 01 234 567 89
				</p>

			</div>
			<!-- Grid column -->

			<!-- Grid column -->
			<div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-4">
				<img alt="" src="./img/sandamali/service.gif"
					style="width: 120%; border-radius: 50px;">

			</div>
			<!-- Grid column -->

		</div>
		<!-- Grid row -->

	</div>
	<!-- Footer Links --> <!-- Copyright -->
	<div style="color: white" class="footer-copyright text-center py-3">
		© 2020 Copyright: <a href="https://mdbootstrap.com/"> www.SLIIT.lk</a>
	</div>
	<!-- Copyright --> </footer>
	<!-- Footer -->
	<script>
		function alertme() {
			alert("Item picked");
		}
	</script>
</body>
</html>
