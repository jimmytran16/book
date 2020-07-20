<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="cit285.book.dao.BookDao"%>
<%@ page import="cit285.book.domain.Book"%>
<%@ page import="cit285.book.domain.Author"%>
<%@ page import="cit285.book.domain.Cart"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="cit285.book.service.*"%>

<!DOCTYPE html
    PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <title>Book Store</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="shortcut icon" type="image/png" href="img/fav.png" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" href="css/owl.carousel.min.css" />
    <link rel="stylesheet" href="css/styles.css" />

    <style>
        .buy_button {
            position: relative;
            left: 30px;
        }
    </style>
</head>

<body>

    <header>
        <div class="header-top">
            <div class="container">
                <div class="row">
                    <div class="col-md-3"><a href="#" class="web-url">www.thecsbookstore.com</a></div>
                    <div class="col-md-6">
                        <h5></h5>
                    </div>
                    <div class="col-md-3">
                        <span class="ph-number">The CS Book Store</span>
                    </div>
                </div>
            </div>
        </div>
        <div class="main-menu">
            <div class="container">
                <nav class="navbar navbar-expand-lg navbar-light">
                    <a class="navbar-brand" href="#"><img src="images/logo.png" alt="logo"></a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
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
                                <a href="login" class="nav-link">User</a>
                            </li>
                        </ul>
                        <%if(session.getAttribute("FirstName")!=null){%>
                        <div class="cart my-2 my-lg-0">
                            <span>
                                <a href="cart"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a></span>
                            <span class="quntity"><%=Cart.getCartCount()%></span>
                        </div>
                        <span>
                            <b>Welcome, ${FirstName}</b>
                        </span>
                        <%}%>
                    </div>
                </nav>
            </div>
        </div>
    </header>
    <section class="recomended-sec">
        <div class="container">
            <div class="title">
                <h2>Welcome!</h2>
            </div>
            <div class="row">
                	<%
					ArrayList<Book> books;
					if(session.getAttribute("bookList")!=null){
						books = (ArrayList<Book>)session.getAttribute("bookList");
					}
					else{
						BookDao bookDao = new BookDao();
						books = new ArrayList<Book>(bookDao.getBooks());
					}
					for (Book book : books) {
				%>
                        <div class="col-lg-3 col-md-6">
                            <div class="item">
                                <img src="images/<%=book.getImage()%>" height="125" width="100" alt="img" />
                                <h3><%=book.getTitle()%></h3>
                                <h6><span class="price">$<%=book.getPrice()%></span></h6>
                                <div class="hover">
                                    <%if(session.getAttribute("FirstName")!=null){%>
                                    <div class="container">
                                        <a class="" href="cart?action=buynow&bookId=<%=book.getBookid() %>">Buy Now</a>
                                    </div>
                                    <%}
							else if(session.getAttribute("FirstName")==null){%>
                                    <div class="container">
                                        <a class="" href="login">Buy Now</a>
                                    </div>
                                    <%}
							%>
                                </div>
                            </div>
                        </div>
                        <%}%>

                </div>
             </div>
   </section>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/custom.js"></script>
<script src="js/owl.carousel.min.js"></script>
</body>
</html>