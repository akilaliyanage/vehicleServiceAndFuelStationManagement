package com.oop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.oop.database.DatabaseConnection;
import com.oop.model.InquiryModel;

public class InquiryDAO {
		
	static Connection connection;
	static PreparedStatement preparedStatement;
	
	public int insertInq(InquiryModel inq) {
		int result = 0;
		
		
		try {
			connection = DatabaseConnection.getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO `vehicleserviceandfuelstationmanagement`.`inquiry` (`inquiryId`,`type`, `userDesc`, `RegId`) VALUES (?, ?, ?, ?)");
			preparedStatement.setString(1, inq.getInqidString());
			preparedStatement.setString(2, inq.getTypeString());
			preparedStatement.setString(3, inq.getUsermessageString());
			preparedStatement.setString(4, inq.getUseridString());
			
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
