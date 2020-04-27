package com.oop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.oop.database.*;

import com.oop.model.PackageForAppoint;

public class PackageAccessDAOImpl implements IPackageAccessDAO {
	
	

	private Connection conn;
	
	@Override
	public List<PackageForAppoint> AllpackagesList() {
		conn = DatabaseConnection.getConnection();
		List<PackageForAppoint> packList = new ArrayList<>();
		
		try {
			PreparedStatement PrepStatement = conn.prepareStatement("SELECT * FROM package");
			ResultSet rSet = PrepStatement.executeQuery();
			packList = AddAllPackages(rSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return packList;
	}

	private List<PackageForAppoint> AddAllPackages(ResultSet rSet) {
		List<PackageForAppoint> packList = new ArrayList<>();
		
		try {
			while (rSet.next()) {
				PackageForAppoint pack = new PackageForAppoint();
				pack.setPackId(rSet.getString(1));
				pack.setAdminRegNo(rSet.getString(2));
				pack.setPackType(rSet.getString(3));
				pack.setPackName(rSet.getString(4));
				pack.setPrice(rSet.getDouble(5));
				pack.setPackDescription(rSet.getString(6));
				pack.setPackImage(rSet.getString(7));
				packList.add(pack);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return packList;
	}
	
	@Override
	public PackageForAppoint getPacacgeByPackageID(String packId) {
		conn = DatabaseConnection.getConnection();
		PackageForAppoint resultPackage = new PackageForAppoint();
		try {
			PreparedStatement pStatment = conn.prepareStatement("SELECT * FROM package WHERE packId = ?");
			pStatment.setString(1, packId);
			ResultSet result = pStatment.executeQuery();
			resultPackage = getPackageObject(result);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return resultPackage;
	}

	private PackageForAppoint getPackageObject(ResultSet result) {
		PackageForAppoint packageObject = new PackageForAppoint();
		try {
			if(result.next()) {
				packageObject.setPackId(result.getString("packId"));
				packageObject.setAdminRegNo(result.getString("adminRegNo"));
				packageObject.setPackType(result.getString("packType"));
				packageObject.setPackName(result.getString("packName"));
				packageObject.setPrice(result.getDouble("price"));
				packageObject.setPackDescription(result.getString("packDescription"));
				packageObject.setPackImage(result.getString("packImage"));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return packageObject;
	}

}
