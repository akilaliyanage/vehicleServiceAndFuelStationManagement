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

import com.oop.model.PackageForAppoint;
import com.oop.model.VehicalServices;
import com.oop.service.IPackageAccess;
import com.oop.service.IServiceAccess;
import com.oop.service.PackageAccessImpl;
import com.oop.service.ServiceAccessImpl;

/**
 * Servlet implementation class NewAppointmentServlet
 */
@WebServlet("/NewAppointmentServlet")
public class NewAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewAppointmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String)session.getValue("regno");
		IPackageAccess packages = new PackageAccessImpl();
		IServiceAccess sevices = new ServiceAccessImpl();
		
		List<PackageForAppoint> packs = new ArrayList<PackageForAppoint>();
		List<VehicalServices> vehiServices = new ArrayList<VehicalServices>();
		packs = packages.getAllPackages();
		vehiServices = sevices.getAllServices();
		
		request.setAttribute("AllPackages", packs);
		request.setAttribute("AllServices", vehiServices);
		
		request.getRequestDispatcher("SendRequest.jsp").forward(request, response);
		request.getRequestDispatcher("SendRequest.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
