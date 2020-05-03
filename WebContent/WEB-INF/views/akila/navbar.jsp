<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
   <!--Navbar -->
        <nav class="mb-1 navbar navbar-expand-lg navbar-dark transparent lighten-1" style="box-shadow: none;font-weight: bolder; border: none;">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-555"
                aria-controls="navbarSupportedContent-555" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent-555">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active" style="background-color: transparent;">
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
                        <a class="nav-link" href="inquiry.jsp">Make Inquiry</a>
                    </li>
                    <li class="nav-item">
                        <form action="LogoutServlet">
                        	<button class="nav-link" type="submit" style="background: transparent;border: none;font-weight: bolder;">Log out</button>
                        </form>
                    </li>
                    <!-- Dropdown -->
                   
                </ul>
                
            </div>
        </nav>
        <!--/.Navbar -->
</body>
</html>