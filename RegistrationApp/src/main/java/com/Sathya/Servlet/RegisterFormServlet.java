package com.Sathya.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterFormServlet")
public class RegisterFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Step 1:READ THE DATA
		String USERNAME=request.getParameter("username");
		String PASSWORD=request.getParameter("password");
		long USERMOBILE=Long.parseLong(request.getParameter("mobile"));
		String Email=request.getParameter("email");
		String GENDER=request.getParameter("Gender");
		String dob=request.getParameter("dob");
		String[] Qualification=request.getParameterValues("qualification");
		String Country=request.getParameter("country");
		String[]Language=request.getParameterValues("language");
		String Comments=request.getParameter("comments");
		//step2:process the data;
		String q=String.join(",",Qualification);
		String l=String.join("-",Language);
		//step3:RENDER THE RESPONSE:
		PrintWriter Writer=response.getWriter();
		response.setContentType("text/html");
		Writer.println("<html>");
		Writer.println("<h1>REGISTER FORM</h1>");
		Writer.println("<body bgcolor=lavender>");
		Writer.println("<br><br>");
		Writer.println("username"+USERNAME);
		Writer.println("<br><br>");
		Writer.println("password:"+PASSWORD);
		Writer.println("<br><br>");
		Writer.println("Email:"+Email);
		Writer.println("<br><br>");
		Writer.println("GENDER:"+GENDER);
		Writer.println("<br><br>");
		Writer.println("date of birth:"+dob);
		Writer.println("<br><br>");
		Writer.println("Qualification:"+q);
		Writer.println("<br><br>");
		Writer.println("country:"+Country);
		Writer.println("<br><br>");
		Writer.println("Languages are known:"+l);
		Writer.println("<br><br>");
		Writer.println("comments:"+Comments);
		Writer.println("<br><br>");
		Writer.println("</body>");
		Writer.println("</html>");
		
		
		 
	}
	 
}
