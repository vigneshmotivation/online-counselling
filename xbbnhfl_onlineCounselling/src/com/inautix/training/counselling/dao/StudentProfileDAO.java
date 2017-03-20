
package com.inautix.training.counselling.dao;

import java.sql.Connection;
import java.util.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.inautix.training.counselling.domain.Student;
import com.inautix.training.counselling.domain.StudentProfile;

public class StudentProfileDAO {
	public Connection con;
	public StudentProfileDAO() throws ClassNotFoundException, SQLException
	{
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		 con = DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
	}

	private Student studentprofile(int regno) throws SQLException
	{
		try{
	
		Student s = new Student();
		Statement stmt = con.createStatement();
		String queryString = "select studentname from student_xbbnhfl where regno = ?";
		PreparedStatement ps = con.prepareStatement(queryString);
		ps.setInt(1, regno);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next())
	{
		s.setName(rs.getString("studentname"));
	}
		return s;
	}
		
		finally
	{
		con.close();
	}
}
	public StudentProfile otherDetails(Integer regno) throws SQLException
	{
		StudentProfile sp = new StudentProfile();
		Statement stmt = con.createStatement();
		String queryString = "select * from studentprofile_xbbnhfl where regno = ?";
		PreparedStatement ps = con.prepareStatement(queryString);
		ps.setInt(1, regno);
		ResultSet rs = ps.executeQuery();
		/*
		 * *************** CODE TO GET STUDENTS NON ACADEMIC DETAILS ************************************
		 */
		while(rs.next())
	{
			
		sp.setName(rs.getString("SNAME"));
		sp.setAddress(rs.getString("ADDRESS"));
		sp.setContactnumber(rs.getInt("PHONE"));
		sp.setFathername(rs.getString("FATHERNAME"));
		sp.setMothername(rs.getString("MOTHERNAME"));
		sp.setGender(rs.getString("GENDER"));
		sp.setEmail(rs.getString("EMAIL"));
		sp.setQualification(rs.getString("QUALIFICATION"));
		sp.setSpecialisation(rs.getString("SPECIALISATION"));
		sp.setScholarship(rs.getString("SCHOLARSHIP"));
		sp.setRegno(regno);
	}
		/*
		 * ***********************CODE TO GET STUDENTS ACADEMIC DETAILS**************************************
		 */
		String subjectString = "select * from studentmarks_xbbnhfl where rollno ="+regno;
		System.out.println(subjectString);
		List<String> subjectlist = new ArrayList<String>();
		List<String> finalsubjectlist = new ArrayList<String>();
		List<Integer> marklist = new ArrayList<Integer>();
		PreparedStatement ps2 = con.prepareStatement(queryString);
		ps2.setInt(1, regno);
		ResultSet rs2 = stmt.executeQuery(subjectString);
		while(rs2.next())
		{
			String rsfsd = rs2.getString("EXAMID");
			subjectlist.add(rsfsd);//rs2.getString("EXAMID")
		}
		Iterator itr = subjectlist.iterator();
		int count =1;
		while(itr.hasNext())
		{
			
			String subject = (String)itr.next();
			String subjectmarkquery = "select marks from studentmarks_xbbnhfl where rollno ="+regno+" and examid='"+subject+"'";
			ResultSet rs3 = stmt.executeQuery(subjectmarkquery);
			while(rs3.next())
			{
				int mark = rs3.getInt("Marks");
				
				finalsubjectlist.add(subject);marklist.add(mark);
			}
	   
		}
		  sp.setSubject1(finalsubjectlist.get(0));
		     sp.setMark1(marklist.get(0));
		     sp.setSubject2(finalsubjectlist.get(1));
		     sp.setMark2(marklist.get(1));
		     sp.setSubject3(finalsubjectlist.get(2));
		     sp.setMark3(marklist.get(2));
		     sp.setSubject4(finalsubjectlist.get(3));
		     sp.setMark4(marklist.get(3));
		     sp.setSubject5(finalsubjectlist.get(4));
		     sp.setMark5(marklist.get(5));	
		
		
		return sp;
	}
		
}
