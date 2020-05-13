package com.oop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
			
			DeleteUserDAO userDAO = new DeleteUserDAO();	//object creation of the DEL DAO class
			
			int result = userDAO.removeUser(userString);	//passing the parameter to the remove user method and getting the results
			
			if(result == 1) {
				PrintWriter writer = response.getWriter();
				writer.println("<html><body><script> alert('success'); </sctipt></body></html>");
				try {
					Thread.sleep(2000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				response.sendRedirect("UpdateDashboardServlet");
			}
			
		} //exception handling
		catch (IOException e) {
			// TODO: handle exception
			LOGGER.log(Level.SEVERE,e.getMessage());
		}catch (Exception e) {
			// TODO: handle exception
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		
	}

}
