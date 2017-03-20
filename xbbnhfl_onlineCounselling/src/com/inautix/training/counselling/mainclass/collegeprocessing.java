package com.inautix.training.counselling.mainclass;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inautix.training.counselling.controller.EligibleCollege;
import com.inautix.training.counselling.controller.applyCounsellingController;
import com.inautix.training.counselling.dao.getEligibleCollegeDAO;
import com.inautix.training.counselling.dao.applyCounsellingDAO;
/**
 * Servlet implementation class collegeprocessing
 */
@WebServlet("/collegeprocessing")
public class collegeprocessing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public collegeprocessing() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		applyCounsellingController cr = new applyCounsellingController();
		List<String> l = new ArrayList<String>();
		
		getEligibleCollegeDAO colseat = new getEligibleCollegeDAO();
		HttpSession htc = request.getSession();
		String collegename = request.getParameter("collegename");
		Integer regno = (Integer) htc.getAttribute("studentid");
		//EligibleCollege se = new EligibleCollege();
					try {
						applyCounsellingDAO ads = new applyCounsellingDAO(regno,collegename);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		RequestDispatcher rdx = request.getRequestDispatcher("/studentProfile.jsp");
		rdx.forward(request, response);}
			
	
		

}

