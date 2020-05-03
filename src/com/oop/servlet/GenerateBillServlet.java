package com.oop.servlet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GenerateBillServlet
 */
//@WebServlet("/GenerateBillServlet")
public class GenerateBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateBillServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String billIdString = request.getParameter("id");
		
	    try {
	    	String path = getServletContext().getRealPath("").toString() + "bill\\";
	    	System.out.println(path);
	        File myObj = new File(path + billIdString+".txt");
	        if (myObj.createNewFile()) {
	          System.out.println("File created: " + myObj.getName());
	          FileWriter myWriter = new FileWriter("filename.txt");
	          myWriter.write("Files in Java might be tricky, but it is fun enough!");
	          myWriter.close();
	          System.out.println("Successfully wrote to the file.");
	        } else {
	          System.out.println("File already exists.");
	        }
	      } catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
		
		
	}

	

}
