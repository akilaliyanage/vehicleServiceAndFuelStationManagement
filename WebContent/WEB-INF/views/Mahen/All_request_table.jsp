<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All requests</title>
</head>
<body>

	<div class="container m-4 ">
	
	<div class="alert alert-info mb-2 ml-4 col-12 " role="alert" style="width: 100% ; background-color: white;">
			
			<div class="row">
				<div class="col-5">
					<form class="form-inline my-2 my-lg-0">
						<input class="form-control mr-sm-2 border-primary search" type="search"
							placeholder="Search" aria-label="Search" />
						<button class="btn btn-outline-primary search-btn my-2 my-sm-0"
							type="submit">Search</button>
					</form>
				</div>
				<div class="col-7 d-flex justify-content-end">
					<a class="text-right d-flex align-self-end" id="csstesthide" href="#" onclick="ShowAdvance()" >
						<h5 style="color: #428bca">Advance Search</h5>
					</a>
				</div>
			</div>
			

		</div>
		
		<div class="alert alert-success mt-2 ml-4 advance_search_area" role="alert">
 			
 			<span style="color: #428bca ;font-style: italic; font-weight: bold;">Advanced Search</span>
            <div class="row row-cols-4 ">
            	<div class="col-md-4 d-flex justify-content-center">
            		<input type="text" placeholder="Name" class="serch_in Text_val">
            	</div>
            	
            	<div class="col-md-4 d-flex justify-content-center">
            		<input type="text" placeholder="Vehicle No" class="serch_in Text_val">
            	</div>
            	
            	<div class="col-md-4 d-flex justify-content-center">
            		<input type="text" placeholder="Mechanic" class="serch_in Text_val">
            	</div>
            	
            	
            	<div class="col-md-4 d-flex justify-content-center">
            		<select class="serch_in Sel_val">
            		<option value="null" disabled selected hidden>Choose a drink</option>
                    <option>ACCESSORIES</option>
                    <option>SUBJECT B</option>
                    <option>SUBJECT C</option>
                  </select>
            	</div>
            	
            	<div class="col-md-4 d-flex justify-content-center">
            		<select class="serch_in Sel_val">
            		<option value="null" disabled selected hidden>Choose Status</option>
                    <option>Pending</option>
                    <option>Approved</option>
                    <option>Active</option>
                    <option>Finished</option>
                    <option>Closed</option>
                  </select>
            	</div>
            	
            	<div class="col-md-4 d-flex justify-content-center">
            		
            		<input placeholder="Date" class="textbox-n serch_in Sel_val" type="text" onfocus="(this.type='date')" id="picker">
            	</div>
            	
            	
            	
            	<div class="col-md-12 d-flex justify-content-end mt-3">
            		<button type="button" class="btn btn-primary" style="margin-right: 20px ; width: 160px">Apply</button>
					<button type="button" class="btn btn-secondary" style="width: 160px">Delete</button>
            	</div>
            	
            	
            	
            </div>
 			
		</div>
<div id="testhide">
		<table class="table table-hover thead-dark ml-4"
			id="All_req_table">
			<thead>
				<tr>
					<th scope="col">Request No</th>
					<th scope="col">Customer name</th>
					<th scope="col">Vehicle No</th>
					<th scope="col">Service</th>
					<th scope="col">Date</th>
					<th scope="col">Time</th>
					<th scope="col">Mechanic</th>
					<th scope="col">Status</th>
					<th scope="col">Action</th>
					
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">1</th>
					<td>Mark</td>
					<td>Otto</td>
					<td>@mdo</td>
					<td>@mdo</td>
					<td>@mdo</td>
					<td>Otto</td>
					<td>@mdo</td>
					
					<td>
					
						
						<a href="newReq.jsp" class="btn btn-secondary" data-toggle="tooltip" data-placement="top" title="Edit">
							<i class="fas fa-edit"></i>
						</a>
					
						<button type="button" class="btn btn-danger" data-toggle="tooltip" data-placement="top" title="Tooltip on top">
							<i class="far fa-trash-alt"></i>
						</button>
					</td>
					
				</tr>
				<tr>
					<th scope="row">2</th>
					<td>Jacob</td>
					<td>Thornton</td>
					<td>@fat</td>
					<td>@mdo</td>
					<td>@mdo</td>
					<td>Otto</td>
					<td>@mdo</td>
					<td>
						<button type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="top" title="Edit">
							<i class="fas fa-edit"></i>
						</button>
					
						<button type="button" class="btn btn-danger" data-toggle="tooltip" data-placement="top" title="Tooltip on top">
							<i class="far fa-trash-alt"></i>
						</button>
					</td>
				</tr>
				<tr>
					<th scope="row">4</th>
					<td>Larry</td>
					<td>the Bird</td>
					<td>@twitter</td>
					<td>@mdo</td>
					<td>@mdo</td>
					<td>Otto</td>
					<td>@mdo</td>
					<td>
						<button type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="top" title="Edit">
							<i class="fas fa-edit"></i>
						</button>
					
						<button type="button" class="btn btn-danger" data-toggle="tooltip" data-placement="top" title="Tooltip on top">
							<i class="far fa-trash-alt"></i>
						</button>
					</td>
					
				</tr>
				<tr>
					<th scope="row">5</th>
					<td>Larry</td>
					<td>the Bird</td>
					<td>@twitter</td>
					<td>@mdo</td>
					<td>@mdo</td>
					<td>Otto</td>
					<td>@mdo</td>
					<td>
						<button type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="top" title="Edit">
							<i class="fas fa-edit"></i>
						</button>
					
						<button type="button" class="btn btn-danger" data-toggle="tooltip" data-placement="top" title="Tooltip on top">
							<i class="far fa-trash-alt"></i>
						</button>
					</td>
					
				</tr>
				<tr>
					<th scope="row">6</th>
					<td>Larry</td>
					<td>the Bird</td>
					<td>@twitter</td>
					<td>@mdo</td>
					<td>@mdo</td>
					<td>Otto</td>
					<td>@mdo</td>
					<td>
						<button type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="top" title="Edit">
							<i class="fas fa-edit"></i>
						</button>
					
						<button type="button" class="btn btn-danger" data-toggle="tooltip" data-placement="top" title="Tooltip on top">
							<i class="far fa-trash-alt"></i>
						</button>
					</td>
					
				</tr>
				<tr>
					<th scope="row">7</th>
					<td>Larry</td>
					<td>the Bird</td>
					<td>@twitter</td>
					<td>@mdo</td>
					<td>@mdo</td>
					<td>Otto</td>
					<td>@mdo</td>
					<td>
						<button type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="top" title="Edit">
							<i class="fas fa-edit"></i>
						</button>
					
						<button type="button" class="btn btn-danger" data-toggle="tooltip" data-placement="top" title="Tooltip on top">
							<i class="far fa-trash-alt"></i>
						</button>
					</td>
					
				</tr>
				<tr>
					<th scope="row">8</th>
					<td>Larry</td>
					<td>the Bird</td>
					<td>@twitter</td>
					<td>@mdo</td>
					<td>@mdo</td>
					<td>Otto</td>
					<td>@mdo</td>
					<td>
						<button type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="top" title="Edit">
							<i class="fas fa-edit"></i>
						</button>
					
						<button type="button" class="btn btn-danger" data-toggle="tooltip" data-placement="top" title="Tooltip on top">
							<i class="far fa-trash-alt"></i>
						</button>
					</td>
					
				</tr>
				<tr>
					<th scope="row">9</th>
					<td>Larry</td>
					<td>the Bird</td>
					<td>@twitter</td>
					<td>@mdo</td>
					<td>@mdo</td>
					<td>Otto</td>
					<td>@mdo</td>
					<td>
						<button type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="top" title="Edit">
							<i class="fas fa-edit"></i>
						</button>
					
						<button type="button" class="btn btn-danger" data-toggle="tooltip" data-placement="top" title="Tooltip on top">
							<i class="far fa-trash-alt"></i>
						</button>
					</td>
					
				</tr>
				<tr>
					<th scope="row">10</th>
					<td>Larry</td>
					<td>the Bird</td>
					<td>@twitter</td>
					<td>@mdo</td>
					<td>@mdo</td>
					<td>Otto</td>
					<td>@mdo</td>
					<td>
						<button type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="top" title="Edit">
							<i class="fas fa-edit"></i>
						</button>
					
						<button type="button" class="btn btn-danger" data-toggle="tooltip" data-placement="top" title="Tooltip on top">
							<i class="far fa-trash-alt"></i>
						</button>
					</td>
					
				</tr>
				<tr>
					<th scope="row">11</th>
					<td>Larry</td>
					<td>the Bird</td>
					<td>@twitter</td>
					<td>@mdo</td>
					<td>@mdo</td>
					<td>Otto</td>
					<td>@mdo</td>
					<td>
						<button type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="top" title="Edit">
							<i class="fas fa-edit"></i>
						</button>
					
						<button type="button" class="btn btn-danger" data-toggle="tooltip" data-placement="top" title="Tooltip on top">
							<i class="far fa-trash-alt"></i>
						</button>
					</td>
					
				</tr>
				<tr>
					<th scope="row">12</th>
					<td>Larry</td>
					<td>the Bird</td>
					<td>@twitter</td>
					<td>@mdo</td>
					<td>@mdo</td>
					<td>Otto</td>
					<td>@mdo</td>
					<td>
						<button type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="top" title="Edit">
							<i class="fas fa-edit"></i>
						</button>
					
						<button type="button" class="btn btn-danger" data-toggle="tooltip" data-placement="top" title="Tooltip on top">
							<i class="far fa-trash-alt"></i>
						</button>
					</td>
					
				</tr>
				<tr>
					<th scope="row">13</th>
					<td>Larry</td>
					<td>the Bird</td>
					<td>@twitter</td>
					<td>@mdo</td>
					<td>@mdo</td>
					<td>Otto</td>
					<td>@mdo</td>
					<td>
						<button type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="top" title="Edit">
							<i class="fas fa-edit"></i>
						</button>
					
						<button type="button" class="btn btn-danger" data-toggle="tooltip" data-placement="top" title="Tooltip on top">
							<i class="far fa-trash-alt"></i>
						</button>
					</td>
					
				</tr>
				<tr>
					<th scope="row">14</th>
					<td>Larry</td>
					<td>the Bird</td>
					<td>@twitter</td>
					<td>@mdo</td>
					<td>@mdo</td>
					<td>Otto</td>
					<td>@mdo</td>
					<td>
						<button type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="top" title="Edit">
							<i class="fas fa-edit"></i>
						</button>
					
						<button type="button" class="btn btn-danger" data-toggle="tooltip" data-placement="top" title="Tooltip on top">
							<i class="far fa-trash-alt"></i>
						</button>
					</td>
					
				</tr>
			</tbody>

		</table>
		</div>

	</div>



<script type="text/javascript">


$(document)
.ready(function () {
    $('#All_req_table').dataTable({
        "autoWidth": false,
        "lengthChange": false,
        "pageLength": 10,
        searching: false,
        
    });
});</script>







</body>
</html>