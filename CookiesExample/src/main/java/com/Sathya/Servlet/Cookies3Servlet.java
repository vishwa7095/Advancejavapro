package com.Sathya.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet("/Cookies3Servlet")
public class Cookies3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the data
				String Email = request.getParameter("Email");
				String Mobile = request.getParameter("mobile number ");				
				//add to cookie objects
				Cookie cookie5 = new Cookie("Email", Email);
				Cookie cookie6 = new Cookie("Mobile", Mobile);
				
				//add the cookiies 
				response.addCookie(cookie5);
				response.addCookie(cookie6);
				
				//store the array
				Cookie[] cookies = request.getCookies();
				
				//print the data
				PrintWriter writer =  response.getWriter();
				response.setContentType("text/html");
				writer.println("<html>");
				writer.println("<body style='color: blue';>");
				writer.println("Username : "+cookies[0].getValue()+"<br>");
				writer.println("Age : "+cookies[1].getValue()+"<br>");
				writer.println("qualification : "+cookies[2].getValue()+"<br>");
				writer.println("Designation : "+cookies[3].getValue()+"<br>");
				writer.println("Email : "+Email+"<br>");
				writer.println("Mobile : "+Mobile+"<br>");
				writer.println("</body>");
				writer.println("</html>");
				
		 
	}

}
