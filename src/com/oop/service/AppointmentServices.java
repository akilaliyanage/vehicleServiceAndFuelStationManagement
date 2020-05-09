package com.oop.service;

import java.util.Date;
import java.util.List;

import com.oop.model.AppointmentModel;
import com.oop.model.UserAppointmentModel;
import com.oop.model.UserModel;
import com.oop.model.VehicleModel;

public interface AppointmentServices {
	public AppointmentModel createAppointment(String userId , String vehi_NO, Date AppointDate, String vehiBrand, String vehiModel,
			String vehiTransmission, String vehiFuel, String vehEngine, int vehiYear, String serviceID,
			String appointTime, String packID, int appointDay);

	public UserModel GetUserById(String userId);

	public VehicleModel getVehicleByAppointmentId(String appId);

	public AppointmentModel UpdateAppointment(String appoint_No, String vehi_no, String brand, String model,
			String transmission, String fuel, String date, String time, String pack, String Service);

	public List<AppointmentModel> getPendingAppointments();

	public void assignMechanic(String appointment, String assignrdMec);

	public void SetRemarksToAppointment(String appointment, String remark);

	public void Changestatus(String appointment, String status);

	public void delelteRequest(String appointment, String vehicle);

	public List<AppointmentModel> getAllAppointments();

	public List<AppointmentModel> SearchAdvanceAppointments( String appId , String userRegNo, String vehicleI_No, String amount,
			String service_id, String status, String prefDate);

	public AppointmentModel getAppointmentByAppID(String appointmentID);

	public List<UserAppointmentModel> getUserWithAppointment();

	public void Setrating(int rating, String appointmentID);

	public void Addfeedback(String fullFeed, String appointID);

	
}
