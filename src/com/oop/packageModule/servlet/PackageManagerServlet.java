package com.oop.packageModule.servlet;

//IT19120058
//Geethika L.W.S

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
@WebServlet("/PackageManagerServlet")//Servlet URL Mapping
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
	//HTTP Getter method to Serve the GET Requests which are coming through this servlet
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		if (("getall").equalsIgnoreCase(request.getParameter("id"))) {
			Gson gson = new Gson();
			//Retriveve all the Service packages from the database and set to the response
			String packagesJsonString = gson.toJson(packageExploreService.getAllServicePackagesS());
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(packagesJsonString);
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
	//HTTP POST method to Serve the POST Requests which are coming through this servlet
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String packageData = request.getParameter("package_info");//get package details from the requset and asign to the package data variable
		String method = request.getParameter("method");//read the request method from the request through a parameter and assign it to a variable
		//request.getSession().getAttribute("regno");
		try {//Read Package details and map the data to the corresponding Package entity object through the Object Mapper 
			ServicePackage servicePackage = (ServicePackage) new ObjectMapper().readValue(packageData,ServicePackage.class);
			if(("save").equalsIgnoreCase(method)) {
				packageExploreService.addServicePackage(servicePackage);	//Save package details
			}else if(("update").equalsIgnoreCase(method)) {
				packageExploreService.updateServicePackage(servicePackage); //Update package details
			}else if(("delete").equalsIgnoreCase(method)) {
				packageExploreService.removeServicePackage(servicePackage.getPackId()); // Delete package details
			}
			
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
