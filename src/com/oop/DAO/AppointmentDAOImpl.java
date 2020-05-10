//Created by D.H.M.M.P.Thammita
//IT No : IT19120362
//this DAO Class is used to data access needs of the appointment based objects.


package com.oop.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import com.oop.database.DatabaseConnection;
import com.oop.model.*;
import com.oop.service.IPackageAccess;
import com.oop.service.IServiceAccess;
import com.oop.service.PackageAccessImpl;
import com.oop.service.ServiceAccessImpl;

//Prepared Statements and connection variable is created are created it global scope of this class
public class AppointmentDAOImpl implements IAppointmentDAO{
	private static final Logger LOGGER = Logger.getLogger(AppointmentDAOImpl.class.getName());
	private  Connection connection;
	private  PreparedStatement prepStatement;
	private  PreparedStatement prepStatement2;
	
	
//This method Creates Appointment model object.
//this will returns an appointment object.
//this method updates both vehicle and appointment tables .
//Also this method is responsible for Calculating the total amount.
	@Override
	public AppointmentModel createNewAppointment(String userId, String vehi_NO, String raelAppointmentDate, String vehiBrand,
			String vehiModel, String vehiTransmission, String vehiFuel, String vehEngine, int vehiYear,
			String serviceID, String appointTime, String packID) {
		
		connection = DatabaseConnection.getConnection();
		String appId = ( "APP" + RandomString.getAlphaNumericString());
		String statuString  = "Pending";
		IPackageAccess pack = new PackageAccessImpl();
		IServiceAccess service = new ServiceAccessImpl();
		
		//following two lines are used to get the prices of the package and the service that select by the user
		PackageForAppoint pacageDetails = pack.getPackageByPackId(packID); 
		VehicalServices serviceObj = service.getServiceDetailServices(serviceID);
		
		//Fetched service and package prices are send to calculate total amount.  
		double amount = calcAmount(pacageDetails.getPrice() , serviceObj.getServicePrice());
		
		
		AppointmentModel newAppointment = new AppointmentModel(appId, packID, userId, statuString , raelAppointmentDate, appointTime, serviceID , vehi_NO , amount );
		VehicleModel vehicleOfAppointment = new VehicleModel(vehi_NO, userId, vehiModel, vehiBrand, vehiYear, vehEngine, vehiTransmission, vehiFuel, appId);
		
		try {
			prepStatement = connection.prepareStatement("INSERT INTO appointment (appId , packID , userRegNo , prefDate , prefTime , service_id , vehicleI_No , amount) VALUES(?,?,?,?,?,?,?,?)");
			prepStatement.setString(1, newAppointment.getAppId());
			prepStatement.setString(2, newAppointment.getPackID());
			prepStatement.setString(3, newAppointment.getUserRegNo());
			prepStatement.setString(4, newAppointment.getPrefDate());
			prepStatement.setString(5, newAppointment.getPrefTime());
			prepStatement.setString(6, newAppointment.getService_id());
			prepStatement.setString(7, newAppointment.getVehicleI_No());
			prepStatement.setDouble(8, newAppointment.getAmmount());
			
			
			prepStatement2 = connection.prepareStatement("INSERT INTO vehicle (vehicleId , userRegNo , model , brand , manuYear , engineCap , transmission , fuelType , appointment_id) values (? , ? , ? , ? , ? , ? , ? , ? , ?)");
			prepStatement2.setString(1, vehicleOfAppointment.getVehicleId());
			prepStatement2.setString(2, vehicleOfAppointment.getUserRegNo());
			prepStatement2.setString(3, vehicleOfAppointment.getModel());
			prepStatement2.setString(4, vehicleOfAppointment.getBrand());
			prepStatement2.setInt(5, vehicleOfAppointment.getManuYear());
			prepStatement2.setString(6, vehicleOfAppointment.getEngineCap());
			prepStatement2.setString(7, vehicleOfAppointment.getTransmission());
			prepStatement2.setString(8, vehicleOfAppointment.getFuelType());
			prepStatement2.setString(9, vehicleOfAppointment.getAppointment_id());
			
			prepStatement.executeUpdate();
			prepStatement2.executeUpdate();
			
 		} 
		catch (SQLException e) {
			LOGGER.log(Level.SEVERE, e.getSQLState());
			LOGGER.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		}
		finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {

					LOGGER.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		return newAppointment;
	}


	//This method is used to calculate the total amount of The customer;
	//this accepts packager price and service price.
	//this will add 5% tax to the total amount and creates the final amount.
	private double calcAmount(Double price, String servicePrice) {
		double amount = 0.00;
		try {
			double total = price + Double.parseDouble(servicePrice);
			double tax = (0.05 * total);
			amount = total - tax;
		} catch (NullPointerException | NumberFormatException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		System.out.println("Ammount is printed in servlet : " + amount);
		return amount;
	}



	/*
	 * UpdateAppointmentbyID is the method that used to update the user appointment.
	 * This accepts the appointment Id vehicle No of the appointment and new values of the appointment and vehicle object.
	 * 
	 */
	
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
			LOGGER.log(Level.SEVERE, e.getSQLState());
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					LOGGER.log(Level.SEVERE, e.getSQLState());
					LOGGER.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		
		
		return UdatedApointment;
	}

	
	/*
	 * This Method is used to get the list of Pending Appointments in the DB.
	 * This will Accepts No Arguments and returns A list of appointmentModels
	 * */


	@Override
	public List<AppointmentModel> getAllPendingAppointments() {
		connection = DatabaseConnection.getConnection();
		List<AppointmentModel> PendingReruests = new ArrayList<AppointmentModel>();
		try {
			prepStatement = connection.prepareStatement("SELECT * FROM appointment WHERE status = ? ORDER BY prefDate DESC");
			prepStatement.setString(1, "Pending");
			ResultSet result = prepStatement.executeQuery();
			/*
			 * Resultset Generated by executing the query is send to another function to create the appointmentModel List.
			 * */
			PendingReruests = getPendingRequestList(result);
		}  catch (SQLException e) {
			LOGGER.log(Level.SEVERE, e.getSQLState());
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					LOGGER.log(Level.SEVERE, e.getSQLState());
					LOGGER.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		return PendingReruests;
	}

/*
 * This method will Creates AppointmentModel List By given resultlist of getAllPendingAppointments method
 * */

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
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		return requestList;
	}

	/*
	 * This method is used to get a single appointment Object by passing the Id of that appointment.
	 * */

	public AppointmentModel getAppointmentById(String appoint_No) {
		
		connection = DatabaseConnection.getConnection();
		AppointmentModel appointment = new AppointmentModel();
		
		try {
			prepStatement = connection.prepareStatement("SELECT * FROM appointment WHERE appId = ?");
			prepStatement.setString(1, appoint_No);
			ResultSet result = prepStatement.executeQuery();
			
			/*
			 * Resultset is sends to getAppointmentobjecct() function to map the aresultset int to a
			 * appointment Model Object.
			 * */
			appointment = getAppointmentObject(result);
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, e.getSQLState());
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					LOGGER.log(Level.SEVERE, e.getSQLState());
					LOGGER.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		return appointment;
	}

/*
 * This will Map the resultset into a appointment object.
 * And then pass the appointmentModel object again to the getAppointmentById method.
 * */

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
				appoinrObject.setFeedbackDescription(result.getString("FeedbackDescription"));
				
			}
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, e.getSQLState());
			LOGGER.log(Level.SEVERE, e.getMessage());
		}		
		return appoinrObject;
	}

/*
 * This method will returns a Corresponding VehicleModel(appointed vehicle) object to a given Appointment id.
 * */

	@Override
	public VehicleModel getvehicleByAppintmentId(String appId) {
		connection = DatabaseConnection.getConnection();
		VehicleModel vehicle = new VehicleModel();
		try {
			prepStatement = connection.prepareStatement("SELECT * FROM vehicle WHERE appointment_id = ?");
			prepStatement.setString(1, appId);
			ResultSet result = prepStatement.executeQuery();
			/*
			 * Resultset is pass to getVehicleObject() method to map the resultset into a VehicleModel Object
			 * */
			vehicle = getVehicleObject(result);
			
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, e.getSQLState());
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				LOGGER.log(Level.SEVERE, e2.getSQLState());
				LOGGER.log(Level.SEVERE, e2.getMessage());
			}
		}
		
		
		return vehicle;
	}

/*
 * This method accepts resultset sent by the getvehicleByAppintmentId() method and this resultset
 * is map in to a vehicle model object.
 * */

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
				vehicleObject.setFuelType(result.getString("fuelType"));
				vehicleObject.setAppointment_id(result.getString("appointment_id"));
			}
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		return vehicleObject;
	}

/*
 * This method will Returns a User model by accepting the user ID of the user.
 * In servlet this method is used to get the Active user object by giving the user id of the
 * user that taken from session.  
 * */

	@Override
	public UserModel getCurrentUserByUid(String userId) {
		connection = DatabaseConnection.getConnection();
		UserModel thisUser = new UserModel();
		try {
			prepStatement = connection.prepareStatement("SELECT * FROM user WHERE regNo = ?");
			prepStatement.setString(1, userId);
			ResultSet resultSet = prepStatement.executeQuery();
			
			//Resultset sends to the getUserObject to map to a userModel object.
			thisUser = getUserObject(resultSet);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.log(Level.SEVERE, e.getSQLState());
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				LOGGER.log(Level.SEVERE, e2.getSQLState());
				LOGGER.log(Level.SEVERE, e2.getMessage());
			}
		}
		
		
		return thisUser;
	}

/*
 * This method will returns a UserModel object by accepting a result set.
 * This method will translate the resultset into UserModel Object. 
 * */

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
			LOGGER.log(Level.SEVERE, e.getSQLState());
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		return userModel;
	}

/*
 * ThisMethod will return the price of the Vehicle service By accepting it's Service Id.
 *   
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
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		finally {
			try {
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				LOGGER.log(Level.SEVERE, e2.getSQLState());
				LOGGER.log(Level.SEVERE, e2.getMessage());
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
			
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				LOGGER.log(Level.SEVERE, e2.getSQLState());
				LOGGER.log(Level.SEVERE, e2.getMessage());
			}
		}
		return PackPrice;
		
	}


/*
 * This Method Is used to Assign A mechanic to a Appointment.
 * this method accepts mechanic ID and the appointment address that mechanic need to assigned.
 * */
	@Override
	public void AssignMechanic(String appointment, String assignrdMec) {
		connection = DatabaseConnection.getConnection();
		
		try {
			prepStatement = connection.prepareStatement("UPDATE appointment SET Mechanic_ID = ? WHERE appId = ?");
			prepStatement.setString(1, assignrdMec);
			prepStatement.setString(2, appointment);
			prepStatement.executeUpdate();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				LOGGER.log(Level.SEVERE, e2.getSQLState());
				LOGGER.log(Level.SEVERE, e2.getMessage());
			}
		}
		
	}

	/*
	 * This Method Is used to Add remarks perticular to a Appointment.
	 * this method accepts the content of remark and the appointment address of that remark need to be add.
	 * */

	@Override
	public void SetRemarks(String appointment, String remark) {
		connection = DatabaseConnection.getConnection();
		
		try {
			prepStatement = connection.prepareStatement("UPDATE appointment SET remarks = ? WHERE appId = ?");
			prepStatement.setString(1, remark);
			prepStatement.setString(2, appointment);
			prepStatement.executeUpdate();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				LOGGER.log(Level.SEVERE, e2.getSQLState());
				LOGGER.log(Level.SEVERE, e2.getMessage());
			}
		}
		
	}

/*
 * This method will change the status of a appointment by accepting it's appointment no and status need to set
 * */

	@Override
	public void setRequestStatus(String appointment, String status) {
		connection = DatabaseConnection.getConnection();
		
		try {
			prepStatement = connection.prepareStatement("UPDATE appointment SET status = ? WHERE appId = ?");
			prepStatement.setString(1, status);
			prepStatement.setString(2, appointment);
			prepStatement.executeUpdate();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				LOGGER.log(Level.SEVERE, e2.getSQLState());
				LOGGER.log(Level.SEVERE, e2.getMessage());
			}
		}
		
	}

/*
 * This method will delete a pereticula appointment object by accepting it's appointment No.
 * Also this will delete the records of the vehicle that associated with that appointment   
 * */

	@Override
	public void DeleteAppointment(String appointment, String vehicle) {
		connection = DatabaseConnection.getConnection();
		try {
			prepStatement = connection.prepareStatement("DELETE FROM vehicle WHERE vehicleId= ?");
			prepStatement.setString(1, vehicle);
			
			if (prepStatement.executeUpdate() != 0) {
				prepStatement2 = connection.prepareStatement("DELETE FROM appointment WHERE appId= ? ");
				prepStatement2.setString(1, appointment);
				prepStatement2.executeUpdate();
			}
			
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				LOGGER.log(Level.SEVERE, e2.getSQLState());
				LOGGER.log(Level.SEVERE, e2.getMessage());
				e2.printStackTrace();
			}
		}
	}

/*
 * This Method will returns The List of all the appointments in the DB
 * */

	@Override
	public List<AppointmentModel> getAllAppointmentsData() {
		List<AppointmentModel> AllappointmentList = new ArrayList<AppointmentModel>();
		connection = DatabaseConnection.getConnection();
		try {
			prepStatement = connection.prepareStatement("SELECT * FROM appointment");
			ResultSet result = prepStatement.executeQuery();
			//Generated resultset is send to the getAppointmentList method to Map to a list op Appointment Objects.
			AllappointmentList = getAppointmentList(result);
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, e.getSQLState());
			LOGGER.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		}
		return AllappointmentList;
	}


/*
 * This method Method will return a list of appointment objects by accepting the resultset generated by
 *  getAllAppointmentsData method.
 * */
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
				appointmentObject.setFeedbackDescription(result.getString("FeedbackDescription"));
				appointmentList.add(appointmentObject);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, e.getSQLState());
			LOGGER.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		}
		return appointmentList;
	}

/*
 * This method  maps with the advance search function in the views.(Allrequests.jsp)
 * This method will accept all the values of fields that are appear in the advance search area.
 * This method will Returns a list of appointmentModel objects that matches with the user expectations.
 * */

	@Override
	public List<AppointmentModel> AdvanceAppointmentSearch( String appId , String userRegNo, String vehicleI_No, String name,
			String service_id, String status, String prefDate) {
		List<AppointmentModel> resultingList = new ArrayList<AppointmentModel>();
		String query = "";
		/*
		 * Accepted values are sends to the createQuery() method to create the the query that relevent 
		 * to the user selections.
		 * */
		query = createQuery(appId , userRegNo , vehicleI_No , name , service_id , status , prefDate);
		connection = DatabaseConnection.getConnection();
		try {
			prepStatement = connection.prepareStatement(query);
			ResultSet result = prepStatement.executeQuery();
			resultingList = getAppointmentList(result);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				LOGGER.log(Level.SEVERE, e2.getSQLState());
				LOGGER.log(Level.SEVERE, e2.getMessage());
				e2.printStackTrace();
			}
		}
		
		return resultingList;
	}

/*
 * This Method will accepts set of values and this method s evaluate them to know that user has given a value to
 * a perticular field or to check that user has selected  that perticular option.
 * According to the users values and his selected options this method will generate a sql query
 * And the it pass that query back to the AdvanceAppointmentSearch() method
 * */

	private String createQuery(String appId , String userRegNo, String vehicleI_No, String amount, String service_id, String status,
			String prefDate) {
		String sQLString = "SELECT * FROM appointment WHERE ";
		if (appId != null && appId != "") {
			sQLString = sQLString + " appId = '" + appId + "' AND   " ;
		}
		if (userRegNo != null && userRegNo != "") {
			sQLString = sQLString + " userRegNo = '" + userRegNo + "' AND   " ;
		}
		if (vehicleI_No != null && vehicleI_No != "") {
			sQLString = sQLString + " vehicleI_No = '" + vehicleI_No + "' AND   " ;
		}
		if (amount != null && amount != "") {
			sQLString = sQLString + " amount = '" + amount + "' AND   " ;
		}
		if (service_id != null && service_id != "") {
			sQLString = sQLString + " service_id = '" + service_id + "' AND   " ;
		}
		if (status != null && status != "") {
			sQLString = sQLString + " status = '" + status + "' AND   " ;
		}
		if (prefDate != null && prefDate != "") {
			sQLString = sQLString + " prefDate = '" + prefDate + "' AND   " ;
		}
		
		
		String queryString = sQLString.substring(0, sQLString.length() -6 );
		
		return queryString;
	}

/*
 * This method associates with User appointment model.
 * It is a model that contains all the details of a perticular appointment and all the details of the customer
 * that placed that appointment.
 * this will return the list of UserAppointmentmentModel objects
 * 
 * */

	@Override
	public List<UserAppointmentModel> getUserAndAppointment() {
		connection = DatabaseConnection.getConnection();
		List<UserAppointmentModel> userAndApp = new ArrayList<UserAppointmentModel>();
		try {
			prepStatement = connection.prepareStatement("SELECT * FROM appointment a , user u WHERE a.userRegNo = u.regNo AND a.status = 'Pending'");
			ResultSet result = prepStatement.executeQuery();
			//This resultset is sends to map in to a UserAppointmentModelList.
			userAndApp = getUserAppointmentList(result);
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
			LOGGER.log(Level.SEVERE, e.getSQLState());
			e.printStackTrace();
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				LOGGER.log(Level.SEVERE, e2.getSQLState());
				LOGGER.log(Level.SEVERE, e2.getMessage());
				e2.printStackTrace();
			}
		}
		return userAndApp;
	}


/*
 * This method Maps resultset to a list of UserAppointmentModels.
 * */
	public static List<UserAppointmentModel> getUserAppointmentList(ResultSet result) {
		List<UserAppointmentModel> userAppointmentList = new ArrayList<UserAppointmentModel>();
		try {
			while (result.next()) {
				UserAppointmentModel userAppointmentObject = new UserAppointmentModel();
				userAppointmentObject.setRegNo(result.getString("regNo"));
				userAppointmentObject.setUserName(result.getString("userName"));
				userAppointmentObject.setUserPassword(result.getString("userPassword"));
				userAppointmentObject.setUserPhone(result.getString("userPhone"));
				userAppointmentObject.setUserEmail(result.getString("userEmail"));
				userAppointmentObject.setUserFullName(result.getString("userFullName"));
				userAppointmentObject.setGender(result.getString("gender"));
				userAppointmentObject.setUserdescription(result.getString("Userdescription"));
				userAppointmentObject.setUserImage(result.getString("userImage"));
				userAppointmentObject.setAddress_line_1(result.getString("address_line_1"));
				userAppointmentObject.setAddress_line_2(result.getString("address_line_2"));
				userAppointmentObject.setAppId(result.getString("appId"));
				userAppointmentObject.setPackID(result.getString("packID"));
				userAppointmentObject.setUserRegNo(result.getString("userRegNo"));
				userAppointmentObject.setStatus(result.getString("status"));
				userAppointmentObject.setRating(result.getString("rating"));
				userAppointmentObject.setLocation(result.getString("location"));
				userAppointmentObject.setPrefDate(result.getString("prefDate"));
				userAppointmentObject.setPrefTime(result.getString("prefTime"));
				userAppointmentObject.setRemarks(result.getString("remarks"));
				userAppointmentObject.setService_id(result.getString("service_id"));
				userAppointmentObject.setVehicleI_No(result.getString("vehicleI_No"));
				userAppointmentObject.setAmmount(result.getDouble("amount"));
				userAppointmentList.add(userAppointmentObject);
				
			}
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
			LOGGER.log(Level.SEVERE, e.getSQLState());
			e.printStackTrace();
		}
		return userAppointmentList;
	}


	
	/*
	 * This Method is uSed to set the Rating to a perticular appointment
	 *  by accepting its appointment id and the raring.
	 * */

	@Override
	public void setAppRating(int rating, String appointmentID) {
		connection = DatabaseConnection.getConnection();
		
		try {
			prepStatement = connection.prepareStatement("UPDATE appointment SET rating = ? WHERE appId = ?");
			prepStatement.setInt(1, rating);
			prepStatement.setString(2, appointmentID);
			prepStatement.executeUpdate();
		}catch (SQLException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
			LOGGER.log(Level.SEVERE, e.getSQLState());
			e.printStackTrace();
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				LOGGER.log(Level.SEVERE, e2.getSQLState());
				LOGGER.log(Level.SEVERE, e2.getMessage());
				e2.printStackTrace();
			}
		}
		
	}

	
	/*
	 * This Method is used to set the Feedback to a perticular appointment
	 *  by accepting its appointment id and the Feedback.
	 * */

	@Override
	public void AddFeedback(String fullFeed, String appointID) {
		connection = DatabaseConnection.getConnection();
		 
		try {
			prepStatement = connection.prepareStatement("UPDATE appointment SET FeedbackDescription = ? WHERE appId = ?");
			prepStatement.setString(1, fullFeed);
			prepStatement.setString(2, appointID);
			prepStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
			LOGGER.log(Level.SEVERE, e.getSQLState());
			e.printStackTrace();
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				LOGGER.log(Level.SEVERE, e2.getSQLState());
				LOGGER.log(Level.SEVERE, e2.getMessage());
				e2.printStackTrace();
			}
		}
	}
	
	



	
	
}
