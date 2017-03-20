package com.inautix.training.counselling.mainclass;
import com.inautix.training.counselling.domain.StudentProfile;
import com.inautix.training.counselling.exception.sqlException;
import com.inautix.training.counselling.controller.profileinserterController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class markinsertservelet
 */
@WebServlet("/markinsertservelet")
public class markinsertservelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public markinsertservelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ,NullPointerException {
		HttpSession session = request.getSession();
		int regno = (int)session.getAttribute("studentid");
		String name = request.getParameter("academicname");
		session.setAttribute("registeredname", name);
		int contactnumber= Integer.parseInt(request.getParameter("phoneno"));
		String email= request.getParameter("email");
		String fathername= request.getParameter("fathername");
		String mothername= request.getParameter("mothername");
		String qualification= request.getParameter("highestqualification");
		String specialisation= request.getParameter("specialisation");
		String gender= request.getParameter("gender");
		String mark1=(request.getParameter("mark1"));if(mark1.isEmpty()){mark1="0";}
		String mark2=(request.getParameter("mark2"));if(mark2.isEmpty()){mark2="0";}
		String mark3=(request.getParameter("mark3"));if(mark3.isEmpty()){mark3="0";}
		String mark4=(request.getParameter("mark4"));if(mark4.isEmpty()){mark4="0";}
		String mark5=(request.getParameter("mark5"));if(mark5.isEmpty()){mark5="0";}
		String subject1= request.getParameter("exam1");
		String subject2= request.getParameter("exam2");
		String subject3= request.getParameter("exam3");
		String subject4= request.getParameter("exam4");
		String subject5= request.getParameter("exam5");
		String saddress = request.getParameter("address");
		String sscholarship = request.getParameter("scholarship");
		StudentProfile sp = new StudentProfile();
		sp.setName(name);sp.setContactnumber(contactnumber);sp.setEmail(email);sp.setFathername(fathername);sp.setMothername(mothername);sp.setGender(gender);sp.setQualification(qualification);sp.setRegno(regno);
		sp.setSpecialisation(specialisation);
		sp.setSubject1(subject1);sp.setSubject2(subject2);sp.setSubject3(subject3);sp.setSubject4(subject4);sp.setSubject5(subject5);
		sp.setMark1(Integer.parseInt(mark1));	sp.setMark2(Integer.parseInt(mark2));	sp.setMark3(Integer.parseInt(mark3));	sp.setMark4(Integer.parseInt(mark4));	sp.setMark5(Integer.parseInt(mark5));
		sp.setAddress(saddress);sp.setScholarship(sscholarship);
		profileinserterController pc = new profileinserterController();
		try {
			String s = pc.myprofileinserterController(sp);
			if(s.equals("PLEASE CHECK YOUR ACADEMIC CREDENTIALS"))
			{
				RequestDispatcher rd = request.getRequestDispatcher("/ProfileFirst.jsp");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/StudentDashboard.jsp");
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (sqlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
