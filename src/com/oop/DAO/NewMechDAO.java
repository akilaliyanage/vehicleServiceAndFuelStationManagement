package com.oop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.oop.database.DatabaseConnection;
import com.oop.model.NewMechModel;
import com.oop.servlet.AdminLoginServlet;

public class NewMechDAO {

	static Connection connection;
	static PreparedStatement preparedStatement;
	static PreparedStatement preparedStatement2;
	
	/** Initialize logger */
	private static final Logger LOGGER = Logger.getLogger(NewMechDAO.class.getName());
	
	public int newMech(NewMechModel user) {
		
		int result = 0;
		int result2 = 0;
		
		try {
			
			connection = DatabaseConnection.getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO `vehicleserviceandfuelstationmanagement`.`user` (`regNo`, `userName`, `userPassword`, `userPhone`, `userEmail`, `userFullName`, `gender`) VALUES (?, ?, ?, ?, ?, ?, ?)");
			preparedStatement2 = connection.prepareStatement("INSERT INTO `vehicleserviceandfuelstationmanagement`.`mechanic` (`regNo`, `basicSalary`, `speciality`, `experience`, `workingHours`) VALUES (?, ?, ?, ?, ?)"); 
			preparedStatement2.setString(1, user.getUserregNoString());
			preparedStatement2.setFloat(2, user.getSal());
			preparedStatement2.setString(3, user.getSpecString());
			preparedStatement2.setFloat(4, user.getEx());
			preparedStatement2.setFloat(5, user.getWh());
				
			preparedStatement.setString(1,user.getUserregNoString());
			preparedStatement.setString(2, user.getUsernameString());
			preparedStatement.setString(3, user.getPasswordString());
			preparedStatement.setString(4, user.getPhoneString());
			preparedStatement.setString(5, user.getEmailString());
			preparedStatement.setString(6, user.getFullnameString());
			preparedStatement.setString(7, user.getGenderString());
			
			result = preparedStatement.executeUpdate();
			result2 = preparedStatement2.executeUpdate();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		
		
		return result;
	}

}
