package com.Sathya.ProductServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {

		public static Connection CreateConnection() {
			Connection connection = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				connection = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe", "viswa", "welcome");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return connection;

}
}
