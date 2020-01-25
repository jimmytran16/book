package cit285.book.servlet;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cit285.book.domain.Book;
import cit285.book.domain.User;
import cit285.book.service.BookServices;
import cit285.book.service.UserServices;

@WebServlet("/LoginServlet")

public class LoginServlet extends HttpServlet{
	

	private static final long serialVersionUID = 1801578236908354143L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{ 
		request.getRequestDispatcher("WEB-INF/process/users.jsp").forward(request, response);
    }

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{ 
		boolean isAdmin = false;
		ArrayList<User> users;
		ArrayList<Book> books;
		boolean userExists = false;
		/*ITERATES THROUGH EACH USER NAME TO VALIDATE IF IN SYSTEM*/
		try {

		HttpSession sess = request.getSession();
		String user_input_username = request.getParameter("username");
		String user_input_password = request.getParameter("password");
		String user_page_type = request.getParameter("page_type");
				
		/*CHECK IF ADMIN OR USER*/
		//if the user list doesn't exist already get the list
		
		if(sess.getAttribute("userList")==null) {

			UserServices userServices = new UserServices();
			users = userServices.getUsers();
			sess.setAttribute("userList",users);		
		}
			//if list already exist	
		else {
			users =(ArrayList<User>)sess.getAttribute("userList");
		}
		//store the book data into session
		if(sess.getAttribute("bookList")==null){
			BookServices bookService = new BookServices();
			books = new ArrayList<>(bookService.getBooks());
			sess.setAttribute("bookList",books);
		}

			//authenticate users
			for(User u:users) {
				if(u.getUserID().equals(user_input_username)) {
					if(u.getPassword().equals(user_input_password)) {
						userExists = true;
						isAdmin = u.type;
						System.out.println("is admin?"+isAdmin);
						System.out.println("Page type?"+user_page_type);
						if(user_page_type.equals("admin")) {
							if(isAdmin) {
								sess.setAttribute("FirstName",u.getFirstName());
								sess.setAttribute("userID",u.getUserID());
								sess.setAttribute("userInfo",u);
								request.getRequestDispatcher("WEB-INF/process/adminPage.jsp").forward(request, response);							}
							else {
								request.getRequestDispatcher("WEB-INF/process/admin.html").forward(request,response);
							}
							
						}else if(user_page_type.equals("user")) {
							if(!isAdmin) {
								sess.setAttribute("FirstName",u.getFirstName());
								sess.setAttribute("userID",u.getUserID());
								sess.setAttribute("userInfo",u);
								response.sendRedirect("index.jsp");
							}
							else {
								sess.setAttribute("Login", "Invalid user name or password!");
								sess.setAttribute("color","red");
								request.getRequestDispatcher("WEB-INF/process/users.jsp").forward(request,response);
							}
						}
					}
					break;
				}
			}
			if(!userExists) {				
				sess.setAttribute("Login", "Invalid user name or password!");
				sess.setAttribute("color","red");
				if(user_page_type.equals("admin")) {request.getRequestDispatcher("WEB-INF/process/users.jsp").forward(request,response);}
				else if(user_page_type.equals("user")) {request.getRequestDispatcher("WEB-INF/process/users.jsp").forward(request,response);}				
			}
		}catch(Exception e) {}
		
    }
}

