package com.oop.service;

import java.util.ArrayList;
import java.util.List;

import com.oop.DAO.IServiceAccessDAO;
import com.oop.DAO.ServiceAccessDAOImpl;
import com.oop.model.VehicalServices;

public class ServiceAccessImpl implements IServiceAccess {
	
	IServiceAccessDAO serviceAccessDAO = new ServiceAccessDAOImpl();

	@Override
	public List<VehicalServices> getAllServices() {
		List<VehicalServices> allServices = serviceAccessDAO.AllVehiServices();
		return allServices;
	}

	@Override
	public VehicalServices getServiceDetailServices(String serviceID) {
		
		
		
		return serviceAccessDAO.getServiceByserviceID(serviceID);
	}
	
	
}
