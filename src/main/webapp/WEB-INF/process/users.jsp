<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>User</title>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <link href="templatemo_style.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="css/main.css" type="text/css">
        <link rel="stylesheet" href="css/util.css" type="text/css">
        <link rel="shortcut icon" type="image/png" href="img/fav.png">
        <link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" type="image/png" href="img/fav.png"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
 <link rel="stylesheet" href="css/bootstrap.min.css">
 <link href="https://fonts.googleapis.com/css?family=Montserrat:200,300,400,500,600,700,800,900" rel="stylesheet"/>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
  <link rel="stylesheet" type="text/css" href="css/owl.carousel.min.css"/>
    <link rel="stylesheet" href="css/styles.css"/>
        </head>
        <body>
         <header>
        <div class="header-top">
            <div class="container">
                <div class="row">
                    <div class="col-md-3"><a href="#" class="web-url">www.thecsbookstore.com</a></div>
                    <div class="col-md-6">
                        <h5></h5></div>
                    <div class="col-md-3">
                        <span class="ph-number">The CS Book Store</span>
                    </div>
                </div>
            </div>
        </div>
        <div class="main-menu">
            <div class="container">
                <nav class="navbar navbar-expand-lg navbar-light">
                    <a class="navbar-brand" href="index.jsp"><img src="images/logo.png" alt="logo"></a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ml-auto">
                            <li class="navbar-item active">
                                <a href="index.jsp" class="nav-link">Home</a>
                            </li>
                            <li class="navbar-item">
                                <a href="admin" class="nav-link">Admin</a>
                            </li>
                            <li class="navbar-item">
                                <a href="#" class="nav-link">User</a>
                            </li>  
                        </ul>
                        
                    </div>
                </nav>
            </div>
        </div>
    </header>
      <div class="container-login100 container">
                        <div class="wrap-login100">
                            <form action ="login" method="post" class="login100-form validate-form p-l-55 p-r-55 p-t-178">
                                <span class="login100-form-title">
                                    User Log in
                                </span>
            
                                <div class="wrap-input100 validate-input m-b-16" data-validate="Please enter username">
                                    <input class="input100" type="text" name="username" placeholder="Username">
                                    <input type ="hidden" name="page_type" value="user" >
                                    <span class="focus-input100"></span>
                                </div>
            
                                <div class ="wrap-input100 validate-input" data-validate = "Please enter password">
                                    <input class="input100" type="password" name="password" placeholder="Password">
                                    <span class="focus-input100"></span>
                                </div>
            					<div> <input type="hidden" id="login_id" name="login_id" value="1"></div>	
                                <div class="text-right p-t-13 p-b-23">
                                    <span class="txt1">
                                        Forgot
                                    </span>
            
                                    <a href="#" class="txt2">
                                        Username / Password?
                                    </a>
                                </div>
            
                                <div class="container-login100-form-btn">
                                    <button value="login" class="login100-form-btn">
                                        Sign in
                                    </button>
                                </div>
            
                                <div class="flex-col-c p-t-170 p-b-40">
                                	<%
									if(session.getAttribute("Login")!=null){
									%>
                                    <span style="color:${color}">${Login}</span><br>
                                    <%
                                    session.setAttribute("Error",null);
									}%>
                                    <span class="txt1 p-b-9">
                                        Don't have an account?
                                    </span>
            
                                    <a href="register" class="txt3">
                                        Sign up now
                                    </a>
                                </div>
                            </form>
                        </div>
                    </div>
       
            
            
        </body>
</html>
