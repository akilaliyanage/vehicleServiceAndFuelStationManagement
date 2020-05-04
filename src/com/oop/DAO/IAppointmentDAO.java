package com.oop.DAO;



import java.util.List;

import com.oop.model.AppointmentModel;
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

	public AppointmentModel createNewAppointment(String userId, String vehi_NO, String raelAppointmentDate, String vehiBrand,
			String vehiModel, String vehiTransmission, String vehiFuel, String vehEngine, int vehiYear,
			String serviceID, String appointTime, String packID);

	public UserModel getCurrentUserByUid(String userId);

	public VehicleModel getvehicleByAppintmentId(String appId);

	public AppointmentModel UpdateAppointmentbyID(String appoint_No, String vehi_no, String brand, String model,
			String transmission, String fuel, String date, String time , String pack  , String Service);

	public List<AppointmentModel> getAllPendingAppointments();

	public void AssignMechanic(String appointment, String assignrdMec);

	public void SetRemarks(String appointment, String remark);

	public void setRequestStatus(String appointment, String status);

	public void DeleteAppointment(String appointment, String vehicle);

	public List<AppointmentModel> getAllAppointmentsData();

	
	
	
	
}
