package com.oop.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.DAO.IUpdateDashboardDAO;
import com.oop.DAO.UpdateDashboardImplDAO;
import com.oop.model.DashboardRequestModel;

/**
 * Servlet implementation class UpdateDashboardServlet
 */
//@WebServlet("/UpdateDashboardServlet")
public class UpdateDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			//creating a objrct of the UpdateDashboardImplDAO
			IUpdateDashboardDAO dashbordMethods = new UpdateDashboardImplDAO();
			
			
			//fetching appointment details from UpdateDashboardImplDAO
			ArrayList<DashboardRequestModel> details = dashbordMethods.getRequestDetails();
			
			//setting the attribute to the request object
			request.setAttribute("userRequests", details);
			
			//fetching appointment details from UpdateDashboardImplDAO
			int totalCustomes = dashbordMethods.totCustomers();
			
			//setting the attribute to the request object
			request.setAttribute("totCustomers", totalCustomes);
			
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("dashboard.jsp");
			requestDispatcher.forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
	}

}
