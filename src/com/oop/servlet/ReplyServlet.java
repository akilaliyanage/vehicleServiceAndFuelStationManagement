package com.oop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.tag.el.fmt.RequestEncodingTag;

import com.oop.DAO.InquiryDAO;

/**
 * Servlet implementation class ReplyServlet
 */
//@WebServlet("/ReplyServlet")
public class ReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			
			HttpSession session = request.getSession();
			String regnoString = (String) session.getAttribute("regno");
			System.out.println(regnoString);
			
			String replyString = request.getParameter("reply");
			String idString = request.getParameter("inqId");
			
			InquiryDAO inquiryDAO = new InquiryDAO();
			
			int result = inquiryDAO.saveReply(regnoString, replyString, idString);
			
			if(result == 1) {
				response.sendRedirect("InquieryNavigateServlet");
			}
			else {
				response.sendError(result);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
