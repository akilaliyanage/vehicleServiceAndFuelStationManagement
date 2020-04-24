package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oop.DAO.NewUserDAO;
import com.oop.model.NewUserModel;
import com.oop.model.RandomString;

/**
 * Servlet implementation class NewUserServlet
 */
//@WebServlet(urlPatterns = { "/NewUserServlet" })
public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ "static-access", "unused" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String newUsernameString = request.getParameter("signusername");
		String newUsweEailString = request.getParameter("signemail");
		String newUserPasswordString = request.getParameter("signpass");
		String newUserRegNoString;
		int status;
		
		
		try {
			
			RandomString randonString = new RandomString();
			newUserRegNoString = "REG" + randonString.getAlphaNumericString();
			NewUserModel newUserModelObject = new NewUserModel(newUsernameString,newUsweEailString,newUserPasswordString,newUserRegNoString);
			NewUserDAO newUserDAOObject = new NewUserDAO();
			
			status = newUserDAOObject.insertdata(newUserModelObject);
			
			if(status == 1) {
				HttpSession session = request.getSession();
				session.setAttribute("regno", newUserModelObject.getUserregNoString());
				response.sendRedirect("HomePageRedirectServlet");		
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(e);
			
		}
	}


}
