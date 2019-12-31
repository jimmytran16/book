<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.io.*" %>
<%@ page import="cit285.book.domain.Book"%>
<%@ page import="cit285.book.domain.User"%>
<%@ page import="cit285.book.domain.Author"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href='https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css'>
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Invoice</title>
</head>
<body>
    <div class="offset-xl-2 col-xl-8 col-lg-12 col-md-12 col-sm-12 col-12 padding">
        <div class="card">
            <div class="card-header p-4">
                <a class="pt-2 d-inline-block" href="index.jsp" data-abc="true">Back to home page</a>
                <div class="float-right">
                <%session.getAttribute("invoiceDate");
                  session.getAttribute("invoiceNumber");	
                %>
                    <h3 class="mb-0">Invoice # ${invoiceNumber}</h3>
                    ${invoiceDate} 
                </div>
            </div>
            <div class="card-body">
                <div class="row mb-4">
                    <div class="col-sm-6">
                        <h5 class="mb-3">From:</h5>
                        <% User user = (User)session.getAttribute("userInfo");
                         String userFullAddress = user.getCity()+","+user.getState()+","+user.getZip();
                        %>
                        <h3 class="text-dark mb-1">CS Book Store</h3>                       
                    </div>
                    <div class="col-sm-6 ">
                        <h5 class="mb-3">To:</h5>
                        <h3 class="text-dark mb-1"><%=user.getFirstName() %>,<%=user.getLastName()%></h3>
                        <div><%=user.getAddressOne()%> </div>
                        <div><%=userFullAddress %></div>
                        <div>Email: <%=user.getEmailAddress() %></div>
                    </div>
                </div>
                <div class="table-responsive-sm">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Item</th>
                                <th class="right">Price</th>
                                <th class="center">Qty</th>
                                <th class="right">Total</th>
                            </tr>
                        </thead>
                        <tbody>
                        <% @SuppressWarnings("unchecked") 
                        HashMap<Book,Integer> invoiceMap = (HashMap<Book,Integer>)session.getAttribute("invoiceMap");
                        double total = (double)session.getAttribute("total");
                        Book book = new Book();
                        for(Map.Entry<Book,Integer> entry : invoiceMap.entrySet())
                        { double book_total = (entry.getKey().getPrice())*(entry.getValue());
                        %>
                            <tr>
                                <td class="left strong"><%= entry.getKey().getTitle() %></td>
                                <td class="right">$<%=entry.getKey().getPrice()%></td>
                                <td class="center"><%= entry.getValue() %></td>
                                <td class="right">$<%=book_total%></td>
                            </tr>
                     <%}%>
                   
                        </tbody>
                    </table>
                </div>
                <div class="row">
                    <div class="col-lg-4 col-sm-5">
                    </div>
                    <div class="col-lg-4 col-sm-5 ml-auto">
                        <table class="table table-clear">
                            <tbody>
                                <tr>
                                    <td class="left">
                                        <strong class="text-dark">Subtotal</strong>
                                    </td>
                                    <td class="right">$<%=total %></td>
                                </tr>
                               
                                <tr>
                                    <td class="left">
                                        <strong class="text-dark">Total</strong> </td>
                                    <td class="right">
                                        <strong class="text-dark">$<%=total %></strong>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js'></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
</body>
</html>