package com.oop.packageModule.service;

//IT19120058
//Geethika L.W.S

import java.util.List;

import com.oop.packageModule.model.ServicePackage;

public interface PackageExploreService {
	public int addServicePackage(ServicePackage servicePackage);//Add service package service method definition

	public ServicePackage updateServicePackage(ServicePackage servicePackage);//Update service package service method definition

	public int removeServicePackage(String id);//Delete service package service method definition

	public ServicePackage getServicePackageById(String id);//Retrieve service package by id service method definition

	public List<ServicePackage> getServicePackageByName(String name);//Retrieve service package by name service method definition

	public List<ServicePackage> getAllServicePackagesS();//Retrieve all service packages service method definition
}
