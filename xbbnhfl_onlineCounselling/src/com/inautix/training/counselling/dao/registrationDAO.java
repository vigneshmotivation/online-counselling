package com.inautix.training.counselling.dao;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.inautix.training.counselling.domain.newStudent;
import com.inautix.training.counselling.exception.sqlException;
public class registrationDAO extends DbConnection{
	public static Connection con;
	public Statement stmt;

	public registrationDAO(newStudent s)throws sqlException,SQLException, ClassNotFoundException
	{
		
		try
		{
	 String host = "java sun.jdbc.odbc.jdbcodbcdriver";
	 String user = "shobana";
	 String pwd = "shobana";
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	 con = DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
		
		Statement statement = con.createStatement();
		ResultSet rs;
		/*Insert regno and name into student_xbbnhfl table */
		String queryString = "Insert into student_xbbnhfl values(?,?)";
		PreparedStatement insertstudentprep = con.prepareStatement(queryString);
		insertstudentprep.setInt(1,s.getRegno());
		insertstudentprep.setString(2, s.getName());
		sqlException e = new sqlException();	
		rs = insertstudentprep.executeQuery();
		if(rs.equals(statement.EXECUTE_FAILED))
		{
			throw (e);
			
			}
		/*Insert regname and password into studentlogin_xbbnhfl table*/
		String queryString2 = "Insert into studentlogin_xbbnhfl values(?,?)";
		
		PreparedStatement insertstudentlogin = con.prepareStatement(queryString);
		insertstudentlogin.setInt(1,s.getRegno());
		insertstudentlogin.setString(2, s.getPassword());
		sqlException f = new sqlException();	
		//System.out.println(insertstudentlogin.toString());
		String example = "insert into studentlogin_xbbnhfl values("+s.getRegno()+",'"+s.getName()+"')";
		System.out.println(example);
		rs = statement.executeQuery(example);
		if(rs.equals(statement.EXECUTE_FAILED))
		{
			throw (f);
			
			}
		con.commit();
		}
		catch(sqlException f)
		{
			System.out.println(f);
		}
	}
	
	public registrationDAO()throws SQLException,ClassNotFoundException
	{
		 String host = "java sun.jdbc.odbc.jdbcodbcdriver";
		 String user = "shobana";
		 String pwd = "shobana";
		   Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
			
		
	}
	public List getalreadypresent() throws SQLException, ClassNotFoundException
	{
		List<Integer> checklist = new ArrayList<Integer>();  
		Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
		Statement statement = con.createStatement();
		String query = "select * from student_xbbnhfl ";
		ResultSet rs = statement.executeQuery(query);
		while(rs.next())
		{
			checklist.add(rs.getInt("regno"));
		}
		return checklist;
	}
	public String getPasswordForUser(int regno) throws ClassNotFoundException, SQLException
	{
		String pwd="";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
	    Statement statement = con.createStatement();
	    String query = "select * from studentlogin_xbbnhfl where regno = ? ";
	PreparedStatement ps = con.prepareStatement(query);
	ps.setInt(1, regno);
	ResultSet rs = ps.executeQuery();
	while(rs.next())
	 {pwd =rs.getString("pwd");}
	return pwd;
	}
	
}
