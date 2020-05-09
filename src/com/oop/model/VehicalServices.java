//Created by D.H.M.M.P.Thammita
//IT No : IT19120362

/*
 * This Model class represents a vehicle Service(ex: car wash , Interior detailing) in the system
 * */

package com.oop.model;

public class VehicalServices {
	
	private String serviceId;
	private String duration;
	private String description;
	private String serviceName;
	private String mechanicRegNo;
	private String servicePrice;
	private String serviceImg;
	
	
	
	public VehicalServices(String serviceId, String duration, String description, String serviceName,
			String mechanicRegNo, String servicePrice, String serviceImg) {
		super();
		this.serviceId = serviceId;
		this.duration = duration;
		this.description = description;
		this.serviceName = serviceName;
		this.mechanicRegNo = mechanicRegNo;
		this.servicePrice = servicePrice;
		this.serviceImg = serviceImg;
	}
	
	
	public VehicalServices() {
		super();
	}


	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getMechanicRegNo() {
		return mechanicRegNo;
	}
	public void setMechanicRegNo(String mechanicRegNo) {
		this.mechanicRegNo = mechanicRegNo;
	}
	public String getServicePrice() {
		return servicePrice;
	}
	public void setServicePrice(String servicePrice) {
		this.servicePrice = servicePrice;
	}
	public String getServiceImg() {
		return serviceImg;
	}
	public void setServiceImg(String serviceImg) {
		this.serviceImg = serviceImg;
	}
	

}
