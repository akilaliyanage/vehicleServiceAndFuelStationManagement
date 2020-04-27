package com.oop.DAO;

import java.util.Date;

import com.oop.model.AppointmentModel;

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

	public AppointmentModel createNewAppointment(String userId, String vehi_NO, String raelAppointmentDate, String vehiBrand,
			String vehiModel, String vehiTransmission, String vehiFuel, String vehEngine, int vehiYear,
			String serviceID, String appointTime, String packID);
	
	
	
}
