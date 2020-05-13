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

import com.oop.packageModule.model.ServicePackage;
import com.oop.packageModule.service.PackageExploreService;
import com.oop.packageModule.service.PackageExploreServiceImpl;

/**
 * Servlet implementation class HomePageRedirectServlet
 */
@WebServlet("/HomePageRedirectServlet") //Servlet URL mapping
public class HomePageRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Created an instance of the package explore service to call the methods available in it
	PackageExploreService packageExploreService = new PackageExploreServiceImpl();

	public HomePageRedirectServlet() {
		super();
	}

	//Use do Get method to manage the GET HTTP calls towards this Servlet and it Redirects to the Home page
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<ServicePackage> packages = packageExploreService.getAllServicePackagesS();//Retrieve all the service packages and assign them to a variable
		request.setAttribute("packageList", packages);  //set the retrieved packages to request through an attribute, since it needs to be access from the front end homepage
		request.getRequestDispatcher("homepage.jsp").forward(request, response); //redirects to the homepage with the request attributes bound.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
