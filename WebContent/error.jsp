<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isErrorPage="true"%>

<!DOCTYPE html>
<html>
  <head>
    <!-- Font Awesome -->
    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
    />
    <!-- Google Fonts -->
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
    />
    <!-- Bootstrap core CSS -->
    <link
      href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <!-- Material Design Bootstrap -->
    <link
      href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.16.0/css/mdb.min.css"
      rel="stylesheet"
    />
    <!-- custom css -->
    <link rel="stylesheet" href="css/akila/error.css" />
    <link rel="stylesheet" href="css/akila/homepage.css" />
    <link rel="stylesheet" href="css/akila/dashboard.css" />
    <meta charset="ISO-8859-1" />
    <title>Error</title>
  </head>
  <body>
    <% 
    
    Integer statusCode =
    (Integer)request.getAttribute("javax.servlet.error.status_code"); Throwable
    throwable =
    (Throwable)request.getAttribute("javax.servlet.error.exception"); String
    servletName =
    (String)request.getAttribute("javax.servlet.error.servlet_name"); String
    requestUri =
    (String)request.getAttribute("javax.servlet.error.request_uri"); 
    if
    (servletName == null) {
    	servletName = "Unknown"; 
    	} 
    if (requestUri == null) {
    	
    requestUri = "Unknown"; 
    } 
    
    %>
    
    

    <div style="background-color: #222831;">
      <jsp:include page="\WEB-INF\views\akila\navbar.jsp"></jsp:include>
    </div>
    <!-- Card -->

    <div class="row section" style="padding: 0px; margin: 0px;">
      <div
        class="col-lg-6 col-md-6 col-sm-8 left"
        style="padding: 0px; margin: 0px;"
      >
        <img src="img/akila/pink.gif" alt="" />
      </div>

      <div class="col-lg-6 col-md-6 col-sm-6 right">
        <h1>
          D'OH!!!!!!! <br />
          LOST ???
        </h1>
        <div
          class="badge badge-danger text-wrap"
          style="width: auto; font-size: 20px;"
        >
          SEEMS SOMETHING HAS WENT WRONG!
        </div>

        <% if (throwable == null && statusCode == null) { %>

        <div
          class="badge badge-success text-wrap"
          style="width: auto; font-size: 20px;"
        >
          ERROR CODE : <%out.println("Error information is missing."); %> <br />
          <%out.print("Please return back!!");%>
        </div>

        <% } else if (statusCode != null) { %>

        <div
          class="badge badge-success text-wrap"
          style="width: auto; font-size: 20px;"
        >
          STATUS CODE : <%out.println(statusCode + " - HTTP code returned");%> <br>        
        </div>
			
        <%}%> 
      </div>
    </div>

    <!-- Card -->

    <jsp:include page="/WEB-INF/views/akila/footer.jsp"></jsp:include>

    <!-- JQuery -->
    <script
      type="text/javascript"
      src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"
    ></script>
    <!-- Bootstrap tooltips -->
    <script
      type="text/javascript"
      src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"
    ></script>
    <!-- Bootstrap core JavaScript -->
    <script
      type="text/javascript"
      src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.min.js"
    ></script>
    <!-- MDB core JavaScript -->
    <script
      type="text/javascript"
      src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.16.0/js/mdb.min.js"
    ></script>
  </body>
</html>
