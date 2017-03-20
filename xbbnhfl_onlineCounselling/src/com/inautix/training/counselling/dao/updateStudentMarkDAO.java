package com.inautix.training.counselling.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class updateStudentMarkDAO {

	public updateStudentMarkDAO(int regno, Collection<String> examcode,
			Collection<Integer> marks) throws ClassNotFoundException, SQLException {
	      int count = 1;
		  Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
	      Statement stmt = con.createStatement();
	      System.out.println(marks);
	      String querystring = "insert into studentmarks_xbbnhfl values(?,?,?)";
	      PreparedStatement ps = con.prepareStatement(querystring);
	      Iterator markiterator = marks.iterator();
	      Iterator examcodeiterator = examcode.iterator();
	      ResultSet rs;
	      while(markiterator.hasNext())
	      {
	    	  String example ="insert into studentmarks_xbbnhfl values("+regno+",'"+(String)examcodeiterator.next()+"',"+(int)markiterator.next()+")";
	    	  System.out.println(example);
	    	  rs = stmt.executeQuery(example);
	    	/**  ps.setInt(1, regno);
	    	  ps.setString(2, examcodeiterator.next().toString());
	    	  ps.setInt(3, (int) markiterator.next());
	    	  System.out.println(ps.executeQuery().toString());
	    	  rs = ps.executeQuery();
	    	  if(rs.equals(Statement.EXECUTE_FAILED))
	    			  {
	    		  count = -1;
	    		  throw new SQLException();
	    			  }
	    			  **/
	    	  
	      }
	      con.commit();
	if(count==-1)
	{System.out.println("Error in performing sql operation...please try again later");}
	else
	{System.out.println("Execution successful");}	
	
	
	}
	

}
