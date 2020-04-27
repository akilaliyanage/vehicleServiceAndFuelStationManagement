package com.oop.service;


import java.util.List;
import com.oop.model.*;

public interface IPackageAccess {

	public List<PackageForAppoint> getAllPackages();
	
	public PackageForAppoint getPackageByPackId(String packId);
}
