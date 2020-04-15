package com.oop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oop.DAO.NewUserDAO;
import com.oop.model.NewUserModel;

/**
 * Servlet implementation class NewUserServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/NewUserServlet" })
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String newUsernameString = request.getParameter("signusername");
		String newUsweEailString = request.getParameter("signemail");
		String newUserPasswordString = request.getParameter("signpass");
		int status;
		
		NewUserModel newUserModelObject = new NewUserModel();
		NewUserDAO newUserDAOObject = new NewUserDAO();
		
		try {
			
			newUserModelObject.setUsernameString(newUsernameString);
			newUserModelObject.setEmailString(newUsweEailString);
			newUserModelObject.setPasswordString(newUserPasswordString);
			
			status = newUserDAOObject.insertdata(newUserModelObject);
			
			if(status == 1) {
				HttpSession session = request.getSession();
				session.setAttribute("username", newUsernameString);
				request.getRequestDispatcher("homepage.jsp");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
