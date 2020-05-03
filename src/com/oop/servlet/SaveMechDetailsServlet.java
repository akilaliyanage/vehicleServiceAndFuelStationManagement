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

import com.oop.DAO.NewMechDAO;
import com.oop.DAO.UpdateMechDAO;
import com.oop.model.NewMechModel;

/**
 * Servlet implementation class SaveMechDetailsServlet
 */
//@WebServlet("/SaveMechDetailsServlet")
public class SaveMechDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(SaveMechDetailsServlet.class.getName());   
   
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usernameString = request.getParameter("mechusername");
		String passwordString = request.getParameter("mechpass");
		String fullnameString = request.getParameter("mechful");
		String emailString = request.getParameter("mechemail");
		float salary = Float.parseFloat(request.getParameter("mechsal"));
		String specialString = request.getParameter("mechspe");
		float ex = Float.parseFloat(request.getParameter("mechex"));
		float wh = Float.parseFloat(request.getParameter("mechwork"));
		String phoneString = request.getParameter("mechphone");
		String genderString = request.getParameter("mechgender");
		
		HttpSession session = request.getSession();
		String regnoString = (String) session.getAttribute("regno");
		
		try {
			
			NewMechModel mechModel = new NewMechModel(usernameString, emailString, passwordString, regnoString);
			mechModel.setFullnameString(fullnameString);
			mechModel.setSal(salary);
			mechModel.setSpecString(specialString);
			mechModel.setEx(ex);
			mechModel.setWh(wh);
			mechModel.setPhoneString(phoneString);
			mechModel.setGenderString(genderString);
			
			UpdateMechDAO mechDAO = new  UpdateMechDAO();
			
			int result = mechDAO.saveMechDetails(mechModel);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		
	}

}
