package com.oop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.oop.database.DatabaseConnection;
import com.oop.model.PaymentModel;

public class PaymentDAO {

	static Connection connection;
	static PreparedStatement pStatement;
	
	public ArrayList<PaymentModel> getPayInfo(String regno) {
		
		ArrayList<PaymentModel> arraypayArrayList = new ArrayList<PaymentModel>();
		
		try {
			
			connection = DatabaseConnection.getConnection();
			pStatement = connection.prepareStatement("SELECT * FROM vehicleserviceandfuelstationmanagement.appointment where userRegNo = ?");
			pStatement.setString(1, regno);
			
			System.out.println(regno);
			
			ResultSet rSet = pStatement.executeQuery();
			
			while(rSet.next()) {
				
				PaymentModel pay = new PaymentModel();
				pay.setIdString(rSet.getString("appId"));
				pay.setTotal(rSet.getFloat("amount"));
				
				System.out.println(rSet.getString("appId"));
				
				arraypayArrayList.add(pay);
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return arraypayArrayList;
		
	}
	
	

}
