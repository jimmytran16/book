<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="cit285.book.dao.BookDao"%>
<%@ page import="cit285.book.domain.Book"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="adminaction?action=home">Admin Site</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active"><a class="nav-link" href="adminaction?action=home">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Book</a></li>
                <li class="nav-item"><a class="nav-link" href="adminaction?action=author">Author</a></li>
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
                <th scope="col">BookID</th>
                <th scope="col">ISBN</th>
                <th scope="col">Title</th>
                <th scope="col">Editor</th>
                <th scope="col">Edition</th>
                <th scope="col">Year</th>
                <th scope="col">Image</th>
                <th scope="col">Price</th>
                <th scope="col">Modify</th>
            </tr>
        </thead>
        <tbody>
            <%
				int count = 0;
				BookDao bookDao = new BookDao();
				ArrayList<Book> books = new ArrayList<>(bookDao.getBooks());
				for (Book book : books) {
					count++;
					int bookid = book.getBookid();
			%>

            <tr>
                <th scope="row"><%=count%></th>
                <td><%=bookid%></td>
                <td><%=book.getIsbn()%></td>
                <td><%=book.getTitle()%></td>
                <td><%=book.getEditor()%></td>
                <td><%=book.getEdition()%></td>
                <td><%=book.getYear()%></td>
                <td><%=book.getImage()%></td>
                <td><%=book.getPrice()%></td>

                <td>
                    <a href="bookdeletion?bookid=<%=bookid%>"><button class="btn btn-outline-success my-2 my-sm-0"
                            type="submit">Delete</button></a>
                </td>

            </tr>

            <%
				}
			%>
        </tbody>
    </table>
    <div>
        <a class="btn btn-large btn-info" type="button" href="adminaction?action=addbook">ADD</a>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/custom.js"></script>
    <script src="js/owl.carousel.min.js"></script>
</body>

</html>