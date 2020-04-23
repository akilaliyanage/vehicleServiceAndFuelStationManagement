package com.oop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class getDateServlet
 */
@WebServlet("/getDateServlet")
public class getDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getDateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String AppDate = request.getParameter("Date");
		String AppTime = request.getParameter("Time");
		System.out.println(AppDate);
		System.out.println(AppTime);
		
		Cookie prefDateCookie = new Cookie("PrefDate", AppDate);
		Cookie prefTimeCookie = new Cookie("PrefTime", AppTime);
		
		response.addCookie(prefDateCookie);
		response.addCookie(prefTimeCookie);
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
