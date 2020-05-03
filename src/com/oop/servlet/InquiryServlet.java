package com.oop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oop.DAO.InquiryDAO;
import com.oop.model.InquiryModel;
import com.oop.model.RandomString;

/**
 * Servlet implementation class InquiryServlet
 */
//@WebServlet("/InquiryServlet")
public class InquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(InquiryServlet.class.getName());   
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			HttpSession session = request.getSession();
			String regnoString = (String) session.getAttribute("regno");
			PrintWriter out = response.getWriter();
			
			RandomString idString = new RandomString();
			String inqidString = "INQ" + idString.getAlphaNumericString();
			
			String typeString = request.getParameter("type");
			String messageString = request.getParameter("message");
			
			InquiryModel inquiryModel = new InquiryModel();
			inquiryModel.setUsermessageString(messageString);
			inquiryModel.setInqidString(inqidString);
			inquiryModel.setUseridString(regnoString);
			inquiryModel.setTypeString(typeString);
			
			InquiryDAO inquiryDAO = new InquiryDAO();
			
			int result = inquiryDAO.insertInq(inquiryModel);
			
			if(result == 1) {
				response.setContentType("text/html;charset=UTF-8");
				out.println("<script>");
			    out.println("alert('Inquiery sent successfully!');");
			    out.println("</script>");
				response.sendRedirect("inquiry.jsp");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
	}

}
