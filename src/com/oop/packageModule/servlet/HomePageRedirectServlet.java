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
@WebServlet("/HomePageRedirectServlet")
public class HomePageRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PackageExploreService packageExploreService = new PackageExploreServiceImpl();

	public HomePageRedirectServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<ServicePackage> packages = packageExploreService.getAllServicePackagesS();
		request.setAttribute("packageList", packages);
		request.getRequestDispatcher("homepage.jsp").forward(request, response);
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
