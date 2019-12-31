package cit285.book.servlet;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/AdminAction")
public class AdminActionServlet extends HttpServlet{
		private static final long serialVersionUID = 1801578236908354143L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    { 
		String action = request.getParameter("action");
		if(action.equals("book")) {
			request.getRequestDispatcher("WEB-INF/process/Book.jsp").forward(request, response);
			
		}else if(action.equals("author")) {
			request.getRequestDispatcher("WEB-INF/process/Author.jsp").forward(request, response);
		
		}else if(action.equals("addauthor")) {
			request.getRequestDispatcher("WEB-INF/process/addAuthor.jsp").forward(request, response);
		
		}else if(action.equals("addbook")) {
			request.getRequestDispatcher("WEB-INF/process/addBook.jsp").forward(request, response);
		
		}else if(action.equals("home")) {
			request.getRequestDispatcher("WEB-INF/process/adminPage.jsp").forward(request, response);
		}
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		doGet(request,response);
	}
}

	

