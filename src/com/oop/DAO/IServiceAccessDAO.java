package com.oop.DAO;

import com.oop.model.VehicalServices;

public interface IServiceAccessDAO {
	
	public VehicalServices getServiceByserviceID(String serviceID);

}
