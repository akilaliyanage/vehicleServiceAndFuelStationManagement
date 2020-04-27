package com.oop.service;

import java.util.List;

import com.oop.DAO.IPackageAccessDAO;
import com.oop.DAO.PackageAccessDAOImpl;
import com.oop.model.PackageForAppoint;

public class PackageAccessImpl implements IPackageAccess{

	@Override
	public List<PackageForAppoint> getAllPackages() {
		IPackageAccessDAO packages = new PackageAccessDAOImpl();
		return packages.AllpackagesList();
	}

}
