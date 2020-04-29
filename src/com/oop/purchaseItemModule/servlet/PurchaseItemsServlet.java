package com.oop.purchaseItemModule.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.oop.packageModule.model.ServicePackage;
import com.oop.packageModule.service.PackageExploreService;
import com.oop.packageModule.service.PackageExploreServiceImpl;
import com.oop.purchaseItemModule.service.ItemService;
import com.oop.purchaseItemModule.service.ItemServiceImpl;

/**
 * Servlet implementation class PurchaseItemsServlet
 */
@WebServlet("/PurchaseItemsServlet")
public class PurchaseItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ItemService itemService = new ItemServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PurchaseItemsServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		if (("getall").equalsIgnoreCase(request.getParameter("id"))) {
			Gson gson = new Gson();
			String employeeJsonString = gson.toJson(itemService.getAllItems());
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(employeeJsonString);
			out.flush();
		} else {
			request.setAttribute("Massage", "Hello");
			request.getRequestDispatcher("sandamali/purchaseItemsPage.jsp").forward(request, response);
		}
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
