package com.Sathya.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HelloWorldServlet() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter Writer=response.getWriter();
		Writer.println("Welcome to the sathaya");
		Writer.println("it is my first servelet application");
		Writer.println("ratan sir woowww");
	}
}
