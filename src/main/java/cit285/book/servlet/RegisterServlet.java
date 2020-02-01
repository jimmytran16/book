package cit285.book.servlet;
import java.io.*;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cit285.book.dao.ConnectionDao;
import cit285.book.dao.LogAndRegisterDao;
import cit285.book.domain.User;
import cit285.book.service.UserServices;



@WebServlet("/Register")
public class RegisterServlet extends HttpServlet{
	private static final long serialVersionUID = 5095365762836165804L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  
    {
		request.getRequestDispatcher("WEB-INF/process/registration.html").forward(request, response);
    }
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  
    { 
		
		try {
			boolean check = true;
			ArrayList<User> update_user_list = null;
			String userId = request.getParameter("UserID"); //requests the user id on user input
			ResultSet dataUser = LogAndRegisterDao.getUsers(); //gets the userID 
			/*ITERATES THROUGH THE USERID RECORD TO CHECK IF USER EXISTS// IF EXISTS THEN REDIRECT BACK TO REGISTRATION PAGE*/
			
			while(dataUser.next()) { 
				String record = dataUser.getString("UserID");
				if(userId.equals(record)) {
					check = false;
				}
			}
			ConnectionDao.closeConnection();
			if(check==false) {
				request.getSession().setAttribute("sameEmail","User name already exist! Please choose a different username");
				request.getSession().setAttribute("sameEmailColor","red");
				request.getRequestDispatcher("WEB-INF/process/registration.html").forward(request,response);
			}
			else {
			/*GET DATA FROM THE WEB PAGE*/
			String password = request.getParameter("password");
			String FirstName = request.getParameter("FirstName");
			String LastName = request.getParameter("LastName");
			String companyName = request.getParameter("CompanyName");
			String Address = request.getParameter("userAddress");
			String AddressTwo = request.getParameter("userAddress2");
			String state = request.getParameter("userState");
			String City = request.getParameter("userCity");
			String Zip = request.getParameter("userZip");
			String Country = request.getParameter("userCountry");
			String emailAddress= request.getParameter("userEmail");
			User user = new User(userId,password,FirstName,LastName,companyName,Address,AddressTwo,City,state,Zip,Country,emailAddress);
			
			
			/*INSERTS USER DATA INTO MYSQL*/
			LogAndRegisterDao.insertUserData(userId,password, FirstName,LastName,companyName); 
			LogAndRegisterDao.insertUserAddress(userId,Address,AddressTwo,City,state,Zip,Country);
			LogAndRegisterDao.insertEmail(userId,emailAddress);
			
			/*RESET the userList*/
			HttpSession sess = request.getSession();
			sess.setAttribute("FirstName",FirstName);
			sess.setAttribute("userID",userId);
			sess.setAttribute("userInfo",user);
			UserServices userServices = new UserServices();
			update_user_list = userServices.getUsers();
			sess.setAttribute("userList",update_user_list);
			/*Redirects back to main page*/
			response.sendRedirect("index.jsp");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
    }
}
