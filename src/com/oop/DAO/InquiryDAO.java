package com.oop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.oop.database.DatabaseConnection;
import com.oop.model.InquiryModel;
import com.oop.servlet.AdminLoginServlet;

public class InquiryDAO {
		
	static Connection connection;
	static PreparedStatement preparedStatement;
	
	/** Initialize logger */
	private static final Logger LOGGER = Logger.getLogger(InquiryDAO.class.getName());
	
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
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		
		return result;
	}
	
	public ArrayList<InquiryModel> getInqDetails(){
		
		ArrayList<InquiryModel> inquiryModels = new ArrayList<InquiryModel>();
		
		try {
			
			connection = DatabaseConnection.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM vehicleserviceandfuelstationmanagement.inquiry i, vehicleserviceandfuelstationmanagement.user u where i.RegId = u.regNo");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				InquiryModel objModel = new InquiryModel();
				objModel.setInqidString(resultSet.getString("inquiryId"));
				objModel.setTypeString(resultSet.getString("type"));
				objModel.setUsermessageString(resultSet.getString("userDesc"));
				objModel.setUsernameString(resultSet.getString("userFullName"));
				objModel.setEmailString(resultSet.getString("userEmail"));
				objModel.setAdminmessageString(resultSet.getString("adminDesc"));
				objModel.setAdminidString(resultSet.getString("adminId"));
				
				inquiryModels.add(objModel);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		
		return inquiryModels;
	}
	
	public int saveReply(String adminIdString, String messageString, String inqidString) {
		
		int result = 0;
		
		try {
			
			connection = DatabaseConnection.getConnection();
			preparedStatement = connection.prepareStatement("UPDATE `vehicleserviceandfuelstationmanagement`.`inquiry` SET `adminDesc` = ?, `adminId` = ? WHERE (`inquiryId` = ?)");
			preparedStatement.setString(1, messageString);
			preparedStatement.setString(2, adminIdString);
			preparedStatement.setString(3, inqidString);
			
			result = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		
		return result;
		
	}

}
