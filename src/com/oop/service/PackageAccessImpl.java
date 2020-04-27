package com.oop.service;

import java.util.List;

import com.oop.DAO.IPackageAccessDAO;
import com.oop.DAO.PackageAccessDAOImpl;
import com.oop.model.PackageForAppoint;

public class PackageAccessImpl implements IPackageAccess{

	IPackageAccessDAO packages = new PackageAccessDAOImpl();
	@Override
	public List<PackageForAppoint> getAllPackages() {
		
		return packages.AllpackagesList();
	}

	@Override
	public PackageForAppoint getPackageByPackId(String packId) {

		return packages.getPacacgeByPackageID(packId);
	}

}
