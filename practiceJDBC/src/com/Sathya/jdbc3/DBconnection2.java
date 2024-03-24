package com.Sathya.jdbc3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection2 {

	public static Connection createConnection()
	{
		Connection conn=null;
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn=DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","viswa","welcome");
	}
	catch(ClassNotFoundException | SQLException e)
	{
		e.printStackTrace();
	}
	return conn;

	}
}
