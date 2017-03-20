package com.inautix.training.counselling.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class getEligibleCollegeDAO {
	public getEligibleCollegeDAO(){}

	public List<String> getCollegeList(Integer regno) throws ClassNotFoundException, SQLException, java.lang.NullPointerException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
	    Statement stmt = con.createStatement();
		String madhan_query = "select distinct collegeeligiblity_xbbnhfl.collid,studentmarks_xbbnhfl.rollno   from collegeeligiblity_xbbnhfl inner join studentmarks_xbbnhfl on collegeeligiblity_xbbnhfl.examid = studentmarks_xbbnhfl.examid where studentmarks_xbbnhfl.marks > collegeeligiblity_xbbnhfl.mark and studentmarks_xbbnhfl.rollno="+regno;  
	   List<Integer> collidList = new ArrayList<Integer>();//madhan_query is dedicated to my colleague madhan who helped me in framing the sql statement .
	    ResultSet mos = stmt.executeQuery(madhan_query);
	   while(mos.next())
	   {
		   
		   collidList.add(mos.getInt("collid"));
		   
	   }
	   List<String> collegename = new ArrayList<String>();
	   Iterator itr = collidList.iterator();
	   while(itr.hasNext())
	   {
		   int id = (int) itr.next();
			String query = "select collname from college_xbbnhfl where collid ="+id;
		   ResultSet sp = stmt.executeQuery(query);
		   while(sp.next())
		   {
			   collegename.add(sp.getString("collname"));
		   }
		   
	   }
	  				return collegename;
	}
public Integer getcurrentseats(String collegename) throws ClassNotFoundException, SQLException
{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
	Statement stmt1 = con.createStatement();
	String query = "select * from college_xbbnhfl where collname = '" + collegename +"'";
	Integer seat = null;
	ResultSet rs = stmt1.executeQuery(query);
	while(rs.next())
	{
		seat = rs.getInt("seats");
	}
	return seat;
	}
	
}
