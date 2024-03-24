package com.Sathya.JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class creatingtable {

	public static void main(String[] args)throws ClassNotFoundException,SQLException{
     Class.forName("oracle.jdbc.driver.OracleDriver");
     Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","viswa","welcome");
     Statement statement=connection.createStatement();
     String q1="create table clothes(cid number,cname varachar(30),cprice number)";
     int res1=statement.executeUpdate(q1);
     System.out.println("table is created successfull"+res1);
//     String q2="drop table clothes";
//     int res2=statement.executeUpdate(q2);
//     System.out.println("table is dropped successfully"+res2);
	}


}
