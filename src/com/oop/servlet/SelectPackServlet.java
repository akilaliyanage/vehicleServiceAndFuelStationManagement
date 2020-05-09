//Created by D.H.M.M.P.Thammita
//IT No : IT19120362

package com.oop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.DAO.AppointmentDAOImpl;
import com.oop.DAO.IAppointmentDAO;

/**
 * Servlet implementation class SelectPackServlet
 * this gets the package id selected by user in the SendRequest.jsp
 * then it creates creates cookies for further us in CreateAppointment Servlet
 */
@WebServlet("/SelectPackServlet")
public class SelectPackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectPackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String selectedPack = request.getParameter("SelectedPackgeNo");
		//creates cookies for further us in CreateAppointment Servlet
		Cookie packId = new Cookie("packId", selectedPack);
		
		response.addCookie(packId);
		
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
