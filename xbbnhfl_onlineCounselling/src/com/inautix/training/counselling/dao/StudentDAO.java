package com.inautix.training.counselling.dao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;
import java.util.Set;

import com.inautix.training.counselling.controller.studentEligiblity;
import com.inautix.training.counselling.domain.*;
import com.inautix.training.counselling.exception.loginFailure;
import com.inautix.training.counselling.exception.noteligibleexception;
public class StudentDAO {

	/* 
	 * ******************************variable declarations********************************************************
	 * 
	 */
	public studentEligiblity se ;//controller class initialization
	public Student s = new Student();// student object
	public course course = new course();//course object
	private College college = new College();//college object
	List<Student> studentList = new ArrayList<Student>();// for storing the student preference of colleges
	List<College> collegeList = new ArrayList<College>();// for storing the list of all colleges 
	List<College> eligibleCollegelist = new ArrayList<College>();//for storing the list of college that satisfy student preference
	List<String> finaleligiblity = new ArrayList<String>();//the final list of colleges for which the student is eligible based on his mark
	/**
	 * Iterator itrstudent = studentList.iterator(); - use this to check for all the students                                            
	 *  usage :
	 *   while(itrstudent.hasnext()
	 *     { Student s1 =  itrstudent.next();
	 *       findEligiblecourses(s1);
	 *     }
	 *     
	 */
	Iterator itrcollege = collegeList.iterator();
	
	//********************************************END OF VARIABLE DECLARATIONS*************************************

	private void getPreferredColleges(Student s)throws noteligibleexception
	{
		/*
		 * This function returns the list of colleges as per the student preferences
		 */
		Iterator<Integer> it = s.getInterestedCollege().iterator();
		while(it.hasNext())
		{
          int csrid = it.next();
          //get the college id which matches with the student preference
          while(itrcollege.hasNext())
          {
        	  College c1 =(College)itrcollege.next();
        	  if(c1.getCollegeId()==csrid)
        	  {
        		  eligibleCollegelist.add(c1);
        	  }
          }
          
		}
	}
	public List findEligiblecourses(Student s) throws noteligibleexception
	{
		getPreferredColleges(s);
		Iterator eligibleListIterator = eligibleCollegelist.iterator();
		while(eligibleListIterator.hasNext())
		{
			College c = (College)eligibleListIterator.next();
			HashMap<String,Integer> collcriteria = c.getCourseEligiblity();
			HashMap<String,Integer> studentMark = s.getMarks();
			Set<String> studentSubcode = studentMark.keySet();	
			Iterator studentcodeIterator = studentSubcode.iterator();
			while(studentcodeIterator.hasNext())
			{
				String cmpstring = (String)studentcodeIterator.next();
				if(collcriteria.containsKey(cmpstring))
				{
					int stdmark = studentMark.get(cmpstring);
					int collmark = collcriteria.get(cmpstring);
					if(stdmark >= collmark)
					{
						finaleligiblity.add(cmpstring);
					}
				}
			}
		}
		return finaleligiblity;
	}
}
