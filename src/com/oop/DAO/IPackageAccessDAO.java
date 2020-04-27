package com.oop.DAO;

import java.util.List;

import com.oop.model.PackageForAppoint;

public interface IPackageAccessDAO {

	public List<PackageForAppoint> AllpackagesList();

	public PackageForAppoint getPacacgeByPackageID(String packId);
}
