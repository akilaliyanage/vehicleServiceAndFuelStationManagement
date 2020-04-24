package com.oop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.oop.database.*;

import com.oop.model.VehicalServices;

public class ServiceAccessDAOImpl implements IServiceAccessDAO{
	
	Connection conn;
	PreparedStatement prepStatement;

	@Override
	public VehicalServices getServiceByserviceID(String serviceID) {
		System.out.println("getServiceByserviceID method is called");
		
		VehicalServices service = null;
		
		try {
			conn = DatabaseConnection.getConnection();
			prepStatement = conn.prepareStatement("select* FROM vehicleserviceandfuelstationmanagement.service WHERE serviceId = ?");
			prepStatement.setString(1, serviceID);
			ResultSet rSet = prepStatement.executeQuery();
			service = getServiceValues(rSet);
		} 
		
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return null;
	}

	private VehicalServices getServiceValues(ResultSet rSet) {
		VehicalServices service = new VehicalServices();
				
		try {
			while (rSet.next()) {
				service.setServiceId(rSet.getString("serviceId"));
				service.setDuration(rSet.getString("duration"));
				service.setDescription(rSet.getString("description"));
				service.setServiceName(rSet.getString("serviceName"));
				service.setMechanicRegNo(rSet.getString("mechanicRegNo"));
				service.setServicePrice(rSet.getString("ServicePrice"));
				service.setServiceImg(rSet.getString("Serviceimg"));
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	

}
