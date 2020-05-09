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
 * Servlet implementation class DeleteRequest
 */
@WebServlet("/DeleteRequest")
public class DeleteRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AppointmentServices appointmentService = new AppointmentServicesImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String appIdString = request.getParameter("AppointmentID");
		 String vehiNoString = request.getParameter("vehicleNo");
		 String pageString = request.getParameter("page");
		 
		 appointmentService.delelteRequest(appIdString, vehiNoString);
		 System.out.println("AppointmentServices deleted");
		 
		 if (pageString.equals("allRequests")) {
			 
			 request.getRequestDispatcher("AdvanceSearchServlet").forward(request, response);
			
		}
		 
		 else if (pageString.equals("FullDetails")) {
			 
			 request.getRequestDispatcher("UpdateUserDashboard").forward(request, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
