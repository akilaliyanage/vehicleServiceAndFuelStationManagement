/**
 * 
 */
package com.oop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.oop.database.DatabaseConnection;
import com.oop.servlet.AdminLoginServlet;


public class DeleteMechDAO {
	
	/** Initialize logger */
	private static final Logger LOGGER = Logger.getLogger(DeleteMechDAO.class.getName());

	static Connection connection;
	static PreparedStatement preparedStatement;
	
	
	public int removeMech(String regnoString) {
		int rslt = 0;
		
		try {
			
			connection = DatabaseConnection.getConnection();
			preparedStatement = connection.prepareStatement("DELETE FROM `vehicleserviceandfuelstationmanagement`.`user` WHERE (`regNo` = ?)");
			preparedStatement.setString(1, regnoString);
			
			rslt = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		
		return rslt;
	}

}
