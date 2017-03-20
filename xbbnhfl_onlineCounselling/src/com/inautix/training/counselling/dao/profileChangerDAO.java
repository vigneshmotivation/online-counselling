package com.inautix.training.counselling.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.inautix.training.counselling.domain.StudentProfile;
import com.inautix.training.counselling.exception.sqlException;

public class profileChangerDAO {

	public String myprofileChangerDAO(StudentProfile p) throws ClassNotFoundException, SQLException, sqlException {
		// TODO Auto-generated method stub
		 Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
			Statement stmt = con.createStatement();
			String deletequery = "delete from studentprofile_xbbnhfl where regno ="+p.getRegno();
			ResultSet rs1 = stmt.executeQuery(deletequery);
			String query = "insert into studentprofile_xbbnhfl values("+p.getRegno()+",'"+p.getFathername()+"','"+p.getMothername()+"','"+p.getGender()+"','" +p.getQualification()+"','"+p.getSpecialisation()+"','"+p.getEmail()+"',"+p.getContactnumber()+",'"+p.getName()+"','"+p.getScholarship()+"','"+p.getAddress()+"')";
		    System.out.println(query);
		    ResultSet rs = stmt.executeQuery(query);
		    String deletemarks = "delete from studentmarks_xbbnhfl where regno ="+p.getRegno();
		    ResultSet rs3 = stmt.executeQuery(deletemarks);
			String s1 = p.getSubject1();
	        String s2 = p.getSubject2();
	        String s3 = p.getSubject3();
	        String s4 = p.getSubject4();
	        String s5 = p.getSubject5();
	        int m1 = p.getMark1();
	        int m2= p.getMark2();
	        int m3 = p.getMark3();
	        int m4=p.getMark4();
	        int m5 = p.getMark5();
	        List<Integer> marklist = new ArrayList<Integer>();
	        List<String> subjectlist = new ArrayList<String>();
	       // if(!s1.equalsIgnoreCase("exam name"))
	        { marklist.add(m1);subjectlist.add(s1);}
	      // if(!s2.equalsIgnoreCase("exam name"))
	        { marklist.add(m2);subjectlist.add(s2);}
	        //if(!s3.equalsIgnoreCase("exam name"))
	        { marklist.add(m3);subjectlist.add(s3);}
	        //if(!s4.equalsIgnoreCase("exam name"))
	        { marklist.add(m4);subjectlist.add(s4);}
	        //if(!s5.equalsIgnoreCase("exam name"))
	        { marklist.add(m5);subjectlist.add(s5);}
		
		    if(marklist.isEmpty()||subjectlist.isEmpty())
		    	return "PLEASE CHECK YOUR ACADEMIC CREDENTIALS";
		    else
		    {
		     markUpdationDAO md = new markUpdationDAO(p.getRegno(), subjectlist, marklist);	
		      return "success";
		    }
		
	}

}
