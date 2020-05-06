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
		
		
		System.out.println(appointment +"  "+ Status);
		
		if (Status.equals("Delete")){
			Origin = "Deleted";
			System.out.println("Entered to delete");
			statusChanger.delelteRequest(appointment , Vehicle);
		}
		
		else{
			Origin = Status;
			System.out.println("Not Entered to delete");
			statusChanger.Changestatus(appointment , Status);
			System.out.println("origin is : " +  Origin);
		}
		
		
		
		List<AppointmentModel> newAppointments = new ArrayList<AppointmentModel>();
		List<NewMechModel> allMechanics = new ArrayList<NewMechModel>();
		newAppointments = statusChanger.getPendingAppointments();
		allMechanics = mechanics.getAllMechanics();
		
		if (newAppointments != null) {

			
			request.setAttribute("PendingRequests", newAppointments);
			request.setAttribute("Mechanics", allMechanics);
			request.setAttribute("origin", Origin);
			request.setAttribute("Affectedappointment", appointment);
		       
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
