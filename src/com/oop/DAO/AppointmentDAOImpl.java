package com.oop.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Connection;
import com.oop.database.DatabaseConnection;


public class AppointmentDAOImpl implements IAppointmentDAO{
	
	private  Connection connection;
	private  PreparedStatement prepStatement;
	
	
	/*
	 * Implementation of getServicePrice to get the
	 * Service price from a given Service ID
	 * */
	
	public double getServicePrice(String ServiceID) {
		
		double ServPrice = 0;
		
		try {
			
			connection = DatabaseConnection.getConnection();
			
			prepStatement = connection.prepareStatement("SELECT ServicePrice FROM vehicleserviceandfuelstationmanagement.service WHERE serviceId = ?");
			prepStatement.setString(1, ServiceID);
			
			ResultSet rSet = prepStatement.executeQuery();
			rSet.next();
			ServPrice = rSet.getDouble(1);
			System.out.println(ServPrice);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

		return ServPrice ;
	}
	
	
	/*
	 * Implementation of getPackagePrice to get the
	 * package price from a given package ID
	 * */
	public double getPackagePrice(String PackageID) {
		
		double PackPrice = 0;
		
		try {
			connection = DatabaseConnection.getConnection();
			
			prepStatement = connection.prepareStatement("SELECT price FROM vehicleserviceandfuelstationmanagement.package WHERE packId = ?");
			prepStatement.setString(1, PackageID);
			
			ResultSet rsSet = prepStatement.executeQuery();
			rsSet.next();
			PackPrice = rsSet.getDouble(1);
			System.out.println(PackPrice);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return PackPrice;
		
	}
	
	
}
