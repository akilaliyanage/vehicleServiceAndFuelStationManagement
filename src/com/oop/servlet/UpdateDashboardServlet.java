package com.oop.servlet;

import java.io.IOException;
import java.util.ArrayList;

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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDashboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
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
		
		
	}

}
