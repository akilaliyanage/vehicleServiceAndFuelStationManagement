/**
 * 
 */
package com.oop.DAO;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.oop.database.DatabaseConnection;
import com.oop.model.NewUserModel;


/**
 * @author mlaki
 *
 */
public  class UpdateUserImageDAO {
	
	static Connection connection;
	static PreparedStatement pStatement;
	public int updateImage(String regNo, String imgPathString) {
		int status = 0;
		
		
		
		try {
			
			connection = DatabaseConnection.getConnection();
			pStatement = connection.prepareStatement("update User set userImage = ? where regNo = ?");
			pStatement.setString(1, imgPathString);
			pStatement.setString(2, regNo);
			
			status = pStatement.executeUpdate();
			
			System.out.println(status);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return status;
	}
	

	
	
}
