package com.Sathya.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/Cookies2Servlet")
public class Cookies2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the data from client
				String qualification = request.getParameter("qualification");
				String Designation = request.getParameter("designation");
				
				//create the cookie object
				Cookie cookie3 = new Cookie("qualification",qualification);
				Cookie cookie4 = new Cookie("designation", Designation);
				
				//add the cookie response to response object
				response.addCookie(cookie3);
				response.addCookie(cookie4);
				
				//send the next form 
				RequestDispatcher dispatcher = request.getRequestDispatcher("Cookies3.html");
				dispatcher.forward(request,response);
	}

}
