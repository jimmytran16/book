<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="cit285.book.dao.AuthorDao"%>
<%@ page import="cit285.book.domain.Author"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>

<head>
<meta name="viewport" content="width=device-width,initial-scale=1">
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="adminPage.jsp">Admin Site</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active"><a class="nav-link" href="adminPage.jsp">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="adminaction?action=book">Book</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Author</a></li>
            </ul>
            <form action="LogoutServlet" method="GET" class="form-inline my-2 my-lg-0">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Log
                    out</button>
            </form>
        </div>
    </nav>
    <table class="table">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">AuthorID</th>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
            </tr>
        </thead>
        <tbody>
            <%
				int count = 0;
				AuthorDao authorDao = new AuthorDao();
				ArrayList<Author> authors = new ArrayList<>(authorDao.getAuthor());
				for (Author author : authors) {
					count++;
			%>
            <tr>
                <th scope="row"><%=count%></th>
                <td><%=author.getAuthorid()%></td>
                <td><%=author.getAuthorfirstname()%></td>
                <td><%=author.getAuthorlastname()%></td>
            </tr>
            <%
				}
			%>
        </tbody>
    </table>
    <div>
        <a class="btn btn-large btn-info" type="button" href="adminaction?action=addauthor">ADD</a>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/custom.js"></script>
    <script src="js/owl.carousel.min.js"></script>
</body>
</html>