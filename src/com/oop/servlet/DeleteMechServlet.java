package com.oop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.DAO.DeleteMechDAO;

/**
 * Servlet implementation class DeleteMechServlet
 */
//@WebServlet("/DeleteMechServlet")
public class DeleteMechServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String regnoString = request.getParameter("id");
		
		try {
			
			DeleteMechDAO deleteMechDAO = new DeleteMechDAO();
			
			int result = deleteMechDAO.removeMech(regnoString);
			System.out.println(result);
			
			if(result == 1) {
				response.sendRedirect("UpdateDashboardServlet");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
