package com.oop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.oop.database.DatabaseConnection;
import com.oop.model.UpdateAdminModel;


public class UpdateAdminDAO {
	
	static Connection connection;
	static PreparedStatement pStatement;
	static PreparedStatement pStatement2;
	
	
	public int updateAdmin(UpdateAdminModel user) {
		int result = 0;
		int result2= 0;
		
		try {
			
			connection = DatabaseConnection.getConnection();
			pStatement = connection.prepareStatement("UPDATE `vehicleserviceandfuelstationmanagement`.`user` SET `userName` = ?, `userPassword` = ?, `userPhone` = ?, `userEmail` = ?, `userFullName` = ? WHERE (`regNo` = ?)");
			pStatement2 = connection.prepareStatement("UPDATE `vehicleserviceandfuelstationmanagement`.`admin` SET `salary` = ? WHERE (`adminRegNo` = ?)");
			pStatement2.setFloat(1, user.getSalFloat());
			pStatement2.setString(2, user.getRegnString());
			pStatement.setString(1, user.getUsernameString());
			pStatement.setString(2, user.getPasswordString());
			pStatement.setString(3, user.getPhoneString());
			pStatement.setString(4, user.getEmailString());
			pStatement.setString(5, user.getFullnameString());
			pStatement.setString(6, user.getRegnString());
			
			result = pStatement.executeUpdate(); 
			result2 = pStatement2.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return result;
		
	}
		
}
