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

import com.oop.DAO.IUpdateDashboardDAO;
import com.oop.DAO.UpdateDashboardImplDAO;
import com.oop.model.DashboardPaymentsDAO;
import com.oop.model.DashboardRequestModel;
import com.oop.model.NewMechModel;
import com.oop.model.PurchaseFuelModel;
import com.oop.model.RequestModel;
import com.oop.model.UpdateUserModel;

/**
 * Servlet implementation class UpdateDashboardServlet
 */
//@WebServlet("/UpdateDashboardServlet")
public class UpdateDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(UpdateDashboardServlet.class.getName());   

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
			
			//fetching the total paid amount of the system
			int paid = dashbordMethods.paidAmm();
			request.setAttribute("paid", paid);
			
			//fetching the total pending amount of the system
			int pending = dashbordMethods.pendingAmm();
			request.setAttribute("pending", pending);
			
			//fetching the total appointments of the system
			int totApps = dashbordMethods.totApps();
			request.setAttribute("apps", totApps);
			
			
			int totPay = dashbordMethods.totPay();
			request.setAttribute("totpay", totPay);
			
			//fetching the total number of pacages of the system
			int totPack = dashbordMethods.totPack();
			request.setAttribute("pack", totPack);
			
			//containd array of objects which has data about pending requirmnts
			ArrayList<RequestModel> req = dashbordMethods.req();
			request.setAttribute("req", req);
			
			//payment details
			ArrayList<DashboardPaymentsDAO> payment = dashbordMethods.pay();
			request.setAttribute("pay", payment);
			
			//mechanic details
			ArrayList<NewMechModel> mech = dashbordMethods.mech();
			request.setAttribute("mech", mech);
			
			//user details
			ArrayList<UpdateUserModel> user = dashbordMethods.user();
			request.setAttribute("user", user);
			
			//fetch the fuel usage of the system
			ArrayList<PurchaseFuelModel> usageArrayList = dashbordMethods.adminusageArrayList();
			request.setAttribute("usage", usageArrayList);
			
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("dashboard.jsp");
			requestDispatcher.forward(request, response);
			
		} 
		catch (IOException ex) {
			// TODO: handle exception
			LOGGER.log(Level.SEVERE, ex.getMessage());
		}catch (Exception e) {
			// TODO: handle exception
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		
		
	}

}
