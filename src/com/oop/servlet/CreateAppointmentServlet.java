package com.oop.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
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

import javax.servlet.http.Cookie;

/**
 * Servlet implementation class CreateAppointmentServlet
 * This servlet acepts parametes from SendRequest.jsp and process them and creates appointment objects.
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
	
		
		//used sessions to know the logged user
		HttpSession session = request.getSession();
		String userId = (String) session.getValue("regno");
		Date AppointDate = null;	
		String appointTime = null;
		String succesMsg = "Success";
		
		
		String vehi_nameString  = request.getParameter("vehi_No");
		String vehiBrand  = request.getParameter("brand");
		String vehiModel  = request.getParameter("model");
		String vehiTransmission  = request.getParameter("Transmission");
		String vehiFuel  = request.getParameter("Fuel");
		String vehEngine  = request.getParameter("Engine");
		int vehiYear  = Integer.parseInt(request.getParameter("year"));
		String serviceID = null;
		int appointDay = 1;
		System.out.println("check for veho No "  + vehi_nameString);
		String packID = null;
		
		
		
		/*
		 * getting the values in the cookies generated in getDateServlet , getVehicleDetailsServlet
		 * and
		 * */
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
		
		//Date is in tho cookie is not in a proper format.before sending it to the service level
		//this will turn it into a proper format.
		try {
			AppointDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("AppDate"));
			//SelectedTime = new SimpleDateFormat("hh:mm:ss").parse(request.getParameter(appointTime));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		AppointmentModel createdAppointmentModel = appointmentServices.createAppointment(userId, vehi_nameString, AppointDate, vehiBrand, vehiModel, vehiTransmission, vehiFuel, vehEngine, vehiYear, serviceID, appointTime, packID, appointDay);
		UserModel currentUser = appointmentServices.GetUserById(userId);
		VehicleModel appointedVehicle = appointmentServices.getVehicleByAppointmentId(createdAppointmentModel.getAppId());
		System.out.println("checking vehi Fuel is : " + appointedVehicle.getFuelType());
		IServiceAccess appointedService = new ServiceAccessImpl();
		VehicalServices selectedService = appointedService.getServiceDetailServices(serviceID);
		
		IPackageAccess appointedPackage = new PackageAccessImpl();
		PackageForAppoint selectedpack = appointedPackage.getPackageByPackId(packID);
		
		List<PackageForAppoint> Allpacks = new ArrayList<PackageForAppoint>();
		List<VehicalServices> AllvehiServices = new ArrayList<VehicalServices>();
		
		IPackageAccess packages = new PackageAccessImpl();
		IServiceAccess sevices = new ServiceAccessImpl();
		
		Allpacks = packages.getAllPackages();
		AllvehiServices = sevices.getAllServices();
		
		if (createdAppointmentModel != null && currentUser != null && appointedVehicle != null && selectedService != null && selectedpack != null) {
			request.setAttribute("Appointment", createdAppointmentModel);
			request.setAttribute("User", currentUser);
			request.setAttribute("Vehicle", appointedVehicle);
			request.setAttribute("Service", selectedService);
			request.setAttribute("Package", selectedpack);
			request.setAttribute("Allpacks", Allpacks);
			request.setAttribute("AllvehiServices", AllvehiServices);
			request.setAttribute("succesMsg", succesMsg);
			System.out.println("suuccess msg is : " + succesMsg);
			
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
