package com.inautix.training.counselling.domain;

import java.util.HashMap;

import com.inautix.training.counselling.controller.*;
import com.inautix.training.counselling.exception.loginFailure;




public class College implements login {
	
	//***************** class objects *******************
	
	private course course;
	private Student student;
	private College college;
	//****************** Variables *********************
	
	public int collegeId ;
	public course getCourse() {
		return course;
	}
	public void setCourse(course course) {
		this.course = course;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public int getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public course getC() {
		return c;
	}
	public void setC(course c) {
		this.c = c;
	}
	public HashMap<String, Integer> getCourseEligiblity() { //courseid , marks
		return courseEligiblity;
	}
	public void setCourseEligiblity(HashMap<String, Integer> courseEligiblity) {
		this.courseEligiblity = courseEligiblity;
	}
	public String collegeName;
	
	//***************** Methods *************************
	
	/* use addCollege() method for adding the course to the 
	 * college
	 *  
	 *  use removeCollge() method for removing the course from a 
	 *  particular college
	 */
	
	course c = new course();
	HashMap<String,Integer> courseEligiblity = new HashMap<String,Integer>(); // courseid,marks
	public void getCredentials() throws loginFailure{
		
	}
}
