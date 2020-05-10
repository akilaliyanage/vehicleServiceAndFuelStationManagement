package com.oop.servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.DAO.DeleteUserDAO;

/**
 * Servlet implementation class UserDelServlet
 */
//@WebServlet("/UserDelServlet")
public class UserDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(UserDelServlet.class.getName());   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userString = request.getParameter("id");
		
		try {
			
			DeleteUserDAO userDAO = new DeleteUserDAO();
			
			int result = userDAO.removeUser(userString);
			
			if(result == 1) {
				
				try {
					Thread.sleep(2000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				response.sendRedirect("UpdateDashboardServlet");
			}
			
		} 
		catch (IOException e) {
			// TODO: handle exception
			LOGGER.log(Level.SEVERE,e.getMessage());
		}catch (Exception e) {
			// TODO: handle exception
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		
	}

}
