package com.oop.packageModule.service;

//IT19120058
//Geethika L.W.S

import java.util.List;

import com.oop.packageModule.model.ServicePackage;

public interface PackageExploreService {
	public int addServicePackage(ServicePackage servicePackage);

	public ServicePackage updateServicePackage(ServicePackage servicePackage);

	public int removeServicePackage(String id);

	public ServicePackage getServicePackageById(String id);

	public List<ServicePackage> getServicePackageByName(String name);

	public List<ServicePackage> getAllServicePackagesS();
}
