//Created by D.H.M.M.P.Thammita
//IT No : IT19120362
//this Interface id implemented by AppointmentDAOImpl Class

package com.oop.DAO;



import java.util.List;

import com.oop.model.AppointmentModel;
import com.oop.model.UserAppointmentModel;
import com.oop.model.UserModel;
import com.oop.model.VehicleModel;

public interface IAppointmentDAO {
	
	
	
	/*
	 * Used to get Service price of a given package 
	 * input parameter packageID
	 * */
	public double getServicePrice(String ServiceID);
	
	/*
	 * Used to get Package price of a given package 
	 * input parameter packageID
	 * */
	public double getPackagePrice(String PackageID);
	
	//This method Creates Appointment model object.
	//this will returns an appointment object.
	//this method updates both vehicle and appointment tables .
	//Also this method is responsible for Calculating the total amount.

	public AppointmentModel createNewAppointment(String userId, String vehi_NO, String raelAppointmentDate, String vehiBrand,
			String vehiModel, String vehiTransmission, String vehiFuel, String vehEngine, int vehiYear,
			String serviceID, String appointTime, String packID);

	
	/*
	 * This method will Returns a User model by accepting the user ID of the user.
	 * In servlet this method is used to get the Active user object by giving the user id of the
	 * user that taken from session.  
	 * */
	public UserModel getCurrentUserByUid(String userId);

	
	/*
	 * This method will returns a Corresponding VehicleModel(appointed vehicle) object to a given Appointment id.
	 * */
	public VehicleModel getvehicleByAppintmentId(String appId);
	
	
	/*
	 * UpdateAppointmentbyID is the method that used to update the user appointment.
	 * This accepts the appointment Id vehicle No of the appointment and new values of the appointment and vehicle object.
	 * 
	 */
	public AppointmentModel UpdateAppointmentbyID(String appoint_No, String vehi_no, String brand, String model,
			String transmission, String fuel, String date, String time , String pack  , String Service);

	
	/*
	 * This Method is used to get the list of Pending Appointments in the DB.
	 * This will Accepts No Arguments and returns A list of appointmentModels
	 * */
	public List<AppointmentModel> getAllPendingAppointments();

	/*
	 * This Method Is used to Assign A mechanic to a Appointment.
	 * this method accepts mechanic ID and the appointment address that mechanic need to assigned.
	 * */
	public void AssignMechanic(String appointment, String assignrdMec);

	/*
	 * This Method Is used to Add remarks perticular to a Appointment.
	 * this method accepts the content of remark and the appointment address of that remark need to be add.
	 * */
	public void SetRemarks(String appointment, String remark);

	/*
	 * This method will change the status of a appointment by accepting it's appointment no and status need to set
	 * */
	public void setRequestStatus(String appointment, String status);

	
	/*
	 * This method will delete a pereticula appointment object by accepting it's appointment No.
	 * Also this will delete the records of the vehicle that associated with that appointment   
	 * */
	public void DeleteAppointment(String appointment, String vehicle);

	
	/*
	 * This Method will returns The List of all the appointments in the DB
	 * */
	public List<AppointmentModel> getAllAppointmentsData();
	
	/*
	 * This method  maps with the advance search function in the views.(Allrequests.jsp)
	 * This method will accept all the values of fields that are appear in the advance search area.
	 * This method will Returns a list of appointmentModel objects that matches with the user expectations.
	 * */

	public List<AppointmentModel> AdvanceAppointmentSearch( String appId ,String userRegNo, String vehicleI_No, String name,
			String service_id, String status, String prefDate);
	
	/*
	 * This method is used to get a single appointment Object by passing the Id of that appointment.
	 * */

	public AppointmentModel getAppointmentById(String appointmentID);

	
	/*
	 * This method associates with User appointment model.
	 * It is a model that contains all the details of a perticular appointment and all the details of the customer
	 * that placed that appointment.
	 * this will return the list of UserAppointmentmentModel objects
	 * 
	 * */
	public List<UserAppointmentModel> getUserAndAppointment();

	
	/*
	 * This Method is uSed to set the Rating to a perticular appointment
	 *  by accepting its appointment id and the raring.
	 * */
	public void setAppRating(int rating, String appointmentID);
	
	

	/*
	 * This Method is used to set the Feedback to a perticular appointment
	 *  by accepting its appointment id and the Feedback.
	 * */
	public void AddFeedback(String fullFeed, String appointID);

	
	
	
	
}
