package com.oop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.print.attribute.TextSyntax;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oop.DAO.PaymentDAO;
import com.oop.model.PaymentModel;

/**
 * Servlet implementation class UpdatePaymentServlet
 */
//@WebServlet("/UpdatePaymentServlet")
public class UpdatePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(UpdatePaymentServlet.class.getName());   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String regnoString = (String) session.getAttribute("regno");
		
		System.out.println(regnoString);
		
		
		try {
			
			ArrayList<PaymentModel> arraypayArrayList = new ArrayList<PaymentModel>();
			PaymentDAO payDao = new PaymentDAO();
			arraypayArrayList = payDao.getPayInfo(regnoString);
			request.setAttribute("info", arraypayArrayList);
			
			RequestDispatcher rDispatcher = request.getRequestDispatcher("payment.jsp");
			rDispatcher.forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		
		
	}

}
