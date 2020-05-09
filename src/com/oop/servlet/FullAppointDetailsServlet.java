//Created by D.H.M.M.P.Thammita
//IT No : IT19120362
package com.oop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.oop.model.AppointmentModel;
import com.oop.model.PackageForAppoint;
import com.oop.model.UserModel;
import com.oop.model.VehicalServices;
import com.oop.model.VehicleModel;
import com.oop.service.AppointmentServices;
import com.oop.service.AppointmentServicesImpl;
import com.oop.service.IPackageAccess;
import com.oop.service.IServiceAccess;
import com.oop.service.PackageAccessImpl;
import com.oop.service.ServiceAccessImpl;

/**
 * Servlet implementation class FullAppointDetailsServlet
 */
@WebServlet("/FullAppointDetailsServlet")
public class FullAppointDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AppointmentServices appointmnetService = new AppointmentServicesImpl();
	IServiceAccess accessService = new ServiceAccessImpl();
	IPackageAccess accessPackage = new PackageAccessImpl();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FullAppointDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String userIdString = (String) session.getValue("regno");
		String appIDString = request.getParameter("appId");
		String successMsgString  = "null";
		
		AppointmentModel appointment = appointmnetService.getAppointmentByAppID(appIDString);
		UserModel currentUser = appointmnetService.GetUserById(userIdString);
		VehicleModel vehicle = appointmnetService.getVehicleByAppointmentId(appointment.getAppId());
		PackageForAppoint pack = accessPackage.getPackageByPackId(appointment.getPackID());
		VehicalServices service = accessService.getServiceDetailServices(appointment.getService_id());
		
		List<PackageForAppoint> allPackages = accessPackage.getAllPackages();
		List<VehicalServices> allServices = accessService.getAllServices();
 		
		if (appointment != null) {
			request.setAttribute("Appointment", appointment);
			request.setAttribute("User", currentUser);
			request.setAttribute("Vehicle", vehicle);
			request.setAttribute("Service", service);
			request.setAttribute("Package", pack);
			request.setAttribute("succesMsg", successMsgString);
			request.setAttribute("Allpacks", allPackages);
			request.setAttribute("AllvehiServices", allServices);
			
			request.getRequestDispatcher("RequestDetailsFrontend.jsp").forward(request, response);
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
