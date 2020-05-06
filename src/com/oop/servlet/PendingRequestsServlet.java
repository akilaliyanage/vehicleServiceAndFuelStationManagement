package com.oop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.AppointmentModel;
import com.oop.model.NewMechModel;
import com.oop.model.UserAppointmentModel;
import com.oop.service.AppointmentServices;
import com.oop.service.AppointmentServicesImpl;
import com.oop.service.ImechanicServices;
import com.oop.service.mechanicServicesImpl;

/**
 * Servlet implementation class PendingRequestsServlet
 */
@WebServlet("/PendingRequestsServlet")
public class PendingRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AppointmentServices pendingAppointments = new AppointmentServicesImpl();
	ImechanicServices mechanics = new mechanicServicesImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PendingRequestsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<UserAppointmentModel> userAndAppointment = new ArrayList<UserAppointmentModel>();
		List<AppointmentModel> newAppointments = new ArrayList<AppointmentModel>();
		List<NewMechModel> allMechanics = new ArrayList<NewMechModel>();
		userAndAppointment = pendingAppointments.getUserWithAppointment();
		newAppointments = pendingAppointments.getPendingAppointments();
		allMechanics = mechanics.getAllMechanics();
		
		if (newAppointments != null) {

			String origin = "";
			request.setAttribute("PendingRequests", userAndAppointment);
			//request.setAttribute("PendingRequests", newAppointments);
			request.setAttribute("Mechanics", allMechanics);
			request.setAttribute("origin", origin);
		       
			request.getRequestDispatcher("newReq.jsp").forward(request, response);
	
		}
		
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
