package com.inautix.training.counselling.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.inautix.training.counselling.dao.updateStudentMarkDAO;

public class updateStudentMarkController {

	public updateStudentMarkController(int regno,
			HashMap<String, Integer> marklist) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
		ArrayList<String> examcode = new ArrayList<String>();
		ArrayList<Integer> marks = new ArrayList<Integer>();
		int i;
		Collection<Integer> markin = new ArrayList<Integer>();
	//	marks = (ArrayList<Integer>) marklist.values();
		Collection<String> examin = new ArrayList<String>();
		markin = marklist.values();
		examin = marklist.keySet();
		updateStudentMarkDAO d = new updateStudentMarkDAO(regno,examin,markin);
	}

}
