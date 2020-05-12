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
@WebServlet("/PackageExplore")
public class PackageExploreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		ServicePackage servicePackage = packageExploreService.getServicePackageById(id);
		List<ServicePackage> packages =  packageExploreService.getAllServicePackagesS(); 
		JSONObject object=new JSONObject();
		object.put("name","simerpreet");
		object.put("mark1",new Integer(100));
		object.put("mark2",new Double(40));
		object.put("Scored",new Double(66.67));
		object.put("nickname","simer");

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
