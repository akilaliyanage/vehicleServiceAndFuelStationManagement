/**
 * 
 */
package com.oop.DAO;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.oop.database.DatabaseConnection;
import com.oop.model.NewUserModel;


/**
 * @author mlaki
 *
 */
public  class UpdateUserImageDAO {
	
	static Connection connection;
	static PreparedStatement pStatement;
	
	/** Initialize logger */
	private static final Logger LOGGER = Logger.getLogger(UpdateUserImageDAO.class.getName());
	
	
	public int updateImage(String regNo, String imgPathString) {
		int status = 0;
		
		
		
		try {
			//sql connection
			connection = DatabaseConnection.getConnection();
			pStatement = connection.prepareStatement("update User set userImage = ? where regNo = ?");
			pStatement.setString(1, imgPathString);
			pStatement.setString(2, regNo);
			
			status = pStatement.executeUpdate();
			
			System.out.println(status);
			
			//logger and exceptions
		} catch (SQLException e) {
			// TODO: handle exception
			LOGGER.log(Level.SEVERE,e.getMessage());
		} 
		catch (Exception e) {
			// TODO: handle exception 
			LOGGER.log(Level.SEVERE,e.getMessage());
			
		}		
		return status;
	}
	

	
	
}
