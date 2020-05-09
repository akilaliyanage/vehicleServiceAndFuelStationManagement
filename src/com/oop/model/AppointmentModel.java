//Created by D.H.M.M.P.Thammita
//IT No : IT19120362


/*
 * This modeclass represents a appointment.
 * 
 * */

package com.oop.model;

public class AppointmentModel {
	
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
	private double Ammount;
	protected String FeedbackDescription;
	
	
	public String getFeedbackDescription() {
		return FeedbackDescription;
	}

	public void setFeedbackDescription(String feedbackDescription) {
		FeedbackDescription = feedbackDescription;
	}

	public AppointmentModel() {
		super();
	}

	public AppointmentModel(String appId, String packID, String userRegNo, String status, String rating,
			String location, String prefDate, String prefTime, String remarks, String service_id , String vehicleI_No , double Ammount) {
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
		this.Ammount = Ammount;
	}
	
	

	public double getAmmount() {
		return Ammount;
	}

	public void setAmmount(double ammount) {
		Ammount = ammount;
	}

	public AppointmentModel(String appId, String packID, String userRegNo, String prefDate, String prefTime,
			String service_id , String vehicleI_No , double Ammount) {
		super();
		this.appId = appId;
		this.packID = packID;
		this.userRegNo = userRegNo;
		this.prefDate = prefDate;
		this.prefTime = prefTime;
		this.service_id = service_id;
		this.vehicleI_No = vehicleI_No;
		this.Ammount = Ammount;
	}
	
	

	public AppointmentModel(String appId, String packID, String userRegNo, String status, String prefDate,
			String prefTime, String service_id, String vehicleI_No, double ammount) {
		super();
		this.appId = appId;
		this.packID = packID;
		this.userRegNo = userRegNo;
		this.status = status;
		this.prefDate = prefDate;
		this.prefTime = prefTime;
		this.service_id = service_id;
		this.vehicleI_No = vehicleI_No;
		Ammount = ammount;
	}

	public String getVehicleI_No() {
		return vehicleI_No;
	}

	public void setVehicleI_No(String vehicleI_No) {
		this.vehicleI_No = vehicleI_No;
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
	
	
	
	

}
