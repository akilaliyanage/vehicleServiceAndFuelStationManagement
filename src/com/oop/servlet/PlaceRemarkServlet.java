package com.oop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.service.AppointmentServices;
import com.oop.service.AppointmentServicesImpl;

/**
 * Servlet implementation class PlaceRemarkServlet
 */
@WebServlet("/PlaceRemarkServlet")
public class PlaceRemarkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AppointmentServices setremarks = new AppointmentServicesImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceRemarkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String appointment = request.getParameter("appointment1");
		String remark = request.getParameter("remark");
		
		setremarks.SetRemarksToAppointment(appointment , remark);
		
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
