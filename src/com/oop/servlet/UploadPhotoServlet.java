package com.oop.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

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
       
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String regno = (String) session.getAttribute("regno");
		String url = getServletContext().getRealPath("")+"img\\userImages\\";
		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
		int status;
		
		try {
			
			List<FileItem> image = sf.parseRequest(request);
			
			for(FileItem item : image) {
				
			    File file = new File(url + File.separator + item.getName()); 
			    
			    if(file.delete()) 
		        { 
		            System.out.println("File deleted successfully"); 
		        } 
			   
				item.write(new File( url + File.separator + item.getName()));
				
				String imgPathString = url + File.separator + item.getName();
				
				UpdateUserImageDAO updateImage = new UpdateUserImageDAO();
				
				status = updateImage.updateImage(regno, item.getName());
				
				 
				
				response.sendRedirect("UpdateUserDashboard");
				
				System.out.println("file uploded");
				System.out.println(url);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		
		
	}

}