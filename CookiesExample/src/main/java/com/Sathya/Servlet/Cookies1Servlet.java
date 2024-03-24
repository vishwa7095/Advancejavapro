package com.Sathya.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet("/Cookies1Servlet")
public class Cookies1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

     
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//get the data from client
				String  username= request.getParameter("username");
				String age = request.getParameter("age");
				
				//create the cookie session
				Cookie cookie1 = new Cookie("username", username);
				Cookie cookie2 = new Cookie("age", age);
				
				//send the data to response object from cookie
				response.addCookie(cookie1);
				response.addCookie(cookie2);
				
				//send the data to next form
				RequestDispatcher dispatcher = request.getRequestDispatcher(" Cookies2.html");
				dispatcher.forward(request, response);

	}

}
