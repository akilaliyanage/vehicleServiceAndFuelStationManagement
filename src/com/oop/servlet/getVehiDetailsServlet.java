package com.oop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class getVehiDetailsServlet
 */
@WebServlet("/getVehiDetailsServlet")
public class getVehiDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getVehiDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//generating cookies using parameters
		//cookies are used to create appointment object in CreateAppointmentServlet
		 Cookie[] vehical_Details = new Cookie[8];
		 vehical_Details[0] = new Cookie("vehicalNo", request.getParameter("vehi_No"));
		 System.out.println( request.getParameter("vehi_No"));
		 vehical_Details[1] = new Cookie("brand", request.getParameter("brand"));
		 vehical_Details[2] = new Cookie("Model", request.getParameter("Model"));
		 vehical_Details[3] = new Cookie("year", request.getParameter("year"));
		 vehical_Details[4] = new Cookie("Transmission", request.getParameter("Transmission"));
		 vehical_Details[5] = new Cookie("Fuel", request.getParameter("Fuel"));
		 vehical_Details[6] = new Cookie("Engine", request.getParameter("Engine"));
		 vehical_Details[7] = new Cookie("Milage", request.getParameter("Milage"));
		 System.out.println(vehical_Details.length);
		 
		 try {
			 for(int i = 0 ; i < vehical_Details.length ; i++ ) {
				 response.addCookie(vehical_Details[i]);
				 
			 }
			
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
		 
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
