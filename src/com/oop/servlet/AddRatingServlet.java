package com.oop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.service.AppointmentServices;
import com.oop.service.AppointmentServicesImpl;

/**
 * Servlet implementation class AddRatingServlet
 * This servlet is used to add ratings to a appointment
 * this servlet is used in the  RequestDetailsFrontend.jsp 
 */
@WebServlet("/AddRatingServlet")
public class AddRatingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AppointmentServices appointServices = new AppointmentServicesImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRatingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int Rating = Integer.parseInt(request.getParameter("Rating"));
		String appointmentID = request.getParameter("appId");
		System.out.println(appointmentID);
		appointServices.Setrating(Rating , appointmentID);
		
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
