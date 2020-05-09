//Created by D.H.M.M.P.Thammita
//IT No : IT19120362

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
 * This servlet is used to get the date and time to the server side when user
 * is creating an appointment
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
		
		Cookie prefDayCookie = new Cookie("PrefDay", AppDate);
		Cookie prefTimeCookie = new Cookie("PrefTime", AppTime);
		
		/*
		 * these cookies are used in CreateAppointment Servlet when creating the appointment.
		 * */
		response.addCookie(prefDayCookie);
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
