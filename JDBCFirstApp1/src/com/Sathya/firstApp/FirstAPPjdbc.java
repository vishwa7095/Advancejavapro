package com.Sathya.firstApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstAPPjdbc {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
			//STEP:1 LOAD THE DRIVER
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Loaded Successfully....");
		
		
		//STEP:2 CREATE THE CONNECTION
		
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","viswa","welcome");
		System.out.println("Data Base is a connected successfully....");
		
		//STEP:3 PROCESS THE QUIERY
		Statement Statement=conn.createStatement();
		
		String q1="create table emp(id number,name varchar2(20),salary number)";
		int res1=Statement.executeUpdate(q1);
		System.out.println("table created successfully....."+res1);
		
		
		
		//STEP:4 CLOSE THE RESOURCES
		conn.close();
		System.out.println("Connection closed successfull");
	}

}
