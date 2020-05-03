package com.oop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.oop.database.DatabaseConnection;
import com.oop.model.NewAdminModel;
import com.oop.servlet.AdminLoginServlet;


public class NewAdminDAO {

	static Connection connection;
	static PreparedStatement pStatement;
	static PreparedStatement pStatement2;
	
	/** Initialize logger */
	private static final Logger LOGGER = Logger.getLogger(NewAdminDAO.class.getName());
	
	public int insertAdmin(NewAdminModel user) {
		int status = 0;
		int status2 = 0;
		try {
			
			connection = DatabaseConnection.getConnection();
			pStatement = connection.prepareStatement("INSERT INTO `vehicleserviceandfuelstationmanagement`.`user` (`regNo`, `userName`, `userPassword`, `userPhone`, `userEmail`, `userFullName`, `gender`) VALUES (?, ?, ?, ?, ?, ?, ?)");
			pStatement2 = connection.prepareStatement("INSERT INTO `vehicleserviceandfuelstationmanagement`.`admin` (`adminRegNo`, `salary`) VALUES (?, ?)");
			pStatement2.setString(1, user.getUserregNoString());
			pStatement2.setFloat(2, user.getSalaryFloat());
			pStatement.setString(1, user.getUserregNoString());
			pStatement.setString(2, user.getUsernameString());
			pStatement.setString(3, user.getPasswordString());
			pStatement.setString(4, user.getPhoneString());
			pStatement.setString(5, user.getEmailString());
			pStatement.setString(6, user.getFullnameString());
			pStatement.setString(7, user.getGenderString());
			
			status = pStatement.executeUpdate();
			status2 = pStatement2.executeUpdate();
			
			System.out.println(status + " " + status2);
		} catch (Exception e) {
			// TODO: handle exception
			
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		
		return status;
	}
	
}
