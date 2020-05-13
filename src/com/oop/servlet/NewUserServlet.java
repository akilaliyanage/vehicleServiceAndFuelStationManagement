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

import com.oop.DAO.NewUserDAO;
import com.oop.model.NewUserModel;
import com.oop.model.RandomString;

/**
 * Servlet implementation class NewUserServlet
 */
//@WebServlet(urlPatterns = { "/NewUserServlet" })
public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//logger implementation
    private static final Logger LOGGER = Logger.getLogger(NewUserServlet.class.getName());   
   
    


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ "static-access", "unused" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//fetching the data from the request object
		String newUsernameString = request.getParameter("signusername");
		String newUsweEailString = request.getParameter("signemail");
		String newUserPasswordString = request.getParameter("signpass");
		String newUserRegNoString;
		int status;
		
		
		try {
			
			RandomString randonString = new RandomString();		//this random string method will create alphanumeric values of 7 digits which will be used as the ID
			newUserRegNoString = "REG" + randonString.getAlphaNumericString();	//concatinates the random number with the prefix
			NewUserModel newUserModelObject = new NewUserModel(newUsernameString,newUsweEailString,newUserPasswordString,newUserRegNoString);	//passing parameters to the uder model object
			NewUserDAO newUserDAOObject = new NewUserDAO();	//creation of the DAO object of the new user
			
			status = newUserDAOObject.insertdata(newUserModelObject);
			
			if(status == 1) {	//setting the session variables
				HttpSession session = request.getSession();
				session.setAttribute("regno", newUserModelObject.getUserregNoString());
				response.sendRedirect("HomePageRedirectServlet");		
			}
			
		} 	//exception handling
		catch (IOException ex) {
			// TODO: handle exception
			LOGGER.log(Level.SEVERE, ex.getMessage());
		}catch (Exception e) {
			// TODO: handle exception
			
			LOGGER.log(Level.SEVERE, e.getMessage());
			
		}
	}


}
