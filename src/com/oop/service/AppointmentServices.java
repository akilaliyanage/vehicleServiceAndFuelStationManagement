package com.oop.service;

import java.util.Date;

import com.oop.model.AppointmentModel;

public interface AppointmentServices {
	public AppointmentModel createAppointment(String userId , String vehi_NO, Date AppointDate, String vehiBrand, String vehiModel,
			String vehiTransmission, String vehiFuel, String vehEngine, int vehiYear, String serviceID,
			String appointTime, String packID, int appointDay);
}
