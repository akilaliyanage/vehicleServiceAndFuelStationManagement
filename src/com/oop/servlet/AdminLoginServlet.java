package com.oop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oop.DAO.AdminLoginDAO;
import com.oop.model.LoginAdminModel;

/**
 * Servlet implementation class AdminLoginServlet
 */
//@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String regnoString = (String) session.getAttribute("regno");
		
		String usernameString = request.getParameter("username");
		String passwordString = request.getParameter("password");
		

		
		try {
			
			LoginAdminModel adminModel = new LoginAdminModel();
			AdminLoginDAO ad = new AdminLoginDAO();
			adminModel =  ad.getAdmin(usernameString, passwordString);
			
			if(adminModel.getUsernameString() != null && adminModel.getPasswordString() != null) {
				
				HttpSession sHttpSession = request.getSession();
				sHttpSession.setAttribute("regno", adminModel.getRegnoString());
				response.sendRedirect("UpdateDashboardServlet");	
				
				System.out.println("akila");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
