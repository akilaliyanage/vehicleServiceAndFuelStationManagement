//Created by D.H.M.M.P.Thammita
//IT No : IT19120362
//this Interface id implemented by ServiceAccessDAOImpl Class


package com.oop.DAO;

import java.util.List;

import com.oop.model.VehicalServices;
import com.oop.service.PackageAccessImpl;

public interface IServiceAccessDAO {
	
	/*
	 * This Method accepts no Arguements and returns the list of all vehicleServvices Model objects 
	 * that are available in the system.
	 * */
	
	public VehicalServices getServiceByserviceID(String serviceID);

	/*
	 * This method is used to get the vehicleService object by providing it's ServiceID.
	 * this will returns a VehicalServices objects that matches to given serviceID
	 * */
	public List<VehicalServices> AllVehiServices();

}
