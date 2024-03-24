package com.Sathya.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
@WebServlet("/Form1Servlet")
public class Form1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Form1Servlet() {
         
    }
 
	 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		//GET THE DATA:
			String username=request.getParameter("username");
			int age=Integer.parseInt(request.getParameter("age"));
		//CREATE THE SESSION OBJECT:
			HttpSession session=request.getSession();
		//place the data into session object:
			session.setAttribute("username",username);
			session.setAttribute("age",age);
		//Dispatch-forwrd form html:
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("Form2.html");
			dispatcher.forward(request, response);
			
	 	}

}
