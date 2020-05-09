//Created by D.H.M.M.P.Thammita
//IT No : IT19120362

package com.oop.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.oop.DAO.AppointmentDAOImpl;
import com.oop.DAO.IAppointmentDAO;
import com.oop.model.AppointmentModel;
import com.oop.model.UserAppointmentModel;
import com.oop.model.UserModel;
import com.oop.model.VehicleModel;


public class AppointmentServicesImpl implements AppointmentServices{

	
	/*
	 * Most of the methods of this services class uses methods that are in the IAppointmentDAO
	 * So that global AppointmentDAOImpl object is created in this class
	 * */
	IAppointmentDAO apppointData = new AppointmentDAOImpl();

	
	/*
	 * This Method Is used to Assign A mechanic to a Appointment.
	 * this method accepts mechanic ID and the appointment address that mechanic need to assigned.
	 * */
	@Override
	public void assignMechanic(String appointment, String assignrdMec) {
		apppointData.AssignMechanic(appointment , assignrdMec);
		
	}

	
	/*
	 * This method is used to create new appointment object.
	 * In the services level this method converts recieved date argument to
	 * a proper date format that date is send to the data access level.
	 * 
	 * */
	@Override
	public AppointmentModel createAppointment(String userId, String vehi_NO, Date AppointDate, String vehiBrand, String vehiModel,
			String vehiTransmission, String vehiFuel, String vehEngine, int vehiYear, String serviceID,
			String appointTime, String packID, int appointDay) {
		
		String raelAppointmentDate = getDay(AppointDate , appointDay);
		AppointmentModel CreatedAppoinment = apppointData.createNewAppointment(userId, vehi_NO, raelAppointmentDate , vehiBrand, vehiModel,
				vehiTransmission, vehiFuel, vehEngine, vehiYear, serviceID,
				appointTime, packID);
		
		
		return CreatedAppoinment;
		
	}
	
	
	/*
	 * This method will returns a Corresponding VehicleModel(appointed vehicle) object to a given Appointment id.
	 * */
	@Override
	public VehicleModel getVehicleByAppointmentId(String appId) {
		VehicleModel vehicleOfAppoint = apppointData.getvehicleByAppintmentId(appId);
		return vehicleOfAppoint;
	}

	
	/*
	 * This method will Returns a User model by accepting the user ID of the user.
	 * In servlet this method is used to get the Active user object by giving the user id of the
	 * user that taken from session.  
	 * */
	@Override
	public UserModel GetUserById(String userId) {
		UserModel thisUser = apppointData.getCurrentUserByUid(userId);
		return thisUser;
	}

	
	/*In the viwes the acctual date is not passed to the servlet.
	 *only the day of the week(sunday = 1 , monday = 2...) is passed
	 *There this date will converted in to a Proper date format.*/
	private String getDay(Date appointDate, int appointDay) {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(appointDate);
		
		
 		int DayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
 		
 		
 		cal.add(Calendar.DAY_OF_MONTH, (-1 * (DayOfWeek-1)));
 		cal.add(Calendar.DAY_OF_MONTH, appointDay);
 		Date corrDate = cal.getTime();
 		
 		SimpleDateFormat usingFormat = new SimpleDateFormat("yyyy-MM-dd");
 		String formattedDate = usingFormat.format(corrDate);
		return formattedDate;
	}

	
	/*
	 * UpdateAppointmentbyID is the method that used to update the user appointment.
	 * This accepts the appointment Id vehicle No of the appointment and new values of the appointment and vehicle object.
	 * 
	 */
	@Override
	public AppointmentModel UpdateAppointment(String appoint_No, String vehi_no, String brand, String model,
			String transmission, String fuel, String date, String time , String pack , String Service) {
		AppointmentModel updatedAppointment = apppointData.UpdateAppointmentbyID(appoint_No , vehi_no , brand , model , transmission , fuel , date , time , pack , Service);
		return updatedAppointment;
	}

	
	/*
	 * This Method is used to get the list of Pending Appointments in the DB.
	 * This will Accepts No Arguments and returns A list of appointmentModels
	 * */
	@Override
	public List<AppointmentModel> getPendingAppointments() {
		List<AppointmentModel> pendingAppointments = apppointData.getAllPendingAppointments();
		return pendingAppointments;
	}

	
	/*
	 * This Method Is used to Add remarks perticular to a Appointment.
	 * this method accepts the content of remark and the appointment address of that remark need to be add.
	 * */
	@Override
	public void SetRemarksToAppointment(String appointment, String remark) {
		apppointData.SetRemarks(appointment , remark);
		
	}

	
	/*
	 * This method will change the status of a appointment by accepting it's appointment no and status need to set
	 * */
	@Override
	public void Changestatus(String appointment, String status) {
		apppointData.setRequestStatus(appointment , status);
		
	}

	
	/*
	 * This method will delete a pereticula appointment object by accepting it's appointment No.
	 * Also this will delete the records of the vehicle that associated with that appointment   
	 * */
	@Override
	public void delelteRequest(String appointment, String vehicle) {
		apppointData.DeleteAppointment(appointment , vehicle);
		
	}

	
	/*
	 * This Method will returns The List of all the appointments in the DB
	 * */
	@Override
	public List<AppointmentModel> getAllAppointments() {
		List<AppointmentModel> allRequests = new ArrayList<AppointmentModel>();
		allRequests = apppointData.getAllAppointmentsData();
		return allRequests;
	}

	
	/*
	 * This method  maps with the advance search function in the views.(Allrequests.jsp)
	 * This method will accept all the values of fields that are appear in the advance search area.
	 * This method will Returns a list of appointmentModel objects that matches with the user expectations.
	 * */
	@Override
	public List<AppointmentModel> SearchAdvanceAppointments( String appId , String userRegNo, String vehicleI_No, String amount,
			String service_id, String status, String prefDate) {
		List<AppointmentModel> filteredappoint = new ArrayList<AppointmentModel>();
		filteredappoint = apppointData.AdvanceAppointmentSearch(appId , userRegNo , vehicleI_No , amount , service_id , status , prefDate);
		return filteredappoint;
	}

	
	/*
	 * This method is used to get a single appointment Object by passing the Id of that appointment.
	 * */
	@Override
	public AppointmentModel getAppointmentByAppID(String appointmentID) {
		AppointmentModel appointment = new AppointmentModel();
		appointment = apppointData.getAppointmentById(appointmentID);
		return appointment;
	}

	/*
	 * This method associates with User appointment model.
	 * It is a model that contains all the details of a perticular appointment and all the details of the customer
	 * that placed that appointment.
	 * this will return the list of UserAppointmentmentModel objects
	 * 
	 * */
	@Override
	public List<UserAppointmentModel> getUserWithAppointment() {
		List<UserAppointmentModel> userWithapp = new ArrayList<UserAppointmentModel>();
		userWithapp = apppointData.getUserAndAppointment();
		return userWithapp;
	}

	/*
	 * This Method is uSed to set the Rating to a perticular appointment
	 *  by accepting its appointment id and the raring.
	 * */
	@Override
	public void Setrating(int rating, String appointmentID) {
		apppointData.setAppRating(rating , appointmentID);
		
	}

	/*
	 * This Method is used to set the Feedback to a perticular appointment
	 *  by accepting its appointment id and the Feedback.
	 * */
	@Override
	public void Addfeedback(String fullFeed, String appointID) {
		apppointData.AddFeedback(fullFeed , appointID);
		
	}
	
	
	
	

}
