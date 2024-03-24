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

 
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final ServletResponse response = null;
	private ServletRequest request;

     
    public EmployeeServlet() {
         
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	//step1: get the data from client
	
	int id=Integer.parseInt( request.getParameter("empId"));
    String n= request.getParameter("empName");
	int b=Integer.parseInt( request.getParameter("empBill"));
	double hra,da,pf;
	 
	 

	if(b>=50000) 
	{
		hra=0.3*b;
		da=0.1*b;
		pf=0.06*b;
	}
	
	else if(b<50000&&b>25000){
		hra=0.2*b;
		da=0.05*b;
		pf=0.03*b;
	}
	else {
		hra=0.1*b;
		da=0.03*b;
		pf=0.02*b;
	}
	gross=b+hra+da-pf;
	
	
	//step3:render the response the client
	
	response.setContentType("text/html");
	
	  PrintWriter writer=response.getWriter();
	  writer.println("<html>");
	  
	  writer.println("<body bgcolor='green'>");
	  
	  writer.println("<h1>Employee Details:</h1>");
	 
	  writer.println("<br><br>");
	            
	  writer.println("Employee Id:              "+id);
	  writer.println("<br><br>");
	  
	  writer.println("Employee Name:            "+n);
	  writer.println("<br><br>");
	  
	  writer.println("Employee BasicSalary :    "+b);
	  writer.println("<br><br>");
	  
	  writer.println("HRA  AMOUNT:               "+hra);
	  writer.println("<br><br>");
	  
	  writer.println("DA  AMOUNT:                "+da);
	  writer.println("<br><br>");
	  
	  writer.println("PF  AMOUNT:                "+pf);
	  writer.println("<br><br>");
	  
	  writer.println("GrossSalary:              "+gross);
	  
	  
	  writer.println("</body>");
	  
	  writer.println("</html>");
	 
 }

	 
	}



