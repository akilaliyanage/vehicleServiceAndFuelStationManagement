package com.oop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oop.DAO.UpdateMechDAO;
import com.oop.model.NewMechModel;

/**
 * Servlet implementation class UpdateMechServlet
 */
//@WebServlet("/UpdateMechServlet")
public class UpdateMechServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(UpdateMechServlet.class.getName());   
   
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String unameString = request.getParameter("username");		
		String passString = request.getParameter("password");
		
		UpdateMechDAO mechDAO = new UpdateMechDAO();
		
		NewMechModel newMechModel = null;
		
		try {
			
			newMechModel = mechDAO.updateMech(unameString, passString);
			request.setAttribute("mech", newMechModel);
			//response.sendRedirect("updateMech.jsp");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("updateMech.jsp");
			requestDispatcher.forward(request, response);
			HttpSession session = request.getSession();
			session.setAttribute("regno", newMechModel.getUserregNoString());
			
			System.out.println(newMechModel.getEmailString());
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		

		
		
	}

}
