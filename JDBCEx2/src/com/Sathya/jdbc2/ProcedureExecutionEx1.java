package com.Sathya.jdbc2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class ProcedureExecutionEx1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","viswa","welcome");
//call the procedure:
		CallableStatement callablestatement=conn.prepareCall("{call getSal(?,?)}");
		//set the input:
		callablestatement.setInt(1, 1001);
	//register one value to store the output:
		callablestatement.registerOutParameter(2, Types.FLOAT);
	//execute the procedures the output will be stored in register parameters:
		callablestatement.executeUpdate();
	//print the output:
		System.out.println(callablestatement.getFloat(2));
		conn.close();
	}

}
