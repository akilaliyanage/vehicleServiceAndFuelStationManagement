package com.oop.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oop.DAO.IUpdateDashboardDAO;
import com.oop.DAO.UpdateDashboardImplDAO;
import com.oop.model.DashboardPaymentsDAO;
import com.oop.model.DashboardRequestModel;
import com.oop.model.RequestModel;

/**
 * Servlet implementation class UpdateDashboardServlet
 */
//@WebServlet("/UpdateDashboardServlet")
public class UpdateDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String regNoString = session.getAttribute("regno").toString();
		request.setAttribute("regno", regNoString);
		
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
			
			int paid = dashbordMethods.paidAmm();
			request.setAttribute("paid", paid);
			
			int pending = dashbordMethods.pendingAmm();
			request.setAttribute("pending", pending);
			
			int totApps = dashbordMethods.totApps();
			request.setAttribute("apps", totApps);
			
			int totPay = dashbordMethods.totPay();
			request.setAttribute("totpay", totPay);
			
			int totPack = dashbordMethods.totPack();
			request.setAttribute("pack", totPack);
			
			ArrayList<RequestModel> req = dashbordMethods.req();
			request.setAttribute("req", req);
			
			ArrayList<DashboardPaymentsDAO> payment = dashbordMethods.pay();
			request.setAttribute("pay", payment);
			
			
			
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("dashboard.jsp");
			requestDispatcher.forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
	}

}
