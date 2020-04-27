package com.oop.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import com.oop.database.DatabaseConnection;
import com.oop.model.*;


public class AppointmentDAOImpl implements IAppointmentDAO{
	
	private  Connection connection;
	private  PreparedStatement prepStatement;
	
	@Override
	public AppointmentModel createNewAppointment(String userId, String vehi_NO, String raelAppointmentDate, String vehiBrand,
			String vehiModel, String vehiTransmission, String vehiFuel, String vehEngine, int vehiYear,
			String serviceID, String appointTime, String packID) {
		
		connection = DatabaseConnection.getConnection();
		String appId = ( "APP" + RandomString.getAlphaNumericString());
		AppointmentModel newAppointment = new AppointmentModel(appId, packID, userId, raelAppointmentDate, appointTime, serviceID , vehi_NO);
		VehicleModel vehicleOfAppointment = new VehicleModel(vehi_NO, userId, vehiModel, vehiBrand, vehiYear, vehEngine, vehiTransmission, vehiFuel, appId);
		
		try {
			prepStatement = connection.prepareStatement("INSERT INTO appointment (appId , packID , userRegNo , prefDate , prefTime , service_id , vehicleI_No) VALUES(?,?,?,?,?,?,?)");
			prepStatement.setString(1, newAppointment.getAppId());
			prepStatement.setString(2, newAppointment.getPackID());
			prepStatement.setString(3, newAppointment.getUserRegNo());
			prepStatement.setString(4, newAppointment.getPrefDate());
			prepStatement.setString(5, newAppointment.getPrefTime());
			prepStatement.setString(6, newAppointment.getService_id());
			prepStatement.setString(7, newAppointment.getVehicleI_No());
			
			PreparedStatement prepStatement2;
			prepStatement2 = connection.prepareStatement("INSERT INTO vehicle (vehicleId , userRegNo , model , brand , manuYear , engineCap , transmission , fuelType , appointment_id)\r\n" + 
					"values (? , ? , ? , ? , ? , ? , ? , ? , ?)");
			prepStatement2.setString(1, vehicleOfAppointment.getVehicleId());
			prepStatement2.setString(2, vehicleOfAppointment.getUserRegNo());
			prepStatement2.setString(3, vehicleOfAppointment.getModel());
			prepStatement2.setString(4, vehicleOfAppointment.getBrand());
			prepStatement2.setInt(5, vehicleOfAppointment.getManuYear());
			prepStatement2.setString(6, vehicleOfAppointment.getEngineCap());
			prepStatement2.setString(7, vehicleOfAppointment.getTransmission());
			prepStatement2.setString(8, vehicleOfAppointment.getFuelType());
			prepStatement2.setString(9, vehicleOfAppointment.getAppointment_id());
			
			int AffectedRows_qury1 = prepStatement.executeUpdate();
			int AffectedRows_qury2 = prepStatement2.executeUpdate();
 		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
		return newAppointment;
	}


	
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
			e.printStackTrace();
			System.out.println(e);
		}
		finally {
			try {
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
				System.out.println(e2);
			}
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
			e.printStackTrace();
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
		return PackPrice;
		
	}
	
	
}
