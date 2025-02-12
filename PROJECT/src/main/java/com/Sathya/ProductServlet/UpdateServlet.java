package com.Sathya.ProductServlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
 
@WebServlet("/UpdateServlet")
@MultipartConfig
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
     		
     		String proId=request.getParameter("proId");
    		String proName=request.getParameter("proName");
    		String proBrand=request.getParameter("proBrand");
    		Double proPrice=Double.parseDouble(request.getParameter("proPrice"));
    		String proMadeIn=request.getParameter("proMadeIn");
    		Date proMfgDate =Date.valueOf(request.getParameter("proMfgDate"));
    		Date proExpDate =Date.valueOf(request.getParameter("proExpDate"));
   
    		//using above details create the product object:
    		product product=new product();
    		product.setProId(proId);
    		product.setProName(proName);
    		product.setProBrand(proBrand);
    		product.setProPrice(proPrice);
    		product.setProMadeIn(proMadeIn);
    		product.setProMfgDate(proMfgDate);
    		product.setProExpDate(proExpDate);
    		
    		Part filePart=request.getPart("newProImage");
    		if(filePart!=null &&filePart.getSize()>0)
    		{
    			InputStream inputStream=filePart.getInputStream();
    			byte[] newImageData=IOUtils.toByteArray(inputStream);
    			product.setProImage(newImageData);
    		}
    		else
    			
    		{
	    		String s = request.getParameter("existingimage");
				byte[] existingImage = Base64.getDecoder().decode(s);
				product.setProImage(existingImage);
    		}
    		
    		ProjectDao Dao=new ProjectDao();
    		int updatecount=Dao.updateById(product);
    		if(updatecount==1)
    		{
    			request.setAttribute("updateresult",updatecount);
    			RequestDispatcher dispatcher=request.getRequestDispatcher("productList.jsp");
    			dispatcher.forward(request, response);
    		}
    		else
    		{
    			request.setAttribute("updateresult", updatecount);
				RequestDispatcher dispatcher = request.getRequestDispatcher("productList.jsp");
				dispatcher.forward(request, response);
    		}
    		
    		
	}

}
