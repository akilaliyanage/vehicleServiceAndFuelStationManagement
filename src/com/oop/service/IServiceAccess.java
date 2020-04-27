package com.oop.service;

import java.util.List;

import com.oop.model.VehicalServices;

public interface IServiceAccess {
	
	public VehicalServices getServiceDetailServices(String serviceID);
	
	public List<VehicalServices> getAllServices();

}
