package com.Sathya.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String Status;
		if(username.equals("vishwa") && password.equals("vishwa@123"))
		{
			Status="LOGIN SUCCESSFULL...";
		}
		else
		{
			Status="LOGIN FAILED";
		}
		PrintWriter Writer =response.getWriter();
		response.setContentType("text/html");
		Writer.println("<html>");
		Writer.println("<h1>LOGIN STATUS....</h1>"+Status);
		Writer.println("</html>");
	
	}
}


