<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Google Fonts -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
<!-- Bootstrap core CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.16.0/css/mdb.min.css" rel="stylesheet">   
</head>
<body style="overflow-x:hidden ">
          
          <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">List of Inquiries</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
     New Inquiry</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>InquiryId</th>
                                <th>Type</th>
                                <th>UserDesc</th>
                                <th>AdminDesc</th>
                                <th>User Name</th>
                                <th>AdminId</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="inquiry" items="${inq}">

                                <tr>
                                    <td>
                                        <c:out value="${inquiry.inqidString}" />
                                    </td>
                                    <td>
                                        <c:out value="${inquiry.typeString}" />
                                    </td>
                                    <td>
                                        <c:out value="${inquiry.usermessageString}" />
                                    </td>
                                    <td>
                                        <c:out value="${inquiry.adminmessageString}" />
                                    </td>
                                    <td>
                                        <c:out value="${inquiry.usernameString}" />
                                    </td>
                                      
                                      <td>
                                        <c:out value="${inquiry.adminidString}" />
                                    </td>
                                    <td>
										            <!-- Button trigger modal -->
										<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#${inquiry.inqidString }">
										  Send Reply
										</button>									
                                    </td>
                                </tr>
                                
                                
                                <!-- Modal -->
										<div class="modal fade" id="${inquiry.inqidString}" tabindex="-1" role="dialog" aria-labelledby="${inquiry.inqidString}"
										  aria-hidden="true">
										  <div class="modal-dialog" role="document">
										    <div class="modal-content p-5">
										     	<form class="p-3 m-3" action="ReplyServlet" method="post">
						
						    						<p class="h4 text-center">Send Reply</p>
						
									
									                    <input type="text" id="defaultSaveFormFirstName" name="inqId" class="form-control mb-4" value="${inquiry.inqidString}" placeholder="Inquiry ID">
									                    
									                    <input type="text" id="defaultSaveFormFirstName" value="${ inquiry.usernameString}" class="form-control mb-4" placeholder="User Name">
									
									                    <p> E-Mail : <a href="mailto:${inquiry.emailString }">${inquiry.emailString }</a> </p>
									
														<textarea class="form-control rounded-0 mb-4" id="exampleFormControlTextareaSave" rows="3" placeholder="Message">${ inquiry.usermessageString}</textarea>
									
									                    <textarea class="form-control rounded-0 mb-4" id="exampleFormControlTextareaSave" name="reply" rows="3" placeholder="reply"></textarea>
									
									    				<button class="btn btn-info btn-block mb-4" type="submit">Save</button>
												</form>
										    </div>
										  </div>
										</div>
                                
				
				
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
            
            
				
            
            
            <!-- JQuery -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.16.0/js/mdb.min.js"></script>
          
         
</body>
</html>