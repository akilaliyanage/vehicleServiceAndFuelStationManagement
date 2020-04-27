package com.oop.DAO;

import java.util.List;

import com.oop.model.VehicalServices;
import com.oop.service.PackageAccessImpl;

public interface IServiceAccessDAO {
	
	public VehicalServices getServiceByserviceID(String serviceID);

	public List<VehicalServices> AllVehiServices();

}
