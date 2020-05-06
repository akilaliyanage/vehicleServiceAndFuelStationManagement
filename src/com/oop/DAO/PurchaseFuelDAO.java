package com.oop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.oop.database.DatabaseConnection;
import com.oop.model.PurchaseFuelModel;

public class PurchaseFuelDAO {

	static Connection connection;
	static PreparedStatement preparedStatement;
	
	
	public int buyFuel(PurchaseFuelModel fuelModel) {
		int result = 0;
		
		try {
			connection = DatabaseConnection.getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO `vehicleserviceandfuelstationmanagement`.`user_dispenser` (`dispenserId`, `userId`, `amount`, `PurchaseID`) VALUES (?, ?, ?, ?)");
			preparedStatement.setString(1, fuelModel.getDisidString());
			preparedStatement.setString(2, fuelModel.getUseridString());
			preparedStatement.setFloat(3, fuelModel.getAmount());
			preparedStatement.setString(4, fuelModel.getPuridString());
			
			result = preparedStatement.executeUpdate();
			//System.out.println(result);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
		
	}
	
	
	

}
