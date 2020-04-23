/**
 * 
 */
package com.oop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

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
			pStatement = connection.prepareStatement(
					"update User set userfullName = ?,userPhone = ?,gender=?,UserDescription = ?,userEmail = ?,userName = ?,userPassword = ? where regNo = ?");
			pStatement.setString(1, user.getNameString());
			pStatement.setString(2, user.getPhoneString());
			pStatement.setString(3, user.getGenderString());
			pStatement.setString(4, user.getDescriptionString());
			pStatement.setString(5, user.getEmailString());
			pStatement.setString(6, user.getUsernameString());
			pStatement.setString(7, user.getPassworString());
			pStatement.setString(8, user.getUserIdString());

			status = pStatement.executeUpdate();
			
			System.out.println(status);
			
			

			//connection.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

		return status;
	}

}
