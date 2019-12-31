package cit285.book.servlet;

import java.io.*;
import java.util.Enumeration;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cit285.book.domain.Cart;



@WebServlet("/LogoutServlet")

public class LogoutServlet extends HttpServlet{
	
	private static final long serialVersionUID = 5095365762836165804L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException 
    { 	
		//clear cart
		HttpSession sess = request.getSession(); //get session
		Cart cart = new Cart();
		cart.clearCart();
		sess.setAttribute("bookcart",cart);
		//clear all attributes in session
		Enumeration<?> em = sess.getAttributeNames();
		while (em.hasMoreElements()) {
		    String element = (String)em.nextElement();
		    if (!"uname".equals(element)&&!"bookcart".equals(element))
		        sess.removeAttribute(element);
		}
		sess.invalidate(); //clear everything in the session (data)
		response.sendRedirect("index.jsp");  //redirect to the main page
    }
}
