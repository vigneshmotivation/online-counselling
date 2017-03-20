package com.inautix.training.counselling.dao;
import com.inautix.training.counselling.controller.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.inautix.training.counselling.domain.StudentProfile;

public class profileinserterDAO {

	public profileinserterDAO(StudentProfile p) throws ClassNotFoundException, SQLException {
		 Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
			Statement stmt = con.createStatement();
			String query = "insert into studentprofile_xbbnhfl values("+p.getRegno()+",'"+p.getFathername()+"','"+p.getMothername()+"','"+p.getGender()+"','" +p.getQualification()+"','"+p.getSpecialisation()+"','"+p.getEmail()+"',"+p.getContactnumber()+",'"+p.getName()+"','"+p.getScholarship()+"','"+p.getAddress()+"')";
		    System.out.println(query);
			ResultSet rs = stmt.executeQuery(query);
	
			
	}

}
