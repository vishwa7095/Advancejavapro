package com.Sathya.ProductServlet;

import java.io.IOException;

import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;



@WebServlet("/ProductProjectServlet")
@MultipartConfig
public class ProductProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProductProjectServlet() {
        
    }
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//read the data:
		String proId=request.getParameter("proId");
		String proName=request.getParameter("proName");
		String proBrand=request.getParameter("proBrand");
		double proPrice=Double.parseDouble(request.getParameter("proPrice"));
		String proMadeIn=request.getParameter("proMadeIn");
		Date proMfgDate =Date.valueOf(request.getParameter("proMfgDate"));
		Date proExpDate =Date.valueOf(request.getParameter("proExpDate"));
		
		Part part=request.getPart("proImage");
		InputStream inputstream=part.getInputStream();
		byte[] proImage=IOUtils.toByteArray(inputstream);
		
		Part part1=request.getPart("proAudio");
		InputStream inputstream1=part1.getInputStream();
		byte[] proAudio=IOUtils.toByteArray(inputstream1);
		
		Part part2=request.getPart("proVideo");
		InputStream inputstream2=part2.getInputStream();
		byte[] proVideo=IOUtils.toByteArray(inputstream2);
				
		//using above details create the product object:
		product product=new product();
		product.setProId(proId);
		product.setProName(proName);
		product.setProBrand(proBrand);
		product.setProPrice(proPrice);
		product.setProMadeIn(proMadeIn);
		product.setProMfgDate(proMfgDate);
		product.setProExpDate(proExpDate);
		product.setProImage(proImage);
		product.setProAudio(proAudio);
		product.setProVideo(proVideo);
		

		  

		//giving the product object to Dao layer:
		ProjectDao projectDao=new ProjectDao();
		int result=projectDao.save(product);
		
		if(result==1)
		{
			request.setAttribute("saveResult", result);
			RequestDispatcher dispatcher=request.getRequestDispatcher("productList.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			response.setContentType("text/html");
			PrintWriter Writer =response.getWriter();
			Writer.println("data insertion fail check once"+result);
			RequestDispatcher dispatcher=request.getRequestDispatcher("add-product.html");
			dispatcher.forward(request, response);
			

	}
		 
			
		
	
	

}
}
