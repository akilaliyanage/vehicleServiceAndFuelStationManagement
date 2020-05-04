package com.oop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.AppointmentModel;
import com.oop.service.AppointmentServices;
import com.oop.service.AppointmentServicesImpl;


/**
 * Servlet implementation class AllrequestsServlet
 */
@WebServlet("/AllrequestsServlet")
public class AllrequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AppointmentServices AppointServices = new AppointmentServicesImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllrequestsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<AppointmentModel> AllAppointments = new ArrayList<AppointmentModel>();
		AllAppointments = AppointServices.getAllAppointments();
		
		if (AllAppointments != null) {
			request.setAttribute("AppointmentList", AllAppointments);
			request.getRequestDispatcher("All_request.jsp").forward(request, response);
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
