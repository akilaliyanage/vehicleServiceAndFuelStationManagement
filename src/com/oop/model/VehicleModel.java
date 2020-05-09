//Created by D.H.M.M.P.Thammita
//IT No : IT19120362

/*
 * This Model class represents a Vehicle that associated with an appointment in the system
 * */

package com.oop.model;

public class VehicleModel {
	private String vehicleId;
	private String userRegNo;
	private String model;
	private String brand;
	private int manuYear;
	private String engineCap;
	private String transmission;
	private String fuelType;
	private String appointment_id;
	
	public VehicleModel() {
		super();
	}

	public VehicleModel(String vehicleId, String userRegNo, String model, String brand, int manuYear, String engineCap,
			String transmission, String fuelType, String appointment_id) {
		super();
		this.vehicleId = vehicleId;
		this.userRegNo = userRegNo;
		this.model = model;
		this.brand = brand;
		this.manuYear = manuYear;
		this.engineCap = engineCap;
		this.transmission = transmission;
		this.fuelType = fuelType;
		this.appointment_id = appointment_id;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getUserRegNo() {
		return userRegNo;
	}

	public void setUserRegNo(String userRegNo) {
		this.userRegNo = userRegNo;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getManuYear() {
		return manuYear;
	}

	public void setManuYear(int manuYear) {
		this.manuYear = manuYear;
	}

	public String getEngineCap() {
		return engineCap;
	}

	public void setEngineCap(String engineCap) {
		this.engineCap = engineCap;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getAppointment_id() {
		return appointment_id;
	}

	public void setAppointment_id(String appointment_id) {
		this.appointment_id = appointment_id;
	}
	

	

}