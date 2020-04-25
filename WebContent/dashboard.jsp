<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%> 
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!--bootstrap-->
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
      crossorigin="anonymous"
    />
    <!-- <link href="css/bootstrap-dropdownhover.min.css" rel="stylesheet" /> -->
    <!--end of the bootstrap-->

    <!--akila css-->
    <link rel="stylesheet" href="css/akila/dashboard.css" />
    <!--end of the akila css-->
    <title>Admin</title>
  </head>
  <body>
  
    <nav class="navbar menu sticky-top navbar-expand-lg navbar-light bg-light" id="mynav">
      <button
        class="navbar-toggler"
        type="button"
        data-toggle="collapse"
        data-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item dropdown">
            <a
              class="nav-link"
              href="#"
              id="navbarDropdown"
              role="button"
              data-toggle="dropdown"
              aria-haspopup="true"
              aria-expanded="false"
            >
              <img src="img/akila/profile_user.jpg" class="profile" alt="" />
            </a>
            <div
              class="dropdown-menu shadow line-height"
              aria-labelledby="navbarDropdown"
            >
              <h4 class="dropdown-header">
                <i class="fas fa-user-shield"></i>
                <strong>M.L.Akila Liyanage - <span>ADMINISTRATOR</span></strong>
              </h4>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="#"
                ><i class="far fa-envelope-open"></i> Incomming Mail</a
              >
              <a class="dropdown-item" href="#"
                ><i class="fas fa-id-card-alt"></i> Profile Details</a
              >
              <a class="dropdown-item" href="#"
                ><i class="far fa-money-bill-alt"></i> Billing Status</a
              >
              <a class="dropdown-item" href="#"
                ><i class="fas fa-bullhorn"></i> Notifications
                <span class="badge badge-danger">1</span></a
              >
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="#">Log Out</a>
            </div>
          </li>

          <li class="nav-item dropdown">
            <a
              class="nav-link"
              href="#"
              id="navbarDropdown"
              role="button"
              data-toggle="dropdown"
              aria-haspopup="true"
              aria-expanded="false"
            >
              <img
                src="img/akila/message-1767998.png"
                class="icons"
                alt=""
              /><span class="badge badge-danger">1</span>
            </a>
            <div class="dropdown-menu shadow" aria-labelledby="navbarDropdown">
              <h4 class="dropdown-header">Latest Notifications</h4>
              <a class="dropdown-item" href="#">
                <div
                  class="alert alert-danger alert-dismissible fade show"
                  role="alert"
                >
                  <strong>Test user 1</strong> This is a test notification
                  <button
                    type="button"
                    class="close"
                    data-dismiss="alert"
                    aria-label="Close"
                  >
                    <span aria-hidden="true">&times;</span>
                  </button>
                </div>
              </a>

              <div class="dropdown-divider"></div>

              <h4 class="dropdown-header">Older Notifications</h4>

              <a class="dropdown-item" href="#">
                <div
                  class="alert alert-success alert-dismissible fade show"
                  role="alert"
                >
                  <strong>Test user 1</strong> This is a test notification
                  <button
                    type="button"
                    class="close"
                    data-dismiss="alert"
                    aria-label="Close"
                  >
                    <span aria-hidden="true">&times;</span>
                  </button>
                </div>
              </a>
              <a class="dropdown-item" href="#">
                <div
                  class="alert alert-success alert-dismissible fade show"
                  role="alert"
                >
                  <strong>Test user 1</strong> This is a test notification
                  <button
                    type="button"
                    class="close"
                    data-dismiss="alert"
                    aria-label="Close"
                  >
                    <span aria-hidden="true">&times;</span>
                  </button>
                </div>
              </a>
            </div>
          </li>

          <li class="nav-item dropdown">
            <a
              class="nav-link"
              href="#"
              id="navbarDropdown"
              role="button"
              data-toggle="dropdown"
              aria-haspopup="true"
              aria-expanded="false"
            >
              <img
                src="img/akila/setting-1820017.png"
                class="icons"
                alt=""
              /><span class="badge badge-danger">1</span>
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="#">Action</a>
              <a class="dropdown-item" href="#">Another action</a>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="#">Something else here</a>
            </div>
          </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
          <input
            class="form-control mr-sm-2 search"
            type="search"
            placeholder="Search"
            aria-label="Search"
          />
          <button
            class="btn btn-outline-success search-btn my-2 my-sm-0"
            type="submit"
          >
            Search
          </button>
        </form>
      </div>
    </nav>

    <!--welcome alert-->
    <div
      class="alert alert-warning alert-dismissible fade show welcome"
      role="alert" style="border-bottom: #8e8e8e solid 1px;;"
    >
      <strong>WELCOME ONBOARD!</strong> Welcome to the
      <strong>CarCare</strong> admin panel. Feel free to scroll up and down.
      <button
        type="button"
        class="close"
        data-dismiss="alert"
        aria-label="Close"
      >
        <span aria-hidden="true">&times;</span>
      </button>
    </div>
    <!-- end of the welcome alert-->

    <!--breadcrumb-->
    <nav aria-label="breadcrumb" style="border-bottom: #8e8e8e solid 1px;;">
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="#">Login</a></li>
        <li class="breadcrumb-item active" aria-current="page">Admin</li>
      </ol>
    </nav>
    <!--end of the breadcrumb-->

    <!--body part-->

    <div class="row row row-cols-2">
      <!--sidebar-->
      <div class="col-2 sidebar">
        <div id="container"><h1 class="style-3">ADMIN PANEL</h1></div>

        <h6 class="dropdown-header">Vehicle Service Center</h6>

        <a href="All_request.jsp" class="btn btn-light"
          ><i class="fas fa-flag-checkered"></i>&nbsp;&nbsp; Pending Requests</a
        >
        <a href="reports.html" class="btn btn-light"
          ><i class="fas fa-file-word"></i>&nbsp;&nbsp; Reports</a
        >
        <a href="" class="btn btn-light"
          ><i class="fas fa-reply"></i>&nbsp;&nbsp; User Feedback</a
        >
        <a href="PackageManagerServlet" class="btn btn-light"
          ><i class="fas fa-box"></i>&nbsp;&nbsp; Packages</a
        >
        <a href="" class="btn btn-light"
          ><i class="fas fa-receipt"></i>&nbsp;&nbsp; Bill</a
        >

        <h6 class="dropdown-header">Fuel Station</h6>

        <a href="" class="btn btn-light"
          ><i class="fas fa-briefcase"></i>&nbsp;&nbsp; Employees</a
        >
        <a href="" class="btn btn-light"
          ><i class="fas fa-parachute-box"></i>&nbsp;&nbsp; Suppliers</a
        >
        <a href="" class="btn btn-light"
          ><i class="fas fa-thermometer-quarter"></i>&nbsp;&nbsp; Status</a
        >
      </div>
      <!--end of the side bar-->

      <!--middle part-->
      <div class="col-7 middle" style="border-right: #8e8e8e solid 1px;;">
        <div class="alert alert-primary requests" role="alert">
          <i class="fas fa-flag-checkered"></i
          ><span> &nbsp;&nbsp;&nbsp;</span> Pending Requests by The Customers &nbsp;&nbsp;&nbsp;
          <div class="filter">
            <select id="day">
              <option value="volvo">Today</option>
              <option value="volvo">Yesterday</option>
            </select>
          </div>
        </div>

        <div class="row" style="margin: 0;overflow-x: hidden;">
          <div class="col pending" style="margin: 0;padding: 0;height: 500px;">
          
           <c:forEach items="${userRequests}" var="obj">
           
            <div class="card shadow force-overflow" style="height: auto;">
              <img src="img/userImages/${obj.userimageString }" style="height: 200px; object-fit: cover;" class="card-img-top" alt="${obj.userimageString}" />
              <div class="card-body">
                <h5 class="card-title">${obj.usernameString }</h5>
                <ul class="list-group">
				  <li class="list-group-item">Service Name : ${obj.servicenameString }</li>
				  <li class="list-group-item">Location : ${obj.locationString }</li>
				  <li class="list-group-item">Appointment ID : ${obj.appidString }</li>
				  <li class="list-group-item">
  								<div class="alert alert-warning" role="alert">
								 Status : ${obj.statuString }
								</div>
					</li>
				</ul>
				</div>
            </div>
           
           
           </c:forEach>

          </div>
        </div>

        <div class="alert alert-secondary requests sales" role="alert">
          <i class="fas fa-balance-scale-right"></i
          ><span> &nbsp;&nbsp;&nbsp;</span> Sales Dashboard &nbsp;&nbsp;&nbsp;
        </div>

        <div class="row">
          <div class="col sales-dashboard">
            <div class="card shadow bg-success">
              <div class="card-body">
                <h5 class="card-title pop">
                  <i class="fas fa-user"></i>&nbsp;&nbsp;Total Customers
                </h5>
                <h6 class="card-subtitle mb-2 card-text pop"><c:out value="${totCustomers }"></c:out></h6>
              </div>
            </div>

            <div class="card shadow bg-warning">
              <div class="card-body">
                <h5 class="card-title pop">
                  <i class="fas fa-dollar-sign"></i>&nbsp;&nbsp;Gross Profit
                </h5>
                <h6 class="card-subtitle mb-2 card-text pop">${paid}</h6>
              </div>
            </div>

            <div class="card shadow bg-secondary">
              <div class="card-body">
                <h5 class="card-title pop">
                  <i class="fas fa-exchange-alt"></i>&nbsp;&nbsp;Total Requests
                </h5>
                <h6 class="card-subtitle mb-2 card-text pop">${apps}</h6>
              </div>
            </div>
          </div>
        </div>

        <div class="row graph">
          <div class="col col-lg-6 col-md-6 col-sm-12">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Customers</h5>

               			<canvas id="user"></canvas>
              </div>
            </div>
          </div>

          <div class="col col-lg-6 col-md-6 col-sm-12 ">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Gross Profit</h5>


                <canvas id="income" style="margin: 10px;"></canvas>
              </div>
            </div>
          </div>

          <div class="col col-lg-12 col-md-12 col-sm-12">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Total Requests</h5>
                
                <canvas id="req"></canvas>
              </div>
            </div>
          </div>
        </div>

        <div class="alert alert-success requests sales" role="alert">
          <i class="fab fa-paypal"></i><span> &nbsp;&nbsp;&nbsp;</span> Payments
          <!-- <div class="filter">
            <select id="day">
              <option value="volvo">Today</option>
              <option value="volvo">Yesterday</option>
            </select>
          </div> -->
        </div>

        <div class="row sales-main">
          <div class="col col-lg-12 col-md-12 col-sm-12">
            <div class="card scrollbar" id="style-1" style="overflow-y: scroll; height: 500px;">
              <div class="card-body force-overflow">
                <h5 class="card-title">Top Sales</h5>
                <button type="button" class="btn btn-success">See all</button>
                <table>
                  <tr>
                    <th>Payment ID</th>
                    <th>User Name</th>
                    <th>Amount</th>
                    <th>Date</th>
                     <th>Paid</th>
                      <th>Pending</th>
                       <th>Appointment ID</th>
                  </tr>
                  
                  <c:forEach items="${pay }" var="rows">
                  
                  <tr>
                   <td><h5>${rows.paymentidString }</h5></td>
                   <td><h5>${rows.usernameString }</h5></td>
                   <td><h5>${rows.amount }</h5></td>
                   <td><h5>${rows.dateString }</h5></td>
                   <td><h5>${rows.paid }</h5></td>
                   <td><h5>${rows.pending }</h5></td>
                   <td><h5>${rows.appidString }</h5></td>
                  </tr>
                  
                  
                  </c:forEach>

                 

                 
                </table>
              </div>
            </div>
          </div>


        </div>

        <!--reports section-->
        <div class="alert alert-warning requests sales" role="alert">
          <i class="fas fa-file-word"></i><span> &nbsp;&nbsp;&nbsp;</span> Reports
          <!-- <div class="filter">
            <select id="day">
              <option value="volvo">Today</option>
              <option value="volvo">Yesterday</option>
            </select>
          </div> -->
        </div>

        <div class="row  report-main">
          <div class="col col-lg-12 col-md-12 col-sm-12">
            <div class="card scrollbar" id="style-1" style="width: auto;">
              <div class="card-body force-overflow">
                <h5 class="card-title">Employee Details</h5>
                <button type="button" class="btn btn-info">See All</button>
                <table>
                  <tr>
                    <th>Name of the Employee</th>
                    <th>Services</th>
                    <th>Worked Hours</th>
                    <th>OT Hours</th>
                    <th>Totals calc. Salary</th>
                    <th>Export Data</th>
                  </tr>

                  <tr>
                    <td>Peter</td>
                    <td>Service</td>
                    <td>100</td>
                    <td>20</td>
                    <td>$100</td>
                    <td>
                      <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          Export
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                          <a class="dropdown-item" href="#">PDF</a>
                          <a class="dropdown-item" href="#">EXCEL SHEET</a>
                          <a class="dropdown-item" href="#">DB FILE</a>
                        </div>
                      </div>
                    </td>
                  </tr>

                  
                  <tr>
                    <td>Peter</td>
                    <td>Service</td>
                    <td>100</td>
                    <td>20</td>
                    <td>$100</td>
                    <td>
                      <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          Export
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                          <a class="dropdown-item" href="#">PDF</a>
                          <a class="dropdown-item" href="#">EXCEL SHEET</a>
                          <a class="dropdown-item" href="#">DB FILE</a>
                        </div>
                      </div>
                    </td>
                  </tr>

                  
                  <tr>
                    <td>Peter</td>
                    <td>Service</td>
                    <td>100</td>
                    <td>20</td>
                    <td>$100</td>
                    <td>
                      <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          Export
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                          <a class="dropdown-item" href="#">PDF</a>
                          <a class="dropdown-item" href="#">EXCEL SHEET</a>
                          <a class="dropdown-item" href="#">DB FILE</a>
                        </div>
                      </div>
                    </td>
                  </tr>

                  
                  <tr>
                    <td>Peter</td>
                    <td>Service</td>
                    <td>100</td>
                    <td>20</td>
                    <td>$100</td>
                    <td>
                      <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          Export
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                          <a class="dropdown-item" href="#">PDF</a>
                          <a class="dropdown-item" href="#">EXCEL SHEET</a>
                          <a class="dropdown-item" href="#">DB FILE</a>
                        </div>
                      </div>
                    </td>
                  </tr>

                  
                  <tr>
                    <td>Peter</td>
                    <td>Service</td>
                    <td>100</td>
                    <td>20</td>
                    <td>$100</td>
                    <td>
                      <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          Export
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                          <a class="dropdown-item" href="#">PDF</a>
                          <a class="dropdown-item" href="#">EXCEL SHEET</a>
                          <a class="dropdown-item" href="#">DB FILE</a>
                        </div>
                      </div>
                    </td>
                  </tr>

                

                </table>
              </div>
            </div>
          </div>
        </div>

        
        <!--end of the reports section-->

        <!--fuel and meter readings-->

        <div class="alert alert-danger requests sales" role="alert">
          <i class="fas fa-thermometer-quarter"></i><span> &nbsp;&nbsp;&nbsp;</span> Status
          <!-- <div class="filter">
            <select id="day">
              <option value="volvo">Today</option>
              <option value="volvo">Yesterday</option>
            </select>
          </div> -->
        </div>      
        
        <div class="row status">
          <div class="col col-lg-12 col-md-12 col-sm-12">
            <div class="card">
             <div class="card-body">
              <h5 class="card-title">Fuel Tank Real-Time Readings</h5>
              <div class="chartWrapper">
                <div class="chartAreaWrapper">
                    <canvas id="tank" height="auto" width="auto"></canvas>
                </div>
            </div>
             </div>
            </div>
          </div>
        </div>

        <!--end of the fuel and meter readings-->


      </div>
      <!--end of the middle part-->

      <div class="col-3 right-sidebar">
        <div class="row" style="border-bottom: #8e8e8e solid 1px;;padding: 10px 0px;">
          <div class="col col-lg-12 col-md-12" style="padding: 0; margin: 0;">
            <h6 class="dropdown-header">Vehicle Service Center</h6>  
           <div class="but">
            <a href="PackageManagerServlet"><button type="button" class="btn btn-light nav-item nav-link"><i class="fas fa-plus"></i> Create Package</button></a>    
            <button type="button" class="btn btn-light"><i class="fab fa-get-pocket"></i> Generate Report</button>
           </div>
          </div>
        </div>

        <div class="row">
          <h6 class="dropdown-header timeline-head" style="font-size: 30px;text-align: center;;">Your Details</h6>  
          <div class="col" style="margin-top: 30px;padding: 0;">
            <div class="timeline">
              <div class="container right">

                <div class="content" style="overflow-y:scroll">

                   <!-- Default form register -->
                <form class="text-center border border-light p-1" action="UpdateAdminServlet" method="post">
                
                    <p class="h4 mb-4">Edit Your Details</p>
                
 
                    
                    <input type="text" name="updatename" id="defaultRegisterFormFirstName" class="form-control mb-4"
                                placeholder="Full Name">
                   
                   <input type="text" name="updateusername" id="defaultRegisterFormLastName" class="form-control mb-4"
                   placeholder="User Name">
                
                    <!-- E-mail -->
                    <input type="email" name="updateemail" id="defaultRegisterFormEmail" class="form-control mb-4" placeholder="E-mail">
                
                    <!-- Password -->
                    <input required type="password" name="updatepass" id="defaultRegisterFormPassword" class="form-control" placeholder="Password"
                        aria-describedby="defaultRegisterFormPasswordHelpBlock">
                    <small id="defaultRegisterFormPasswordHelpBlock" class="form-text text-muted mb-4">
                        At least 8 characters and 1 digit
                    </small>
                
                    <!-- Phone number -->
                    <input type="text" name="updatephone" id="defaultRegisterPhonePassword" class="form-control"
                        placeholder="Phone number" aria-describedby="defaultRegisterFormPhoneHelpBlock">
                    <small id="defaultRegisterFormPhoneHelpBlock" class="form-text text-muted mb-4">
                        Optional!!
                    </small>
                
                
                    <!-- Phone number -->
                    <input type="text" name="updatesal" class="form-control" placeholder="Salary"
                        aria-describedby="defaultRegisterFormPhoneHelpBlock">
                    <small id="defaultRegisterFormPhoneHelpBlock" class="form-text text-muted mb-4">
                        Optional!!
                    </small>
                
                   
                
                    <!-- Sign up button -->
                    <button class="btn btn-info my-4 btn-block" type="submit">Update</button>
                
                
                
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
          </div>
        </div>
      </div>
    </div>

    <!--end of the body part-->

    <!--footer-->
    

<footer class="new_footer_area bg_color">
  <div class="new_footer_top">
      <div class="container">
          <div class="row">
              <div class="col-lg-3 col-md-6">
                  <div class="f_widget company_widget wow fadeInLeft" data-wow-delay="0.2s" style="visibility: visible; animation-delay: 0.2s; animation-name: fadeInLeft;">
                      <h3 class="f-title f_600 t_color f_size_18">Get in Touch</h3>
                      <p>Don’t miss any updates of our new templates and extensions.!</p>
                      <form action="#" class="f_subscribe_two mailchimp" method="post" novalidate="true" _lpchecked="1">
                          <input type="text" name="EMAIL" class="form-control memail" placeholder="Email">
                          <button class="btn btn_get btn_get_two" type="submit">Subscribe</button>
                          <p class="mchimp-errmessage" style="display: none;"></p>
                          <p class="mchimp-sucmessage" style="display: none;"></p>
                      </form>
                  </div>
              </div>
              <div class="col-lg-3 col-md-6">
                  <div class="f_widget about-widget pl_70 wow fadeInLeft" data-wow-delay="0.4s" style="visibility: visible; animation-delay: 0.4s; animation-name: fadeInLeft;">
                      <h3 class="f-title f_600 t_color f_size_18">Services</h3>
                      <ul class="list-unstyled f_list">
                          <li><a href="#">Packages</a></li>
                          <li><a href="#">Requexts App</a></li>
                          <li><a href="#">Status</a></li>
                          <li><a href="#">Reports</a></li>
                          <li><a href="#">Bills</a></li>
                          <li><a href="#">Notifications</a></li>
                      </ul>
                  </div>
              </div>
              <div class="col-lg-3 col-md-6">
                  <div class="f_widget about-widget pl_70 wow fadeInLeft" data-wow-delay="0.6s" style="visibility: visible; animation-delay: 0.6s; animation-name: fadeInLeft;">
                      <h3 class="f-title f_600 t_color f_size_18">Navigate to other pages</h3>
                      <ul class="list-unstyled f_list">
                          <li><a href="#">FAQ</a></li>
                          <li><a href="#">Login</a></li>
                          <li><a href="#">User Admin</a></li>
                      </ul>
                  </div>
              </div>
              <div class="col-lg-3 col-md-6">
                  <div class="f_widget social-widget pl_70 wow fadeInLeft" data-wow-delay="0.8s" style="visibility: visible; animation-delay: 0.8s; animation-name: fadeInLeft;">
                      <h3 class="f-title f_600 t_color f_size_18">Social Media</h3>
                      <div class="f_social_icon">
                          <a href="#" class="fab fa-facebook"></a>
                          <a href="#" class="fab fa-twitter"></a>
                          <a href="#" class="fab fa-linkedin"></a>
                          <a href="#" class="fab fa-pinterest"></a>
                      </div>
                  </div>
              </div>
          </div>
      </div>
      <div class="footer_bg">
          <div class="footer_bg_one"></div>
          <div class="footer_bg_two"></div>
      </div>
  </div>
  <div class="footer_bottom">
      <div class="container">
          <div class="row align-items-center">
              <div class="col-lg-6 col-sm-7">
                  <p class="mb-0 f_400">© CarCare System Solutions All rights reserved.</p>
              </div>
          </div>
      </div>
  </div>
</footer>
    <!--end of the footer-->

    <!--bootstrap-->
    <script
      src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
      integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
      integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
      integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
      crossorigin="anonymous"
    ></script>
    <!--end of the bootstrap-->

    <!--akila js-->
    <script src="js/akila/dashboard.js"></script>
    <!--end of the akila js-->

    <!--font awsome cdn-->
    <script
      src="https://kit.fontawesome.com/61a479e883.js"
      crossorigin="anonymous"
    ></script>
    <!--end of the font awsone cdn-->

    <!--chart.js-->
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2/dist/Chart.min.js"></script>
    <!--end of the chart.js-->

    <!--charts-->
    <script>
    
  //bar
    var ctxB = document.getElementById("user").getContext('2d');
    var myBarChart = new Chart(ctxB, {
    type: 'bar',
    data: {
    labels: ["Total Customers", "Total Appointments", "Total Payments", "Total Packages"],
    datasets: [{
    label: '# of Votes',
    data: [${totCustomers}, ${apps}, ${totpay}, ${pack}],
    backgroundColor: [
    'rgba(255, 99, 132, 0.2)',
    'rgba(54, 162, 235, 0.2)',
    'rgba(255, 206, 86, 0.2)',
    'rgba(75, 192, 192, 0.2)',
    'rgba(153, 102, 255, 0.2)',
    'rgba(255, 159, 64, 0.2)'
    ],
    borderColor: [
    'rgba(255,99,132,1)',
    'rgba(54, 162, 235, 1)',
    'rgba(255, 206, 86, 1)',
    'rgba(75, 192, 192, 1)',
    'rgba(153, 102, 255, 1)',
    'rgba(255, 159, 64, 1)'
    ],
    borderWidth: 1
    }]
    },
    options: {
    scales: {
    yAxes: [{
    ticks: {
    beginAtZero: true
    }
    }]
    }
    }
    });
    
    
    
    

      let imcome = document.getElementById("income").getContext("2d");

      let pieOne = new Chart(income, {
        type: "doughnut",
        data: {
          labels: [
            "Paid",
            "Pending"
          ],
          datasets: [
            {
              label: "Count",
              data: [${paid},${pending}],
              backgroundColor: [
                "green",
                "red"
               
              ],
              //borderColor : '#FFFF',
              borderWidth: "3px"
            }
          ]
        },
        options: {
          cutoutPercentage: 50,
          scales: {
        xAxes: false,
        yAxes: false,
    },
    legend: {
                display: true,
                position: 'right',
                labels: {
                    fontColor: 'rgb(255, 99, 132)'
                }
            }
        }
      });

      let req = document.getElementById("req").getContext("2d");

let bar = new Chart(req, {
  type: "bar",
  data: {
    labels: [
    	
    	<c:forEach items="${req}" var="item">
    		"${item.dateString}",
    	</c:forEach>
    	
    ],
    datasets: [
      {
        label: "Count",
        data: [
        	
        	<c:forEach items="${req}" var="item">
    			${item.count},
    		</c:forEach>
		],
        backgroundColor: [
          "#fa163f",
          "#f0134d",
          "#40bfc1",
          "#1b262c",
          "#52de97",
          "#3e206d",
          "#12cad6"
        ],
        //borderColor : '#FFFF',
        borderWidth: "3px"
      }
    ]
  },
  options: {
    cutoutPercentage: 50,
    scales: {
  xAxes: [{
      gridLines: {
          color: "rgba(0, 0, 0, 0)",
      }
  }],
  yAxes: [{
      gridLines: {
          display: true
      }   
  }]
}
  }
});

       let tank = document.getElementById("tank").getContext("2d");

      let statOne = new Chart(tank, {
        type: "line",
        data: {
          labels: [
            "Sunday",
            "Monday",
            "Tuesday",
            "Wednsday",
            "Thursday",
            "Friday",
            "Saturday",
            "Sunday",
            "Monday",
            "Tuesday",
            "Wednsday",
            "Thursday",
            "Friday",
            "Saturday"
          ],
          datasets: [
            {
              label: "Liters",
              data: [10, 30, 1, 30, 50, 70, 60,10, 30, 1, 30, 50, 70, 90],
             
              //borderColor : '#FFFF',
              borderWidth: "3",          
              borderColor: "red",
              fill: false,
              pointBackgroundColor : 'red',
              pointBorderWidth : '5'
              //backgroundColor: 'red'
            }
          ],

        },
        options: {
          cutoutPercentage: 50,
          scales: {
        xAxes: [{
            gridLines: {
                color: "rgba(0, 0, 0, 0)",
            }
        }],
        yAxes: [{
            gridLines: {
                display: true
            }   
        }]
    }
        }
      });
      
    </script>
    <!--end of the charts-->
  </body>
</html>
