package com.inautix.training.counselling.domain;

import java.util.HashMap;
/*
 * This class is supposed to be the base class for course . the idea is that any course should have the
 * following structure ..
 * 
 */
 public class course {
           /*
            * variable declarations ...
            * 
            */
	private String[] eligibleExams;// = new String[10];
	public int courseId ;
	public String courseName;
	public HashMap<Integer, Integer> eligiblityCriteria = new HashMap<Integer, Integer>();
	public HashMap<String,Integer > colleges = new HashMap<String, Integer>();
	public String[] getEligibleExams() {
		return eligibleExams;
	}
	public void setEligibleExams(String[] eligibleExams) {
		this.eligibleExams = eligibleExams;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public HashMap<Integer, Integer> getEligiblityCriteria() {
		return eligiblityCriteria;
	}
	public void setEligiblityCriteria(HashMap<Integer, Integer> eligiblityCriteria) {
		this.eligiblityCriteria = eligiblityCriteria;
	}
	public HashMap<String, Integer> getColleges() {
		return colleges;
	}
	public void setColleges(HashMap<String, Integer> colleges) {
		this.colleges = colleges;
	}
	public void removeCollege( int CollegeId){}
}
