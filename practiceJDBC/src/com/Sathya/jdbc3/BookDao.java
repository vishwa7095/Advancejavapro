package com.Sathya.jdbc3;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDao 
{
	public int save(BookInfo book)
	{
		Connection conn=null;
		PreparedStatement preparedStatement=null;
		int count=0;
		try
		{
			conn=DBconnection2.createConnection();
			preparedStatement = conn.prepareCall("insert into bookValues(?,?,?)");
			
			preparedStatement.setInt(1, book.getBookId());
			preparedStatement.setString(2, book.getBookName());
			preparedStatement.setDouble(3, book.getBookPrice());
			
			count=preparedStatement.executeUpdate();		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
			if(conn!=null)
			{
				conn.close();
				
			}
		}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return count;
		}
	}
}

		




