package com.oop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oop.DAO.PurchaseFuelDAO;
import com.oop.model.PurchaseFuelModel;
import com.oop.model.RandomString;

/**
 * Servlet implementation class FuelDisServlet
 */
//@WebServlet("/FuelDisServlet")
public class FuelDisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    //let#doPost(HttpServletRequest request, HttpServletResponse response)
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		float amount = Float.parseFloat(request.getParameter("fuelam"));
		String disString = request.getParameter("type");
		
		//session variable
		HttpSession session = request.getSession();
		String regnoString = (String) session.getAttribute("regno");
		
		try {
			
			PurchaseFuelModel fuelModel = new PurchaseFuelModel();
			PurchaseFuelDAO fuelDao = new PurchaseFuelDAO();
			RandomString rs = new RandomString();
			String puridString = "PUR" + rs.getAlphaNumericString();
			fuelModel.setAmount(amount);
			fuelModel.setDisidString(disString);
			fuelModel.setUseridString(regnoString);
			fuelModel.setPuridString(puridString);
			
			
			@SuppressWarnings("unused")
			int result = fuelDao.buyFuel(fuelModel);
			//System.out.println(result);
			
			if (result == 1) {
				response.sendRedirect("UpdateUserDashboard");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
