package com.oop.servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oop.DAO.NewAdminDAO;
import com.oop.model.NewAdminModel;
import com.oop.model.RandomString;

/**
 * Servlet implementation class NewAdminServlet
 */
//@WebServlet("/NewAdminServlet")
public class NewAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(NewAdminServlet.class.getName());   
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		String fullnameString = request.getParameter("adminname");
		String usernameString = request.getParameter("adminusername");
		String emailString = request.getParameter("adminemail");
		String passwordString = request.getParameter("adminpass");
		String phoneString = request.getParameter("adminphone");
		Float salFloat = Float.parseFloat(request.getParameter("adminsal"));
		String genderString = request.getParameter("admingender");
		int result = 0;
		
		RandomString rString = new RandomString();
		@SuppressWarnings("static-access")
		String adminregString = "ADM" + rString.getAlphaNumericString();
		
		NewAdminModel adminModel = new NewAdminModel(usernameString, emailString, passwordString, adminregString);
		try {
			adminModel.setFullnameString(fullnameString);
			adminModel.setPhoneString(phoneString);
			adminModel.setGenderString(genderString);
			adminModel.setSalaryFloat(salFloat);
			
			NewAdminDAO adminDAO = new NewAdminDAO();
			result = adminDAO.insertAdmin(adminModel);
			
			if(result == 1) {
				HttpSession session = request.getSession();
				session.setAttribute("regno", adminregString);
				response.sendRedirect("UpdateDashboardServlet");
			}
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		
		
	}

}
