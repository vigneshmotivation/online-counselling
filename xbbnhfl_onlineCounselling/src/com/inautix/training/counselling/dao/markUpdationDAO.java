package com.inautix.training.counselling.dao;
import java.sql.*;
import java.util.Iterator;
import java.util.List;

import com.inautix.training.counselling.exception.sqlException;
public class markUpdationDAO {

	public markUpdationDAO(int rollno ,List<String> examId,List<Integer> mark)throws sqlException, SQLException, ClassNotFoundException
	{
		try
		{
	 String host = "java sun.jdbc.odbc.jdbcodbcdriver";
	 String user = "shobana";
	 String pwd = "shobana";
	   Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
		
		Statement statement = con.createStatement();
		ResultSet rs ;
		String queryString = "Insert into studentmarks_xbbnhfl values(?,?,?)";
		
		for(int i =0;i<examId.size();i++)
		{
			
					
		PreparedStatement insertprep = con.prepareStatement(queryString);
		insertprep.setInt(1,rollno);
		
		insertprep.setString(2,examId.get(i) );
		
		insertprep.setInt(3,mark.get(i) );
		sqlException e = new sqlException();	
		
		rs = insertprep.executeQuery();
		
		
		if(rs.equals(statement.EXECUTE_FAILED))
		{
			throw (e);
			
			}
		}
		}
		
		catch(sqlException e)
		{
			System.out.println(e);
		}
	}
	}

