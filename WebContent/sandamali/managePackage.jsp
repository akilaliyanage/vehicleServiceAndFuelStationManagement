<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Package Manager</title>
<link rel="stylesheet" href="css/sandamali/bootstrap.css">
<script src="js/sandamali/angular.js"></script>
<script src="js/sandamali/app.js"></script>
<script src="js/sandamali/jquery-3.1.1.js"></script>
<script src="js/sandamali/bootstrap.js"></script>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
	position: fixed;
	top: 0;
	width: 100%;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover:not (.active ) {
	background-color: #111;
}

.active {
	background-color: #4CAF50;
}
</style>
</head>
<body ng-app="myModule" ng-controller="myController">

<ul>
  <li><a href="dashboard.jsp">Home</a></li>
  <li><a href="#news">News</a></li>
  <li><a href="#contact">Contact</a></li>
  <li style="float:right"><a class="active" href="#about">About</a></li>
</ul>
<form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>
	<div class="row" style="margin-top: 70px">
		<div class="col-md-2"></div>
		<div class="col-md-8 well">
			<h3 class="text-primary">Package Manager</h3>
			<hr style="border-top: 1px dotted #000;" />
			<div class="alert alert-info">
				Create your new service packages here
				<button class="btn btn-sm btn-primary pull-right"
					data-toggle="modal" data-target="#add_member">
					<span class="glyphicon glyphicon-plus"> </span>
				</button>
			</div>
			<div class="container-fluid">
				<br /> <br />
				<table class="table table-dark table-hover table-bordered tborder">
					<thead>
						<tr>
							<th>Package ID</th>
							<th>Package Name</th>
							<th>Admin Reg No</th>
							<th>Package Type</th>
							<th>Price</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="member in members">
							<td>{{member.packId}}</td>
							<td>{{member.packName}}</td>
							<td>{{member.adminRegNo}}</td>
							<td>{{member.packType}}</td>
							<td>{{member.price}}</td>
							<td><button type="button" data-toggle="modal"
									data-target="#update_member" ng-click="selectMember(member)"
									class="btn btn-sm btn-warning">
									<span class="glyphicon glyphicon-edit"></span> Update
								</button> |
								<button type="button" data-toggle="modal"
									data-target="#delete_member" ng-click="selectMember(member)"
									class="btn btn-sm btn-danger">
									<span class="glyphicon glyphicon-trash"></span> Delete
								</button></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="modal fade" id="add_member" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form>
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title text-info" id="myModalLabel">Package
							Registration</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>Package ID</label> <input type="text" class="form-control"
								ng-model="newMember.packId" />
						</div>
						<div class="form-group">
							<label>Package Name</label> <input type="text" class="form-control"
								ng-model="newMember.packName" />
						</div>
						<div class="form-group">
							<label>Admin Reg No</label> <input type="text" class="form-control"
								ng-model="newMember.adminRegNo" />
						</div>
						<div class="form-group">
							<label>Package Type</label> <input type="text" class="form-control"
								ng-model="newMember.packType" />
						</div>
						<div class="form-group">
							<label>Package Price</label> <input type="text" class="form-control"
								ng-model="newMember.price" />
						</div>
						<div class="form-group">
							<label>Package Description</label> <input type="text" class="form-control"
								ng-model="newMember.packDescription" />
						</div>

					</div>
					<div class="modal-footer">
						<button class="btn btn-primary" ng-click="saveMember()"
							data-dismiss="modal">
							<span class="glyphicon glyphicon-save"></span> Save
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
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
						<h4 class="modal-title text-info" id="myModalLabel">Updating
							Package</h4>
					</div>
					<div class="modal-body">					
						
						<div class="form-group">
							<label>Package ID</label> <input type="text" class="form-control"
								ng-model="selectedMember.packId" />
						</div>
						<div class="form-group">
							<label>Package Name</label> <input type="text" class="form-control"
								ng-model="selectedMember.packName" />
						</div>
						<div class="form-group">
							<label>Admin Reg No</label> <input type="text" class="form-control"
								ng-model="selectedMember.adminRegNo" />
						</div>
						<div class="form-group">
							<label>Package Type</label> <input type="text" class="form-control"
								ng-model="selectedMember.packType" />
						</div>
						<div class="form-group">
							<label>Package Price</label> <input type="text" class="form-control"
								ng-model="selectedMember.price" />
						</div>
						<div class="form-group">
							<label>Package Description</label> <input type="text" class="form-control"
								ng-model="selectedMember.packDescription" />
						</div>

					</div>
					<div class="modal-footer">
						<button class="btn btn-success" data-dismiss="modal"
							ng-click="updateMember()">
							<span class="glyphicon glyphicon-edit"></span> Update
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="modal fade" id="delete_member" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form>
					<div class="modal-body">
						<center>
							<h4 class="text-danger">Are you sure you want to delete this
								record?</h4>
						</center>
					</div>
					<div class="modal-footer">
						<button class="btn btn-danger" data-dismiss="modal"
							ng-click="deleteMember()">
							<span class="glyphicon glyphicon-check"></span> Yes
						</button>
						<button class="btn btn-success" data-dismiss="modal">
							<span class="glyphicon glyphicon-remove"></span> No
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>