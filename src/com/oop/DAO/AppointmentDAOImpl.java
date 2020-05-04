package com.oop.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import com.oop.database.DatabaseConnection;
import com.oop.model.*;


public class AppointmentDAOImpl implements IAppointmentDAO{
	
	private  Connection connection;
	private  PreparedStatement prepStatement;
	private  PreparedStatement prepStatement2;
	
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
			System.out.println(AffectedRows_qury1);
			System.out.println(AffectedRows_qury2);
 		} 
		catch (SQLException e) {
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
		return newAppointment;
	}


	
	/*
	 * Implementation of getServicePrice to get the
	 * Service price from a given Service ID
	 * */
	
	@Override
	public AppointmentModel UpdateAppointmentbyID(String appoint_No, String vehi_no, String brand, String model,
			String transmission, String fuel, String date, String time  , String pack  , String Service) {
		connection = DatabaseConnection.getConnection();
		AppointmentModel UdatedApointment = new AppointmentModel();
		VehicleModel updatedVehicle = new VehicleModel();
		
		try {
			prepStatement = connection.prepareStatement("UPDATE appointment SET prefDate = ? , prefTime = ?  WHERE appId = ?");
			prepStatement.setString(1, date);
			prepStatement.setString(2, time);
			prepStatement.setString(3, appoint_No);
			
			prepStatement.executeUpdate();
			
			prepStatement2 = connection.prepareStatement("UPDATE vehicle SET model = ? , brand = ? , transmission = ? , fuelType = ? WHERE vehicleId = ?");
			prepStatement2.setString(1, model);
			prepStatement2.setString(2, brand);
			prepStatement2.setString(3, transmission);
			prepStatement2.setString(4, fuel);
			prepStatement2.setString(5, vehi_no);
			
			
			prepStatement2.executeUpdate();
			
			UdatedApointment = getAppointmentById(appoint_No);
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
		
		
		return UdatedApointment;
	}



	@Override
	public List<AppointmentModel> getAllPendingAppointments() {
		connection = DatabaseConnection.getConnection();
		List<AppointmentModel> PendingReruests = new ArrayList<AppointmentModel>();
		try {
			prepStatement = connection.prepareStatement("SELECT * FROM appointment WHERE status = ?");
			prepStatement.setString(1, "Pending");
			ResultSet result = prepStatement.executeQuery();
			PendingReruests = getPendingRequestList(result);
		}  catch (SQLException e) {
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
		return PendingReruests;
	}



	private List<AppointmentModel> getPendingRequestList(ResultSet result) {
		List<AppointmentModel> requestList = new ArrayList<AppointmentModel>();
		
		try {
			while (result.next()) {
				AppointmentModel appointmentPending = new AppointmentModel();
				appointmentPending.setAppId(result.getString("appId"));
				appointmentPending.setPackID(result.getString("packID"));
				appointmentPending.setUserRegNo(result.getString("userRegNo"));
				appointmentPending.setStatus(result.getString("status"));
				appointmentPending.setRating(result.getString("rating"));
				appointmentPending.setLocation(result.getString("location"));
				appointmentPending.setPrefDate(result.getString("prefDate"));
				appointmentPending.setPrefTime(result.getString("prefTime"));
				appointmentPending.setRemarks(result.getString("remarks"));
				appointmentPending.setService_id(result.getString("service_id"));
				appointmentPending.setVehicleI_No(result.getString("vehicleI_No"));
				appointmentPending.setAmmount(result.getDouble("amount"));
				requestList.add(appointmentPending);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return requestList;
	}



	private AppointmentModel getAppointmentById(String appoint_No) {
		// TODO Auto-generated method stub
		connection = DatabaseConnection.getConnection();
		AppointmentModel appointment = new AppointmentModel();
		
		try {
			prepStatement = connection.prepareStatement("SELECT * FROM appointment WHERE appId = ?");
			prepStatement.setString(1, appoint_No);
			ResultSet result = prepStatement.executeQuery();
			appointment = getAppointmentObject(result);
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
		return appointment;
	}



	private AppointmentModel getAppointmentObject(ResultSet result) {
		AppointmentModel appoinrObject = new AppointmentModel();
		
		try {
			if (result.next()) {
				appoinrObject.setAppId(result.getString("appId"));
				appoinrObject.setPackID(result.getString("packID"));
				appoinrObject.setUserRegNo(result.getString("userRegNo"));
				appoinrObject.setStatus(result.getString("status"));
				appoinrObject.setRating(result.getString("rating"));
				appoinrObject.setLocation(result.getString("location"));
				appoinrObject.setPrefDate(result.getString("prefDate"));
				appoinrObject.setPrefTime(result.getString("prefTime"));
				appoinrObject.setRemarks(result.getString("remarks"));
				appoinrObject.setService_id(result.getString("service_id"));
				appoinrObject.setVehicleI_No(result.getString("vehicleI_No"));
				appoinrObject.setAmmount(result.getDouble("amount"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}		
		return appoinrObject;
	}



	@Override
	public VehicleModel getvehicleByAppintmentId(String appId) {
		connection = DatabaseConnection.getConnection();
		VehicleModel vehicle = new VehicleModel();
		try {
			prepStatement = connection.prepareStatement("SELECT * FROM vehicle WHERE appointment_id = ?");
			prepStatement.setString(1, appId);
			ResultSet result = prepStatement.executeQuery();
			vehicle = getVehicleObject(result);
			System.out.println(vehicle.getVehicleId());
			System.out.println(vehicle.getBrand());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
				System.out.println(e2);
			}
		}
		
		
		return vehicle;
	}



	private VehicleModel getVehicleObject(ResultSet result) {
		VehicleModel vehicleObject = new VehicleModel();
		try {
			if(result.next()) {
				vehicleObject.setVehicleId(result.getString("vehicleId"));
				vehicleObject.setUserRegNo(result.getString("userRegNo"));
				vehicleObject.setModel(result.getString("model"));
				vehicleObject.setBrand(result.getString("brand"));
				vehicleObject.setManuYear(result.getInt("manuYear"));
				vehicleObject.setEngineCap(result.getString("engineCap"));
				vehicleObject.setTransmission(result.getString("transmission"));
				vehicleObject.setAppointment_id(result.getString("fuelType"));
				vehicleObject.setAppointment_id(result.getString("appointment_id"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return vehicleObject;
	}



	@Override
	public UserModel getCurrentUserByUid(String userId) {
		connection = DatabaseConnection.getConnection();
		UserModel thisUser = new UserModel();
		try {
			prepStatement = connection.prepareStatement("SELECT * FROM user");
			ResultSet resultSet = prepStatement.executeQuery();
			thisUser = getUserObject(resultSet);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
				System.out.println(e2);
			}
		}
		
		
		return thisUser;
	}



	private UserModel getUserObject(ResultSet resultSet) {
		
		UserModel userModel = new UserModel();
		
		try {
			if (resultSet.next()) {
				userModel.setRegNo(resultSet.getString("regNo"));
				userModel.setUserName(resultSet.getString("userName"));
				userModel.setUserPassword(resultSet.getString("userPassword"));
				userModel.setUserPhone(resultSet.getString("userPhone"));
				userModel.setUserEmail(resultSet.getString("userEmail"));
				userModel.setUserFullName(resultSet.getString("userFullName"));
				userModel.setGender(resultSet.getString("gender"));
				userModel.setUserdescription(resultSet.getString("Userdescription"));
				userModel.setUserImage(resultSet.getString("userImage"));
				userModel.setAddress_line_1(resultSet.getString("address_line_1"));
				userModel.setAddress_line_2(resultSet.getString("address_line_2"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		return userModel;
	}



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
			System.out.println(e);
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
				System.out.println(e2);
			}
		}
		return PackPrice;
		
	}



	@Override
	public void AssignMechanic(String appointment, String assignrdMec) {
		connection = DatabaseConnection.getConnection();
		
		try {
			prepStatement = connection.prepareStatement("UPDATE appointment SET Mechanic_ID = ? WHERE appId = ?");
			prepStatement.setString(1, assignrdMec);
			prepStatement.setString(2, appointment);
			prepStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
				System.out.println(e2);
			}
		}
		
	}



	@Override
	public void SetRemarks(String appointment, String remark) {
		connection = DatabaseConnection.getConnection();
		
		try {
			prepStatement = connection.prepareStatement("UPDATE appointment SET remarks = ? WHERE appId = ?");
			prepStatement.setString(1, remark);
			prepStatement.setString(2, appointment);
			prepStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
				System.out.println(e2);
			}
		}
		
	}



	@Override
	public void setRequestStatus(String appointment, String status) {
		connection = DatabaseConnection.getConnection();
		
		try {
			prepStatement = connection.prepareStatement("UPDATE appointment SET status = ? WHERE appId = ?");
			prepStatement.setString(1, status);
			prepStatement.setString(2, appointment);
			prepStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
				System.out.println(e2);
			}
		}
		
	}



	@Override
	public void DeleteAppointment(String appointment, String vehicle) {
		connection = DatabaseConnection.getConnection();
		try {
			prepStatement = connection.prepareStatement("DELETE FROM vehicle WHERE vehicleId= ?");
			prepStatement.setString(1, vehicle);
			System.out.println("VehicleModel Deleted");
			
			if (prepStatement.executeUpdate() != 0) {
				prepStatement2 = connection.prepareStatement("DELETE FROM appointment WHERE appId= ? ");
				prepStatement2.setString(1, appointment);
				prepStatement2.executeUpdate();
				System.out.println("Appointment Deleted");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
				System.out.println(e2);
			}
		}
	}



	@Override
	public List<AppointmentModel> getAllAppointmentsData() {
		List<AppointmentModel> AllappointmentList = new ArrayList<AppointmentModel>();
		connection = DatabaseConnection.getConnection();
		try {
			prepStatement = connection.prepareStatement("SELECT * FROM appointment");
			ResultSet result = prepStatement.executeQuery();
			AllappointmentList = getAppointmentList(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return AllappointmentList;
	}



	private List<AppointmentModel> getAppointmentList(ResultSet result) {
		List<AppointmentModel> appointmentList = new ArrayList<AppointmentModel>();
		try {
			while(result.next()) {
				AppointmentModel appointmentObject = new AppointmentModel();
				appointmentObject.setAppId(result.getString("appId"));
				appointmentObject.setPackID(result.getString("packID"));
				appointmentObject.setUserRegNo(result.getString("userRegNo"));
				appointmentObject.setStatus(result.getString("status"));
				appointmentObject.setRating(result.getString("rating"));
				appointmentObject.setLocation(result.getString("location"));
				appointmentObject.setPrefDate(result.getString("prefDate"));
				appointmentObject.setPrefTime(result.getString("prefTime"));
				appointmentObject.setRemarks(result.getString("remarks"));
				appointmentObject.setService_id(result.getString("service_id"));
				appointmentObject.setVehicleI_No(result.getString("vehicleI_No"));
				appointmentObject.setAmmount(result.getDouble("amount"));
				appointmentList.add(appointmentObject);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return appointmentList;
	}



	
	
}
