/**
 * 
 */
package com.oop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.oop.database.DatabaseConnection;
import com.oop.model.UpdateUserModel;

/**
 * @author mlaki
 *
 */
public class UpdateUserDAO {
	
	static Connection connection;
	static PreparedStatement pStatement;
	
	public int updateUser(UpdateUserModel user) {
		int status = 0;
		
		try {
			
			connection = DatabaseConnection.getConnection();
			pStatement = connection.prepareStatement("insert into user(name,email,phone,gender,description) values (?,?,?,?,?)");
			pStatement.setString(1, user.getNameString());
			pStatement.setString(2, user.getEmailString());
			pStatement.setString(3, user.getPhoneString());
			pStatement.setString(4, user.getGenderString());
			pStatement.setString(5, user.getDescriptionString());

			status = pStatement.executeUpdate();
			
			connection.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return status;
	}

}
