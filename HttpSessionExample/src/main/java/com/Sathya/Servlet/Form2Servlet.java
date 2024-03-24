package com.Sathya.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
@WebServlet("/Form2Servlet")
public class Form2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//get the data 
		String qualification=request.getParameter("qualification");
		String designation=request.getParameter("designation");
	//create the session object:
		HttpSession session =request.getSession(false);
	//place the data into session object:
		session.setAttribute( "qualifiaction",qualification);
		session.setAttribute("designation",designation);
	//Dispatch forward formhtml:
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("Form3.html");
		dispatcher.forward(request, response);
		
		}

}
