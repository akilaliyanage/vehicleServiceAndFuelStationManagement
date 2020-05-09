package com.oop.servlet;

import java.io.File;
import java.io.IOException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oop.DAO.UpdateUserImageDAO;

/**
 * Servlet implementation class UploadPhotoServlet
 */
//@WebServlet("/UploadPhotoServlet")
@MultipartConfig
public class UploadPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(UploadPhotoServlet.class.getName());   
   
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String regno = (String) session.getAttribute("regno");
		String url = getServletContext().getRealPath("")+"img\\userImages\\";		//setting the image save location
		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
		int status;
		
		try {
			
			//creating a file itm object to save the image fetched from the request object
			List<FileItem> image = sf.parseRequest(request);
			
			for(FileItem item : image) {
				
			    File file = new File(url + File.separator + item.getName()); 
			    
			    //checks the availability of the same file; this will delet the image file if it already exist in the given location
			    if(file.delete()) 
		        { 
		            System.out.println("File deleted successfully"); 
		        } 
			   
			    //writes the image to the location
				item.write(new File( url + File.separator + item.getName()));
				
				String imgPathString = url + File.separator + item.getName();
				
				UpdateUserImageDAO updateImage = new UpdateUserImageDAO();
				
				status = updateImage.updateImage(regno, item.getName());
				
				 
				
				response.sendRedirect("UpdateUserDashboard");
				
				System.out.println("file uploded");
				System.out.println(url);
				
			}
		} 
		catch (IOException e) {
			// TODO: handle exception
			LOGGER.log(Level.SEVERE, e.getMessage());
		}catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		
		
	}

}