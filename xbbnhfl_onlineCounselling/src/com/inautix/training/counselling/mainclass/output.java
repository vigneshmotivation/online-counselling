package com.inautix.training.counselling.mainclass;
import java.sql.SQLException;
import java.util.*;

import com.inautix.training.counselling.controller.EligibleCollege;
import com.inautix.training.counselling.controller.applyCounsellingController;
import com.inautix.training.counselling.controller.registrationController;
import com.inautix.training.counselling.controller.updateStudentMarkController;
import com.inautix.training.counselling.domain.Student;
import com.inautix.training.counselling.domain.newStudent;
import com.inautix.training.counselling.exception.sqlException;
public class output  {
	public static void main(String args[]) throws ClassNotFoundException, sqlException, SQLException
	{
		Scanner sc = new Scanner(System.in);
		newStudent n = new newStudent();
		Student s = new Student();
		String name;
        String registeredpassword,confirmpassword; 
		int choice,regno,torf;
		System.out.println("STEP 1 : REGISTER / LOGIN ");
		System.out.println("1.ENTER YOUR REGISTRATION NUMBER");
		regno = sc.nextInt();
		sc.nextLine();
		registrationController rc = new registrationController();
		torf =rc.registrationCheck(regno);
		if(torf==1)
		{
			System.out.println("Welcome\t"+regno+"\nenter your password ");
			registeredpassword = sc.nextLine();
			System.out.println(rc.passwordCheck(regno, registeredpassword));
		    System.out.println("\n choose what to do :\n1. Update Marks \n2.View eligible colleges \n3.Book a College");
		    choice = sc.nextInt();
		    sc.nextLine();
		    switch(choice)
		    {
		    case 1:
		     {
		    	int examcount,i,mark;
		    	String examId;
		    	HashMap<String,Integer> marklist= new HashMap<String,Integer>();
		    	System.out.println("ENTER THE NUMBER OF EXAMS YOU HAVE TAKEN");
		    	examcount = sc.nextInt();
		    	sc.nextLine();
		    	for(i=0;i<examcount;i++)
		    	{
		    		System.out.println("enter the examId #"+i);
		    		    examId = sc.nextLine();
		    	  	System.out.println("enter your score in " + examId);
		    	  	    mark = sc.nextInt();
		    	  	    sc.nextLine();
		    	  	marklist.put(examId, mark);
		    	  	  
		    	}
		    	updateStudentMarkController m= new updateStudentMarkController(regno,marklist);
		    	break;
		      }
		    case 2:
		    {
		    	List<String> l = new ArrayList<String>();
		    	EligibleCollege se = new EligibleCollege();
		    	l = se.getEligibleColleges(regno);
		    	Iterator itr = l.iterator();
                System.out.println(regno + "LIST OF ELIGIBLE COLLEGES FOR \n"+regno);
		    	while(itr.hasNext())
		    	{
		    		String temp = (String) itr.next();
		    		System.out.println(temp);
		    	}
		    	break;
		     }
		    case 3:
		    {
		    	applyCounsellingController cr = new applyCounsellingController();
		    	List<String> l = new ArrayList<String>();
		    	EligibleCollege se = new EligibleCollege();
		    	l = se.getEligibleColleges(regno);
		    	Iterator itr = l.iterator();
                System.out.println(regno + "You are eligible to apply for the following colleges\n");
		    	while(itr.hasNext())
		    	{
		    		String temp = (String) itr.next();
		    		System.out.println(temp);
		    	}
		    	System.out.println("PLEASE MAKE YOUR CHOICE");
		    	String college = sc.nextLine();
		    	if(!(l.contains(college)))
		    		System.out.println("please enter a college that you are eligible for");
		    	applyCounsellingController c = new applyCounsellingController(regno,college);
		    }
		  }
		}
		else
		{
			System.out.println("You are not registered with counsellor . please a password to complete the registration process");
			registeredpassword = sc.nextLine();
			System.out.println("Re-enter the password again");
			confirmpassword = sc.nextLine();
			if(!registeredpassword.equals(confirmpassword))
			{
				System.out.println("passwords donot match - please try again");
			}
			else
	    	{
			  	System.out.println("Your good name please..");
			  	name = sc.nextLine();
			  	n.setName(name);
			  	n.setRegno(regno);
			  	n.setPassword(registeredpassword);
			  	registrationController register = new registrationController(n);
			  	System.out.println("Congratulations ! You have been successfully registered with counsellor !\n Please login with your registration number and your password ");
			}
			
		}
		
	}

}
