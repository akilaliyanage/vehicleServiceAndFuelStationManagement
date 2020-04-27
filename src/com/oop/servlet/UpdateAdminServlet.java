package com.oop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oop.DAO.UpdateAdminDAO;
import com.oop.model.UpdateAdminModel;

/**
 * Servlet implementation class UpdateAdminServlet
 */
//@WebServlet("/UpdateAdminServlet")
public class UpdateAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String regnoString = session.getAttribute("regno").toString();
		
		try {
			
			String fullnameString = request.getParameter("updatename");
			String usernameString = request.getParameter("updateusername");
			String emailString = request.getParameter("updateemail");
			String passwordString = request.getParameter("updatepass");
			String phoneString = request.getParameter("updatephone");
			Float salFloat = Float.parseFloat(request.getParameter("updatesal"));
			
			int result = 0;
			
			UpdateAdminModel adminModel = new UpdateAdminModel();
			UpdateAdminDAO updateAdmin = new UpdateAdminDAO();
			adminModel.setFullnameString(fullnameString);
			adminModel.setUsernameString(usernameString);
			adminModel.setPasswordString(passwordString);
			adminModel.setEmailString(emailString);
			adminModel.setPhoneString(phoneString);
			adminModel.setSalFloat(salFloat);
			adminModel.setRegnString(regnoString);
			
			result = updateAdmin.updateAdmin(adminModel);
			
			System.out.println(result);
			
			if(result == 1) {
				
				response.sendRedirect("UpdateDashboardServlet");
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
		
		
	}

}
