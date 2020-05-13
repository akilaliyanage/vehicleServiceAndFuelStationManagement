package com.oop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.oop.database.DatabaseConnection;
import com.oop.servlet.AdminLoginServlet;

public class DeleteUserDAO {

	static Connection connection;
	static PreparedStatement preparedStatement;
	/** Initialize logger */
	private static final Logger LOGGER = Logger.getLogger(DeleteUserDAO.class.getName());
	
	
	public int removeUser(String regnoString) {
		int rslt = 0;
		
		try {
				//initialization of the database connection
			connection = DatabaseConnection.getConnection();
			preparedStatement = connection.prepareStatement("DELETE FROM `vehicleserviceandfuelstationmanagement`.`user` WHERE (`regNo` = ?)");
			preparedStatement.setString(1, regnoString);
			
			rslt = preparedStatement.executeUpdate();
			
		} //exception handling
		catch (SQLException e) {
			// TODO: handle exception
			LOGGER.log(Level.SEVERE, e.getMessage());
		}catch (Exception e) {
			// TODO: handle exception
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		
		return rslt;
	}

}
