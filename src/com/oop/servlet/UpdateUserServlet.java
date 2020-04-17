package com.oop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.DAO.UpdateUserDAO;
import com.oop.model.UpdateUserModel;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//fetching the values from the request object 
		
		String nameString = request.getParameter("updateName");
		String emailString = request.getParameter("updateEmail");
		String phoneString = request.getParameter("updatePhone");
		String genderString = request.getParameter("updateGender");
		String massegeString = request.getParameter("updateMessage");
		
		//creating the model and dao objects
		
		UpdateUserModel updateModel = new UpdateUserModel();
		UpdateUserDAO updatedao = new UpdateUserDAO();
		int status;
		
		try {
			
			updateModel.setNameString(nameString);
			updateModel.setEmailString(emailString);
			updateModel.setPhoneString(phoneString);
			updateModel.setGenderString(genderString);
			updateModel.setDescriptionString(massegeString);
			
			
			status = updatedao.updateUser(updateModel);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		// TODO Auto-generated method stub
	}

}
