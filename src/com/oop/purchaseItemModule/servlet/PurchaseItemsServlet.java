package com.oop.purchaseItemModule.servlet;

//IT19120058
//Geethika L.W.S

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.oop.packageModule.model.ServicePackage;
import com.oop.packageModule.service.PackageExploreService;
import com.oop.packageModule.service.PackageExploreServiceImpl;
import com.oop.purchaseItemModule.model.CartItem;
import com.oop.purchaseItemModule.model.RegUserItem;
import com.oop.purchaseItemModule.service.ItemService;
import com.oop.purchaseItemModule.service.ItemServiceImpl;

/**
 * Servlet implementation class PurchaseItemsServlet
 */
@WebServlet("/PurchaseItemsServlet")//URL mapping to access the servlet
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
	//HTTP GET method to serve the GET requests comes through this servlet 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
	//HTTP POST method to serve the POST requests comes through this servlet 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		List<RegUserItem> userItems = new ArrayList<RegUserItem>();
		String user = (String) request.getSession().getAttribute("regno");
		String packageData = request.getParameter("package_info");
		String cartNo = request.getParameter("cartNo");
		request.getSession().setAttribute("cartNo", cartNo);
		ObjectMapper mapper = new ObjectMapper();
		
		//Read Cart items sent from the front end and loop through each objects using a 
		//for loop to create separate cart items objects to save in the database
		List<CartItem> items = Arrays.asList(mapper.readValue(packageData, CartItem[].class));
		for (CartItem cartItem : items) {
			RegUserItem userItem = new RegUserItem();
			userItem.setItemId(cartItem.getItemId());
			userItem.setCustId(user);
			userItem.setQuantity(Integer.parseInt(cartItem.getQuantity()));
			userItem.setCartNo(cartNo);
			userItems.add(userItem);
		}
		itemService.savePurchasedItems(userItems);
	}

}
