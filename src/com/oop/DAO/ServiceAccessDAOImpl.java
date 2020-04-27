package com.oop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.oop.database.*;

import com.oop.model.VehicalServices;
import com.oop.service.PackageAccessImpl;

public class ServiceAccessDAOImpl implements IServiceAccessDAO{
	
	



	public Connection conn;
	public PreparedStatement prepStatement;
	
	@Override
	public List<VehicalServices> AllVehiServices() {
		conn = DatabaseConnection.getConnection();
		List<VehicalServices> allServives = new ArrayList<VehicalServices>();
		
		try {
			prepStatement = conn.prepareStatement("SELECT * FROM service");
			ResultSet resultSet = prepStatement.executeQuery();
			allServives = getServiceList(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (conn != null ) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return allServives;
	}

	private List<VehicalServices> getServiceList(ResultSet resultSet) {
		List<VehicalServices> serviceList = new ArrayList<VehicalServices>();
		
		try {
			while (resultSet.next()) {
				VehicalServices vehiService = new VehicalServices();
				vehiService.setServiceId(resultSet.getString("serviceId"));
				vehiService.setDuration(resultSet.getString("duration"));
				vehiService.setDescription(resultSet.getString("description"));
				vehiService.setServiceName(resultSet.getString("serviceName"));
				vehiService.setMechanicRegNo(resultSet.getString("mechanicRegNo"));
				vehiService.setServicePrice(resultSet.getString("ServicePrice"));
				vehiService.setServiceImg(resultSet.getString("Serviceimg"));
				serviceList.add(vehiService);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serviceList;
	}

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
			e.printStackTrace();
		}
		finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		System.out.println(service.getServiceId());
		System.out.println(service.getDescription());
		
		return service;
	}

	
	
	private VehicalServices getServiceValues(ResultSet rSet) {
		VehicalServices service = new VehicalServices();
				
		try {
			if (rSet.next()) {
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
		return service;
	}

	

}
