/**
 * 
 */
package com.oop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.oop.database.DatabaseConnection;
import com.oop.model.NewMechModel;

/**
 * @author mlaki
 *
 */
public class UpdateMechDAO {
	
	static Connection connection;
	static PreparedStatement preparedStatement;
	static PreparedStatement preparedStatement2;

	
	public NewMechModel updateMech(String unameString, String passwordString){
		
		ArrayList<String> models = new ArrayList<String>();
		
		NewMechModel mechModel = null;

		
		try {
			
			connection = DatabaseConnection.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM vehicleserviceandfuelstationmanagement.mechanic m, vehicleserviceandfuelstationmanagement.user u where m.regNo = u.regNo and u.userName = ? and u.userPassword = ? and u.regNo like 'MEC%'");
			preparedStatement.setString(1, unameString);
			preparedStatement.setString(2, passwordString);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				mechModel = new NewMechModel(resultSet.getString("userName"), resultSet.getString("userEmail"), resultSet.getString("userPassword"), resultSet.getString("regNo"));
				
				mechModel.setFullnameString(resultSet.getString("userFullName"));
				mechModel.setGenderString(resultSet.getString("gender"));
				mechModel.setPhoneString(resultSet.getString("userPhone"));
				mechModel.setSal(resultSet.getFloat("basicSalary"));
				mechModel.setSpecString(resultSet.getString("speciality"));
				mechModel.setWh(resultSet.getFloat("workingHours"));
				mechModel.setEx(resultSet.getFloat("experience"));
								
				

				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return mechModel;
		
	}
	
	public int saveMechDetails(NewMechModel user) {
		
		int result = 0;
		int result2 = 0;
		
		try {
			
			connection = DatabaseConnection.getConnection();
			preparedStatement = connection.prepareStatement("UPDATE `vehicleserviceandfuelstationmanagement`.`user` SET `userName` = ?, `userPassword` = ?, `userPhone` = ?, `userEmail` = ?, `userFullName` = ?, `gender` = ?  WHERE (`regNo` = ?)");
			preparedStatement.setString(1, user.getUsernameString());
			preparedStatement.setString(2, user.getPasswordString());
			preparedStatement.setString(3, user.getPhoneString());
			preparedStatement.setString(4, user.getEmailString());
			preparedStatement.setString(5, user.getFullnameString());
			preparedStatement.setString(6, user.getGenderString());
			preparedStatement.setString(7, user.getUserregNoString());
			
			result = preparedStatement.executeUpdate();
			
			System.out.println(result);
			
			preparedStatement2 = connection.prepareStatement("UPDATE `vehicleserviceandfuelstationmanagement`.`mechanic` SET `basicSalary` = ? , `speciality` = ? , `experience` = ? , `workingHours` = ? where `regNo` = ?"); 
			preparedStatement2.setFloat(1, user.getSal());
			preparedStatement2.setString(2, user.getSpecString());
			preparedStatement2.setFloat(3, user.getEx());
			preparedStatement2.setFloat(4, user.getWh());
			preparedStatement2.setString(5, user.getUserregNoString());
			
			result2 = preparedStatement2.executeUpdate();
			
			System.out.println(result2);

			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
		
	}
	
}
