package com.oop.service;

import com.oop.DAO.IServiceAccessDAO;
import com.oop.DAO.ServiceAccessDAOImpl;
import com.oop.model.VehicalServices;

public class ServiceAccessImpl implements IServiceAccess {

	@Override
	public VehicalServices getServiceDetailServices(String serviceID) {
		
		IServiceAccessDAO serviceAccessDAO = new ServiceAccessDAOImpl();
		
		return serviceAccessDAO.getServiceByserviceID(serviceID);
	}
	
	
}
