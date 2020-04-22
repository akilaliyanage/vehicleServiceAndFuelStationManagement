<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Service Packages</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/sandamali/bootstrap.min.css">
<link rel="stylesheet" href="css/sandamali/packages-page.css">
<link rel="stylesheet" href="css/sandamali/swiper.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lobster">
<script src="js/sandamali/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="js/sandamali/bootstrap.min.js"></script>
<style>
body {
	position: relative;
}
</style>
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50">

	<nav class="navbar navbar-expand-lg bg-dark navbar-dark fixed-top">
	<a class="navbar-brand" href="HomePageRedirectServlet">Home</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li id="b1" class="nav-item li-border">
				<button class="btn btn-outline-info my-2 my-sm-0" type="submit">Banner</button>
			</li>
			<li id="b2" class="nav-item li-border">
				<button class="btn btn-outline-info my-2 my-sm-0" type="submit">Package
					Details</button>
			</li>
			<li id="b3" class="nav-item li-border">
				<button class="btn btn-outline-info my-2 my-sm-0" type="submit">About
					Our Packages</button>
			</li>
			<li id="b4" class="nav-item li-border">
				<button class="btn btn-outline-info my-2 my-sm-0" type="submit">Package
					Types</button>
			</li>
		</ul>
		<form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>
	</div>
	</nav>

	<div id="section1" class="container-fluid div1"
		style="padding-top: 70px; padding-bottom: 70px">
		<div class="w3-container w3-lobster" style="margin-left: 30px">
			<h1 class="w3-xxxlarge"
				style="font-size: 50px; color: white; text-shadow: 2px 2px 4px #000000;">Automotive
				Service Packages</h1>
			<h1 style="color: white; text-shadow: 2px 2px 4px #000000;">${servicePackage.packName}</h1>
		</div>

		<div class="transbox">
			<button class="collapsible">Our Packages Will,</button>
			<div class="content">
				<p align="justify">Let Your Money And Your Car Go Farther.
					Regular maintenance service is a key component to keeping your
					vehicle running and reliable. So we have put together service
					packages that give you the mechanic work you need all bundled up to
					save you money.</p>
			</div>
		</div>



	</div>

	<div id="section2" class="container-fluid div2"
		style="padding-top: 50px; padding-bottom: 30px">
		<h1>Package Details</h1>

		<table class="table table-dark table-hover table-bordered tborder">
			<tbody>
				<tr>
					<td>Package ID</td>
					<td><c:out value="${servicePackage.packId}" /></td>
				</tr>
				<tr>
					<td>Package Name</td>
					<td><c:out value="${servicePackage.packName}" /></td>
				</tr>
				<tr>
					<td>Package Type</td>
					<td><c:out value="${servicePackage.packType}" /></td>
				</tr>
				<tr>
					<td>Package Price</td>
					<td>LKR <c:out value="${servicePackage.price}" />0
					</td>
				</tr>
				<tr>
					<td>Package Description</td>
					<td>
						<p align="justify">
							<c:out value="${servicePackage.packDescription}" />
						</p>
					</td>
				</tr>
			</tbody>
		</table>

	</div>

	<div id="section3" class="container-fluid bg-secondary"
		style="padding-top: 60px; padding-bottom: 60px">
		<h1>About Our Packages</h1>
		<div class="container">
			<div class="swiper-container">
				<div class="swiper-wrapper">

					<c:forEach items="${myList}" var="ServicePackage">

						<div class="swiper-slide slide-color">
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

	<div id="section4" class="container-fluid bg-info"
		style="padding-top: 60px; padding-bottom: 60px">
		<h1>Explore More Our Packages</h1>
		

	</div>


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