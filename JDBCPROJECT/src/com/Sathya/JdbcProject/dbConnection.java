package com.Sathya.JdbcProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
	public static Connection CreateConnection()
	{
		Connection conn=null;
		try
		{
		//LOAD THE DRIVER:	
			Class.forName("oracle.jdbc.driver.OracleDriver");
		//CREATE THE CONNECTION:
			 conn=DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","viswa","welcome");
			
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		 return conn;
	}
}
