<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

   <nav class="navbar fixed-top navbar-expand-lg navbar-dark">
        <div class="container">
            <a class="navbar-brand" href="index.jsp">
                <h3 class="my-heading ">EVENT<span class="bg-main">INO</span></h3>
            </a>
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="fa fa-bars mfa-white"></span>
            </button>

            <div id="main">
                <a href="javascript:void(0)" class="openNav"><span class="fa fa-bars" onclick="openNav()"></span></a>
            </div>
			
         
           
        <div id="mySidenav" class="sidenav">
          <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
          <ul class="mob-ul">
             <li class="nav-item"><a class="nav-link" href="#">Home</a></li>
             <li class="nav-item"><a class="nav-link" href="#">Events</a></li>
             <li class="nav-item"><a class="nav-link" href="#">My Profile</a></li>
             <li class="nav-item"><a class="nav-link" href="#">Login</a></li>
             <li class="nav-item"><a class="nav-link" href="#">Register</a></li>
             
             
          </ul>
        </div>


            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
              		
                	<li class="nav-link">
                        <a class="btn btn-primary btn-block btn-login" href="/Eventino/Events">Events</a>
                    </li>
                <%
					response.setHeader("Cache-Control", "no-cach,no-store,must-revalidate");
					if (session.getAttribute("username") == null) {
				%>
                    <li class="nav-link">
                        <a class="btn btn-primary btn-block btn-login" href="login.jsp">Login</a>
                    </li>
                    <li class="nav-link">
                        <a class="btn btn-primary btn-block btn-register" href="register.jsp">Register</a>
                    </li>                               
                    <%
					} else {
						if (session.getAttribute("user-type").equals("Administrator")) {
				%>
				
				<li class="nav-link">
                    	<a class="btn btn-primary btn-block btn-register" href="register.jsp">Administration</a>
                    </li>
                    <%
						}
                    %>
                    
                    <li class="nav-link">
                        <a class="btn btn-primary btn-block btn-login" href="/Eventino/Myprofile">My Profile</a>
                    </li>
                    <li class="nav-link">
                    <form class="form-inline" action="Logout">
                        <button type = "submit" class = "btn btn-primary btn-block btn-login" value="Logout">Logout</button>
                        </form>
                    </li>
				<%
					}
				%>
                </ul>
            </div>

        </div>
    </nav>
    
    