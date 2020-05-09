//Created by D.H.M.M.P.Thammita
//IT No : IT19120362

/*
 * This class is a combination of appointment model and UserModel
 * this class contains all the details of a appointment and the customer details that
 * placed that appointment
 * This class Inhrtits UserModel
 * */

package com.oop.model;

public class UserAppointmentModel extends UserModel {

	public UserAppointmentModel() {
		// TODO Auto-generated constructor stub
	}
	
	protected String appId;
	protected String packID;
	protected String userRegNo;
	protected String status;
	protected String rating;
	protected String location;
	protected String prefDate;
	protected String prefTime;
	protected String remarks;
	protected String service_id;
	protected String vehicleI_No;
	protected double Ammount;

	
	public UserAppointmentModel(String appId, String packID, String userRegNo, String status, String rating,
			String location, String prefDate, String prefTime, String remarks, String service_id, String vehicleI_No,
			double ammount) {
		super();
		this.appId = appId;
		this.packID = packID;
		this.userRegNo = userRegNo;
		this.status = status;
		this.rating = rating;
		this.location = location;
		this.prefDate = prefDate;
		this.prefTime = prefTime;
		this.remarks = remarks;
		this.service_id = service_id;
		this.vehicleI_No = vehicleI_No;
		Ammount = ammount;
	}


	public UserAppointmentModel(String regNo, String userName, String userPassword, String userPhone, String userEmail,
			String userFullName, String gender, String userdescription, String userImage, String address_line_1,
			String address_line_2) {
		super(regNo, userName, userPassword, userPhone, userEmail, userFullName, gender, userdescription, userImage,
				address_line_1, address_line_2);
		// TODO Auto-generated constructor stub
	}


	public String getAppId() {
		return appId;
	}


	public void setAppId(String appId) {
		this.appId = appId;
	}


	public String getPackID() {
		return packID;
	}


	public void setPackID(String packID) {
		this.packID = packID;
	}


	public String getUserRegNo() {
		return userRegNo;
	}


	public void setUserRegNo(String userRegNo) {
		this.userRegNo = userRegNo;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getPrefDate() {
		return prefDate;
	}


	public void setPrefDate(String prefDate) {
		this.prefDate = prefDate;
	}


	public String getPrefTime() {
		return prefTime;
	}


	public void setPrefTime(String prefTime) {
		this.prefTime = prefTime;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public String getService_id() {
		return service_id;
	}


	public void setService_id(String service_id) {
		this.service_id = service_id;
	}


	public String getVehicleI_No() {
		return vehicleI_No;
	}


	public void setVehicleI_No(String vehicleI_No) {
		this.vehicleI_No = vehicleI_No;
	}


	public double getAmmount() {
		return Ammount;
	}


	public void setAmmount(double ammount) {
		Ammount = ammount;
	}
	
	

}
