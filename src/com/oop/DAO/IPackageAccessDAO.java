//Created by D.H.M.M.P.Thammita
//IT No : IT19120362
//this Interface id implemented by PackageAccessDAOImpl Class
package com.oop.DAO;

import java.util.List;

import com.oop.model.PackageForAppoint;

public interface IPackageAccessDAO {

	/*
	 * This method will not accept any arguments and returns the list of All packages That are in the system
	 * */
	public List<PackageForAppoint> AllpackagesList();

	/*
	 * This method will accept Package Id of a package and returns a object of a packageforAppointment 
	 * That matches to the package ID.
	 * */
	public PackageForAppoint getPacacgeByPackageID(String packId);
}
