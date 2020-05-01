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
	static PreparedStatement pStatement2;
	
	public ArrayList<PaymentModel> getPayInfo(String regno) {
		
		ArrayList<PaymentModel> arraypayArrayList = new ArrayList<PaymentModel>();
		
		try {
			
			connection = DatabaseConnection.getConnection();
			pStatement = connection.prepareStatement("select a.appId, a.amount from vehicleserviceandfuelstationmanagement.appointment a left join vehicleserviceandfuelstationmanagement.payments p on a.appId = p.appId where a.userRegNo = ? and p.appId is null");
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
	
	public int savePay(String payIdString,String billidString,String idString,float tot,String regnoString) {
		
		int result = 0;
		int result2 = 0;
		
		
		
		try {
			
			connection = DatabaseConnection.getConnection();
			pStatement = connection.prepareStatement("INSERT INTO `vehicleserviceandfuelstationmanagement`.`payments` (`paymentId`, `userRegNo`, `amount` , `appId`) VALUES (?, ?, ?,?)");
			pStatement.setString(1, payIdString);
			pStatement.setString(2, regnoString);
			pStatement.setFloat(3, tot);
			pStatement.setString(4, idString);
			
			
			result = pStatement.executeUpdate();
			
			pStatement2 = connection.prepareStatement("INSERT INTO `vehicleserviceandfuelstationmanagement`.`bill` (`billId`, `paymentId`) VALUES (?, ?)");
			pStatement2.setString(1, billidString);
			pStatement2.setString(2, payIdString);
			
			result2 = pStatement2.executeUpdate();
			System.out.println(result);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	

}
