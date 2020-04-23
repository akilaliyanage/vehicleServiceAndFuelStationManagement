package com.oop.DAO;

public interface IAppointmentDAO {
	
	
	
	/*
	 * Used to get Service price of a given package 
	 * input parameter packageID
	 * */
	public double getServicePrice(String ServiceID);
	
	/*
	 * Used to get Package price of a given package 
	 * input parameter packageID
	 * */
	public double getPackagePrice(String PackageID);
	
	
	
}
