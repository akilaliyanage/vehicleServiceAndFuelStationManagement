package com.oop.servlet;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.*;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.oop.DAO.UpdateUserDAO;
import com.oop.model.UpdateUserModel;

/**
 * Servlet implementation class UpdateUserServlet
 */
//@WebServlet(value = "/UpdateUserServlet")
@MultipartConfig(maxFileSize = 16177215)
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(UpdateUserServlet.class.getName());   

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// fetching the values from the request object

		String nameString = request.getParameter("updateName");
		String phoneString = request.getParameter("updatePhone");
		String genderString = request.getParameter("updateGender");
		String massegeString = request.getParameter("updateMassege");
		String usernameString = request.getParameter("updateUsername");
		String passwordString = request.getParameter("updatePassword");
		String emailString = request.getParameter("updateEmail");
		
		HttpSession session = request.getSession();
		String userIdString = (String) session.getAttribute("regno");
		
				 
		

		// creating the model and dao objects

		
		UpdateUserDAO updatedao = new UpdateUserDAO();
		int status;

		try {
			UpdateUserModel updateModel = new UpdateUserModel(usernameString,emailString,passwordString,userIdString);
			updateModel.setNameString(nameString);
			updateModel.setPhoneString(phoneString);
			updateModel.setGenderString(genderString);
			updateModel.setDescriptionString(massegeString);
			

			status = updatedao.updateUser(updateModel);
		
			if(status == 1) {
				
				response.sendRedirect("UpdateUserDashboard");
				
			}
			

		} 
		catch (IOException e) {
			// TODO: handle exception
			LOGGER.log(Level.SEVERE, e.getMessage());
		}catch (Exception e) {
			// TODO: handle exception
			LOGGER.log(Level.SEVERE, e.getMessage());
		}

		// TODO Auto-generated method stub
	}

}
