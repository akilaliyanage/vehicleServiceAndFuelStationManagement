package com.oop.service;

import java.util.Date;

import com.oop.model.AppointmentModel;
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

	//public AppointmentModel UpdateAppointment();
}
