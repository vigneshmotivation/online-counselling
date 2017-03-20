package com.inautix.training.counselling.mainclass;
import com.inautix.training.*;
import com.inautix.training.counselling.controller.registrationController;
import com.inautix.training.counselling.domain.Student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class studentloginservlet
 */
@WebServlet("/studentloginservlet")
public class studentloginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentloginservlet() {
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
		
		PrintWriter out = response.getWriter();
		int regno = Integer.parseInt(request.getParameter("suserid"));
		String password = (request.getParameter("spassword"));
		Student s = new Student();
		s.setRegno(regno);
        registrationController r = new registrationController();
        try {
			if(r.passwordCheck(regno, password).equalsIgnoreCase("you have successfully logged in !"))
					{
				       System.out.println("login success");
				       response.setContentType("Text/Html");
				      // response.sendRedirect("ProfileFirst.jsp");
				       HttpSession session = request.getSession();
				       request.setAttribute("rollno", regno);
				       session.setAttribute("studentid", regno);
				       RequestDispatcher rd = request.getRequestDispatcher("/studentProfile.jsp");
				       rd.forward(request, response);
					}
			else
			{
				response.setContentType("Text/Html");
			       response.sendRedirect("Loginstudent.html");
			       
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
