/**
 * 
 */
package com.oop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.oop.database.DatabaseConnection;
import com.oop.model.NewUserModel;

/**
 * @author mlaki
 *
 */
public class NewUserDAO {
	
	static Connection connection;
	static PreparedStatement pStatement;
	
	public int insertdata(NewUserModel newUser) {
		
		int status = 0;
		
		try {
			
			connection = DatabaseConnection.getConnection();
			pStatement = connection.prepareStatement("insert into user(username, email, password) values(?,?)");
			pStatement.setString(1, newUser.getUsernameString());
			pStatement.setString(2, newUser.getEmailString());
			pStatement.setString(3, newUser.getPasswordString());
			
			status = pStatement.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
		return status;
		
		
		
	}

}
