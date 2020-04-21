package com.oop.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oop.DAO.IUpdateUserDAO;
import com.oop.DAO.UpdatUserImplDAO;

/**
 * Servlet implementation class UpdateUserDashboard
 */
//@WebServlet("/UpdateUserDashboard")
public class UpdateUserDashboard extends HttpServlet {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get the session value
		
		HttpSession session = request.getSession();
		String regNoString = (String) session.getAttribute("regno");	//storing the session value to the variable
		
			IUpdateUserDAO userMethods = new UpdatUserImplDAO();
			
			try {
				//getting the user detials
				ArrayList<String> userDetails =  userMethods.getUserDetails(regNoString);
				
				request.setAttribute("userDetails", userDetails);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("userProfile.jsp");
				requestDispatcher.forward(request, response);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
	}

}
