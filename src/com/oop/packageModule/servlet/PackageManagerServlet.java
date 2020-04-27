package com.oop.packageModule.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.oop.packageModule.model.ServicePackage;
import com.oop.packageModule.service.PackageExploreService;
import com.oop.packageModule.service.PackageExploreServiceImpl;

/**
 * Servlet implementation class PackageManageServlet
 */
@WebServlet("/PackageManagerServlet")
public class PackageManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PackageExploreService packageExploreService = new PackageExploreServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PackageManagerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		if (("getall").equalsIgnoreCase(request.getParameter("id"))) {
			Gson gson = new Gson();
			String employeeJsonString = gson.toJson(packageExploreService.getAllServicePackagesS());
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(employeeJsonString);
			out.flush();
		} else {
			request.setAttribute("Massage", "Hello");
			request.getRequestDispatcher("sandamali/managePackage.jsp").forward(request, response);	
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String packageData = request.getParameter("package_info");
		String method = request.getParameter("method");
		
		try {
			ServicePackage servicePackage = (ServicePackage) new ObjectMapper().readValue(packageData,ServicePackage.class);
			if(("save").equalsIgnoreCase(method)) {
				packageExploreService.addServicePackage(servicePackage);	
			}else if(("update").equalsIgnoreCase(method)) {
				packageExploreService.updateServicePackage(servicePackage);
			}else if(("delete").equalsIgnoreCase(method)) {
				packageExploreService.removeServicePackage(servicePackage.getPackId());
			}
			
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
