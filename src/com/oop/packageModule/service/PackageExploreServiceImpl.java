package com.oop.packageModule.service;

//IT19120058
//Geethika L.W.S

import java.util.List;

import com.oop.packageModule.dao.PackageExploreDao;
import com.oop.packageModule.dao.PackageExploreDaoImpl;
import com.oop.packageModule.model.ServicePackage;

public class PackageExploreServiceImpl implements PackageExploreService {

	//Create Package Explorer DAO instance to access methods implemented in it.
	PackageExploreDao packageExploreDao = new PackageExploreDaoImpl();

	@Override //call each methods implemented in the DAO class from the service class
	public int addServicePackage(ServicePackage servicePackage) {
		return packageExploreDao.addServicePackage(servicePackage);
	}

	@Override
	public ServicePackage updateServicePackage(ServicePackage servicePackage) {
		return packageExploreDao.updateServicePackage(servicePackage);
	}

	@Override
	public int removeServicePackage(String id) {
		return packageExploreDao.removeServicePackage(id);
	}

	@Override
	public ServicePackage getServicePackageById(String id) {
		return packageExploreDao.getServicePackageById(id);
	}

	@Override
	public List<ServicePackage> getServicePackageByName(String name) {
		return packageExploreDao.getServicePackageByName(name);
	}

	@Override
	public List<ServicePackage> getAllServicePackagesS() {
		return packageExploreDao.getAllServicePackagesS();
	}

}
