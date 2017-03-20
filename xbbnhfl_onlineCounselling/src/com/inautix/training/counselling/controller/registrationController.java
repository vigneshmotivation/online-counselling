package com.inautix.training.counselling.controller;
import com.inautix.training.counselling.dao.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.inautix.training.counselling.dao.markUpdationDAO;
import com.inautix.training.counselling.dao.registrationDAO;
import com.inautix.training.counselling.domain.newStudent;
import com.inautix.training.counselling.exception.sqlException;

public class registrationController {


	public registrationController(newStudent student) throws sqlException, SQLException, ClassNotFoundException
	{
		registrationDAO mk = new registrationDAO(student);
	}
	public registrationController() {
		// blank constructor - does nothing
	}
	public int registrationCheck(int regno) throws ClassNotFoundException, sqlException, SQLException
	{
		int no;
		List<Integer> ctrllist = new ArrayList<Integer>();
		registrationDAO d = new registrationDAO();
		ctrllist = d.getalreadypresent();
		if(ctrllist.contains(regno))
			no = 1;
		
		else 
			no = 0;
		return no;
		
	}
	public String passwordCheck(int regno,String password) throws ClassNotFoundException, SQLException
	{
		 registrationDAO d = new registrationDAO();
		String dbpwd = d.getPasswordForUser(regno);
		if(dbpwd.equals(password))
		return "you have successfully logged in !";
		else
		return "wrong password...please try again";
	}

}
