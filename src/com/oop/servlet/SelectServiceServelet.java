//Created by D.H.M.M.P.Thammita
//IT No : IT19120362
package com.oop.servlet;

import java.io.IOException;
import com.oop.DAO.*;
import com.oop.service.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.DAO.AppointmentDAOImpl;
import com.oop.model.VehicalServices;



/**
 * Servlet implementation class SelectPackServlet
 * this gets the service id selected by user in the SendRequest.jsp
 * then it creates creates cookies for further us in CreateAppointment Servlet
 */
@WebServlet("/SelectServiceServelet")
public class SelectServiceServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectServiceServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String selectedService = request.getParameter("ServiceID");
		
		
		
		//creates creates cookies for further us in CreateAppointment Servlet
		Cookie serviceCookie = new Cookie("Service", selectedService);
		
		response.addCookie(serviceCookie);
		
		
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
