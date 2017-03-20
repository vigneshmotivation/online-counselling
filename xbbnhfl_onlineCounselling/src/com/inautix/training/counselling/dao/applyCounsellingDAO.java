package com.inautix.training.counselling.dao;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class applyCounsellingDAO {

	public applyCounsellingDAO()
	{	}
	public applyCounsellingDAO(Integer regno, String college) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
	    Statement stmt = con.createStatement();	
	    List<Integer> alreadypresent = new ArrayList<Integer>();
	    String checkquery = "select regno from finallist_xbbnhfl";
	    ResultSet checkSet = stmt.executeQuery(checkquery);
	    while(checkSet.next())
	    {
	    	alreadypresent.add(checkSet.getInt("regno"));
	    }
	    if(alreadypresent.contains(regno))
	    {
	    	System.out.println("You have already selected a college");
	    }
	    else
	    {
	    	Integer collegeid = null;
	    	String collegeidgen = "select collid from college_xbbnhfl where collname = '" + college + "'";
	    	ResultSet sr = stmt.executeQuery(collegeidgen);
	    	while(sr.next())
	    	{
	    		collegeid = sr.getInt("collid");
	    	}
	    	String insertQuery = "insert into finallist_xbbnhfl values("+regno+","+collegeid+",'"+college+"')";
	    	System.out.println(insertQuery);
	    	String appliedCollegequery = "update college_xbbnhfl set seats = seats-1 where collname = '" + college +"'";
	    	ResultSet consel = stmt.executeQuery(insertQuery);
	    	if(consel.equals(stmt.EXECUTE_FAILED))
	    	{
	    		System.out.println("Unable to complete the process. please try again later");
	    	}
	    	ResultSet consel1 = stmt.executeQuery(appliedCollegequery);
	    	if(consel1.equals(stmt.EXECUTE_FAILED))
	    	{
	    		System.out.println("Unable to complete the process. please try again later");
	    	}
	    }
	    
	}
	public String checkalreadyapplied(Integer regno) throws SQLException, ClassNotFoundException
	{
		 String college ="";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
	    Statement stmt = con.createStatement();	
	    List<Integer> alreadypresent = new ArrayList<Integer>();
	    String checkquery = "select regno from finallist_xbbnhfl";
	    ResultSet checkSet = stmt.executeQuery(checkquery);
	    while(checkSet.next())
	    {
	    	alreadypresent.add(checkSet.getInt("regno"));
	    }
	   
		if(alreadypresent.contains(regno))
	    {
	    	 String checkquery1 = "select collegename from finallist_xbbnhfl where regno =" + regno;
	 	    ResultSet checkSet1 = stmt.executeQuery(checkquery1);
	 	    while(checkSet1.next())
	 	    {
	 	  college= checkSet1.getString("collegename");
	 	    }	
	    }
	    else{
	    	
	     college= "NO COLLEGE ASSIGNED YET";
	    }
		return college;
	
	}

}
