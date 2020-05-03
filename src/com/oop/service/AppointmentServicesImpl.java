package com.oop.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.oop.DAO.AppointmentDAOImpl;
import com.oop.DAO.IAppointmentDAO;
import com.oop.model.AppointmentModel;
import com.oop.model.UserModel;
import com.oop.model.VehicleModel;


public class AppointmentServicesImpl implements AppointmentServices{

	IAppointmentDAO apppointData = new AppointmentDAOImpl();

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

	@Override
	public VehicleModel getVehicleByAppointmentId(String appId) {
		VehicleModel vehicleOfAppoint = apppointData.getvehicleByAppintmentId(appId);
		return vehicleOfAppoint;
	}

	@Override
	public UserModel GetUserById(String userId) {
		UserModel thisUser = apppointData.getCurrentUserByUid(userId);
		return thisUser;
	}

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

	@Override
	public AppointmentModel UpdateAppointment(String appoint_No, String vehi_no, String brand, String model,
			String transmission, String fuel, String date, String time , String pack , String Service) {
		AppointmentModel updatedAppointment = apppointData.UpdateAppointmentbyID(appoint_No , vehi_no , brand , model , transmission , fuel , date , time , pack , Service);
		return updatedAppointment;
	}

}
