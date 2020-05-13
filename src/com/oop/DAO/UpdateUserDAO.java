/**
 * 
 */
package com.oop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	
	/** Initialize logger */
	private static final Logger LOGGER = Logger.getLogger(PurchaseFuelDAO.class.getName());

	public int updateUser(UpdateUserModel user) {
		int status = 0;

		try {
			//sql connection

			connection = DatabaseConnection.getConnection();
			pStatement = connection.prepareStatement(
					"update User set userfullName = ?,userPhone = ?,gender=?,UserDescription = ?,userEmail = ?,userName = ?,userPassword = ? where regNo = ?");
			pStatement.setString(1, user.getNameString());
			pStatement.setString(2, user.getPhoneString());
			pStatement.setString(3, user.getGenderString());
			pStatement.setString(4, user.getDescriptionString());
			pStatement.setString(5, user.getEmailString());
			pStatement.setString(6, user.getUsernameString());
			pStatement.setString(7, user.getPasswordString());
			pStatement.setString(8, user.getUserregNoString());

			status = pStatement.executeUpdate();
			
			System.out.println(status);
			
			

			//connection.close();

		} //exception handling and loggers
		catch (SQLException e) {
			// TODO: handle exception
			LOGGER.log(Level.SEVERE,e.getMessage());
		}catch (Exception e) {
			// TODO: handle exception
			LOGGER.log(Level.SEVERE,e.getMessage());
		}

		return status;
	}

}
