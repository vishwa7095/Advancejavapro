package com.Sathya.JdbcProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//CRAETION OF TABLE:
public class ProductDao {
	public int CreateProductTable()
	{
	//DECLARE THE RESOURCES:
		Connection conn=null;
		Statement statement=null;
		int res1=0;
		try { 
	//GET THE CONNECTION:
		conn=dbConnection.CreateConnection();
	//STATIC QUERY EXECUTION:
		statement=conn.createStatement();
		String q1="create table Product1(proId number,proName varchar2(30),proPrice number(8,2))";
		 res1=statement.executeUpdate(q1);
		System.out.println("table created successfully...."+res1);
		}
		catch( SQLException e)
		{
			e.printStackTrace();
		}
		return res1;
	}
	
	//SAVE PRODUCT:
	  public int saveProduct(ProductInfo product1)
	  {
		//DECLARE THE RESOURCES:
		  Connection conn=null;
		  PreparedStatement preparedStatement=null;
		  int count=0;
		  try
		  {
		//GET THE CONNECTION:
		  conn=dbConnection.CreateConnection();
		//  CREATE THE PREPAREDSTATEMENT OBJECT:
		  preparedStatement=conn.prepareStatement("insert into product1 values(?,?,?)");
		//  READ THE DATA FROM PRODUCT OBJECT AND SET TO PARAMETERS:
		  	preparedStatement.setInt(1,product1.getProId());
		  	preparedStatement.setString(2,product1.getProName());
		  	preparedStatement.setDouble(3, product1.getProPrice());
		  	count=preparedStatement.executeUpdate();
	  }
		  catch(SQLException e)
		  {
			  e.printStackTrace();
		  }
		  finally
		  {
			  //before release connection check the connection is present or not
			  		try
			  		{
			  			if(conn !=null)
			  			{
			  				conn.close();
			  			}
			  			if(preparedStatement!=null)
			  			{
			  				preparedStatement.close();
			  			}
			  		}
			  		catch(SQLException  e)
			  		{
			  			e.printStackTrace();
			  		}
		  }
		  return count;
	  }
		  
	//PRODUCTID:
		public ProductInfo findbyId(int proId) 
		  {
			ProductInfo p = new ProductInfo();
		//try with resources :once the try block is completed the resources automatically closed
			  try(Connection connection=dbConnection.CreateConnection();
				  PreparedStatement preparedStatement=connection.prepareStatement("select * from product1 where proId=?");)
			  {
				    preparedStatement.setInt(1, proId);
				    ResultSet resultSet =preparedStatement.executeQuery();
				    if(resultSet.next())
				    {
				    	
				    	p.setProId(resultSet.getInt(1));
				    	p.setProName(resultSet.getString(2));
				    	p.setProPrice(resultSet.getDouble(3));
				    	
				    }
				 
			  }
			  
			  catch(SQLException e)
			  {
				  e.printStackTrace();
			  }
			  return p;
		  }
		public List<ProductInfo>getALLProducts()
		{
			List<ProductInfo>product=new ArrayList<ProductInfo>();
			try(Connection connection=dbConnection.CreateConnection();
					Statement statement=connection.createStatement())
			{
				ResultSet resultSet=statement.executeQuery("select * from product1");
				
				while(resultSet.next())
					{
					ProductInfo prod=new ProductInfo();
					prod.setProId(resultSet.getInt(1));
					prod.setProName(resultSet.getString(2));
					prod.setProPrice(resultSet.getDouble(3));
					
					product.add(prod);
					}
			
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return product;		
		}
		//UpdatePrice:
		public int UpdateByPrice(double IncrementValue,double priceRange)
		{
			int count=0;
			//try the resources
			try(Connection connection=dbConnection.CreateConnection();
					PreparedStatement preparedStatement=connection.prepareStatement("update product1 set proPrice=proPrice+? where proPrice>?");)
			{
				preparedStatement.setDouble(1, IncrementValue);
				preparedStatement.setDouble(2,priceRange);
			
				count=preparedStatement.executeUpdate();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return count;
		}
			
			//deleteByID:
			public int DeleteById(int proid)
			{
			int count=0;
			try(Connection connection=dbConnection.CreateConnection();
					PreparedStatement preparedStatement=connection.prepareStatement("delete from product1 where proId=?");)
					{
						preparedStatement.setInt(1,proid);
						
						count=preparedStatement.executeUpdate();
					}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return count;
		  }
			//DELETEBYPRICE:
		public int deleteByprice(double proPrice)
		{
			int count=0;
			try(Connection connection=dbConnection.CreateConnection();
					PreparedStatement preparedStatement=connection.prepareStatement("delete from product1 where proPrice=?"))
			{
				preparedStatement.setDouble(1, proPrice);
				count=preparedStatement.executeUpdate();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return count;
		}
		public int droptable()
		{
			Connection conn=null;
			Statement statement=null;
			int res2=0;
			try
			{
				conn=dbConnection.CreateConnection();
					statement=conn.createStatement();
					String q2="drop table product1";
					 res2=statement.executeUpdate(q2);
					
			}
			 catch(SQLException e)
			{
				 e.printStackTrace();
			}	
			return res2;
		}
}
		
		
		 
	  

