package com.Sathya.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/test")

public class OneMoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
     
     
    public OneMoreServlet() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter Writer=response.getWriter();
			Writer.println("<html>");
			Writer.println("<h1>one more programe is done</h1>");
			Writer.println("<h2>bharath is my best friend</h2>");
			
		
	}
			
	
	 
 
}
