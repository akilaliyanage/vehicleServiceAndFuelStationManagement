package com.oop.servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.DAO.NewMechDAO;
import com.oop.model.NewMechModel;
import com.oop.model.RandomString;

/**
 * Servlet implementation class NewMechServlet
 */
//@WebServlet("/NewMechServlet")
public class NewMechServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(NewMechServlet.class.getName());   

	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String regnoString;
		
		RandomString rString = new RandomString();
		regnoString = "MEC" + rString.getAlphaNumericString();
		String fullnameString = request.getParameter("mechful");
		String usernameString = request.getParameter("mechusername");
		String passwoString = request.getParameter("mechpass");
		String emailString = request.getParameter("mechemail");
		String genderString = request.getParameter("mechgender");
		String phoneString = request.getParameter("mechphone");
		float salString = Float.parseFloat(request.getParameter("mechsal"));
		String specString = request.getParameter("mechspe");
		float ex = Float.parseFloat(request.getParameter("mechex"));
		float wh = Float.parseFloat(request.getParameter("mechwork"));
		
		try {
			
			NewMechModel mechModel = new NewMechModel(usernameString, emailString, passwoString, regnoString);
			NewMechDAO newMechDAO = new NewMechDAO();
			mechModel.setFullnameString(fullnameString);
			mechModel.setGenderString(genderString);
			mechModel.setPhoneString(phoneString);
			mechModel.setSal(salString);
			mechModel.setSpecString(specString);
			mechModel.setEx(ex);
			mechModel.setWh(wh);
			
			int result = newMechDAO.newMech(mechModel);
			
			if (result == 1) {
				
				response.sendRedirect("addEmp.jsp");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		
		
		
	}

}
