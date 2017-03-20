package com.inautix.training.counselling.dao;

import com.inautix.training.counselling.controller.studentEligiblity;
import com.inautix.training.counselling.domain.Student;
import com.inautix.training.counselling.exception.noteligibleexception;

import java.util.HashMap;
import java.util.List;
import java.sql.*;
public class CounsellingProcess extends studentEligiblity{
	List eligibleList = studentEligiblity.checklist;
    HashMap <String,Integer> seatlist = new HashMap<String, Integer>();// GET SEAT LIST FROM THE COLLEGE DATABASE 
	public CounsellingProcess(Student s) throws noteligibleexception {
				super(s);
		int activeseat = seatlist.get(eligibleList.get(0));// gets the total number of seats in the first college as per student preference
		activeseat = activeseat-1;
		seatlist.put((String) eligibleList.get(0), activeseat);//upates seat ...make sure to update this in the database
	}
	
	

}
