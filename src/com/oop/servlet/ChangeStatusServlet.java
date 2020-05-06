package com.oop.servlet;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class ChangeStatusServlet
 */
@WebServlet("/ChangeStatusServlet")
public class ChangeStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AppointmentServices statusChanger = new AppointmentServicesImpl();
	ImechanicServices mechanics = new mechanicServicesImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String appointment = request.getParameter("appointment2");
		String Status = request.getParameter("Status");
		String Vehicle = request.getParameter("Vehicle_to_dele");
		String Origin = "Accepted";
		String Page = request.getParameter("Page") ;
		

		
		if (Status.equals("Delete")){
			Origin = "Deleted";
			statusChanger.delelteRequest(appointment , Vehicle);
		}
		
		else{
			Origin = Status;
			statusChanger.Changestatus(appointment , Status);
		}
		
		
		List<UserAppointmentModel> appUserList = new ArrayList<UserAppointmentModel>();
		List<AppointmentModel> newAppointments = new ArrayList<AppointmentModel>();
		List<NewMechModel> allMechanics = new ArrayList<NewMechModel>();
		appUserList = statusChanger.getUserWithAppointment();
		//newAppointments = statusChanger.getPendingAppointments();
		allMechanics = mechanics.getAllMechanics();
		
		if (appUserList != null && Page.equals("Newrequest")) {

			request.setAttribute("PendingRequests", appUserList);
			//request.setAttribute("PendingRequests", newAppointments);
			request.setAttribute("Mechanics", allMechanics);
			request.setAttribute("origin", Origin);
			request.setAttribute("Affectedappointment", appointment);
		       
			request.getRequestDispatcher("newReq.jsp").forward(request, response);
	
		}
		
		else if (appUserList != null && Page.equals("Fullrequest")) {
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
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
