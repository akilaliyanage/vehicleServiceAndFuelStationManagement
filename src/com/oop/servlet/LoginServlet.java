package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oop.DAO.LoginDao;
import com.oop.model.LoginModel;


import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet(description = "This controler is used to controll the user login of the system", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class.getName());   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		try {
			//fetcthin the usr request from the html request
			
			String loginUsernameString = request.getParameter("loginemail");
			String loginPasswordString = request.getParameter("loginpassword");
			String isSubmitString = request.getParameter("signin");
			
			LoginModel loginModel = new LoginModel();	//creating a login model object so that the returning object from the LoginDAO class can hold the value
			
			LoginDao loginDao = new LoginDao();		//creating a LoginDAO object to call the getData() in the LoginDao class
			
			loginModel = loginDao.getData(loginUsernameString,loginPasswordString);		//saving the returned loginModel object to the loginmodel object
			
			if(isSubmitString.equals("signin") && loginModel.getUsernameString() != null && loginModel.getPassworString() != null) {
				
					HttpSession sHttpSession = request.getSession();
					sHttpSession.setAttribute("regno", loginModel.getRegNoString());
					response.sendRedirect("HomePageRedirectServlet");			
			}
			else {
				request.setAttribute("error", "Invalid username or password");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		
		
	}

}
