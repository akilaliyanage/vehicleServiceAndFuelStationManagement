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
	
		HttpSession session = request.getSession();
		String userId = (String) session.getValue("regno");
		
		String Appoint_No = request.getParameter("CurrentAppID");
		String Current_vehi_no = request.getParameter("CurrentVehiId");
		String brand = request.getParameter("Edit_brand");
		String model = request.getParameter("Edit_model");
		String transmission = request.getParameter("Edit_transmission");
		String fuel = request.getParameter("Edit_fuel");
		String date = request.getParameter("Edit_date");
		String time = request.getParameter("Edit_time");
		String pack = request.getParameter("Edit_pack");
		String Service = request.getParameter("Edit_Service");
		
		System.out.println(Service);
		System.out.println(pack);
		
		AppointmentModel editedAppointment = editAppoinement.UpdateAppointment(Appoint_No , Current_vehi_no , brand , model , transmission , fuel , date , time , pack , Service);
		
		UserModel currentUser = editAppoinement.GetUserById(userId);
		VehicleModel editedVehicle = editAppoinement.getVehicleByAppointmentId(Appoint_No);
		
		IServiceAccess appointedService = new ServiceAccessImpl();
		VehicalServices selectedService = appointedService.getServiceDetailServices(editedAppointment.getService_id());
		
		IPackageAccess appointedPackage = new PackageAccessImpl();
		PackageForAppoint selectedpack = appointedPackage.getPackageByPackId(editedAppointment.getPackID());
		
		List<PackageForAppoint> Allpacks = new ArrayList<PackageForAppoint>();
		List<VehicalServices> AllvehiServices = new ArrayList<VehicalServices>();
		
		IPackageAccess packages = new PackageAccessImpl();
		IServiceAccess sevices = new ServiceAccessImpl();
		
		
		if (editedAppointment != null && currentUser != null && selectedService != null && selectedpack != null) {
			request.setAttribute("Appointment", editedAppointment);
			request.setAttribute("User", currentUser);
			request.setAttribute("Vehicle", editedVehicle);
			request.setAttribute("Service", selectedService);
			request.setAttribute("Package", selectedpack);
			request.setAttribute("Allpacks", Allpacks);
			request.setAttribute("AllvehiServices", AllvehiServices);
			
			request.getRequestDispatcher("RequestDetailsFrontend.jsp").forward(request, response);
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
