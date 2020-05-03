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

import com.oop.DAO.InquiryDAO;
import com.oop.model.InquiryModel;

/**
 * Servlet implementation class InquieryNavigateServlet
 */
//@WebServlet("/InquieryNavigateServlet")
public class InquieryNavigateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/** Initialize logger */
	private static final Logger LOGGER = Logger.getLogger(InquieryNavigateServlet.class.getName());
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			InquiryDAO inquiryDAO = new InquiryDAO();
			
			ArrayList<InquiryModel> inquiryModels = inquiryDAO.getInqDetails();
			request.setAttribute("inq", inquiryModels);
			RequestDispatcher dispatcher = request.getRequestDispatcher("inquiry-list.jsp");
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		
	}

}
