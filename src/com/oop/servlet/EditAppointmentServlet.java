package com.oop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.AppointmentModel;
import com.oop.service.AppointmentServices;
import com.oop.service.AppointmentServicesImpl;

/**
 * Servlet implementation class EditAppointmentServlet
 */
@WebServlet("/EditAppointmentServlet")
public class EditAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AppointmentServices editAppoinement = new AppointmentServicesImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAppointmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String Appoint_No = (String) request.getAttribute("flag");
		String vehi_no = request.getParameter("Edit_Vehi_No");
		String brand = request.getParameter("Edit_brand");
		String model = request.getParameter("Edit_model");
		String transmission = request.getParameter("Edit_transmission");
		String fuel = request.getParameter("Edit_fuel");
		String date = request.getParameter("Edit_date");
		String time = request.getParameter("Edit_time");
		
		//AppointmentModel editedAppointment = editAppoinement.UpdateAppointment(Appoint_No , vehi_no , brand , model , transmission , fuel , date , date);
		System.out.println("app no : " + Appoint_No);
		System.out.println(time);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
