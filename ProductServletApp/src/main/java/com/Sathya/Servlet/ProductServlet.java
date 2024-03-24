 package com.Sathya.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ProductServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int proId = Integer.parseInt(request.getParameter("proId"));
        String proName = request.getParameter("proName");
        int proPrice = Integer.parseInt(request.getParameter("proPrice"));
        int proQuantity = Integer.parseInt(request.getParameter("proQuantity"));

        int totalBill = proPrice * proQuantity;
        double netPrice;
        double discount = 0;

        if (totalBill < 1000) {
            netPrice = totalBill;
        } else if (totalBill >= 1000 && totalBill < 5000) {
            discount = totalBill * 0.05;
            netPrice = totalBill - discount;
        } else if (totalBill >= 5000 && totalBill < 10000) {
            discount = totalBill * 0.1;
            netPrice = totalBill - discount;
        } else {
            discount = totalBill * 0.15;
            netPrice = totalBill - discount;
        }

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<body bgcolor=pink>");
        writer.println("<br><br>");
        writer.println("Product id=" + proId);
        writer.println("<br><br>");
        writer.println("Product name=" + proName);
        writer.println("<br><br>");
        writer.println("Product price=" + proPrice);
        writer.println("<br><br>");
        writer.println("Product Quantity=" + proQuantity);
        writer.println("<br><br>");
        writer.println("Product total bill.....=" + totalBill);
        writer.println("<br><br>");
        writer.println("Product discount.....=" + discount);
        writer.println("<br><br>");
        writer.println("Product net price.....=" + netPrice);
        writer.println("<br><br>");
        writer.println("</html>");
    }
}
