package com.inautix.training.counselling.controller;

import java.sql.SQLException;
import java.util.List;

import com.inautix.training.counselling.dao.getEligibleCollegeDAO;

public class EligibleCollege {

	public List<String> getEligibleColleges(Integer regno) throws ClassNotFoundException, SQLException, java.lang.NullPointerException {
		getEligibleCollegeDAO dec = new getEligibleCollegeDAO();
		List<String> collegelist = dec.getCollegeList(regno);
		return collegelist;
	}

}
