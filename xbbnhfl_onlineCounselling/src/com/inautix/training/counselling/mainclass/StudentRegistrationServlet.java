package com.inautix.training.counselling.mainclass;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inautix.training.counselling.controller.registrationController;
import com.inautix.training.counselling.domain.newStudent;
import com.inautix.training.counselling.exception.sqlException;

/**
 * Servlet implementation class StudentRegistrationServlet
 */
@WebServlet("/StudentRegistrationServlet")
public class StudentRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegistrationServlet() {
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
		String name = request.getParameter("namenew");
        int regno = Integer.parseInt(request.getParameter("useridnew"));
        String pwd = request.getParameter("passwordnew");
        newStudent ns = new newStudent();
        ns.setName(name);
        ns.setPassword(pwd);
        ns.setRegno(regno);
        try {
			registrationController r = new registrationController(ns);
			HttpSession session = request.getSession();
			//session.setMaxInactiveInterval(2);
			session.setAttribute("studentid", regno);
			request.setAttribute("newname", name);
			request.setAttribute("newregno", regno); 
			RequestDispatcher rd = request.getRequestDispatcher("/ProfileFirst.jsp");
			rd.forward(request, response);
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
