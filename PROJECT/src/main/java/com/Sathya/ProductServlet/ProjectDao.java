 package com.Sathya.ProductServlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProjectDao {
    public int save(product product) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int count = 0;
        try {
            // Establish database connection
            connection = Dbconnection.CreateConnection();

            // Prepare SQL statement for insertion
            preparedStatement = connection.prepareStatement("insert into product2 values(?,?,?,?,?,?,?,?,?,?)");

            // Set values for each parameter in the prepared statement 
            preparedStatement.setString(1, product.getProId());
            preparedStatement.setString(2, product.getProName());
            preparedStatement.setDouble(3, product.getProPrice());
            preparedStatement.setString(4, product.getProBrand());
            preparedStatement.setString(5, product.getProMadeIn());
            preparedStatement.setDate(6, product.getProMfgDate());
            preparedStatement.setDate(7, product.getProExpDate());
            preparedStatement.setBytes(8, product.getProImage());
            preparedStatement.setBytes(9, product.getProAudio());
            preparedStatement.setBytes(10,product.getProVideo());
            // Execute the SQL statement and get the number of affected rows
            count = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // Handle any SQL exceptions
            e.printStackTrace();
        } finally {
            // Close resources in reverse order of their creation to avoid resource leaks
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // Return the count of affected rows (0 if no rows were inserted)
        return count;
    }
    //method:
public List<product> findAll()
	
	{
		List<product>productList=new ArrayList<product>();
		try(Connection connection=Dbconnection.CreateConnection();
				Statement statement =connection.createStatement())
		{
			//add t
		
			   ResultSet resultset=statement.executeQuery("select * from product2");
			//add theto employee object:
			   while(resultset.next())
			   {
				    product product =new product();
				   product.setProId(resultset.getString(1));
				   product.setProName(resultset.getString(2));
				   product.setProPrice(resultset.getDouble(3));
				   product.setProBrand(resultset.getString(4));
				   product.setProMadeIn(resultset.getString(5));
				   product.setProMfgDate(resultset.getDate(6));
				   product.setProExpDate(resultset.getDate(7));
				   product.setProImage(resultset.getBytes(8));
				   product.setProAudio(resultset.getBytes(9));
				   product.setProVideo(resultset.getBytes(10));
				   
				   productList.add(product);
			   }
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return productList;
	}
public int deleteById(String proId)
{
 int count=0;
 //try with resources
 
 try(Connection connection=Dbconnection.CreateConnection();
		 PreparedStatement preparedStatement = connection.prepareStatement("delete from product2 where proId= ?"))
 {
	 preparedStatement.setString(1, proId);
	  count=preparedStatement.executeUpdate();
	 
 }
 catch(SQLException e)
 {
	 e.printStackTrace();
 }
 
return count;
		 
}
public product findbyId(String proId) 
{
//TRY WITH RESOURCES
	product products=null;
	
try(Connection connection=Dbconnection.CreateConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from product2 where proId=?"))    
		{
		//set the data to parameter
		preparedStatement.setString(1, proId);

		//execute the query:
		
		ResultSet resultset=preparedStatement.executeQuery();
		
		
//IF THE RECORD IS PRESENT EXECUTE BELOW CODE,IF THE RECORD IS NOT PRESENT IT RETURNS NULL			
		if(resultset.next())
		{
			//READING THE DATA FROM RESULTSET SETTING TO EMPLOYEE OBJECT
			products =new product();
			products.setProId(resultset.getString("proId"));
			products.setProName(resultset.getString("proName"));
			products.setProPrice(resultset.getDouble("proPrice"));
			products.setProBrand(resultset.getString("proBrand"));
			products.setProMadeIn(resultset.getString("proMadeIn"));
			products.setProMfgDate(resultset.getDate("proMfgDate"));
			products.setProExpDate(resultset.getDate("proExpDate"));
			products.setProImage(resultset.getBytes("proImage"));
				 
		}
		
		}
		catch(SQLException e)
		{
			e.printStackTrace() ;
		}
	return products;
}
public int  updateById(product products)
{
	String sql="update product2 set proName=?,proPrice=?,proBrand=?,proMadeIn=?,proMfgDate=?,ProExpDate=?,ProImage=? where proId=?";
	int updateresult=0;
	try(Connection connection=Dbconnection.CreateConnection())
	{
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1,products.getProName());
		preparedStatement.setDouble(2,products.getProPrice());
		preparedStatement.setString(3,products.getProBrand());
		preparedStatement.setString(4,products.getProMadeIn());
		preparedStatement.setDate(5,products.getProMfgDate());
		preparedStatement.setDate(6,products.getProExpDate());
		preparedStatement.setBytes(7,products.getProImage());
		preparedStatement.setString(8,products.getProId());
		updateresult=preparedStatement.executeUpdate();
		
	}
	catch(SQLException e) 
	{
		e.printStackTrace();
	}
	return updateresult;
}
 

}