package com.Sathya.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/NameServlet")
public class NameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



    public NameServlet() {


    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	String firstname =request.getParameter("firstname");
	String middlename=request.getParameter("middle name");
	String lastname=request.getParameter("lastname");
	
	String fullname;
	fullname=firstname+" "+middlename+" "+lastname;
	
	PrintWriter Writer =response.getWriter();
	response.setContentType("text/html");
	Writer.println("<html>");
	Writer.println("<h1>fullname is </h1>"+fullname);
	Writer.println("</html>");
		
	}





}
