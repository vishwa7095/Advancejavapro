package com.Sathya.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
@WebServlet("/Form3Servlet")
public class Form3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 response.setContentType("text/html");
		 PrintWriter writer=response.getWriter();
		 HttpSession session=request.getSession(false);
		 writer.println("<html>");
		 writer.println("<body>");
		 writer.println("<pre>");
		 writer.println("Username:"+session.getAttribute("username"));
		 writer.println("age:"+session.getAttribute("age"));
		 writer.println("qualifiacation:"+session.getAttribute("qualifiaction"));
		 writer.println("designation"+session.getAttribute("designation"));
		 writer.println("User Email:"+request.getParameter("email"));
		 writer.println("Mobile Number:"+request.getParameter("mobile number"));
		 writer.println("</pre>");
		 writer.println("</body>");
		 writer.println("</html>");
		 
		 
		 }

}
