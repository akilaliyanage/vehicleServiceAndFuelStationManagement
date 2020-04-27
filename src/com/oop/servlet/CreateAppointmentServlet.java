package com.oop.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oop.model.AppointmentModel;
import com.oop.model.UserModel;
import com.oop.service.AppointmentServices;
import com.oop.service.AppointmentServicesImpl;

import javax.servlet.http.Cookie;

/**
 * Servlet implementation class CreateAppointmentServlet
 */
@WebServlet("/CreateAppointmentServlet")
public class CreateAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AppointmentServices appointmentServices = new AppointmentServicesImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAppointmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String userId = (String) session.getValue("regno");
		Date AppointDate = null;	
		String appointTime = null;
		
		
		
		String vehi_nameString  = request.getParameter("vehi_No");
		String vehiBrand  = request.getParameter("brand");
		String vehiModel  = request.getParameter("model");
		String vehiTransmission  = request.getParameter("Transmission");
		String vehiFuel  = request.getParameter("Vehicle_fuel");
		String vehEngine  = request.getParameter("Engine");
		//String vehiMilage  = request.getParameter("Milage");
		int vehiYear  = Integer.parseInt(request.getParameter("year"));
		String serviceID = null;
		int appointDay = 1;
		
		String packID = null;
		
		
		Cookie otherValues[] = request.getCookies();
		for (Cookie cookie : otherValues) {
			if (cookie.getName().equals("Service")) {
				serviceID = cookie.getValue();
			}
			if (cookie.getName().equals("PrefDay")) {
				appointDay = Integer.parseInt(cookie.getValue());
			}
			if (cookie.getName().equals("PrefTime")) {
				appointTime = cookie.getValue();
			}
			if (cookie.getName().equals("packId")) {
				packID = cookie.getValue();
			}
		}
		
		//Date SelectedTime = null;
		try {
			AppointDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("AppDate"));
			//SelectedTime = new SimpleDateFormat("hh:mm:ss").parse(request.getParameter(appointTime));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		AppointmentModel createdAppointmentModel = appointmentServices.createAppointment(userId, vehi_nameString, AppointDate, vehiBrand, vehiModel, vehiTransmission, vehiFuel, vehEngine, vehiYear, serviceID, appointTime, packID, appointDay);
		
		UserModel currentUser = appointmentServices.GetUserById(userId);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
