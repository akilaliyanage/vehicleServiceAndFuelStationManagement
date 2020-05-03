package com.oop.servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oop.DAO.PaymentDAO;
import com.oop.model.RandomString;

/**
 * Servlet implementation class PaymentServlet
 */
//@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(PaymentServlet.class.getName());   
   
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			HttpSession session = request.getSession();
			String regnoString = (String) session.getAttribute("regno");
			
			RandomString rString = new RandomString();
			
			@SuppressWarnings("static-access")
			String payIdString = "PAY" + rString.getAlphaNumericString();
			@SuppressWarnings("static-access")
			String billidString = "BIL" + rString.getAlphaNumericString();
			float tot = Float.parseFloat(request.getParameter("tot"));
			String idString = request.getParameter("id");
			
			//System.out.println(totString);
			
			PaymentDAO paymentDAO = new PaymentDAO();
			
			int result = paymentDAO.savePay(payIdString, billidString,idString, tot, regnoString);
			
			System.out.println(result);
			
			response.sendRedirect("UpdatePaymentServlet");
			
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		
		
		
	}

}
