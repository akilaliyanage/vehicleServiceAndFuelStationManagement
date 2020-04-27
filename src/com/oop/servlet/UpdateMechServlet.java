package com.oop.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.DAO.UpdateMechDAO;
import com.oop.model.NewMechModel;

/**
 * Servlet implementation class UpdateMechServlet
 */
//@WebServlet("/UpdateMechServlet")
public class UpdateMechServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String unameString = request.getParameter("username");		
		String passString = request.getParameter("password");
		
		UpdateMechDAO mechDAO = new UpdateMechDAO();
		
		ArrayList<String> mech = new ArrayList<String>();
		
		try {
			
			mech = mechDAO.updateMech(unameString, passString);
			request.setAttribute("mech", mech);
			
			response.sendRedirect("updateMech.jsp");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
