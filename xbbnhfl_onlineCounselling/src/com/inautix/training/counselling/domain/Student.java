package com.inautix.training.counselling.domain;
import java.util.HashMap;
import java.util.ArrayList;

import com.inautix.training.counselling.controller.*;
import com.inautix.training.counselling.exception.*;



 public class Student implements login{

	 private int regno;
	 private String name;
	 HashMap<String,Integer> Marks = new HashMap<String,Integer>();
	 public ArrayList<Integer> interestedCollege = new ArrayList<Integer>(3);
	 public int getRegno() {
		return regno;
	}

	public void setRegno(int regno) {
		this.regno = regno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<String,Integer> getMarks() {
		return Marks;
	}

	public void setMarks(HashMap<String,Integer> marks) {
		Marks = marks;
	}

	 
public ArrayList<Integer> getInterestedCollege() {
	
	
		return interestedCollege;
	}

	public void setInterestedCollege(ArrayList<Integer> interestedCollege) {
		this.interestedCollege = interestedCollege;
	}

public void getCredentials() throws loginFailure {
	try { loginFailure f = new loginFailure(); 	throw(f); }
	catch(loginFailure f)
	{ System.out.println(f.loginException());}
}
}
