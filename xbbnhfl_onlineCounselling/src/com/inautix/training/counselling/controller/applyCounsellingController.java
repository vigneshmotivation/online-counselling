package com.inautix.training.counselling.controller;

import java.sql.SQLException;

import com.inautix.training.counselling.dao.applyCounsellingDAO;

public class applyCounsellingController {

	public applyCounsellingController(int regno, String college) throws ClassNotFoundException, SQLException {
	
		applyCounsellingDAO r = new applyCounsellingDAO(regno, college);
	}

	public applyCounsellingController() {
		// TODO Auto-generated constructor stub
	}

	
	
}
