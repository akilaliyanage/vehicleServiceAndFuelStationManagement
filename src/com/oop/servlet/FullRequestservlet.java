package com.oop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oop.model.AppointmentModel;
import com.oop.model.NewMechModel;
import com.oop.model.PackageForAppoint;
import com.oop.model.UserModel;
import com.oop.model.VehicalServices;
import com.oop.model.VehicleModel;
import com.oop.service.AppointmentServices;
import com.oop.service.AppointmentServicesImpl;
import com.oop.service.IPackageAccess;
import com.oop.service.IServiceAccess;
import com.oop.service.ImechanicServices;
import com.oop.service.PackageAccessImpl;
import com.oop.service.ServiceAccessImpl;
import com.oop.service.mechanicServicesImpl;

/**
 * Servlet implementation class FullRequestservlet
 */
@WebServlet("/FullRequestservlet")
public class FullRequestservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AppointmentServices appServices = new AppointmentServicesImpl();
	ImechanicServices Machinics = new mechanicServicesImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FullRequestservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String) session.getValue("regno");
		IPackageAccess pack = new PackageAccessImpl();
		IServiceAccess service = new ServiceAccessImpl();
		String AppointmentID = request.getParameter("Id_Of_Appointment");
		
		AppointmentModel appointment = appServices.getAppointmentByAppID(AppointmentID);
		VehicleModel vehicle = appServices.getVehicleByAppointmentId(appointment.getAppId());
		UserModel customer = appServices.GetUserById(userId);
		PackageForAppoint appointedPack = pack.getPackageByPackId(appointment.getPackID());
		VehicalServices appointedServic = service.getServiceDetailServices(appointment.getService_id());
		List<NewMechModel> listOfMech = new ArrayList<NewMechModel>();
		listOfMech = Machinics.getAllMechanics();
		
		if (appointment != null && customer != null && appointedPack != null && appointedServic != null) {
			
			request.setAttribute("Appointment", appointment);
			request.setAttribute("Customer", customer);
			request.setAttribute("Package", appointedPack);
			request.setAttribute("Service", appointedServic);
			request.setAttribute("Vehicle", vehicle);
			request.setAttribute("Mechanics" , listOfMech);
			
			
			request.getRequestDispatcher("FullRequestDetails.jsp").forward(request, response);
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
