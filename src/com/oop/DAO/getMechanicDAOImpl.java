//created by D.H.M.M.P.Thammita
//IT No : IT19120362
package com.oop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oop.database.DatabaseConnection;
import com.oop.model.NewMechModel;


public class getMechanicDAOImpl implements IgetMechanicDAO{
	private  Connection connection;
	private  PreparedStatement Statement;
	
	/*
	 * This method will accept No arguments and returns the List of all mechanics That are available
	 * in the system 
	 * */
	@Override
	public List<NewMechModel> getAllMechanics() {
		connection = DatabaseConnection.getConnection();
		List<NewMechModel> allMechanics = new ArrayList<NewMechModel>();
		try {
			Statement = connection.prepareStatement("SELECT * FROM mechanic m , user u WHERE u.regNo = m.regNo");
			ResultSet result = Statement.executeQuery();
			allMechanics = getMechList(result);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
					System.out.println(e);
				}
			}
		}
		return allMechanics;
	}
	private List<NewMechModel> getMechList(ResultSet result) {
		List<NewMechModel> MechList = new ArrayList<NewMechModel>();
		try {
			while(result.next()) {
				NewMechModel mechModel = new NewMechModel();
				mechModel.setUserregNoString(result.getString("regNo"));
				mechModel.setSal(result.getFloat("basicSalary"));
				mechModel.setFullnameString(result.getString("userFullName"));
				mechModel.setFullnameString(result.getString("userFullName"));
				mechModel.setSpecString(result.getString("speciality"));
				
				MechList.add(mechModel);
			}
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return MechList;
	}

}
