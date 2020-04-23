package com.oop.servlet;

import java.io.IOException;
import com.oop.DAO.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.DAO.AppointmentDAOImpl;



/**
 * Servlet implementation class SelectPackServelet
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
		String selectedService = request.getParameter("PackageID");
		System.out.println(selectedService);
		
		IAppointmentDAO appointment = new AppointmentDAOImpl();
		
		/*Generate a cookies to further use CreateAppointmentServlet*/
		Cookie serviceCookie = new Cookie("Service", selectedService);
		Cookie servicePrice = new Cookie("servicePrice", Double.toString(appointment.getServicePrice(selectedService)));
		response.addCookie(serviceCookie);
		response.addCookie(servicePrice);
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
