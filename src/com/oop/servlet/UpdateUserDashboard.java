package com.oop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oop.DAO.IUpdateUserDAO;
import com.oop.DAO.UpdatUserImplDAO;
import com.oop.model.AppointmentDetailsModel;
import com.oop.model.BillDetailsModel;

/**
 * Servlet implementation class UpdateUserDashboard
 */
//@WebServlet("/UpdateUserDashboard")
public class UpdateUserDashboard extends HttpServlet {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get the session value
		
		HttpSession session = request.getSession();
		String regNoString = (String) session.getAttribute("regno");	//storing the session value to the variable
		
		IUpdateUserDAO userMethods = new UpdatUserImplDAO();
			
			try {
				//getting the user detials
				ArrayList<String> userDetails =  userMethods.getUserDetails(regNoString);
				request.setAttribute("userDetails", userDetails);
				
				
				//getting bill details
				List<BillDetailsModel> billDet = userMethods.getBillDetails(regNoString);
				request.setAttribute("bill", billDet);
				
				
				//get the appointment details
				ArrayList<AppointmentDetailsModel> det = userMethods.getAppDetails(regNoString);
				request.setAttribute("app", det);
				
				
				//get the total vehivles
				int totalVehicles = userMethods.getTotVehicles(regNoString);
				request.setAttribute("totvehi", totalVehicles);
				
				
				//get total appointments
				int totApps =  userMethods.getTotApp(regNoString);
				request.setAttribute("totapps", totApps);
				
				//get the total payments
				int totPay = userMethods.totPay(regNoString);
				request.setAttribute("totpay", totPay);
				
				//get the total items purchased
				int totItems = userMethods.totItesm(regNoString);
				request.setAttribute("totitems", totItems);
				
				//get the total paid amount
				float paid = userMethods.paid(regNoString);
				request.setAttribute("paid", paid);
				
				//get the total paid amount
				float pend = userMethods.pending(regNoString);
				request.setAttribute("pend", pend);
				
				
				
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("userProfile.jsp");
				requestDispatcher.forward(request, response);
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
	}

}
