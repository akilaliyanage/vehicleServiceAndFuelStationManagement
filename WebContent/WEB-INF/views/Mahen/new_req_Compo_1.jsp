<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<div class="Act_new_req m-4">

		<div class="jumbotron">

			<div class="row row-cols-3 d-flex align-items-center">

				<div
					class="col-md-3 d-flex align-items-center justify-content-center">
					<img src="img/akila/big.jpg" class="img-circle">
				</div>
				<div class="col-md-3  text-left">
					<h3>
						<i class="fas fa-user-check"></i> <u> Stacy V. Pearson </u>
					</h3>
					<p class="mt-3">944 Meadow LaneOakland, CA 94612</p>
					<p class="mt-3" style="color: #4285F4">LeahRJoshi@dayrep.com</p>
				</div>
				<div class="col-md-6 text-right">
					<h3  >Appointment No</h3>
					<h4 style="color: gray;">AP004856</h4>
				</div>

			</div>

			<hr class="my-4">
			
			
			<div class="row row-cols-3">

				
				<div class="col-md-4 text-left border-right ">
					<h4 class="text-center">Request Details</h4>
					<hr class="my-4">
					<div class="requ_inf">
						<strong>Requested Service : </strong>
						<p class="text-right">Interior Detiling</p>
					</div>
					
					<div class="requ_inf">
						<strong>Vehicle NO : </strong>
						<p class="text-right">WP-AND-2251</p>
					</div>
					<div class="requ_inf">
						<strong>Total Amount : </strong>
						<p class="text-right">40152.00 Rs</p>
					</div>
					<div class="requ_inf">
						<strong>Service Date & Time : </strong>
						<p class="text-right">23 September 2020</p>
						<p class="text-right">14.00 to 15.00</p>
					</div>
					<div class="requ_inf">
						<strong>Mechanic : </strong>
						<p class="text-right">Not yet Assigned</p>
					</div>
				</div>
				
				<div class="col-md-7 text-right ml-4">
					<div class="alert alert-danger alert-dismissible fade show text-center"
						role="alert">
						<strong>Mechanics are not assigned to this job</strong> 
						<p>Please Assign a mechanic first.</p>
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<button type="button" class="btn btn btn-outline-primary btn-lg btn-block"><i class="fas fa-cogs"></i> Assign Mechanic</button>
					<form action="" class="border border-primary rounded p-4 mt-4 text-left">
						<div class="form-group ">
							<label><h3>Add Remarks</h3></label>
							<textarea class="form-control" rows="3"></textarea>
						</div>
						<div class="d-flex justify-content-end">
							<input type = "submit" value="Place Remark" class="btn btn-primary">
						</div>
						
					</form>
				</div>
				

			</div>

			<hr class="my-4">

			<div class="">
				<div class="row mt-4 d-flex justify-content-center">
					<button type="button" class="btn btn-success mr-4"><i class="fas fa-clipboard-check"></i> Accept Job Request</button>
					<button type="button" class="btn btn-warning mr-4"><i class="far fa-window-close"></i> Reject Job Request</button>
					<button type="button" class="btn btn-danger mr-4"><i class="far fa-trash-alt"></i> Delete Job Request</button>
					<button type="button" class="btn btn-secondary mr-4"><i class="fas fa-info-circle"></i> More Details</button>
				</div>
			</div>



		</div>

	</div>



</body>
</html>