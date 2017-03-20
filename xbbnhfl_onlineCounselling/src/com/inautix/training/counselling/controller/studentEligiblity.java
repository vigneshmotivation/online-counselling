package com.inautix.training.counselling.controller;

import java.util.List;

import javax.security.auth.login.LoginException;

import com.inautix.training.counselling.dao.StudentDAO;
import com.inautix.training.counselling.domain.Student;
import com.inautix.training.counselling.exception.loginFailure;
import com.inautix.training.counselling.exception.noteligibleexception;

public class studentEligiblity {
	public static List checklist;
    
public studentEligiblity(Student s) throws noteligibleexception {
		/*
		 * checklist will get the list of all eligible student courses
		 */
StudentDAO student = new StudentDAO();
try {
	checklist = student.findEligiblecourses(s);
	noteligibleexception f = new  noteligibleexception();
	if(checklist.isEmpty())
		throw f;
} catch (noteligibleexception e) {
	// TODO Auto-generated catch block
	System.out.println(e.notEligibleException());
} 

}
}