<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="cit285.book.dao.BookDao"%>
<%@ page import="cit285.book.domain.Book"%>
<%@ page import="cit285.book.domain.Cart"%>
<%@ page import="cit285.book.domain.Author"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>   




<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Book Store</title>

<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" type="image/png" href="img/fav.png"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserat:200,300,400,500,600,700,800,900" rel="stylesheet"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
<link rel="stylesheet" type="text/css" href="css/owl.carousel.min.css"/>
<link rel="stylesheet" href="css/styles.css"/>
<link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css"/>
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
                        	<li><form action="LogoutServlet" method="get">
                        		<button type="submit">Logout</button>
                        	</form></li>
                            <li class="navbar-item active">
                                <a href="index.jsp" class="nav-link">Home</a>
                            </li>
                            <li class="navbar-item">
                                <a href="admin" class="nav-link">Admin</a>
                            </li>
                            <li class="navbar-item">
                                <a href="login" class="nav-link">User</a>
                            </li>
                            <li class="navbar-item">
                                <a href="#" class="nav-link">FAQ</a>
                            </li>
                            
                        </ul>
                        <%if(session.getAttribute("FirstName")!=null){
                         %>
                        
                        <div class="cart my-2 my-lg-0">
                            <span>
                                <a href="#"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a></span>
                            <span class="quntity"><%=Cart.getCartCount() %></span>
                        </div>
                            <span>
                             <b>Welcome, ${FirstName}</b>
                            </span>
                            <%}else{
                            	response.sendRedirect("login");
                            } %>
                    </div>
                </nav>
            </div>
        </div>
    </header>
   <div class="container">
                    <div class="row">
                        <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">
    
                            <!-- Shopping cart table -->
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th scope="col" class="border-0 bg-light">
                                                <div class="p-2 px-3 text-uppercase">Product</div>
                                            </th>
                                            <th scope="col" class="border-0 bg-light">
                                                <div class="py-2 text-uppercase">Price</div>
                                            </th>
                                            <th scope="col" class="border-0 bg-light">
                                                <div class="py-2 text-uppercase">Quantity</div>
                                            </th>
                                            <th scope="col" class="border-0 bg-light">
                                                <div class="py-2 text-uppercase">Remove</div>
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                    double total = 0.0;
                                    int counter = 0;
                                    HttpSession sess = request.getSession();
                                    if(!(session.getAttribute("bookcart")==null))
                                    {
                                        HashMap<Book,Integer> showCart = new HashMap<>(Cart.getCart());
                                        /*ITERATE THROUGH THE HASHMAP*/
                                        for(Map.Entry<Book,Integer> entry : showCart.entrySet())
                                        { 
                                            Book book = entry.getKey();
                                            /*GETS THE QUANTITY * THE PRICE OF THE BOOK TO GET SUBTOTAL*/
                                            int priceCounter = entry.getValue();
                                            total+=(book.getPrice()*entry.getValue());
                                    %>
                                        <tr>
                                            <th scope="row" class="border-0">
                                                <div class="p-2">
                                                    <img src="images/<%=book.getImage()%>" alt="" width="70" class="img-fluid rounded shadow-sm" />
                                                    <div class="ml-3 d-inline-block align-middle"/>
                                                        <h5 class="mb-0">
                                                            <a href="#" class="text-dark d-inline-block align-middle"><%=book.getTitle()%></a>
                                                        </h5>
                                                        <span
                                                            class="text-muted font-weight-normal font-italic d-block">Author: <%=book.getAuthor().getAuthorfirstname()+" "+book.getAuthor().getAuthorlastname() %></span>
                                                    </div>
                                                </div>
                                            </th>
                                            
                                            <td class="border-0 align-middle"><strong><%="$"+book.getPrice()%></strong></td>
                                            <td class="border-0 align-middle"><strong><%=entry.getValue() %></strong></td>
                                
                                            <td class="border-0 align-middle">
                                            <form method="post" action="CartServlet">
                                            <input type="hidden" name="action" value="deletenow"/>
                                            <input type="hidden" name="bookId" value="<%=book.getBookid() %>"/>                                       
                                            <button type="submit"><i class="fa fa-trash"></i></button>
                                            </form>
                                            </td>
                                        </tr>
                                    </tbody>
                                    <% }
                                        }%>
                                </table>
                            </div>
                            <!-- End -->
                        </div>
                    </div>
    
                    <div class="row py-5 p-4 bg-white rounded shadow-sm">
                       
                        <div class="container">
                            <div
                                class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Order
                                summary</div>
                            <div class="p-4">
                                <p class="font-italic mb-4">Shipping and additional costs are
                                    calculated based on values you have entered.</p>
                                <ul class="list-unstyled mb-4">
                                    <li class="d-flex justify-content-between py-3 border-bottom"><strong
                                        class="text-muted">Order Subtotal </strong><strong>$<%=total %></strong></li>
                                    <li class="d-flex justify-content-between py-3 border-bottom"><strong
                                        class="text-muted">Shipping and handling</strong><strong>Free Shipping</strong></li>
                                    <li class="d-flex justify-content-between py-3 border-bottom"><strong
                                        class="text-muted">Tax</strong><strong>$0.00</strong></li>
                                    <li class="d-flex justify-content-between py-3 border-bottom"><strong
                                        class="text-muted">Total</strong>
                                        <h5 class="font-weight-bold">$<%=total %></h5></li>
                                </ul>
                                <a href="proccess?total=<%=total %>" class="btn btn-dark rounded-pill py-2 btn-block">Procceed
                                    to checkout</a>
                            </div>
                        </div>
                        
                    </div>
    
                </div>
	</body>
</html>








































