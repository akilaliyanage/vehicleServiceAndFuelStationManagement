package com.oop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		return packList;
	}

}
