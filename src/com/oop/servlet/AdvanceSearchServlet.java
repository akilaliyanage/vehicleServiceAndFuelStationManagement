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
import com.oop.model.UserAppointmentModel;
import com.oop.service.AppointmentServices;
import com.oop.service.AppointmentServicesImpl;

/**
 * Servlet implementation class AdvanceSearchServlet
 * This servlet is associates with the  All_requests.jsp 
 * this will give the result to to user according to their selections. 
 */
@WebServlet("/AdvanceSearchServlet")
public class AdvanceSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AppointmentServices serviceAppointments = new AppointmentServicesImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdvanceSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String userRegNo = request.getParameter("Search_by_CusId");
		String vehicleI_No = request.getParameter("Search_by_VehiNo");
		String amount = request.getParameter("Search_by_amount");
		String service_id = request.getParameter("Search_by_Service");
		String status = request.getParameter("Search_by_Status");
		String prefDate = request.getParameter("Search_by_Date");
		String Appid = request.getParameter("search_by_app_ID");
		
		List<AppointmentModel> filteredAppointments = new ArrayList<AppointmentModel>();
		
		filteredAppointments = serviceAppointments.SearchAdvanceAppointments(Appid , userRegNo , vehicleI_No , amount , service_id , status , prefDate);
		
		if (filteredAppointments != null) {
			request.setAttribute("AppointmentList", filteredAppointments);
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
