package cit285.book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdminServlet extends HttpServlet{
	

	private static final long serialVersionUID = 1801578236908354143L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    { 
		request.getRequestDispatcher("WEB-INF/process/admin.html").forward(request, response);
    }
	
}

