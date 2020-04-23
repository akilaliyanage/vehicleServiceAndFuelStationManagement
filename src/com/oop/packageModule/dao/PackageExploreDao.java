package com.oop.packageModule.dao;

import java.util.List;

import com.oop.packageModule.model.ServicePackage;

public interface PackageExploreDao {

	public int addServicePackage(ServicePackage servicePackage);

	public ServicePackage updateServicePackage(ServicePackage servicePackage);

	public int removeServicePackage(int id);

	public ServicePackage getServicePackageById(String id);

	public List<ServicePackage> getServicePackageByName(String name);

	public List<ServicePackage> getAllServicePackagesS();

}
