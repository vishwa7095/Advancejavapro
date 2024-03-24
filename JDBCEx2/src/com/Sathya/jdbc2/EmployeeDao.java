package com.Sathya.jdbc2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

	public int save(EmployeeInfo emp)
	{
		//DECLARE THE RESOURCES
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		int count=0;
		try
		{
			//GET THE CONNECTION
			connection =DBconnection.CreateConnection();
			//CREATE PS OBJECT
			preparedStatement = connection.prepareStatement("insert into emp values(?,?,?)");
			
			//READ THE DATA FROM EMP OBJECT AND SET TO PARAMETERS
			
			preparedStatement.setInt(1, emp.empID);
			preparedStatement.setString(2, emp.empName);
			preparedStatement.setDouble(3, emp.empSalary);
			
			count = preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(connection!=null)
				{
					connection.close();
				}
				if(preparedStatement!=null)
				{
					preparedStatement.close();
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return count;
		
	}
	
	//find by id
	public EmployeeInfo findbyId(int empId) 
	{
	//TRY WITH RESOURCES
		EmployeeInfo employee=null;
		
	try(Connection connection=DBconnection.CreateConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from emp where id=?"))    
			{
			//set the data to parameter
			preparedStatement.setInt(1, empId);

			//execute the query:
			
			ResultSet resultset=preparedStatement.executeQuery();
			
			
// IF THE RECORD IS PRESENT EXECUTE BELOW CODE,IF THE RECORD IS NOT PRESENT IT RETURNS NULL			
			if(resultset.next())
			{
				//READING THE DATA FROM RESULTSET SETTING TO EMPLOYEE OBJECT
				employee =new EmployeeInfo();
				employee.setEmpID(resultset.getInt(1));
				employee.setEmpName(resultset.getString(2));
				employee.setEmpSalary(resultset.getDouble(3));
			}
			
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		return employee;
	}
	
	
	
	//delete by salary
	
	public int deleteBySalary(double empSalary)
	{
	 int count=0;
	 //try with resources
	 
	 try(Connection connection=DBconnection.CreateConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement("delete from emp where SALARY < ?"))
	 {
		 preparedStatement.setDouble(1,empSalary);
		  count=preparedStatement.executeUpdate();
		 
	 }
	 catch(SQLException e)
	 {
		 e.printStackTrace();
	 }
	 
	return count;
			 
	}
	
	//findAll
	public List<EmployeeInfo>findAll()
	
	{
		List<EmployeeInfo>emps=new ArrayList<EmployeeInfo>();
		try(Connection connection=DBconnection.CreateConnection();
				Statement statement =connection.createStatement())
		{
			//add to resultset
		
			   ResultSet resultset=statement.executeQuery("select * from emp");
			//add the resultset to employee object:
			   while(resultset.next())
			   {
				   EmployeeInfo employee =new EmployeeInfo();
				   employee.setEmpID(resultset.getInt(1));
				   employee.setEmpName(resultset.getString(2));
				   employee.setEmpSalary(resultset.getDouble(3));
				   emps.add( employee);
			   }
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return emps;
	}

	public int updateSalary(double currentSalary,double incSalary) {
		int updateCount=0;
		try {
			Connection connection=DBconnection.CreateConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("update emp set Salary= Salary+? where Salary>?");
			//PASSING THE VALUE TO QUERY?
			     preparedStatement.setDouble(1,incSalary);
			     preparedStatement.setDouble(2, currentSalary);
			//execute the update:
			     updateCount=preparedStatement.executeUpdate();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return updateCount;
		
		
	}
	
}
