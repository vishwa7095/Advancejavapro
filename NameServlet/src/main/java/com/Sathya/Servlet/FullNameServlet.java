package com.Sathya.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FullNameServlet")
public class FullNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final ServletResponse response = null;
	private ServletRequest request;
    public FullNameServlet() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
		String firstname=request.getParameter("firstname");
		String middlename=request.getParameter("middlename");
		String lastname=request.getParameter("lastname");
	String fullname;
            	 fullname=firstname+" "+middlename+" "+lastname;
	
		PrintWriter Writer =response.getWriter();
		response.setContentType("text/html");
		Writer.println("<html>");
		Writer.println("<h1>FULL NAME</h1>"+fullname);
		Writer.println("</html>");	

	}
}


