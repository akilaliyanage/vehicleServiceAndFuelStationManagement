package com.oop.packageModule.dao;

//IT19120058
//Geethika L.W.S
import java.util.List;

import com.oop.packageModule.model.ServicePackage;

public interface PackageExploreDao {

	public int addServicePackage(ServicePackage servicePackage);//save service package DAO function method definition

	public ServicePackage updateServicePackage(ServicePackage servicePackage);//update service package DAO function method definition

	public int removeServicePackage(String id);//delete service package DAO function method definition

	public ServicePackage getServicePackageById(String id);//retrieve service package by id DAO function method definition

	public List<ServicePackage> getServicePackageByName(String name);//retrieve service package by name DAO function method definition

	public List<ServicePackage> getAllServicePackagesS();//retrieve all service packages DAO function method definition

}
