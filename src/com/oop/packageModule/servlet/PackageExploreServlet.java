package com.oop.packageModule.servlet;

//IT19120058
//Geethika L.W.S

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.oop.packageModule.model.ServicePackage;
import com.oop.packageModule.service.PackageExploreService;
import com.oop.packageModule.service.PackageExploreServiceImpl;

/**
 * Servlet implementation class PackageExploreServlet
 */
@WebServlet("/PackageExplore")// Servlet URL Mapping
public class PackageExploreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Created an instance of PackageExploreService to access the methods in it
	PackageExploreService packageExploreService = new PackageExploreServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PackageExploreServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	//Do Get Method to manage and serve all the HTTP GET request comes to the servlet
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");//Read a parameter sent through in the request
		ServicePackage servicePackage = packageExploreService.getServicePackageById(id); //Retrieve a Service Package using its ID
		List<ServicePackage> packages =  packageExploreService.getAllServicePackagesS(); //Retrieve all the service packages
		JSONObject object=new JSONObject();// Initialize a JSON object to use in the front end

		String output=object.toString();
		request.setAttribute("servicePackage",servicePackage);
		request.setAttribute("output",output);
		request.setAttribute("myList",packages);
		request.setAttribute("jsonResponse", servicePackage.toString());
		// request.setAttribute("message", JSONSerializer.toJSON(customers).toString());
		request.getRequestDispatcher("sandamali/packages.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("answer", "WinterMotive Package");
		// request.setAttribute("message", JSONSerializer.toJSON(customers).toString());
		request.getRequestDispatcher("sandamali/packages.jsp").forward(request, response);
	}

}
