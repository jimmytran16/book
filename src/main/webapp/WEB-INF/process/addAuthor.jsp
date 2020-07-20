<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="css/styles.css">
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="adminPage.html">Admin Site</a>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active"><a class="nav-link" href="adminaction?action=home">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="adminaction?action=book">Book</a></li>
                <li class="nav-item"><a class="nav-link" href="adminaction?action=author">Author</a></li>
            </ul>
            <form action="LogoutServlet" method="GET" class="form-inline my-2 my-lg-0">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Log out</button>
            </form>
        </div>
    </nav>
    <form method="post" action="addAuthor">
        <div class="container center_div">
            <div class="form-group">
                <div class="col-md-4 mb-3">
                    <label>Author ID</label> <input type="text" class="form-control" placeholder="Author ID"
                        name="authorID" required>
                </div>
                <div class="col-md-4 mb-3">
                    <label>Author's First Name</label> <input type="text" class="form-control" placeholder="First Name"
                        name="firstName" required>
                </div>
                <div class="col-md-4 mb-3">
                    <label>Author's Last Name</label> <input type="text" class="form-control" placeholder="Last Name"
                        name="lastName" required>
                </div>
            </div>
            <button class="btn btn-primary btnSubmit" type="submit">Add</button>
        </div>
    </form>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/custom.js"></script>
    <script src="js/owl.carousel.min.js"></script>
</body>
</html>